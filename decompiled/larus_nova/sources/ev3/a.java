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

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f474232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Long f474233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Long f474234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Long f474235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Long f474236e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Long f474237f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static JSONObject f474238g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Long f474239h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static JSONObject f474240i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f474241j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f474242k;

    static {
    }

    public a() {
    }

    public static void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (f474238g != null) goto L5;
        f474238g = new JSONObject();
    L5:
        JSONObject r102 = f474238g;
        if (r102 == null) goto L9;
        r102.put(r100, r101);
        return;
    }

    public static void b(RealTimeNavEndReason r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        String r103 = f474232a;
        if (r103 != null) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r103, f474242k) == true) goto L24;
        f474242k = f474232a;
        Long r104 = f474239h;
        if (r104 == null) goto L16;
        Long r105 = Long.valueOf(SystemClock.elapsedRealtime() - r104.longValue());
    L17:
        String r106 = f474232a;
        JSONObject r107 = f474240i;
        if (r107 == null) goto L20;
        String r108 = r107.toString();
    L21:
        b3.a(r106, r105, r100, r101, r108);
        f474232a = null;
        f474234c = null;
        f474235d = null;
        f474236e = null;
        f474237f = null;
        f474238g = null;
        f474239h = null;
        f474240i = null;
        return;
    L20:
        r108 = null;
        goto L21
    L16:
        r105 = null;
        goto L17
    }

    public static void d(RealTimeNavStartResult r110, RealTimeNavStartFailReason r111, String r112, int r113) {
        String r100 = null;
        if ((r113 & 2) == 0) goto L5;
        RealTimeNavStartFailReason r101 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        String r114 = null;
    L10:
        Intrinsics.checkNotNullParameter(r110, "result");
        String r115 = f474232a;
        if (r115 != null) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual(r115, f474241j) == true) goto L25;
        f474241j = f474232a;
        Long r116 = f474233b;
        if (r116 == null) goto L18;
        Long r102 = Long.valueOf(SystemClock.elapsedRealtime() - r116.longValue());
    L19:
        String r103 = f474232a;
        Long r104 = f474234c;
        Long r105 = f474235d;
        Long r106 = f474236e;
        Long r107 = f474237f;
        JSONObject r117 = f474238g;
        if (r117 == null) goto L22;
        r100 = r117.toString();
    L22:
        b3.b(r103, r110, r104, r105, r106, r107, r102, r101, r114, r100);
        f474239h = Long.valueOf(SystemClock.elapsedRealtime());
        return;
    L18:
        r102 = null;
        goto L19
    L25:
        return;
    L9:
        r114 = r112;
        goto L10
    L5:
        r101 = r111;
        goto L7
    }

    public static void c(RealTimeNavErrorType r100, RealTimeNavErrorMsg r101, String r102, JSONObject r103, int r104) {
        String r105 = null;
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "type");
        String r106 = f474232a;
        if (r106 == null) goto L28;
        if (r103 == null) goto L16;
        r105 = r103.toString();
    L16:
        JSONObject r107 = new JSONObject();
        Intrinsics.checkNotNullParameter(r107, "params");
        r107.put("navigate_unique_id", r106);
        if (r100 == null) goto L20;
        r107.put("type", r100.getValue());
    L20:
        if (r101 == null) goto L22;
        r107.put("error_msg", r101.getValue());
    L22:
        if (r102 == null) goto L24;
        r107.put("error_msg", r102);
    L24:
        if (r105 == null) goto L26;
        r107.put("extra_info", r105);
    L26:
        TrackParams r108 = new TrackParams().merge(r107);
        by7.a r109 = new by7.a("real_time_nav_error");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    }
}
