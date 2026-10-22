package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class u0 {
    public static void b(String r100, by7.e r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        JSONObject r103 = new JSONObject();
    L7:
        if ((r102 & 4) == 0) goto L9;
        r101 = null;
    L9:
        Intrinsics.checkNotNullParameter(r100, "failReason");
        Intrinsics.checkNotNullParameter(r103, "params");
        r103.put("fail_reason", r100);     // Catch: JSONException -> L12
    L14:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("doc_offline_id_not_synced");
        if (r101 == null) goto L17;
        r105.f21464b = r101;
    L17:
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L12:
        e = move-exception;
        FLogger.f375446a.e("DocumentEventHelper", "error in DocumentEventHelper mobDocOfflineIdNotSynced: " + e.getLocalizedMessage());
        goto L14
    L5:
        r103 = null;
        goto L7
    }

    public static void i(boolean r100, String r101, String r102, Integer r103, String r104, by7.e r105) {
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r101 != null) goto L24;
    L7:
        if (r102 == null) goto L9;
        r106.put("artifact_meta_id", r102);     // Catch: JSONException -> L5
    L9:
        if (r103 == null) goto L11;
        r106.put("resource_type", r103.intValue());     // Catch: JSONException -> L5
    L11:
        if (r104 == null) goto L15;
        r106.put("current_page", r104);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("DocumentEventHelper", "error in DocumentEventHelper mobSecurityReviewRejected: " + e.getLocalizedMessage());
    L15:
        TrackParams r107 = new TrackParams().merge(r106);
        if (r100 == false) goto L18;
        String r108 = "doc_security_review_rejected_click";
    L19:
        by7.a r109 = new by7.a(r108);
        if (r105 == null) goto L22;
        r109.f21464b = r105;
    L22:
        r109.f21463a.merge(r107);
        r109.b();
        return;
    L18:
        r108 = "doc_security_review_rejected_show";
        goto L19
    L24:
        r106.put("page_token", r101);     // Catch: JSONException -> L5
        goto L7
    }

    public static void a(String r100, boolean r101, Boolean r102, Boolean r103, Boolean r104, Boolean r105, by7.e r106) {
        JSONObject r107 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "failReason");
        Intrinsics.checkNotNullParameter(r107, "params");
        r107.put("fail_reason", r100);     // Catch: JSONException -> L13
        r107.put("has_offline_doc_created", r101);     // Catch: JSONException -> L13
        if (r102 == null) goto L6;
        r107.put("is_compensate_create", r102.booleanValue());     // Catch: JSONException -> L13
    L6:
        if (r103 == null) goto L8;
        r107.put("has_real_token", r103.booleanValue());     // Catch: JSONException -> L13
    L8:
        if (r104 == null) goto L10;
        r107.put("has_user_changes", r104.booleanValue());     // Catch: JSONException -> L13
    L10:
        if (r105 == null) goto L15;
        r107.put("has_frontend_linked", r105.booleanValue());     // Catch: JSONException -> L13
    L15:
        TrackParams r108 = new TrackParams().merge(r107);
        by7.a r109 = new by7.a("doc_offline_compensate_create");
        if (r106 == null) goto L18;
        r109.f21464b = r106;
    L18:
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L13:
        e = move-exception;
        FLogger.f375446a.e("DocumentEventHelper", "error in DocumentEventHelper mobDocOfflineCompensateCreate: " + e.getLocalizedMessage());
        goto L15
    }

    public static void c(String r100, String r101, String r102, Long r103, String r104, Integer r105, JSONObject r106, int r107) {
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
        r106 = new JSONObject();
    L23:
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r101 != null) goto L42;
    L28:
        if (r100 == null) goto L30;
        r106.put("success", r100);     // Catch: JSONException -> L26
    L30:
        if (r102 == null) goto L32;
        r106.put("export_type", r102);     // Catch: JSONException -> L26
    L32:
        if (r103 == null) goto L34;
        r106.put("duration", r103.longValue());     // Catch: JSONException -> L26
    L34:
        if (r105 == null) goto L36;
        r106.put("resource_type", r105.intValue());     // Catch: JSONException -> L26
    L36:
        if (r104 == null) goto L40;
        r106.put("error_msg", r104);     // Catch: JSONException -> L26
    L26:
        e = move-exception;
        FLogger.f375446a.e("DocumentEventHelper", "error in DocumentEventHelper mobFileFunctionStatus: " + e.getLocalizedMessage());
    L40:
        TrackParams r108 = new TrackParams().merge(r106);
        by7.a r109 = new by7.a("doc_export_result");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L42:
        r106.put("page_token", r101);     // Catch: JSONException -> L26
        goto L28
    }

    public static void f(String r100, String r101, String r102, String r103, String r104, String r105, Integer r106, String r107, JSONObject r110, by7.e r111, int r112) {
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
        if (r100 != null) goto L58;
    L37:
        if (r103 == null) goto L39;
        r110.put("button_name", r103);     // Catch: JSONException -> L35
    L39:
        if (r104 == null) goto L41;
        r110.put("page_token", r104);     // Catch: JSONException -> L35
    L41:
        if (r105 == null) goto L43;
        r110.put("artifact_meta_id", r105);     // Catch: JSONException -> L35
    L43:
        if (r106 == null) goto L45;
        r110.put("resource_type", r106.intValue());     // Catch: JSONException -> L35
    L45:
        if (r107 == null) goto L47;
        r110.put("current_page", r107);     // Catch: JSONException -> L35
    L47:
        if (r101 == null) goto L49;
        r110.put("success", r101);     // Catch: JSONException -> L35
    L49:
        if (r102 == null) goto L53;
        r110.put("error_code", r102);     // Catch: JSONException -> L35
    L35:
        e = move-exception;
        FLogger.f375446a.e("DocumentEventHelper", "error in DocumentEventHelper mobFileFunctionStatus: " + e.getLocalizedMessage());
    L53:
        TrackParams r108 = new TrackParams().merge(r110);
        by7.a r109 = new by7.a("file_function_status");
        if (r111 == null) goto L56;
        r109.f21464b = r111;
    L56:
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L58:
        r110.put("show_from", r100);     // Catch: JSONException -> L35
        goto L37
    }

    public static /* synthetic */ void h(boolean r110, String r111, Integer r112, String r113, String r114, String r210, String r211, String r212, String r213, JSONObject r214, int r215) {
        if ((r215 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r215 & 4) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r215 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r215 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r215 & 32) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r215 & 64) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r215 & 128) == 0) goto L29;
        String r115 = null;
    L31:
        if ((r215 & 256) == 0) goto L33;
        String r116 = null;
    L35:
        if ((r215 & 2048) == 0) goto L37;
        JSONObject r117 = new JSONObject();
    L38:
        g(r110, r100, r101, r102, r103, r104, r105, r115, r116, null, null, r117);
        return;
    L37:
        r117 = r214;
        goto L38
    L33:
        r116 = r213;
        goto L35
    L29:
        r115 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public static final void g(boolean r100, String r101, Integer r102, String r103, String r104, String r105, String r106, String r110, String r111, String r112, String r113, JSONObject r114) {
        Intrinsics.checkNotNullParameter(r114, "params");
        if (r101 != null) goto L61;
    L7:
        if (r102 == null) goto L9;
        r114.put("resource_type", r102.intValue());     // Catch: JSONException -> L5
    L9:
        if (r103 == null) goto L11;
        r114.put("canvas_type", r103);     // Catch: JSONException -> L5
    L11:
        if (r104 == null) goto L13;
        r114.put("page_token", r104);     // Catch: JSONException -> L5
    L13:
        if (r105 == null) goto L15;
        r114.put("artifact_meta_id", r105);     // Catch: JSONException -> L5
    L15:
        if (r106 == null) goto L17;
        r114.put("button_name_level_one", r106);     // Catch: JSONException -> L5
    L17:
        if (r111 == null) goto L19;
        r114.put("enter_method", r111);     // Catch: JSONException -> L5
    L19:
        if (r110 == null) goto L21;
        r114.put("button_name_level_two", r110);     // Catch: JSONException -> L5
    L21:
        String r107 = r114.optString("is_general_agent");     // Catch: JSONException -> L5
        Intrinsics.checkNotNull(r107);     // Catch: JSONException -> L5
        boolean r108 = false;
        if (r107.length() <= 0) goto L24;
        boolean r109 = true;
    L25:
        String r115 = null;
        if (r109 == true) goto L29;
        r107 = null;
    L29:
        if (r107 != null) goto L43;
        if (r112 != null) goto L32;
    L35:
        boolean r116 = true;
    L37:
        if ((!r116) == true) goto L40;
        r112 = null;
    L40:
        if (r112 != null) goto L42;
        r107 = "0";
        goto L43
    L42:
        r107 = r112;
        goto L43
    L32:
        if (r112.length() == 0) goto L35;
        r116 = false;
    L43:
        String r117 = r114.optString("chat_id");     // Catch: JSONException -> L5
        Intrinsics.checkNotNull(r117);     // Catch: JSONException -> L5
        if (r117.length() <= 0) goto L46;
        r108 = true;
    L46:
        if (r108 == false) goto L48;
        r115 = r117;
    L48:
        if (r115 != null) goto L51;
        if (r113 != null) goto L52;
        r113 = "";
    L52:
        r114.put("is_general_agent", r107);     // Catch: JSONException -> L5
        r114.put("chat_id", r113);     // Catch: JSONException -> L5
    L55:
        TrackParams r118 = new TrackParams().merge(r114);
        if (r100 == false) goto L58;
        String r119 = "output_preview_tool_show";
    L59:
        by7.a r120 = new by7.a(r119);
        r120.f21463a.merge(r118);
        r120.b();
        return;
    L58:
        r119 = "output_preview_tool_click";
    L5:
        e = move-exception;
        FLogger.f375446a.e("DocumentEventHelper", "error in DocumentEventHelper reportOutputPreviewToolShow: " + e.getLocalizedMessage());
        goto L55
    L51:
        r113 = r115;
        goto L52
    L24:
        r109 = false;
        goto L25
    L61:
        r114.put("current_page", r101);     // Catch: JSONException -> L5
        goto L7
    }

    public static void e(String r100, String r101, String r102, Integer r103, String r104, String r105, String r106, String r107, String r110, String r111, JSONObject r112, by7.e r113, int r114) {
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
        r112 = new JSONObject();
    L36:
        if ((r114 & 2048) == 0) goto L38;
        r113 = null;
    L38:
        Intrinsics.checkNotNullParameter(r112, "params");
        if (r100 != null) goto L68;
    L43:
        if (r101 == null) goto L45;
        r112.put("page_token", r101);     // Catch: JSONException -> L41
    L45:
        if (r102 == null) goto L47;
        r112.put("artifact_meta_id", r102);     // Catch: JSONException -> L41
    L47:
        if (r103 == null) goto L49;
        r112.put("resource_type", r103.intValue());     // Catch: JSONException -> L41
    L49:
        if (r104 == null) goto L51;
        r112.put("current_page", r104);     // Catch: JSONException -> L41
    L51:
        if (r105 == null) goto L53;
        r112.put("previous_page", r105);     // Catch: JSONException -> L41
    L53:
        if (r106 == null) goto L55;
        r112.put("collection_id", r106);     // Catch: JSONException -> L41
    L55:
        if (r107 == null) goto L57;
        r112.put("collection_name", r107);     // Catch: JSONException -> L41
    L57:
        if (r110 == null) goto L59;
        r112.put("content_type", r110);     // Catch: JSONException -> L41
    L59:
        if (r111 == null) goto L63;
        r112.put("content_sec_type", r111);     // Catch: JSONException -> L41
    L41:
        e = move-exception;
        FLogger.f375446a.e("DocumentEventHelper", "error in DocumentEventHelper mobFileFunctionShow: " + e.getLocalizedMessage());
    L63:
        TrackParams r108 = new TrackParams().merge(r112);
        by7.a r109 = new by7.a("file_function_show");
        if (r113 == null) goto L66;
        r109.f21464b = r113;
    L66:
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L68:
        r112.put("show_from", r100);     // Catch: JSONException -> L41
        goto L43
    }

    public static void d(String r110, String r111, String r112, String r113, Integer r114, String r210, String r211, String r212, String r213, String r214, String r215, String r216, JSONObject r217, by7.e r218, int r219) {
        by7.e r100 = null;
        if ((r219 & 1) == 0) goto L5;
        Object r101 = null;
    L7:
        if ((r219 & 2) == 0) goto L9;
        Object r102 = null;
    L11:
        if ((r219 & 4) == 0) goto L13;
        Object r103 = null;
    L15:
        if ((r219 & 8) == 0) goto L17;
        Object r104 = null;
    L19:
        if ((r219 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r219 & 32) == 0) goto L25;
        Object r106 = null;
    L27:
        if ((r219 & 64) == 0) goto L29;
        Object r107 = null;
    L31:
        if ((r219 & 128) == 0) goto L33;
        Object r108 = null;
    L35:
        if ((r219 & 256) == 0) goto L37;
        Object r115 = null;
    L39:
        if ((r219 & 512) == 0) goto L41;
        Object r116 = null;
    L43:
        if ((r219 & 1024) == 0) goto L45;
        Object r117 = null;
    L47:
        if ((r219 & 2048) == 0) goto L49;
        Object r118 = null;
    L51:
        if ((r219 & 4096) == 0) goto L53;
        JSONObject r119 = new JSONObject();
    L55:
        if ((r219 & 8192) != 0) goto L58;
        r100 = r218;
    L58:
        Intrinsics.checkNotNullParameter(r119, "params");
        if (r101 != null) goto L92;
    L63:
        if (r102 == null) goto L65;
        r119.put("button_name", r102);     // Catch: JSONException -> L61
    L65:
        if (r103 == null) goto L67;
        r119.put("page_token", r103);     // Catch: JSONException -> L61
    L67:
        if (r104 == null) goto L69;
        r119.put("artifact_meta_id", r104);     // Catch: JSONException -> L61
    L69:
        if (r105 == null) goto L71;
        r119.put("resource_type", r105.intValue());     // Catch: JSONException -> L61
    L71:
        if (r106 == null) goto L73;
        r119.put("current_page", r106);     // Catch: JSONException -> L61
    L73:
        if (r107 == null) goto L75;
        r119.put("previous_page", r107);     // Catch: JSONException -> L61
    L75:
        if (r108 == null) goto L77;
        r119.put("collection_id", r108);     // Catch: JSONException -> L61
    L77:
        if (r115 == null) goto L79;
        r119.put("collection_name", r115);     // Catch: JSONException -> L61
    L79:
        if (r116 == null) goto L81;
        r119.put("content_type", r116);     // Catch: JSONException -> L61
    L81:
        if (r117 == null) goto L83;
        r119.put("content_sec_type", r117);     // Catch: JSONException -> L61
    L83:
        if (r118 == null) goto L87;
        r119.put("if_multiple_choose", r118);     // Catch: JSONException -> L61
    L61:
        e = move-exception;
        FLogger.f375446a.e("DocumentEventHelper", "error in DocumentEventHelper mobFileFunctionClick: " + e.getLocalizedMessage());
    L87:
        TrackParams r109 = new TrackParams().merge(r119);
        by7.a r120 = new by7.a("file_function_click");
        if (r100 == null) goto L90;
        r120.f21464b = r100;
    L90:
        r120.f21463a.merge(r109);
        r120.b();
        return;
    L92:
        r119.put("show_from", r101);     // Catch: JSONException -> L61
        goto L63
    L53:
        r119 = r217;
        goto L55
    L49:
        r118 = r216;
        goto L51
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
        goto L27
    L21:
        r105 = r114;
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
