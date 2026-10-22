package dh5;

import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b {
    void addUser(UserInfo r1);

    ArrayList<UserInfo> getSelected();

    void registerChangeListener(c r1);

    void removeUser(UserInfo r1);

    void unregisterChangeListener(c r1);
}
