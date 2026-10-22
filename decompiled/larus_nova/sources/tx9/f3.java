package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class f3 {
    public static void b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        TrackParams r101 = new TrackParams().merge(r100);
        by7.a r102 = new by7.a("chat_list_not_bot_cell_remove");
        r102.f21463a.merge(r101);
        r102.b();
    }

    public static void a(String r100, String r101, String r102, String r103, String r104, JSONObject r105, String r106, String r107, String r110, String r111, String r112, int r113) {
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
        r105 = new JSONObject();
    L21:
        if ((r113 & 128) == 0) goto L24;
        r106 = null;
    L24:
        if ((r113 & 256) == 0) goto L27;
        r107 = null;
    L27:
        if ((r113 & 512) == 0) goto L30;
        r110 = null;
    L30:
        if ((r113 & 1024) == 0) goto L33;
        r111 = null;
    L33:
        if ((r113 & 2048) == 0) goto L35;
        r112 = null;
    L35:
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L72;
    L40:
        if (r101 == null) goto L42;
        r105.put("conversation_id", r101);     // Catch: JSONException -> L38
    L42:
        if (r102 == null) goto L44;
        r105.put("chat_type", r102);     // Catch: JSONException -> L38
    L44:
        if (r103 == null) goto L46;
        r105.put("click_from", r103);     // Catch: JSONException -> L38
    L46:
        if (r104 == null) goto L48;
        r105.put("current_page", r104);     // Catch: JSONException -> L38
    L48:
        if (r107 == null) goto L50;
        r105.put("is_call_bot", r107);     // Catch: JSONException -> L38
    L50:
        boolean r108 = false;
        if (r106 != null) goto L53;
    L55:
        boolean r109 = false;
    L56:
        if (r109 == false) goto L58;
        r105.put("recommend_from", r106);     // Catch: JSONException -> L38
    L58:
        if (r110 != null) goto L60;
    L62:
        if (r108 == false) goto L64;
        r105.put("request_id", r110);     // Catch: JSONException -> L38
    L64:
        if (r111 == null) goto L66;
        r105.put("is_navigation_sidebar", r111);     // Catch: JSONException -> L38
    L66:
        if (r112 == null) goto L70;
        r105.put("chat_status", r112);     // Catch: JSONException -> L38
    L38:
        e = move-exception;
        FLogger.f375446a.e("RemoveEventHelper", "error in RemoveEventHelper removeChat " + e.getLocalizedMessage());
    L70:
        TrackParams r114 = new TrackParams().merge(r105);
        by7.a r115 = new by7.a("remove_chat");
        r115.f21463a.merge(r114);
        r115.b();
        return;
    L60:
        if (com.larus.utils.o0.d(r110) != true) goto L62;
        r108 = true;
        goto L62
    L53:
        if (com.larus.utils.o0.d(r106) != true) goto L55;
        r109 = true;
        goto L56
    L72:
        r105.put("bot_id", r100);     // Catch: JSONException -> L38
        goto L40
    }
}
