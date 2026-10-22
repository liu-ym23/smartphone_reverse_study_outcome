package iba;

import android.content.Context;
import android.os.UserManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Method;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final long a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("user");
        Number r102 = null;
        if ((r101 instanceof UserManager) == false) goto L5;
        UserManager r103 = (UserManager) r101;
    L7:
        if (r103 != null) goto L20;
        FLogger.f375446a.e("UserUnlockRealtimeCompat", "getUserUnlockRealtime failed: UserManager unavailable");
        return -1;
    L20:
        Method r104 = UserManager.class.getDeclaredMethod("getUserUnlockRealtime", new Class[0]);     // Catch: Exception -> L17
        r104.setAccessible(true);     // Catch: Exception -> L17
        Object r105 = r104.invoke(r103, new Object[0]);     // Catch: Exception -> L17
        if ((r105 instanceof Number) == false) goto L13;
        r102 = (Number) r105;     // Catch: Exception -> L17
    L13:
        if (r102 != null) goto L21;
        FLogger.f375446a.e("UserUnlockRealtimeCompat", "getUserUnlockRealtime failed: unexpected value=" + r105);     // Catch: Exception -> L17
        return -1;
    L21:
        return r102.longValue();
    L17:
        e = move-exception;
        FLogger.f375446a.e("UserUnlockRealtimeCompat", "getUserUnlockRealtime failed", e);
        return -1;
    L5:
        r103 = null;
        goto L7
    }
}
