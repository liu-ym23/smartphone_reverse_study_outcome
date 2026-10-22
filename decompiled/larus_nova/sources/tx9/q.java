package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class q {
    public static final void a(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, Long r110, String r111, JSONObject r112, by7.e r113) {
        Intrinsics.checkNotNullParameter(r112, "params");
        if (r100 != null) goto L34;
    L7:
        if (r101 == null) goto L9;
        r112.put("current_page", r101);     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L11;
        r112.put("previous_page", r102);     // Catch: JSONException -> L5
    L11:
        if (r103 == null) goto L13;
        r112.put("chat_type", r103);     // Catch: JSONException -> L5
    L13:
        if (r104 == null) goto L15;
        r112.put("bot_id", r104);     // Catch: JSONException -> L5
    L15:
        if (r105 == null) goto L17;
        r112.put("conversation_id", r105);     // Catch: JSONException -> L5
    L17:
        if (r106 == null) goto L19;
        r112.put(MusicAppletPage.KEY_MESSAGE_ID, r106);     // Catch: JSONException -> L5
    L19:
        if (r107 == null) goto L21;
        r112.put("show_from", r107);     // Catch: JSONException -> L5
    L21:
        if (r108 == null) goto L23;
        r112.put("section_id", r108);     // Catch: JSONException -> L5
    L23:
        if (r110 == null) goto L25;
        r112.put("with_code", r110.longValue());     // Catch: JSONException -> L5
    L25:
        if (r111 == null) goto L29;
        r112.put("code_type", r111);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("ButtonEventHelper", "error in ButtonEventHelper showButton " + e.getLocalizedMessage());
    L29:
        TrackParams r109 = new TrackParams().merge(r112);
        by7.a r114 = new by7.a("show_button");
        if (r113 == null) goto L32;
        r114.f21464b = r113;
    L32:
        r114.f21463a.merge(r109);
        r114.b();
        return;
    L34:
        r112.put("button_name", r100);     // Catch: JSONException -> L5
        goto L7
    }
}
