package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class u1 {
    public static void a(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Integer r107, JSONObject r110, by7.e r111, int r112) {
        if ((r112 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r112 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r112 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r112 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r112 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r112 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r112 & 128) == 0) goto L27;
        r107 = null;
    L27:
        if ((r112 & 256) == 0) goto L30;
        r110 = new JSONObject();
    L30:
        if ((r112 & 512) == 0) goto L32;
        r111 = null;
    L32:
        Intrinsics.checkNotNullParameter(r110, "params");
        if (r100 != null) goto L68;
    L37:
        if (r101 == null) goto L39;
        r110.put("chat_type", r101);     // Catch: JSONException -> L35
    L39:
        if (r102 == null) goto L41;
        r110.put("current_page", r102);     // Catch: JSONException -> L35
    L41:
        if (r104 == null) goto L43;
        r110.put("is_call_bot", r104);     // Catch: JSONException -> L35
    L43:
        boolean r108 = false;
        if (r103 != null) goto L46;
    L48:
        boolean r109 = false;
    L49:
        if (r109 == false) goto L51;
        r110.put("recommend_from", r103);     // Catch: JSONException -> L35
    L51:
        if (r105 != null) goto L53;
    L55:
        if (r108 == false) goto L57;
        r110.put("req_id", r105);     // Catch: JSONException -> L35
    L57:
        if (r106 == null) goto L59;
        r110.put("is_navigation_sidebar", r106);     // Catch: JSONException -> L35
    L59:
        if (r107 == null) goto L63;
        r110.put("red_dot_cnt", r107.intValue());     // Catch: JSONException -> L35
    L35:
        e = move-exception;
        FLogger.f375446a.e("LongPressBotListEventHelper", "error in LongPressBotListEventHelper mobLongPressBotListChat " + e.getLocalizedMessage());
    L63:
        TrackParams r113 = new TrackParams().merge(r110);
        by7.a r114 = new by7.a("long_press_bot_list");
        if (r111 == null) goto L66;
        r114.f21464b = r111;
    L66:
        r114.f21463a.merge(r113);
        r114.b();
        return;
    L53:
        if (com.larus.utils.o0.d(r105) != true) goto L55;
        r108 = true;
        goto L55
    L46:
        if (com.larus.utils.o0.d(r103) != true) goto L48;
        r109 = true;
        goto L49
    L68:
        r110.put("bot_id", r100);     // Catch: JSONException -> L35
        goto L37
    }
}
