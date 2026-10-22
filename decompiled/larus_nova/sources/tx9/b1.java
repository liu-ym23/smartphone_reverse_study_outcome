package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.FilePreviewFragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class b1 {
    public static void d(String r100, String r101, String r102, String r103, FilePreviewFragment r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "params");
        r105.putOpt("bot_id", r100);     // Catch: JSONException -> L5
        r105.putOpt("export_id", r102);     // Catch: JSONException -> L5
        r105.putOpt("click_from", r103);     // Catch: JSONException -> L5
        r105.putOpt("file_type", r101);     // Catch: JSONException -> L5
    L7:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("exporting_file_preview_click");
        r107.f21464b = r104;
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("ExportFileEventHelper", "error in ExportFileEventHelper mobExportingFilePreviewClick " + e.getLocalizedMessage());
        goto L7
    }

    public static void c(String r100, String r101, String r102, String r103, String r104, String r105, Integer r106, by7.e r107, int r110) {
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
        r106 = null;
    L24:
        if ((r110 & 256) == 0) goto L26;
        JSONObject r108 = new JSONObject();
    L28:
        if ((r110 & 512) == 0) goto L30;
        r107 = null;
    L30:
        Intrinsics.checkNotNullParameter(r108, "params");
        r108.putOpt("bot_id", r100);     // Catch: JSONException -> L33
        r108.putOpt("chat_type", r101);     // Catch: JSONException -> L33
        r108.putOpt("export_action_id", r102);     // Catch: JSONException -> L33
        r108.putOpt("page_token", r103);     // Catch: JSONException -> L33
        r108.putOpt("artifact_meta_id", r105);     // Catch: JSONException -> L33
        r108.putOpt("resource_type", r106);     // Catch: JSONException -> L33
        r108.putOpt("show_from", r104);     // Catch: JSONException -> L33
    L35:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r111 = new by7.a("export_panel_show");
        if (r107 == null) goto L38;
        r111.f21464b = r107;
    L38:
        r111.f21463a.merge(r109);
        r111.b();
        return;
    L33:
        e = move-exception;
        FLogger.f375446a.e("ExportFileEventHelper", "error in ExportFileEventHelper mobExportPanelShow " + e.getLocalizedMessage());
        goto L35
    L26:
        r108 = null;
        goto L28
    }

    public static void b(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, Integer r111, String r112, String r113, by7.e r114, int r115) {
        if ((r115 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r115 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r115 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r115 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r115 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r115 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r115 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r115 & 128) == 0) goto L27;
        r107 = null;
    L27:
        if ((r115 & 256) == 0) goto L30;
        r110 = null;
    L30:
        if ((r115 & 512) == 0) goto L33;
        r111 = null;
    L33:
        if ((r115 & 1024) == 0) goto L36;
        r112 = null;
    L36:
        if ((r115 & 2048) == 0) goto L39;
        r113 = null;
    L39:
        if ((r115 & 4096) == 0) goto L41;
        JSONObject r108 = new JSONObject();
    L43:
        if ((r115 & 8192) == 0) goto L45;
        r114 = null;
    L45:
        Intrinsics.checkNotNullParameter(r108, "params");
        r108.putOpt("bot_id", r100);     // Catch: JSONException -> L48
        r108.putOpt("chat_type", r101);     // Catch: JSONException -> L48
        r108.putOpt("show_from", r102);     // Catch: JSONException -> L48
        r108.putOpt("export_action_id", r103);     // Catch: JSONException -> L48
        r108.putOpt("message_id_list", r104);     // Catch: JSONException -> L48
        r108.putOpt("deep_research_id", r105);     // Catch: JSONException -> L48
        r108.putOpt("click_module", r106);     // Catch: JSONException -> L48
        r108.putOpt("page_token", r107);     // Catch: JSONException -> L48
        r108.putOpt("artifact_meta_id", r110);     // Catch: JSONException -> L48
        r108.putOpt("resource_type", r111);     // Catch: JSONException -> L48
        r108.putOpt("file_type", r112);     // Catch: JSONException -> L48
        r108.putOpt("current_page", r113);     // Catch: JSONException -> L48
    L50:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r116 = new by7.a("export_panel_element_show");
        if (r114 == null) goto L53;
        r116.f21464b = r114;
    L53:
        r116.f21463a.merge(r109);
        r116.b();
        return;
    L48:
        e = move-exception;
        FLogger.f375446a.e("ExportFileEventHelper", "error in ExportFileEventHelper mobExportPanelElementShow " + e.getLocalizedMessage());
        goto L50
    L41:
        r108 = null;
        goto L43
    }

    public static void a(String r110, String r111, Integer r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, Integer r218, String r219, by7.e r310, int r311) {
        by7.e r100 = null;
        if ((r311 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r311 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r311 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r311 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r311 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r311 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r311 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r311 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r311 & 256) == 0) goto L37;
        String r113 = null;
    L39:
        if ((r311 & 512) == 0) goto L41;
        String r114 = null;
    L43:
        if ((r311 & 1024) == 0) goto L45;
        String r115 = null;
    L47:
        if ((r311 & 2048) == 0) goto L49;
        Integer r116 = null;
    L51:
        if ((r311 & 4096) == 0) goto L53;
        String r117 = null;
    L55:
        if ((r311 & 16384) == 0) goto L57;
        JSONObject r118 = new JSONObject();
    L59:
        if ((r311 & 32768) != 0) goto L62;
        r100 = r310;
    L62:
        Intrinsics.checkNotNullParameter(r118, "params");
        r118.putOpt("bot_id", r101);     // Catch: JSONException -> L65
        r118.putOpt("chat_type", r102);     // Catch: JSONException -> L65
        r118.putOpt("export_action_id", r105);     // Catch: JSONException -> L65
        r118.putOpt("click_from", r106);     // Catch: JSONException -> L65
        r118.putOpt("export_msg_cnt", r103);     // Catch: JSONException -> L65
        r118.putOpt("file_type", r104);     // Catch: JSONException -> L65
        r118.putOpt("message_id_list", r107);     // Catch: JSONException -> L65
        r118.putOpt("click_module", r113);     // Catch: JSONException -> L65
        r118.putOpt("deep_research_id", r108);     // Catch: JSONException -> L65
        r118.putOpt("page_token", r114);     // Catch: JSONException -> L65
        r118.putOpt("artifact_meta_id", r115);     // Catch: JSONException -> L65
        r118.putOpt("resource_type", r116);     // Catch: JSONException -> L65
        r118.putOpt("show_from", r117);     // Catch: JSONException -> L65
    L67:
        TrackParams r109 = new TrackParams().merge(r118);
        by7.a r119 = new by7.a("export_panel_element_click");
        if (r100 == null) goto L70;
        r119.f21464b = r100;
    L70:
        r119.f21463a.merge(r109);
        r119.b();
        return;
    L65:
        e = move-exception;
        FLogger.f375446a.e("ExportFileEventHelper", "error in ExportFileEventHelper mobExportPanelElementClick " + e.getLocalizedMessage());
        goto L67
    L57:
        r118 = null;
        goto L59
    L53:
        r117 = r219;
        goto L55
    L49:
        r116 = r218;
        goto L51
    L45:
        r115 = r217;
        goto L47
    L41:
        r114 = r216;
        goto L43
    L37:
        r113 = r215;
        goto L39
    L33:
        r108 = r214;
        goto L35
    L29:
        r107 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
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
