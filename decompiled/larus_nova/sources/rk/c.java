package rk;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f538243a = 0;

    static {
    }

    public static void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "location");
        Intrinsics.checkNotNullParameter("product_flow", "business");
        String r103 = null;
        String r104 = new JSONObject().put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r101).toString();     // Catch: JSONException -> L8
        r103 = new JSONObject().put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r102).toString();     // Catch: JSONException -> L6
    L11:
        b(r100, "product_flow", r104, r103);
        return;
    L6:
        JSONException e100 = e;
    L10:
        ECExceptionMonitor.e(e100);
    L8:
        e = move-exception;
        e100 = e;
        r104 = null;
        goto L10
    }

    public static void b(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "location");
        Intrinsics.checkNotNullParameter(r101, "business");
        new b(r100, r101, r102, r103).post(null, null);
    }
}
