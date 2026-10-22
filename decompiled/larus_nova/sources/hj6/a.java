package hj6;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import li6.c;
import li6.d;
import li6.e;
import li6.f;
import li6.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    static {
    }

    public static c a(String r100) {
        if (r100 != null) goto L5;
    L17:
        c r101 = new c(0);     // Catch: Exception -> L14
        r101.f509382a = r100;     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r100);     // Catch: Exception -> L14
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L14
        r101.f509383b = r102.optString("rtc_business_id");     // Catch: Exception -> L14
        JSONObject r103 = r102.optJSONObject("live_rtc_engine_config");     // Catch: Exception -> L14
        if (r103 == null) goto L10;
        r101.f509384c = b(r103);     // Catch: Exception -> L14
    L10:
        JSONObject r104 = r102.optJSONObject("live_rtc_video_param");     // Catch: Exception -> L14
        if (r104 == null) goto L13;
        r101.f509385d = c(r104);     // Catch: Exception -> L14
    L13:
        return r101;
    L14:
        e = move-exception;
        int r105 = ej6.a.f472874a;
        ej6.a.b("LiveRTCExtInfoParser", "parse exception " + e);
        return null;
    L5:
        if (StringsKt.isBlank(r100) != true) goto L17;
        return null;
    }

    public static li6.b b(JSONObject r100) {
        li6.b r101 = new li6.b(0);
        r101.f509375b = r100.optString("rtc_channel_id");
        r101.f509374a = r100.optString("rtc_app_id");
        r101.f509376c = r100.optString("rtc_app_sign");
        r101.f509377d = r100.optString("rtc_token");
        r101.f509378e = r100.optString("rtc_user_id");
        r101.f509379f = r100.optInt("rtc_user_id_mode");
        r101.f509380g = r100.optInt("rtc_vendor");
        r101.f509381h = r100.optString("user_id");
        return r101;
    }

    public static d c(JSONObject r100) {
        d r101 = new d(0);
        r101.f509388b = r100.optInt("rtc_mix_type");
        r101.f509390d = r100.optInt("rtc_video_param_mode");
        JSONObject r102 = r100.optJSONObject("rtc_video_param_1v1_client");
        if (r102 == null) goto L5;
        r101.f509392f = d(r102);
    L5:
        JSONObject r103 = r100.optJSONObject("rtc_video_param_1v1_server");
        if (r103 == null) goto L8;
        r101.f509393g = d(r103);
    L8:
        JSONObject r104 = r100.optJSONObject("rtc_mix_param");
        if (r104 == null) goto L14;
        f r105 = new f(0);
        r105.f509395a = r104.optInt("video_bitrate_kbps");
        r105.f509396b = r104.optString("task_id");
        JSONObject r106 = r104.optJSONObject("mix_video_param_server");
        if (r106 == null) goto L13;
        r105.f509397c = d(r106);
    L13:
        r101.f509387a = r105;
    L14:
        JSONObject r107 = r100.optJSONObject("rtc_performance_profiles");
        if (r107 == null) goto L20;
        e r108 = new e(0);
        JSONObject r109 = r107.optJSONObject("rtc_performance_low");
        if (r109 == null) goto L19;
        r108.f509394a = d(r109);
    L19:
        r101.f509389c = r108;
    L20:
        JSONObject r110 = r100.optJSONObject("rtc_video_param_server_define");
        if (r110 == null) goto L23;
        r101.f509391e = d(r110);
    L23:
        return r101;
    }

    public static h d(JSONObject r100) {
        h r101 = new h(0);
        r101.f509402a = r100.optInt("bitrate_kbps");
        r101.f509404c = r100.optInt("fps");
        r101.f509405d = r100.optInt("height");
        r101.f509406e = r100.optInt("width");
        return r101;
    }
}
