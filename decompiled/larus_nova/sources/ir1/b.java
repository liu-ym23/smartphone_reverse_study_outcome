package ir1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import mq1.d0;

/* JADX INFO: loaded from: classes8.dex */
public final class b {
    public static <T extends c> T a(Class<T> r100) {
        d0 r101 = ReplayRoomFragmentScopeUtil.b();
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) r101.c(r100);
    }
}
