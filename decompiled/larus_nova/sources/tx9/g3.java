package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class g3 {
    public static void a(String r100, String r101, String r102, String r103, String r104, String r105, JSONObject r106) {
        Intrinsics.checkNotNullParameter(r106, "params");
        r106.put("bot_from_status", r100);     // Catch: JSONException -> L23
        if (r101 == null) goto L6;
        r106.put("bot_id", r101);     // Catch: JSONException -> L23
    L6:
        if (r102 == null) goto L8;
        r106.put("call_id", r102);     // Catch: JSONException -> L23
    L8:
        if (r104 == null) goto L11;
        r106.put("conversation_id", r104);     // Catch: JSONException -> L23
    L11:
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        if (r103.length() != 0) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L19;
        r103 = "abnormal_exit";
    L19:
        r106.put("enter_method", r103);     // Catch: JSONException -> L23
        if (r105 == null) goto L25;
        r106.put("call_scene", r105);     // Catch: JSONException -> L23
    L25:
        TrackParams r108 = new TrackParams().merge(r106);
        by7.a r109 = new by7.a("mute_call");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L16:
        r107 = false;
    L23:
        e = move-exception;
        FLogger.f375446a.e("RtcEventHelper", "error in mobMuteCall muteCall " + e.getLocalizedMessage());
        goto L25
    }
}
