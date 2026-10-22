package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class i3 {
    public static void d(String r100, int r101, long r102, int r103) {
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "params");
        r104.put("success", r101);     // Catch: JSONException -> L5
        r104.put("scene", r100);     // Catch: JSONException -> L5
        r104.put("duration", r102);     // Catch: JSONException -> L5
        r104.put("count", r103);     // Catch: JSONException -> L5
    L7:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("search_message_result");
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("SearchEventHelper", "error in SearchEventHelper mobConversationSearchResult " + e.getLocalizedMessage());
        goto L7
    }

    public static void g(Long r100, String r101, String r102, String r103, by7.e r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 64) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 256) == 0) goto L17;
        JSONObject r106 = new JSONObject();
    L19:
        if ((r105 & 512) == 0) goto L21;
        r104 = null;
    L21:
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 != null) goto L39;
    L26:
        if (r101 == null) goto L28;
        r106.put("query", r101);     // Catch: JSONException -> L24
    L28:
        if (r102 == null) goto L30;
        r106.put("query_id", r102);     // Catch: JSONException -> L24
    L30:
        if (r103 == null) goto L34;
        r106.put("search_id", r103);     // Catch: JSONException -> L24
    L24:
        e = move-exception;
        FLogger.f375446a.e("SearchEventHelper", "error in SearchEventHelper searchStayDetailPage " + e.getLocalizedMessage());
    L34:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("search_stay_detail_page");
        if (r104 == null) goto L37;
        r108.f21464b = r104;
    L37:
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L39:
        r106.put("duration", r100.longValue());     // Catch: JSONException -> L24
        goto L26
    L17:
        r106 = null;
        goto L19
    }

    public static void a(String r100, String r101, String r102, String r103, JSONObject r104, by7.e r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 4) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 16) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 32) == 0) goto L18;
        r104 = new JSONObject();
    L18:
        if ((r106 & 64) == 0) goto L20;
        r105 = null;
    L20:
        Intrinsics.checkNotNullParameter(r104, "params");
        if (r100 != null) goto L38;
    L25:
        if (r101 == null) goto L27;
        r104.put("previous_page", r101);     // Catch: JSONException -> L23
    L27:
        if (r102 == null) goto L29;
        r104.put("click_from", r102);     // Catch: JSONException -> L23
    L29:
        if (r103 == null) goto L33;
        r104.put("search_domain", r103);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        FLogger.f375446a.e("SearchEventHelper", "error in SearchEventHelper searchBarClick " + e.getLocalizedMessage());
    L33:
        TrackParams r107 = new TrackParams().merge(r104);
        by7.a r108 = new by7.a("search_bar_click");
        if (r105 == null) goto L36;
        r108.f21464b = r105;
    L36:
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L38:
        r104.put("current_page", r100);     // Catch: JSONException -> L23
        goto L25
    }

    public static void b(String r100, String r101, String r102, String r103, String r104, String r105, JSONObject r106, by7.e r107, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r110 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r110 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r110 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r110 & 64) == 0) goto L24;
        r106 = new JSONObject();
    L24:
        if ((r110 & 128) == 0) goto L26;
        r107 = null;
    L26:
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 != null) goto L48;
    L31:
        if (r101 == null) goto L33;
        r106.put("enter_from", r101);     // Catch: JSONException -> L29
    L33:
        if (r102 == null) goto L35;
        r106.put("previous_page", r102);     // Catch: JSONException -> L29
    L35:
        if (r103 == null) goto L37;
        r106.put("show_method", r103);     // Catch: JSONException -> L29
    L37:
        if (r104 == null) goto L39;
        r106.put("function_type", r104);     // Catch: JSONException -> L29
    L39:
        if (r105 == null) goto L43;
        r106.put("search_domain", r105);     // Catch: JSONException -> L29
    L29:
        e = move-exception;
        FLogger.f375446a.e("SearchEventHelper", "error in SearchEventHelper searchBarShow " + e.getLocalizedMessage());
    L43:
        TrackParams r108 = new TrackParams().merge(r106);
        by7.a r109 = new by7.a("search_bar_show");
        if (r107 == null) goto L46;
        r109.f21464b = r107;
    L46:
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L48:
        r106.put("current_page", r100);     // Catch: JSONException -> L29
        goto L31
    }

    public static void h(String r100, String r101, Long r102, String r103, String r104, String r105, String r106, String r107, String r110, by7.e r111, int r112) {
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
        if ((r112 & 128) == 0) goto L24;
        r106 = null;
    L24:
        if ((r112 & 256) == 0) goto L27;
        r107 = null;
    L27:
        if ((r112 & 512) == 0) goto L30;
        r110 = null;
    L30:
        if ((r112 & 1024) == 0) goto L32;
        JSONObject r108 = new JSONObject();
    L34:
        if ((r112 & 2048) == 0) goto L36;
        r111 = null;
    L36:
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r100 != null) goto L64;
    L41:
        if (r101 == null) goto L43;
        r108.put("current_page", r101);     // Catch: JSONException -> L39
    L43:
        if (r102 == null) goto L45;
        r108.put("duration", r102.longValue());     // Catch: JSONException -> L39
    L45:
        if (r103 == null) goto L47;
        r108.put("query", r103);     // Catch: JSONException -> L39
    L47:
        if (r104 == null) goto L49;
        r108.put("query_id", r104);     // Catch: JSONException -> L39
    L49:
        if (r105 == null) goto L51;
        r108.put("rank", r105);     // Catch: JSONException -> L39
    L51:
        if (r106 == null) goto L53;
        r108.put("search_id", r106);     // Catch: JSONException -> L39
    L53:
        if (r107 == null) goto L55;
        r108.put("search_request_id", r107);     // Catch: JSONException -> L39
    L55:
        if (r110 == null) goto L59;
        r108.put("search_result_id", r110);     // Catch: JSONException -> L39
    L39:
        e = move-exception;
        FLogger.f375446a.e("SearchEventHelper", "error in SearchEventHelper searchStayListPage " + e.getLocalizedMessage());
    L59:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r113 = new by7.a("search_stay_list_page");
        if (r111 == null) goto L62;
        r113.f21464b = r111;
    L62:
        r113.f21463a.merge(r109);
        r113.b();
        return;
    L64:
        r108.put("bot_id", r100);     // Catch: JSONException -> L39
        goto L41
    L32:
        r108 = null;
        goto L34
    }

    public static void c(String r100, String r101, String r102, Long r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, by7.e r113, int r114) {
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
        r105 = null;
    L21:
        if ((r114 & 128) == 0) goto L24;
        r106 = null;
    L24:
        if ((r114 & 256) == 0) goto L27;
        r107 = null;
    L27:
        if ((r114 & 512) == 0) goto L30;
        r110 = null;
    L30:
        if ((r114 & 1024) == 0) goto L33;
        r111 = null;
    L33:
        if ((r114 & 2048) == 0) goto L36;
        r112 = null;
    L36:
        if ((r114 & 4096) == 0) goto L38;
        JSONObject r108 = new JSONObject();
    L40:
        if ((r114 & 8192) == 0) goto L42;
        r113 = null;
    L42:
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r100 != null) goto L74;
    L47:
        if (r101 == null) goto L49;
        r108.put("enter_method", r101);     // Catch: JSONException -> L45
    L49:
        if (r102 == null) goto L51;
        r108.put("err_code", r102);     // Catch: JSONException -> L45
    L51:
        if (r103 == null) goto L53;
        r108.put("is_result_cnt", r103.longValue());     // Catch: JSONException -> L45
    L53:
        if (r104 == null) goto L55;
        r108.put("query", r104);     // Catch: JSONException -> L45
    L55:
        if (r105 == null) goto L57;
        r108.put("query_id", r105);     // Catch: JSONException -> L45
    L57:
        if (r106 == null) goto L59;
        r108.put("search_id", r106);     // Catch: JSONException -> L45
    L59:
        if (r107 == null) goto L61;
        r108.put("search_request_id", r107);     // Catch: JSONException -> L45
    L61:
        if (r110 == null) goto L63;
        r108.put("recommend_from", r110);     // Catch: JSONException -> L45
    L63:
        if (r111 == null) goto L65;
        r108.put("req_id", r111);     // Catch: JSONException -> L45
    L65:
        if (r112 == null) goto L69;
        r108.put("success", r112);     // Catch: JSONException -> L45
    L45:
        e = move-exception;
        FLogger.f375446a.e("SearchEventHelper", "error in SearchEventHelper searchButtonResult " + e.getLocalizedMessage());
    L69:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r115 = new by7.a("search_button_result");
        if (r113 == null) goto L72;
        r115.f21464b = r113;
    L72:
        r115.f21463a.merge(r109);
        r115.b();
        return;
    L74:
        r108.put("current_page", r100);     // Catch: JSONException -> L45
        goto L47
    L38:
        r108 = null;
        goto L40
    }

    public static void e(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111, String r112, Boolean r113, TraceFragment r114, int r115) {
        if ((r115 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r115 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r115 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r115 & 32) == 0) goto L15;
        r103 = null;
    L15:
        if ((r115 & 128) == 0) goto L18;
        r104 = null;
    L18:
        if ((r115 & 256) == 0) goto L21;
        r105 = null;
    L21:
        if ((r115 & 512) == 0) goto L24;
        r106 = null;
    L24:
        if ((r115 & 1024) == 0) goto L27;
        r110 = null;
    L27:
        if ((r115 & 2048) == 0) goto L30;
        r111 = null;
    L30:
        if ((r115 & 4096) == 0) goto L33;
        r112 = null;
    L33:
        if ((r115 & 8192) == 0) goto L36;
        r113 = null;
    L36:
        if ((r115 & 16384) == 0) goto L38;
        JSONObject r107 = new JSONObject();
    L40:
        if ((r115 & 32768) == 0) goto L42;
        r114 = null;
    L42:
        Intrinsics.checkNotNullParameter(r107, "params");
        if (r100 != null) goto L78;
    L47:
        if (r101 == null) goto L49;
        r107.put("chat_type", r101);     // Catch: JSONException -> L45
    L49:
        if (r102 == null) goto L51;
        r107.put("query", r102);     // Catch: JSONException -> L45
    L51:
        if (r103 == null) goto L53;
        r107.put("rank", r103);     // Catch: JSONException -> L45
    L53:
        if (r104 == null) goto L55;
        r107.put("search_id", r104);     // Catch: JSONException -> L45
    L55:
        if (r105 == null) goto L57;
        r107.put("search_request_id", r105);     // Catch: JSONException -> L45
    L57:
        if (r106 == null) goto L59;
        r107.put("search_result_id", r106);     // Catch: JSONException -> L45
    L59:
        if (r110 == null) goto L61;
        r107.put("query_type", r110);     // Catch: JSONException -> L45
    L61:
        if (r111 == null) goto L63;
        r107.put("user_type", r111);     // Catch: JSONException -> L45
    L63:
        if (r112 == null) goto L65;
        r107.put("function_type", r112);     // Catch: JSONException -> L45
    L65:
        if (r113 != null) goto L67;
    L73:
        TrackParams r108 = new TrackParams().merge(r107);
        by7.a r109 = new by7.a("search_result_click");
        if (r114 == null) goto L76;
        r109.f21464b = r114;
    L76:
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L67:
        if (r113.booleanValue() == false) goto L69;
        int r116 = 1;
    L70:
        r107.put("if_have_query", r116);     // Catch: JSONException -> L45
    L45:
        e = move-exception;
        FLogger.f375446a.e("SearchEventHelper", "error in SearchEventHelper searchResultClick " + e.getLocalizedMessage());
        goto L73
    L69:
        r116 = 0;
        goto L70
    L78:
        r107.put("bot_id", r100);     // Catch: JSONException -> L45
        goto L47
    L38:
        r107 = null;
        goto L40
    }

    public static void f(String r110, String r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, String r215, String r216, Boolean r217, by7.e r218, int r219) {
        by7.e r100 = null;
        if ((r219 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r219 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r219 & 8) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r219 & 16) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r219 & 32) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r219 & 128) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r219 & 256) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r219 & 512) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r219 & 1024) == 0) goto L37;
        String r114 = null;
    L39:
        if ((r219 & 2048) == 0) goto L41;
        String r115 = null;
    L43:
        if ((r219 & 4096) == 0) goto L45;
        String r116 = null;
    L47:
        if ((r219 & 8192) == 0) goto L49;
        Boolean r117 = null;
    L51:
        if ((r219 & 16384) == 0) goto L53;
        JSONObject r118 = new JSONObject();
    L55:
        if ((r219 & 32768) != 0) goto L58;
        r100 = r218;
    L58:
        Intrinsics.checkNotNullParameter(r118, "params");
        if (r101 != null) goto L96;
    L63:
        if (r102 == null) goto L65;
        r118.put("chat_type", r102);     // Catch: JSONException -> L61
    L65:
        if (r103 == null) goto L67;
        r118.put("query", r103);     // Catch: JSONException -> L61
    L67:
        if (r104 == null) goto L69;
        r118.put("query_id", r104);     // Catch: JSONException -> L61
    L69:
        if (r105 == null) goto L71;
        r118.put("rank", r105);     // Catch: JSONException -> L61
    L71:
        if (r106 == null) goto L73;
        r118.put("search_id", r106);     // Catch: JSONException -> L61
    L73:
        if (r107 == null) goto L75;
        r118.put("search_request_id", r107);     // Catch: JSONException -> L61
    L75:
        if (r108 == null) goto L77;
        r118.put("search_result_id", r108);     // Catch: JSONException -> L61
    L77:
        if (r114 == null) goto L79;
        r118.put("query_type", r114);     // Catch: JSONException -> L61
    L79:
        if (r116 == null) goto L81;
        r118.put("user_type", r116);     // Catch: JSONException -> L61
    L81:
        if (r115 == null) goto L83;
        r118.put("function_type", r115);     // Catch: JSONException -> L61
    L83:
        if (r117 != null) goto L85;
    L91:
        TrackParams r109 = new TrackParams().merge(r118);
        by7.a r119 = new by7.a("search_result_show");
        if (r100 == null) goto L94;
        r119.f21464b = r100;
    L94:
        r119.f21463a.merge(r109);
        r119.b();
        return;
    L85:
        if (r117.booleanValue() == false) goto L87;
        int r120 = 1;
    L88:
        r118.put("if_have_query", r120);     // Catch: JSONException -> L61
    L61:
        e = move-exception;
        FLogger.f375446a.e("SearchEventHelper", "error in SearchEventHelper searchResultShow " + e.getLocalizedMessage());
        goto L91
    L87:
        r120 = 0;
        goto L88
    L96:
        r118.put("bot_id", r101);     // Catch: JSONException -> L61
        goto L63
    L53:
        r118 = null;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
