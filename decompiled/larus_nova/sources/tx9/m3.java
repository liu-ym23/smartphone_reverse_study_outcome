package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class m3 {
    public static void a(String r100, String r101, Long r102, String r103, String r104, String r105, String r106, String r107, Long r110, JSONObject r111, TraceFragment r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r113 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r113 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r113 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r113 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r113 & 128) == 0) goto L27;
        r107 = null;
    L27:
        if ((r113 & 256) == 0) goto L30;
        r110 = null;
    L30:
        if ((r113 & 512) == 0) goto L33;
        r111 = new JSONObject();
    L33:
        if ((r113 & 1024) == 0) goto L35;
        r112 = null;
    L35:
        Intrinsics.checkNotNullParameter(r111, "params");
        if (r100 != null) goto L63;
    L40:
        if (r101 == null) goto L42;
        r111.put("current_page", r101);     // Catch: JSONException -> L38
    L42:
        if (r102 == null) goto L44;
        r111.put("err_code", r102.longValue());     // Catch: JSONException -> L38
    L44:
        if (r103 == null) goto L46;
        r111.put("err_tips", r103);     // Catch: JSONException -> L38
    L46:
        if (r104 == null) goto L48;
        r111.put("group_type", r104);     // Catch: JSONException -> L38
    L48:
        if (r105 == null) goto L50;
        r111.put("is_immersive_background", r105);     // Catch: JSONException -> L38
    L50:
        if (r106 == null) goto L52;
        r111.put("recommend_from", r106);     // Catch: JSONException -> L38
    L52:
        if (r107 == null) goto L54;
        r111.put("req_id", r107);     // Catch: JSONException -> L38
    L54:
        if (r110 == null) goto L58;
        r111.put("success", r110.longValue());     // Catch: JSONException -> L38
    L38:
        e = move-exception;
        FLogger.f375446a.e("SettingEventHelper", "error in SettingEventHelper settingClearMessageResult " + e.getLocalizedMessage());
    L58:
        TrackParams r108 = new TrackParams().merge(r111);
        by7.a r109 = new by7.a("setting_clear_message_result");
        if (r112 == null) goto L61;
        r109.f21464b = r112;
    L61:
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L63:
        r111.put("bot_id", r100);     // Catch: JSONException -> L38
        goto L40
    }
}
