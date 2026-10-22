package eh5;

import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IModel;
import dh5.c;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a extends IModel {
    ArrayList<UserInfo> e();

    void registerChangeListener(c r1);

    void unregisterChangeListener(c r1);
}
