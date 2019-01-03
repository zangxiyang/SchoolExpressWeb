package DAO;

import Beans.UserBean;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


/**
 * 关于用户层的 DAO接口实现层
 */
public class UserDAOImpl implements IDao {
    String TAG = "DAO";
    @Override
    public void insert(Object obj) {
        ConnectionDAO connectionDAO = null ;
        PreparedStatement ps = null ;
        String sql =
                "INSERT INTO end_users(userName,passWord) VALUES (?,?)"
                ;
        try {
            connectionDAO = ConnectionDAO.getInstance();
            ps = connectionDAO.getConnection().prepareStatement(sql);
            //进行强制转换
            UserBean userBean = (UserBean) obj;
            String userName = userBean.getUserName();
            String passWord = userBean.getPassWord();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(TAG+"数据库连接失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(TAG+"驱动注册失败");
        }


    }

    @Override
    public void delete(int key) {

    }

    @Override
    public void update(Object obj) {

    }

    @Override
    public Object select(int key) {
        return null;
    }

    @Override
    public List selectAll(int key) {
        return null;
    }


}
