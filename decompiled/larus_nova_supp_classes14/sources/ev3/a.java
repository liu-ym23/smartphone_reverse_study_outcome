package ev3;

import android.os.SystemClock;
import com.ixigua.lib.track.TrackParams;
import com.larus.trace.RealTimeNavEndReason;
import com.larus.trace.RealTimeNavErrorMsg;
import com.larus.trace.RealTimeNavErrorType;
import com.larus.trace.RealTimeNavStartFailReason;
import com.larus.trace.RealTimeNavStartResult;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.b3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static String a;
    public static Long b;
    public static Long c;
    public static Long d;
    public static Long e;
    public static Long f;
    public static JSONObject g;
    public static Long h;
    public static JSONObject i;
    public static String j;
    public static String k;

    static {
    }

    public a() {
    }

    public static void a(String r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        if (g != null) goto L5;
        g = new JSONObject();
    L5:
        JSONObject r0 = g;
        if (r0 == null) goto L9;
        r0.put(r1, r2);
        return;
    }

    public static void b(RealTimeNavEndReason r6, String r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r6 = null;
    L6:
        if ((r8 & 2) == 0) goto L8;
        r7 = null;
    L8:
        String r9 = a;
        if (r9 != null) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r9, k) == true) goto L24;
        k = a;
        Long r10 = h;
        if (r10 == null) goto L16;
        Long r11 = Long.valueOf(SystemClock.elapsedRealtime() - r10.longValue());
    L17:
        String r0 = a;
        JSONObject r2 = i;
        if (r2 == null) goto L20;
        String r3 = r2.toString();
    L21:
        b3.a(r0, r11, r6, r7, r3);
        a = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        return;
    L20:
        r3 = null;
        goto L21
    L16:
        r11 = null;
        goto L17
    }

    public static void d(RealTimeNavStartResult r12, RealTimeNavStartFailReason r13, String r14, int r15) {
        String r1 = null;
        if ((r15 & 2) == 0) goto L5;
        RealTimeNavStartFailReason r9 = null;
    L7:
        if ((r15 & 4) == 0) goto L9;
        String r10 = null;
    L10:
        Intrinsics.checkNotNullParameter(r12, "result");
        String r16 = a;
        if (r16 != null) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual(r16, j) == true) goto L25;
        j = a;
        Long r17 = b;
        if (r17 == null) goto L18;
        Long r8 = Long.valueOf(SystemClock.elapsedRealtime() - r17.longValue());
    L19:
        String r2 = a;
        Long r4 = c;
        Long r5 = d;
        Long r6 = e;
        Long r7 = f;
        JSONObject r18 = g;
        if (r18 == null) goto L22;
        r1 = r18.toString();
    L22:
        b3.b(r2, r12, r4, r5, r6, r7, r8, r9, r10, r1);
        h = Long.valueOf(SystemClock.elapsedRealtime());
        return;
    L18:
        r8 = null;
        goto L19
    L25:
        return;
    L9:
        r10 = r14;
        goto L10
    L5:
        r9 = r13;
        goto L7
    }

    public static void c(RealTimeNavErrorType r3, RealTimeNavErrorMsg r4, String r5, JSONObject r6, int r7) {
        String r1 = null;
        if ((r7 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = null;
    L11:
        Intrinsics.checkNotNullParameter(r3, "type");
        String r0 = a;
        if (r0 == null) goto L28;
        if (r6 == null) goto L16;
        r1 = r6.toString();
    L16:
        JSONObject r8 = new JSONObject();
        Intrinsics.checkNotNullParameter(r8, "params");
        r8.put("navigate_unique_id", r0);
        if (r3 == null) goto L20;
        r8.put("type", r3.getValue());
    L20:
        if (r4 == null) goto L22;
        r8.put("error_msg", r4.getValue());
    L22:
        if (r5 == null) goto L24;
        r8.put("error_msg", r5);
    L24:
        if (r1 == null) goto L26;
        r8.put("extra_info", r1);
    L26:
        TrackParams r9 = new TrackParams().merge(r8);
        by7.a r10 = new by7.a("real_time_nav_error");
        r10.a.merge(r9);
        r10.b();
        return;
    }
}
