package ch5;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.department.VisibleDepartment;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.department.VisibleTopUserInDep;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface e extends IModel {
    UserInfo K6(VisibleDepartment r1);

    VisibleDepartment M2(UserInfo r1);

    ArrayList<VisibleTopUserInDep> O1();

    void V7(VisibleDepartment r1, com.bytedance.ee.bear.middleground.permission.collaborator.search.department.d.c r2);

    UserInfo Y6(VisibleTopUserInDep r1);

    void i(UserInfo r1);

    void l(UserInfo r1);

    ArrayList<UserInfo> m0();

    void q6(d r1);

    ArrayList<VisibleDepartment> r6();

    void registerChangeListener(dh5.c r1);

    VisibleTopUserInDep u2(UserInfo r1);

    void unregisterChangeListener(dh5.c r1);
}
