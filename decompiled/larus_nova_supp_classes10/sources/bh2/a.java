package bh2;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public a() {
    }

    static {
    }

    public static void a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "errType");
        JSONObject r0 = new JSONObject();
        r0.put(LocationMonitorConst.TYPE, "decode_err");
        r0.put("err_type", r4);
        if (r5 != null) goto L5;
        String r1 = "";
    L6:
        r0.put("content_type", r1);
        int r2 = ECSdk.a;
        pi.b r3 = (pi.b) ECSdk.a(pi.b.class);
        if (r3 == null) goto L9;
        r3.monitorEvent("ec_live_message_usability", r0, null, null);
    L9:
        ECExceptionMonitor.e(new AssertionError("MonitorMessageError: contentType=" + r5 + ", errType=" + r4));
        return;
    L5:
        r1 = r5;
        goto L6
    }
}
