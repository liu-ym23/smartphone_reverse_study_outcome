package hh5;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.UserGroup;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface c extends IModel {
    UserGroup A0(UserInfo r1);

    ArrayList<UserGroup> I5();

    void i(UserInfo r1);

    void l(UserInfo r1);

    ArrayList<UserInfo> m0();

    void o5(k r1);

    void registerChangeListener(dh5.c r1);

    UserInfo t2(UserGroup r1);

    void unregisterChangeListener(dh5.c r1);
}
