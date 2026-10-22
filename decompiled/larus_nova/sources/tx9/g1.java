package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class g1 {
    public static void a(String r100, String r101, String r102, Function0 r103, by7.e r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r111 & 4) == 0) goto L11;
        String r104 = null;
    L13:
        if ((r111 & 8) == 0) goto L16;
        r102 = null;
    L16:
        if ((r111 & 16) == 0) goto L18;
        String r105 = null;
    L20:
        if ((r111 & 32) == 0) goto L22;
        String r106 = null;
    L24:
        if ((r111 & 64) == 0) goto L26;
        JSONObject r107 = new JSONObject();
    L28:
        if ((r111 & 128) == 0) goto L31;
        r103 = null;
    L31:
        if ((r111 & 256) == 0) goto L33;
        r110 = null;
    L33:
        Intrinsics.checkNotNullParameter(r107, "params");
        if (r100 != null) goto L62;
    L38:
        if (r101 == null) goto L40;
        r107.put(MusicAppletPage.KEY_MESSAGE_ID, r101);     // Catch: JSONException -> L36
    L40:
        if (r104 == null) goto L42;
        r107.put("message_type", r104);     // Catch: JSONException -> L36
    L42:
        if (r102 == null) goto L44;
        r107.put("content_type", r102);     // Catch: JSONException -> L36
    L44:
        if (r106 == null) goto L46;
        r107.put("click_from", r106);     // Catch: JSONException -> L36
    L46:
        if (r105 == null) goto L48;
        r107.put("user_type", r105);     // Catch: JSONException -> L36
    L48:
        if (r103 == null) goto L57;
        Map r108 = (Map) r103.invoke();     // Catch: JSONException -> L36
        if (r108 == null) goto L57;
        Iterator r109 = r108.entrySet().iterator();     // Catch: JSONException -> L36
    L52:
        if (r109.hasNext() == false) goto L57;
        Map.Entry r112 = (Map.Entry) r109.next();     // Catch: JSONException -> L36
        r107.put((String) r112.getKey(), r112.getValue());     // Catch: JSONException -> L36
    L36:
        e = move-exception;
        FLogger.f375446a.e("FullScreenEventHelper", "error in FullScreenEventHelper fullScreenPreviewClick " + e.getLocalizedMessage());
    L57:
        TrackParams r113 = new TrackParams().merge(r107);
        by7.a r114 = new by7.a("full_screen_preview_click");
        if (r110 == null) goto L60;
        r114.f21464b = r110;
    L60:
        r114.f21463a.merge(r113);
        r114.b();
        return;
    L62:
        r107.put("bot_id", r100);     // Catch: JSONException -> L36
        goto L38
    L26:
        r107 = null;
        goto L28
    L22:
        r106 = "answer";
        goto L24
    L18:
        r105 = "bot";
        goto L20
    L11:
        r104 = "text";
        goto L13
    }
}
