package xf7;

import android.util.Log;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile SDKMonitor f563496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f563497b;

    static {
    }

    @JvmStatic
    public static final void d(Throwable r100, String r101) {
        JSONObject r102 = new JSONObject();
        eg7.a.c(r102, "errMsg", r101);
        JSONObject r103 = new JSONObject();
        eg7.a.c(r103, "stack", Log.getStackTraceString(r100));
        eg7.a.c(r103, "type", r100.getClass().getName());
        zf7.b.a("[Monitor] -> syncsdk_exception," + r102);
        EnsureManager.ensureNotReachHere(r100, r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    @JvmStatic
    public static final void c(int r100, int r101, int r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L5
        r103.put("compress_ratio", r100 / r101);     // Catch: Exception -> L5
        r103.put("compress_msg_type", r102);     // Catch: Exception -> L5
        b("sync_sdk_compress", r103, null, null, 12);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d(e, null);
    }

    @JvmStatic
    public static final void a(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        if (f563497b == false) goto L9;
        zf7.b.d("[Monitor] " + r100 + ", " + r101 + ", " + r102 + ", " + r103);
        SDKMonitor r104 = f563496a;
        if (r104 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        r104.monitorEvent(r100, r101, r102, r103);
        return;
    }

    public static /* synthetic */ void b(String r100, JSONObject r101, JSONObject r102, JSONObject r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        a(r100, r101, r102, r103);
    }
}
