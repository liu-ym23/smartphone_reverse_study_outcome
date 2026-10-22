package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class n3 {
    public static void a(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, int r111) {
        JSONObject r108 = null;
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r111 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r111 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r111 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r111 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r111 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r111 & 128) == 0) goto L27;
        r107 = null;
    L27:
        if ((r111 & 256) == 0) goto L30;
        r110 = null;
    L30:
        if ((r111 & 512) == 0) goto L32;
        r108 = new JSONObject();
    L32:
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r100 != null) goto L57;
    L37:
        if (r101 == null) goto L39;
        r108.put("current_page", r101);     // Catch: JSONException -> L35
    L39:
        if (r102 == null) goto L41;
        r108.put("show_from", r102);     // Catch: JSONException -> L35
    L41:
        if (r103 == null) goto L43;
        r108.put(MusicAppletPage.KEY_MESSAGE_ID, r103);     // Catch: JSONException -> L35
    L43:
        if (r104 == null) goto L45;
        r108.put("section_id", r104);     // Catch: JSONException -> L35
    L45:
        if (r105 == null) goto L47;
        r108.put("bot_id", r105);     // Catch: JSONException -> L35
    L47:
        if (r106 == null) goto L49;
        r108.put("conversation_id", r106);     // Catch: JSONException -> L35
    L49:
        if (r107 == null) goto L51;
        r108.put("chat_type", r107);     // Catch: JSONException -> L35
    L51:
        if (r110 == null) goto L55;
        r108.put("is_immersive_background", r110);     // Catch: JSONException -> L35
    L35:
        e = move-exception;
        FLogger.f375446a.e("ShowButtonEventHelper", "error in ShowButtonEventHelper " + e.getLocalizedMessage());
    L55:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r112 = new by7.a("show_button");
        r112.f21463a.merge(r109);
        r112.b();
        return;
    L57:
        r108.put("button_name", r100);     // Catch: JSONException -> L35
        goto L37
    }
}
