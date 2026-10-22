package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class v2 {
    public static void c(boolean r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        TrackParams r102 = new TrackParams().merge(r101);
        if (r100 == false) goto L5;
        String r103 = "pin_no_chat_cell";
    L6:
        by7.a r104 = new by7.a(r103);
        r104.f21463a.merge(r102);
        r104.b();
        return;
    L5:
        r103 = "unpin_no_chat_cell";
        goto L6
    }

    public static final void a(String r100, String r101, String r102, String r103, String r104, JSONObject r105, by7.e r106, String r107, String r108, String r110, String r111, Integer r112, String r113) {
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L45;
    L7:
        if (r101 == null) goto L9;
        r105.put("click_from", r101);     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L11;
        r105.put("current_page", r102);     // Catch: JSONException -> L5
    L11:
        if (r103 == null) goto L13;
        r105.put("chat_type", r103);     // Catch: JSONException -> L5
    L13:
        if (r104 == null) goto L15;
        r105.put("is_immersive_background", r104);     // Catch: JSONException -> L5
    L15:
        if (r108 == null) goto L17;
        r105.put("is_call_bot", r108);     // Catch: JSONException -> L5
    L17:
        boolean r109 = true;
        if (r107 != null) goto L20;
    L22:
        boolean r114 = false;
    L23:
        if (r114 == false) goto L25;
        r105.put("recommend_from", r107);     // Catch: JSONException -> L5
    L25:
        if (r110 != null) goto L27;
    L29:
        r109 = false;
    L30:
        if (r109 == false) goto L32;
        r105.put("request_id", r110);     // Catch: JSONException -> L5
    L32:
        if (r111 == null) goto L34;
        r105.put("is_navigation_sidebar", r111);     // Catch: JSONException -> L5
    L34:
        if (r112 == null) goto L36;
        r105.put("bot_type", r112.intValue());     // Catch: JSONException -> L5
    L36:
        if (r113 == null) goto L40;
        r105.put("conversation_id", r113);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("PinEventHelper", "error in PinEventHelper pinChat " + e.getLocalizedMessage());
    L40:
        TrackParams r115 = new TrackParams().merge(r105);
        by7.a r116 = new by7.a("pin_chat");
        if (r106 == null) goto L43;
        r116.f21464b = r106;
    L43:
        r116.f21463a.merge(r115);
        r116.b();
        return;
    L27:
        if (com.larus.utils.o0.d(r110) != true) goto L29;
    L20:
        if (com.larus.utils.o0.d(r107) != true) goto L22;
        r114 = true;
        goto L23
    L45:
        r105.put("bot_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static /* synthetic */ void b(String r100, String r101, String r102, String r103, String r104, JSONObject r105, by7.e r106, String r107, String r110, String r111, String r112, Integer r113, int r114) {
        if ((r114 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r114 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r114 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r114 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r114 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r114 & 32) == 0) goto L21;
        r105 = new JSONObject();
    L21:
        if ((r114 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r114 & 128) == 0) goto L27;
        r107 = null;
    L27:
        if ((r114 & 256) == 0) goto L30;
        r110 = null;
    L30:
        if ((r114 & 512) == 0) goto L33;
        r111 = null;
    L33:
        if ((r114 & 1024) == 0) goto L36;
        r112 = null;
    L36:
        if ((r114 & 2048) == 0) goto L38;
        r113 = null;
    L38:
        a(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, null);
    }

    public static final void d(String r100, String r101, String r102, String r103, String r104, JSONObject r105, by7.e r106, String r107, String r108, String r110, String r111, Integer r112, String r113) {
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L45;
    L7:
        if (r101 == null) goto L9;
        r105.put("click_from", r101);     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L11;
        r105.put("current_page", r102);     // Catch: JSONException -> L5
    L11:
        if (r103 == null) goto L13;
        r105.put("chat_type", r103);     // Catch: JSONException -> L5
    L13:
        if (r104 == null) goto L15;
        r105.put("is_immersive_background", r104);     // Catch: JSONException -> L5
    L15:
        if (r107 == null) goto L17;
        r105.put("is_call_bot", r107);     // Catch: JSONException -> L5
    L17:
        boolean r109 = true;
        if (r108 != null) goto L20;
    L22:
        boolean r114 = false;
    L23:
        if (r114 == false) goto L25;
        r105.put("recommend_from", r108);     // Catch: JSONException -> L5
    L25:
        if (r110 != null) goto L27;
    L29:
        r109 = false;
    L30:
        if (r109 == false) goto L32;
        r105.put("request_id", r110);     // Catch: JSONException -> L5
    L32:
        if (r111 == null) goto L34;
        r105.put("is_navigation_sidebar", r111);     // Catch: JSONException -> L5
    L34:
        if (r112 == null) goto L36;
        r105.put("bot_type", r112.intValue());     // Catch: JSONException -> L5
    L36:
        if (r113 == null) goto L40;
        r105.put("conversation_id", r113);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("PinEventHelper", "error in PinEventHelper pinChat " + e.getLocalizedMessage());
    L40:
        TrackParams r115 = new TrackParams().merge(r105);
        by7.a r116 = new by7.a("unpin_chat");
        if (r106 == null) goto L43;
        r116.f21464b = r106;
    L43:
        r116.f21463a.merge(r115);
        r116.b();
        return;
    L27:
        if (com.larus.utils.o0.d(r110) != true) goto L29;
    L20:
        if (com.larus.utils.o0.d(r108) != true) goto L22;
        r114 = true;
        goto L23
    L45:
        r105.put("bot_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static /* synthetic */ void e(String r100, String r101, String r102, String r103, String r104, JSONObject r105, by7.e r106, String r107, String r110, String r111, String r112, Integer r113, int r114) {
        if ((r114 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r114 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r114 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r114 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r114 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r114 & 32) == 0) goto L21;
        r105 = new JSONObject();
    L21:
        if ((r114 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r114 & 128) == 0) goto L27;
        r107 = null;
    L27:
        if ((r114 & 256) == 0) goto L30;
        r110 = null;
    L30:
        if ((r114 & 512) == 0) goto L33;
        r111 = null;
    L33:
        if ((r114 & 1024) == 0) goto L36;
        r112 = null;
    L36:
        if ((r114 & 2048) == 0) goto L38;
        r113 = null;
    L38:
        d(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, null);
    }
}
