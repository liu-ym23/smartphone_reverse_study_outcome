package dh5;

import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public interface b {
    void addUser(UserInfo r100);

    ArrayList<UserInfo> getSelected();

    void registerChangeListener(c r100);

    void removeUser(UserInfo r100);

    void unregisterChangeListener(c r100);
}
