package yg5;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IModel;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a extends IModel {
    void H6(dh5.c r1);

    Flowable<SimpleRequestResult> P4(String r1);

    void V(UserInfo r1);

    ArrayList<UserInfo> getUsers();

    void r5(dh5.c r1);
}
