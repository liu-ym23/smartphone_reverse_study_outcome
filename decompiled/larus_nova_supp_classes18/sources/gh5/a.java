package gh5;

import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a extends IModel {
    ArrayList<UserInfo> C1();

    void i(UserInfo r1);

    void registerChangeListener(dh5.c r1);

    void unregisterChangeListener(dh5.c r1);
}
