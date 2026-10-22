package gy;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdk.config.w90;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f483302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f483303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f483304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f483305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f483306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f483307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Room f483308g;

    public final HashMap<String, Object> a() {
        HashMap<String, Object> r100 = new HashMap();
        r100.put("interact_first_video_time_interval", Long.valueOf(this.f483305d));
        r100.put("interact_first_frame_render_interval", Long.valueOf(this.f483306e));
        r100.put("interact_start_join_channel_time_interval", Long.valueOf(this.f483304c));
        r100.put("interact_join_channel_success_time_interval", Long.valueOf(this.f483303b));
        r100.put("scene", 0);
        StreamUrlExtra r101 = this.f483308g.getStreamUrlExtraSafely();
        if (r101 == null) goto L5;
        StringBuilder r102 = new StringBuilder();
        r102.append(r101.getWidth());
        r102.append('-');
        r102.append(r101.getHeight());
        r100.put("push_stream_info", r102.toString());
    L5:
        return r100;
    }

    public a(Room r100) {
        Intrinsics.checkNotNullParameter(r100, "room");
        this.f483308g = r100;
        this.f483302a = "ttlive_anchor_link_rtc";
        this.f483307f = new h(r100);
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reqSrc");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("req_src", r100);
        h r102 = this.f483307f;
        LiveTracingMonitor.EventModule r103 = LiveTracingMonitor.b(0);
        int r104 = h.f483311d;
        r102.m(r103, "trace_null_client", r101, false);
    }

    public static void b(a r100, String r110, String r111, int r112, int r113) {
        if (r113 == 0) goto L60;
        if (r112 != 0) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r110) == true) goto L63;
        HashMap<String, Object> r101 = r100.a();
        if (r110 != null) goto L10;
        String r102 = "";
    L11:
        r101.put("rtc_params", r102);
        if (r111 != null) goto L14;
        r111 = "";
    L14:
        r101.put("update_src", r111);
        r101.put("self_layer_width", Integer.valueOf(r112));
        r101.put("self_layer_height", Integer.valueOf(r113));
        JSONObject r114 = new JSONObject(r110);     // Catch: JSONException -> L55
        JSONObject r115 = r114.optJSONObject("live_rtc_video_param");     // Catch: JSONException -> L55
        String r116 = r114.optString("rtc_business_id");     // Catch: JSONException -> L55
        if (r115 == null) goto L62;
        int r103 = r115.optInt("rtc_video_param_mode");     // Catch: JSONException -> L55
        int r104 = -1;
        if (r103 != 1) goto L21;
        JSONObject r117 = r115.optJSONObject("rtc_video_param_server_define");     // Catch: JSONException -> L55
        if (r117 == null) goto L41;
        int r105 = r117.optInt("width");     // Catch: JSONException -> L55
    L42:
        if (r117 == null) goto L45;
        int r118 = r117.optInt("height");     // Catch: JSONException -> L55
    L44:
        r104 = r118;
    L45:
        r101.put("update_rtc_width", Integer.valueOf(r105));     // Catch: JSONException -> L55
        r101.put("update_rtc_height", Integer.valueOf(r104));     // Catch: JSONException -> L55
        r101.put("rtc_user_size", 1);     // Catch: JSONException -> L55
        r101.put("ext_rtc_business_id", r116);     // Catch: JSONException -> L55
        StringBuilder r119 = new StringBuilder();     // Catch: JSONException -> L55
        r119.append(r105);     // Catch: JSONException -> L55
        r119.append('*');     // Catch: JSONException -> L55
        r119.append(r104);     // Catch: JSONException -> L55
        r101.put("ext_rtc_resolution", r119.toString());     // Catch: JSONException -> L55
        if (r105 == 0) goto L49;
        if (r112 == 0) goto L49;
        float r120 = ((r104 * 1.0f) / r105) - ((r113 * 1.0f) / r112);     // Catch: JSONException -> L55
    L51:
        if (r120 <= w90.f121506a.getValue().floatValue()) goto L53;
        h r121 = r100.f483307f;     // Catch: JSONException -> L55
        LiveTracingMonitor.EventModule r122 = LiveTracingMonitor.b(0);     // Catch: JSONException -> L55
        int r123 = h.f483311d;     // Catch: JSONException -> L55
        r121.m(r122, "pushstream_resolution_redundancy", r101, false);     // Catch: JSONException -> L55
    L53:
        r100.f483307f.m(LiveTracingMonitor.b(0), "switch_rtc_and_livecore_ext_info", r101, true);     // Catch: JSONException -> L55
        return;
    L49:
        r120 = 0.0f;
        goto L51
    L41:
        r105 = 0;
        goto L42
    L21:
        if (r103 == 3) goto L23;
        r105 = 0;
        goto L45
    L23:
        JSONObject r106 = r115.optJSONObject("rtc_video_param_1v1_client");     // Catch: JSONException -> L55
        if (r106 == null) goto L26;
        r105 = r106.optInt("width");     // Catch: JSONException -> L55
    L27:
        if (r106 == null) goto L29;
        int r107 = r106.optInt("height");     // Catch: JSONException -> L55
    L30:
        if (r106 != null) goto L37;
        JSONObject r124 = r115.optJSONObject("rtc_video_param_1v1_server");     // Catch: JSONException -> L55
        if (r124 == null) goto L34;
        r105 = r124.optInt("width");     // Catch: JSONException -> L55
    L35:
        if (r124 == null) goto L45;
        r118 = r124.optInt("height");     // Catch: JSONException -> L55
        goto L44
    L34:
        r105 = 0;
        goto L35
    L37:
        r104 = r107;
        goto L45
    L29:
        r107 = -1;
        goto L30
    L26:
        r105 = 0;
        goto L27
    L62:
        return;
    L55:
        e = move-exception;
        ALogger.e("monitorPushResolution", "e = " + e);
        return;
    L10:
        r102 = r110;
        goto L11
    L63:
        return;
    }
}
