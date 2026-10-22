package hh5;

import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b extends IModel {
    ArrayList<UserInfo> e();

    void registerChangeListener(dh5.c r1);

    void unregisterChangeListener(dh5.c r1);
}
