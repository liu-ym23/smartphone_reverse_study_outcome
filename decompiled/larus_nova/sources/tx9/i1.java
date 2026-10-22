package tx9;

import com.bytedance.android.livehostapi.platform.base.IBaseHostPerformanceMonitor;
import com.ixigua.lib.track.TrackParams;
import com.larus.trace.GlobalAudioErrorType;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class i1 {
    public static void d(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("scene", r100);
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("audio_device_monitor");
        r103.f21463a.merge(r102);
        r103.b();
    }

    public static void a(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("scene", r100);     // Catch: JSONException -> L5
        r102.put("id", r101);     // Catch: JSONException -> L5
    L7:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("audio_complete_event");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioCompleteEvent " + e.getLocalizedMessage());
        goto L7
    }

    public static void c(String r100, int r101, String r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "executor");
        Intrinsics.checkNotNullParameter(r103, "params");
        r103.put("scene", r100);     // Catch: JSONException -> L5
        r103.put("executor", r102);     // Catch: JSONException -> L5
        r103.put("control_type", r101);     // Catch: JSONException -> L5
    L7:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("audio_control_triggered");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioControlTriggered " + e.getLocalizedMessage());
        goto L7
    }

    public static void f(String r100, String r101, int r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r103, "params");
        r103.put("scene", r100);     // Catch: JSONException -> L5
        r103.put("id", r101);     // Catch: JSONException -> L5
        r103.put("state", r102);     // Catch: JSONException -> L5
    L7:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("audio_load_state_changed");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioLoadStateChanged " + e.getLocalizedMessage());
        goto L7
    }

    public static void j(String r100, String r101, int r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter("default", "reason");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r103, "params");
        r103.put("scene", r100);     // Catch: JSONException -> L5
        r103.put("reason", "default");     // Catch: JSONException -> L5
        r103.put("id", r101);     // Catch: JSONException -> L5
        r103.put("status", r102);     // Catch: JSONException -> L5
    L7:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("audio_stop_triggered");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioStopTriggered " + e.getLocalizedMessage());
        goto L7
    }

    public static void g(String r100, String r101, String r102, int r103) {
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r102, "id");
        Intrinsics.checkNotNullParameter(r104, "params");
        r104.put("scene", r100);     // Catch: JSONException -> L5
        r104.put("reason", r101);     // Catch: JSONException -> L5
        r104.put("id", r102);     // Catch: JSONException -> L5
        r104.put("status", r103);     // Catch: JSONException -> L5
    L7:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("audio_pause_triggered");
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioPauseTriggered " + e.getLocalizedMessage());
        goto L7
    }

    public static void h(String r100, String r101, String r102, boolean r103, int r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r102, "id");
        Intrinsics.checkNotNullParameter(r105, "params");
        r105.put("scene", r100);     // Catch: JSONException -> L9
        r105.put("reason", r101);     // Catch: JSONException -> L9
        r105.put("id", r102);     // Catch: JSONException -> L9
        if (r103 == false) goto L6;
        int r106 = 1;
    L7:
        r105.put("first_trigger_play", r106);     // Catch: JSONException -> L9
        r105.put("status", r104);     // Catch: JSONException -> L9
    L11:
        TrackParams r107 = new TrackParams().merge(r105);
        by7.a r108 = new by7.a("audio_play_triggered");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L6:
        r106 = 0;
    L9:
        e = move-exception;
        FLogger.f375446a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioPlayTriggered " + e.getLocalizedMessage());
        goto L11
    }

    public static void e(String r100, String r101, GlobalAudioErrorType r102, String r103, Integer r104, int r105) {
        JSONObject r106 = null;
        if ((r105 & 16) == 0) goto L6;
        r104 = null;
    L6:
        if ((r105 & 32) == 0) goto L8;
        r106 = new JSONObject();
    L8:
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "errorMsg");
        Intrinsics.checkNotNullParameter(r106, "params");
        r106.put("scene", r100);     // Catch: JSONException -> L11
        r106.put("id", r101);     // Catch: JSONException -> L11
        r106.put("type", r102.getValue());     // Catch: JSONException -> L11
        r106.put("error_msg", r103);     // Catch: JSONException -> L11
        r106.put("sdk_error_code", r104);     // Catch: JSONException -> L11
    L13:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("audio_error_event");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L11:
        e = move-exception;
        FLogger.f375446a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioErrorEvent " + e.getLocalizedMessage());
        goto L13
    }

    public static void k(String r100, String r101, boolean r102, long r103, JSONObject r104, int r105) {
        if ((r105 & 16) == 0) goto L5;
        r104 = new JSONObject();
    L5:
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r104, "params");
        r104.put("scene", r100);
        r104.put("id", r101);
        r104.put("is_hit_cache", r102 ? 1 : 0);
        r104.put(IBaseHostPerformanceMonitor.CACHE_BITMAP_MEMORY_SIZE, r103);
        TrackParams r106 = new TrackParams().merge(r104);
        by7.a r107 = new by7.a("media_hit_cache_event");
        r107.f21463a.merge(r106);
        r107.b();
    }

    public static void b(String r100, int r101, String r102, boolean r103, String r104, Integer r105, Integer r110) {
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "executor");
        Intrinsics.checkNotNullParameter(r106, "params");
        r106.put("scene", r100);     // Catch: JSONException -> L15
        r106.put("control_type", r101);     // Catch: JSONException -> L15
        r106.put("executor", r102);     // Catch: JSONException -> L15
        if (r103 == false) goto L6;
        int r107 = 1;
    L7:
        r106.put("result", r107);     // Catch: JSONException -> L15
        if (r104 == null) goto L10;
        r106.put("failure_msg", r104);     // Catch: JSONException -> L15
    L10:
        if (r105 == null) goto L12;
        r106.put("target_volume", r105.intValue());     // Catch: JSONException -> L15
    L12:
        if (r110 == null) goto L17;
        r106.put("dora_abs_volume_supported", r110.intValue());     // Catch: JSONException -> L15
    L17:
        TrackParams r108 = new TrackParams().merge(r106);
        by7.a r109 = new by7.a("audio_control_result");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L6:
        r107 = 0;
    L15:
        e = move-exception;
        FLogger.f375446a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioControlResult " + e.getLocalizedMessage());
        goto L17
    }

    public static void i(String r100, String r101, int r102, int r103, Long r104, Boolean r105, Boolean r110) {
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r106, "params");
        r106.put("scene", r100);     // Catch: JSONException -> L15
        r106.put("id", r101);     // Catch: JSONException -> L15
        r106.put("status", r102);     // Catch: JSONException -> L15
        r106.put("previous_status", r103);     // Catch: JSONException -> L15
        if (r104 == null) goto L6;
        r106.put("latency", r104.longValue());     // Catch: JSONException -> L15
    L6:
        if (r105 != null) goto L8;
    L12:
        if (r110 == null) goto L17;
        r106.put("is_hit_cache", r110.booleanValue() ? 1 : 0);     // Catch: JSONException -> L15
    L17:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("audio_status_changed");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L8:
        if (r105.booleanValue() == false) goto L10;
        int r109 = 1;
    L11:
        r106.put("first_trigger_play", r109);     // Catch: JSONException -> L15
        goto L12
    L10:
        r109 = 0;
    L15:
        e = move-exception;
        FLogger.f375446a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioPauseTriggered " + e.getLocalizedMessage());
        goto L17
    }
}
