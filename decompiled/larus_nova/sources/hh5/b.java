package hh5;

import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public interface b extends IModel {
    ArrayList<UserInfo> e();

    void registerChangeListener(dh5.c r100);

    void unregisterChangeListener(dh5.c r100);
}
