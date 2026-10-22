package hw;

import android.content.Context;
import com.bytedance.android.gamecp.host_api.model.user.FollowPair;
import com.bytedance.android.gamecp.host_api.model.user.IUser;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes44.dex */
public interface b {
    String a(String r100);

    IUser b();

    Observable<IUser> c(Context r100, com.bytedance.android.gamecp.host_api.model.user.c r101);

    Observable<FollowPair> d(com.bytedance.android.gamecp.host_api.model.user.b r100);

    String getCurrentUserId();

    boolean isLogin();
}
