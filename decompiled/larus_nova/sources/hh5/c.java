package hh5;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.UserGroup;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public interface c extends IModel {
    UserGroup A0(UserInfo r100);

    ArrayList<UserGroup> I5();

    void i(UserInfo r100);

    void l(UserInfo r100);

    ArrayList<UserInfo> m0();

    void o5(k r100);

    void registerChangeListener(dh5.c r100);

    UserInfo t2(UserGroup r100);

    void unregisterChangeListener(dh5.c r100);
}
