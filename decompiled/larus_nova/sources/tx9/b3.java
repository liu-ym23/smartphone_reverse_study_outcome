package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.trace.RealTimeNavEndReason;
import com.larus.trace.RealTimeNavStartFailReason;
import com.larus.trace.RealTimeNavStartResult;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class b3 {
    public static void a(String r100, Long r101, RealTimeNavEndReason r102, String r103, String r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 == null) goto L5;
        r105.put("navigate_unique_id", r100);
    L5:
        if (r101 == null) goto L8;
        r105.put("duration", r101.longValue());
    L8:
        if (r102 == null) goto L10;
        r105.put("end_reason", r102.getValue());
    L10:
        if (r103 == null) goto L12;
        r105.put("end_reason", r103);
    L12:
        if (r104 == null) goto L14;
        r105.put("extra_info", r104);
    L14:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("real_time_nav_end");
        r107.f21463a.merge(r106);
        r107.b();
    }

    public static void b(String r100, RealTimeNavStartResult r101, Long r102, Long r103, Long r104, Long r105, Long r106, RealTimeNavStartFailReason r107, String r110, String r111) {
        JSONObject r108 = new JSONObject();
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r100 == null) goto L5;
        r108.put("navigate_unique_id", r100);
    L5:
        if (r101 == null) goto L7;
        r108.put("result", r101.getValue());
    L7:
        if (r102 == null) goto L9;
        r108.put("init_duration", r102.longValue());
    L9:
        if (r103 == null) goto L11;
        r108.put("auth_duration", r103.longValue());
    L11:
        if (r104 == null) goto L13;
        r108.put("get_origin_duration", r104.longValue());
    L13:
        if (r105 == null) goto L15;
        r108.put("route_duration", r105.longValue());
    L15:
        if (r106 == null) goto L18;
        r108.put("total_duration", r106.longValue());
    L18:
        if (r107 == null) goto L20;
        r108.put("fail_reason", r107.getValue());
    L20:
        if (r110 == null) goto L22;
        r108.put("fail_reason", r110);
    L22:
        if (r111 == null) goto L24;
        r108.put("extra_info", r111);
    L24:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r112 = new by7.a("real_time_nav_start");
        r112.f21463a.merge(r109);
        r112.b();
    }
}
