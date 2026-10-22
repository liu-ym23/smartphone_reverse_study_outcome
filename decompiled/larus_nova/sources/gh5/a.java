package gh5;

import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public interface a extends IModel {
    ArrayList<UserInfo> C1();

    void i(UserInfo r100);

    void registerChangeListener(dh5.c r100);

    void unregisterChangeListener(dh5.c r100);
}
