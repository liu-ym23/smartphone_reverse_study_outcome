package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class a0 {
    public static void a(String r100, String r101, String r102, String r103, Boolean r104, Boolean r105, String r106, String r107, String r110, JSONObject r111, by7.e r112, int r113) {
        if ((r113 & 4) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 64) == 0) goto L9;
        r101 = null;
    L9:
        if ((r113 & 128) == 0) goto L12;
        r102 = null;
    L12:
        if ((524288 & r113) == 0) goto L15;
        r103 = null;
    L15:
        if ((4194304 & r113) == 0) goto L18;
        r104 = null;
    L18:
        if ((8388608 & r113) == 0) goto L21;
        r105 = null;
    L21:
        if ((16777216 & r113) == 0) goto L24;
        r106 = null;
    L24:
        if ((33554432 & r113) == 0) goto L27;
        r107 = null;
    L27:
        if ((67108864 & r113) == 0) goto L30;
        r110 = null;
    L30:
        if ((134217728 & r113) == 0) goto L33;
        r111 = new JSONObject();
    L33:
        if ((r113 & 268435456) == 0) goto L35;
        r112 = null;
    L35:
        Intrinsics.checkNotNullParameter(r111, "params");
        if (r100 != null) goto L72;
    L40:
        if (r101 == null) goto L42;
        r111.put("is_immersive_background", r101);     // Catch: JSONException -> L38
    L42:
        if (r102 == null) goto L44;
        r111.put(MusicAppletPage.KEY_MESSAGE_ID, r102);     // Catch: JSONException -> L38
    L44:
        if (r103 == null) goto L46;
        r111.put("message_is_interrupted", r103);     // Catch: JSONException -> L38
    L46:
        String r108 = "1";
        if (r104 != null) goto L49;
    L53:
        if (r105 != null) goto L55;
    L59:
        if (r106 == null) goto L61;
        r111.put("click_module", r106);     // Catch: JSONException -> L38
    L61:
        if (r107 == null) goto L63;
        r111.put("select_range", r107);     // Catch: JSONException -> L38
    L63:
        if (r110 == null) goto L67;
        r111.put("call_id", r110);     // Catch: JSONException -> L38
    L38:
        e = move-exception;
        FLogger.f375446a.e("ChooseEventHelper", "error in ChooseEventHelper copy " + e.getLocalizedMessage());
    L67:
        TrackParams r109 = new TrackParams().merge(r111);
        by7.a r114 = new by7.a("choose_text");
        if (r112 == null) goto L70;
        r114.f21464b = r112;
    L70:
        r114.f21463a.merge(r109);
        r114.b();
        return;
    L55:
        if (r105.booleanValue() == true) goto L58;
        r108 = "0";
    L58:
        r111.put("is_thinking_generating", r108);     // Catch: JSONException -> L38
        goto L59
    L49:
        if (r104.booleanValue() == false) goto L51;
        Object r115 = "1";
    L52:
        r111.put("is_message_generating", r115);     // Catch: JSONException -> L38
        goto L53
    L51:
        r115 = "0";
        goto L52
    L72:
        r111.put("click_from", r100);     // Catch: JSONException -> L38
        goto L40
    }
}
