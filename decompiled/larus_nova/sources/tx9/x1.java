package tx9;

import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class x1 {
    public static void a(Long r100, String r101, Long r102, Long r103, Long r104, int r105) {
        JSONObject r106 = null;
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r105 & 32) == 0) goto L20;
        r106 = new JSONObject();
    L20:
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 != null) goto L37;
    L25:
        if (r101 == null) goto L27;
        r106.put("node_type_list", r101);     // Catch: JSONException -> L23
    L27:
        if (r102 == null) goto L29;
        r106.put("markwonCreateDuration", r102.longValue());     // Catch: JSONException -> L23
    L29:
        if (r103 == null) goto L31;
        r106.put("markwonParseDuration", r103.longValue());     // Catch: JSONException -> L23
    L31:
        if (r104 == null) goto L35;
        r106.put("markwonRenderDuration", r104.longValue());     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        FLogger.f375446a.e("MarkdownSpanEventHelper", "error in MarkdownSpanEventHelper mobFlowMarkdownRender " + e.getLocalizedMessage());
    L35:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("flow_markdown_render");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L37:
        r106.put("parse_char_count", r100.longValue());     // Catch: JSONException -> L23
        goto L25
    }

    public static void e(String r100, String r101, String r102, String r103, String r104, JSONObject r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 16) == 0) goto L18;
        r104 = "meet_quota_limit";
    L18:
        if ((r106 & 32) == 0) goto L20;
        r105 = new JSONObject();
    L20:
        Intrinsics.checkNotNullParameter(r105, "params");
        r105.remove("growth_deepevent");     // Catch: JSONException -> L35
        if (r100 == null) goto L24;
        r105.put("pc_guide_scene", r100);     // Catch: JSONException -> L35
    L24:
        if (r101 == null) goto L26;
        r105.put("pc_guide_position", r101);     // Catch: JSONException -> L35
    L26:
        if (r102 == null) goto L28;
        r105.put("pc_guide_style", r102);     // Catch: JSONException -> L35
    L28:
        if (r103 == null) goto L31;
        r105.put("pc_guide_content", r103);     // Catch: JSONException -> L35
    L31:
        if (Intrinsics.areEqual(r100, "ug_free_subs_download_pc") == false) goto L37;
        if (r104 == null) goto L37;
        r105.put("ug_free_subs_download_pc_source", r104);     // Catch: JSONException -> L35
    L37:
        TrackParams r107 = new TrackParams().merge(r105);
        by7.a r108 = new by7.a("pc_guide_link_click");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L35:
        e = move-exception;
        FLogger.f375446a.e("MarkdownSpanEventHelper", "error in MarkdownSpanEventHelper pcGuideLinkClick " + e.getLocalizedMessage());
        goto L37
    }

    public static void f(String r100, String r101, String r102, String r103, String r104, JSONObject r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 16) == 0) goto L18;
        r104 = "meet_quota_limit";
    L18:
        if ((r106 & 32) == 0) goto L20;
        r105 = new JSONObject();
    L20:
        Intrinsics.checkNotNullParameter(r105, "params");
        r105.remove("growth_deepevent");     // Catch: JSONException -> L35
        if (r100 == null) goto L24;
        r105.put("pc_guide_scene", r100);     // Catch: JSONException -> L35
    L24:
        if (r101 == null) goto L26;
        r105.put("pc_guide_position", r101);     // Catch: JSONException -> L35
    L26:
        if (r102 == null) goto L28;
        r105.put("pc_guide_style", r102);     // Catch: JSONException -> L35
    L28:
        if (r103 == null) goto L31;
        r105.put("pc_guide_content", r103);     // Catch: JSONException -> L35
    L31:
        if (Intrinsics.areEqual(r100, "ug_free_subs_download_pc") == false) goto L37;
        if (r104 == null) goto L37;
        r105.put("ug_free_subs_download_pc_source", r104);     // Catch: JSONException -> L35
    L37:
        TrackParams r107 = new TrackParams().merge(r105);
        by7.a r108 = new by7.a("pc_guide_link_show");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L35:
        e = move-exception;
        FLogger.f375446a.e("MarkdownSpanEventHelper", "error in MarkdownSpanEventHelper pcGuideLinkShow " + e.getLocalizedMessage());
        goto L37
    }

    public static void d(String r100, Long r101, Long r102, Long r103, Long r104, Long r105, Long r106, Long r107, Long r110, Long r111) {
        JSONObject r108 = new JSONObject();
        Intrinsics.checkNotNullParameter(r108, "params");
        r108.put("node_type_list", r100);     // Catch: JSONException -> L23
        if (r101 == null) goto L6;
        r108.put("create_view_duration", r101.longValue());     // Catch: JSONException -> L23
    L6:
        if (r102 == null) goto L8;
        r108.put("set_listener_duration", r102.longValue());     // Catch: JSONException -> L23
    L8:
        if (r103 == null) goto L10;
        r108.put("before_set_text_duration", r103.longValue());     // Catch: JSONException -> L23
    L10:
        if (r104 == null) goto L12;
        r108.put("real_set_text_duration", r104.longValue());     // Catch: JSONException -> L23
    L12:
        if (r105 == null) goto L14;
        r108.put("after_set_text_duration", r105.longValue());     // Catch: JSONException -> L23
    L14:
        if (r106 == null) goto L16;
        r108.put("set_markdown_duration", r106.longValue());     // Catch: JSONException -> L23
    L16:
        if (r107 == null) goto L18;
        r108.put("set_stream_alpha_duration", r107.longValue());     // Catch: JSONException -> L23
    L18:
        if (r110 == null) goto L20;
        r108.put("set_add_view_duration", r110.longValue());     // Catch: JSONException -> L23
    L20:
        if (r111 == null) goto L25;
        r108.put("total_duration", r111.longValue());     // Catch: JSONException -> L23
    L25:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r112 = new by7.a("flow_md_text_view_widget_render");
        r112.f21463a.merge(r109);
        r112.b();
        return;
    L23:
        e = move-exception;
        FLogger.f375446a.e("MarkdownSpanEventHelper", "error in MarkdownSpanEventHelper mobMdTextViewWidgetRender " + e.getLocalizedMessage());
        goto L25
    }

    public static void b(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, String r113, String r114, String r115) {
        JSONObject r108 = new JSONObject();
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r106 != null) goto L36;
    L7:
        r108.put("current_page", r100);     // Catch: JSONException -> L5
        if (r101 == null) goto L10;
        r108.put("previous_page", r101);     // Catch: JSONException -> L5
    L10:
        if (r105 == null) goto L12;
        r108.put("chat_type", r105);     // Catch: JSONException -> L5
    L12:
        if (r104 == null) goto L14;
        r108.put("bot_id", r104);     // Catch: JSONException -> L5
    L14:
        if (r103 == null) goto L16;
        r108.put("conversation_id", r103);     // Catch: JSONException -> L5
    L16:
        if (r102 == null) goto L18;
        r108.put(MusicAppletPage.KEY_MESSAGE_ID, r102);     // Catch: JSONException -> L5
    L18:
        if (r107 == null) goto L20;
        r108.put("url", r107);     // Catch: JSONException -> L5
    L20:
        if (r110 == null) goto L22;
        r108.put("inline_type", r110);     // Catch: JSONException -> L5
    L22:
        if (r114 == null) goto L24;
        r108.put("deep_research_id", r114);     // Catch: JSONException -> L5
    L24:
        if (r115 == null) goto L26;
        r108.put("doc_id", r115);     // Catch: JSONException -> L5
    L26:
        if (r111 == null) goto L28;
        r108.put("inline_display_position", r111);     // Catch: JSONException -> L5
    L28:
        if (r112 == null) goto L30;
        r108.put("inline_text", r112);     // Catch: JSONException -> L5
    L30:
        if (r113 == null) goto L34;
        r108.put("doc_position", r113);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("MarkdownSpanEventHelper", "error in MarkdownSpanEventHelper mobInlineCitationSpanClick " + e.getLocalizedMessage());
    L34:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r116 = new by7.a("inline_click");
        r116.f21463a.merge(r109);
        r116.b();
        return;
    L36:
        r108.put(NoticeInfo.KEY_REPLY_ID, r106);     // Catch: JSONException -> L5
        goto L7
    }

    public static void c(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, String r113, String r114, String r115) {
        JSONObject r108 = new JSONObject();
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r106 != null) goto L36;
    L7:
        r108.put("current_page", r100);     // Catch: JSONException -> L5
        if (r101 == null) goto L10;
        r108.put("previous_page", r101);     // Catch: JSONException -> L5
    L10:
        if (r105 == null) goto L12;
        r108.put("chat_type", r105);     // Catch: JSONException -> L5
    L12:
        if (r104 == null) goto L14;
        r108.put("bot_id", r104);     // Catch: JSONException -> L5
    L14:
        if (r103 == null) goto L16;
        r108.put("conversation_id", r103);     // Catch: JSONException -> L5
    L16:
        if (r102 == null) goto L18;
        r108.put(MusicAppletPage.KEY_MESSAGE_ID, r102);     // Catch: JSONException -> L5
    L18:
        if (r107 == null) goto L20;
        r108.put("url", r107);     // Catch: JSONException -> L5
    L20:
        if (r110 == null) goto L22;
        r108.put("inline_type", r110);     // Catch: JSONException -> L5
    L22:
        if (r114 == null) goto L24;
        r108.put("deep_research_id", r114);     // Catch: JSONException -> L5
    L24:
        if (r115 == null) goto L26;
        r108.put("doc_id", r115);     // Catch: JSONException -> L5
    L26:
        if (r111 == null) goto L28;
        r108.put("inline_display_position", r111);     // Catch: JSONException -> L5
    L28:
        if (r112 == null) goto L30;
        r108.put("inline_text", r112);     // Catch: JSONException -> L5
    L30:
        if (r113 == null) goto L34;
        r108.put("doc_position", r113);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("MarkdownSpanEventHelper", "error in MarkdownSpanEventHelper mobInlineCitationSpanShow " + e.getLocalizedMessage());
    L34:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r116 = new by7.a("inline_show");
        r116.f21463a.merge(r109);
        r116.b();
        return;
    L36:
        r108.put(NoticeInfo.KEY_REPLY_ID, r106);     // Catch: JSONException -> L5
        goto L7
    }
}
