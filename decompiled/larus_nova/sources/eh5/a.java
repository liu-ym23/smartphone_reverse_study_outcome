package eh5;

import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IModel;
import dh5.c;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public interface a extends IModel {
    ArrayList<UserInfo> e();

    void registerChangeListener(c r100);

    void unregisterChangeListener(c r100);
}
