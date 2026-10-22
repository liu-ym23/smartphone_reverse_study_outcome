package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class k1 {
    public static void a(String r100, String r101, String r102, String r103, Integer r104, String r105, by7.e r106, int r107) {
        if ((r107 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r107 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r107 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r107 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r107 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r107 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r107 & 64) == 0) goto L23;
        JSONObject r108 = new JSONObject();
    L25:
        if ((r107 & 128) == 0) goto L27;
        r106 = null;
    L27:
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r100 != null) goto L49;
    L32:
        if (r101 == null) goto L34;
        r108.put("click_from", r101);     // Catch: JSONException -> L30
    L34:
        if (r102 == null) goto L36;
        r108.put("current_page", r102);     // Catch: JSONException -> L30
    L36:
        if (r103 == null) goto L38;
        r108.put("chat_type", r103);     // Catch: JSONException -> L30
    L38:
        if (r104 == null) goto L40;
        r108.put("bot_type", r104.intValue());     // Catch: JSONException -> L30
    L40:
        if (r105 == null) goto L44;
        r108.put("is_navigation_sidebar", r105);     // Catch: JSONException -> L30
    L30:
        e = move-exception;
        FLogger.f375446a.e("HideChatEventHelper", "error in HideChatEventHelper hideChat " + e.getLocalizedMessage());
    L44:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r110 = new by7.a("hide_chat");
        if (r106 == null) goto L47;
        r110.f21464b = r106;
    L47:
        r110.f21463a.merge(r109);
        r110.b();
        return;
    L49:
        r108.put("bot_id", r100);     // Catch: JSONException -> L30
        goto L32
    L23:
        r108 = null;
        goto L25
    }
}
