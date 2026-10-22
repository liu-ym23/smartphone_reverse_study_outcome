package tx9;

import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.ixigua.lib.track.TrackParams;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class z2 {
    public static void a(String r110, String r111, String r210, String r211, String r212, Integer r213, String r214, Long r215, Long r216, Long r217, Long r218, Long r219, Long r310, Long r311, String r312, String r313, Long r314, Long r315, Long r316, Long r317, Long r318, Long r319, Long r410, Long r411, Long r412, Long r413, String r414, String r415, Integer r416, String r417, String r418, String r419, JSONObject r510, by7.e r511, Long r512, String r513, String r514, String r515, String r516, String r517, String r518, String r519, String r610, String r611, Integer r612, Integer r613, String r614, String r615, String r616, String r617, Integer r618, String r619, String r710, Integer r711, Integer r712, String r713, Long r714, String r715, String r716, Integer r717, String r718, String r719, String r810, String r811, Map r812, String r813) {
        Intrinsics.checkNotNullParameter(r510, "params");
        if (r812 != null) goto L153;
    L8:
        r510.putOpt("ai_create_show_mode", r518);     // Catch: JSONException -> L146
        r510.putOpt("ai_creation_tool_list", r519);     // Catch: JSONException -> L146
        if (r414 == null) goto L11;
        r510.put("source_type", r414);     // Catch: JSONException -> L146
    L11:
        if (r415 == null) goto L13;
        r510.put("task_id", r415);     // Catch: JSONException -> L146
    L13:
        if (r110 == null) goto L15;
        r510.put(MusicAppletPage.KEY_MESSAGE_ID, r110);     // Catch: JSONException -> L146
    L15:
        if (r111 == null) goto L17;
        r510.put(NoticeInfo.KEY_REPLY_ID, r111);     // Catch: JSONException -> L146
    L17:
        if (r210 == null) goto L19;
        r510.put("section_id", r210);     // Catch: JSONException -> L146
    L19:
        if (r211 == null) goto L21;
        r510.put("conversation_id", r211);     // Catch: JSONException -> L146
    L21:
        r510.put("bot_id", r212);     // Catch: JSONException -> L146
        if (r213 == null) goto L24;
        r510.put("bot_type", r213.intValue());     // Catch: JSONException -> L146
    L24:
        if (r214 == null) goto L26;
        r510.put("chat_type", r214);     // Catch: JSONException -> L146
    L26:
        if (r215 == null) goto L28;
        r510.put("message_height", r215.longValue());     // Catch: JSONException -> L146
    L28:
        if (r216 == null) goto L30;
        r510.put("thinking_content_height", r216.longValue());     // Catch: JSONException -> L146
    L30:
        if (r217 == null) goto L32;
        r510.put("show_duration", r217.longValue());     // Catch: JSONException -> L146
    L32:
        if (r218 == null) goto L34;
        r510.put("read_duration", r218.longValue());     // Catch: JSONException -> L146
    L34:
        if (r219 == null) goto L36;
        r510.put("thinking_content_read_duration", r219.longValue());     // Catch: JSONException -> L146
    L36:
        if (r310 == null) goto L38;
        r510.put("is_stream", r310.longValue());     // Catch: JSONException -> L146
    L38:
        if (r311 == null) goto L40;
        r510.put("is_regenerate", r311.longValue());     // Catch: JSONException -> L146
    L40:
        if (r312 == null) goto L42;
        r510.put(AiProactiveTaskViewModel.PARAM_START_METHOD, r312);     // Catch: JSONException -> L146
    L42:
        if (r313 == null) goto L44;
        r510.put("end_method", r313);     // Catch: JSONException -> L146
    L44:
        r510.put("is_contain_ecommerce", r417);     // Catch: JSONException -> L146
        if (r314 == null) goto L47;
        r510.put("is_show_content_full_screen", r314.longValue());     // Catch: JSONException -> L146
    L47:
        if (r315 == null) goto L49;
        r510.put("is_message_finished_generation", r315.longValue());     // Catch: JSONException -> L146
    L49:
        if (r316 == null) goto L51;
        r510.put("is_thinking_content_finished_generation", r316.longValue());     // Catch: JSONException -> L146
    L51:
        if (r317 == null) goto L53;
        r510.put("is_message_fully_shown", r317.longValue());     // Catch: JSONException -> L146
    L53:
        if (r319 == null) goto L55;
        r510.put("is_answer_action_show", r319.longValue());     // Catch: JSONException -> L146
    L55:
        if (r318 == null) goto L57;
        r510.put("is_thinking_content_fully_shown", r318.longValue());     // Catch: JSONException -> L146
    L57:
        if (r410 == null) goto L59;
        r510.put("message_type", r410.longValue());     // Catch: JSONException -> L146
    L59:
        if (r411 == null) goto L61;
        r510.put("is_have_video", r411.longValue());     // Catch: JSONException -> L146
    L61:
        if (r412 == null) goto L63;
        r510.put("is_have_pic", r412.longValue());     // Catch: JSONException -> L146
    L63:
        if (r413 == null) goto L65;
        r510.put("message_show_area_height", r413.longValue());     // Catch: JSONException -> L146
    L65:
        if (r416 == null) goto L67;
        r510.put("index", r416.intValue());     // Catch: JSONException -> L146
    L67:
        if (r512 == null) goto L69;
        r510.put("is_deep_thinking", r512.longValue());     // Catch: JSONException -> L146
    L69:
        if (r418 == null) goto L71;
        r510.put("agent_id", r418);     // Catch: JSONException -> L146
    L71:
        if (r419 == null) goto L73;
        r510.put("msg_candidate_source", r419);     // Catch: JSONException -> L146
    L73:
        if (r513 == null) goto L75;
        r510.put("msg_group_id", r513);     // Catch: JSONException -> L146
    L75:
        if (r514 == null) goto L78;
        r510.put("user_case_item_id", r514);     // Catch: JSONException -> L146
    L78:
        if (r515 == null) goto L81;
        r510.put("user_case_reco_request_id", r515);     // Catch: JSONException -> L146
    L81:
        if (r517 == null) goto L84;
        r510.put("thinking_content_card_type", r517);     // Catch: JSONException -> L146
    L84:
        if (r516 == null) goto L87;
        r510.put("previous_page", r516);     // Catch: JSONException -> L146
    L87:
        if (r610 == null) goto L90;
        r510.put("page_token", r610);     // Catch: JSONException -> L146
    L90:
        if (r611 == null) goto L92;
        r510.put("artifact_meta_id", r611);     // Catch: JSONException -> L146
    L92:
        if (r612 == null) goto L94;
        r510.put("artifact_type", r612.intValue());     // Catch: JSONException -> L146
    L94:
        if (r613 == null) goto L97;
        r510.put("resource_type", r613.intValue());     // Catch: JSONException -> L146
    L97:
        if (r614 == null) goto L100;
        r510.put("presentation_id", r614);     // Catch: JSONException -> L146
    L100:
        if (r615 == null) goto L103;
        r510.put("resource_id", r615);     // Catch: JSONException -> L146
    L103:
        if (r616 == null) goto L106;
        r510.put("base_id", r616);     // Catch: JSONException -> L146
    L106:
        if (r617 == null) goto L108;
        r510.put("aippt_task_id", r617);     // Catch: JSONException -> L146
    L108:
        if (r618 == null) goto L111;
        r510.put("is_with_ai_doc", r618.intValue());     // Catch: JSONException -> L146
    L111:
        if (r619 == null) goto L114;
        r510.put("ai_doc_show_status", r619);     // Catch: JSONException -> L146
    L114:
        if (r710 == null) goto L116;
        r510.put("ai_doc_gen_status", r710);     // Catch: JSONException -> L146
    L116:
        if (r711 == null) goto L118;
        r510.put("is_float_chat", r711.intValue());     // Catch: JSONException -> L146
    L118:
        if (r712 == null) goto L121;
        r510.put("float_chat_shown_pct", r712.intValue());     // Catch: JSONException -> L146
    L121:
        if (r713 == null) goto L123;
        r510.put("is_chat_last_message", r713);     // Catch: JSONException -> L146
    L123:
        if (r714 == null) goto L125;
        r510.put("thinking_duration", r714.longValue());     // Catch: JSONException -> L146
    L125:
        r510.put("read_stop_scene", r715);     // Catch: JSONException -> L146
        if (r716 == null) goto L128;
        r510.put("block_types", r716);     // Catch: JSONException -> L146
    L128:
        if (r717 == null) goto L131;
        r510.put("status_local", r717.intValue());     // Catch: JSONException -> L146
    L131:
        if (com.larus.utils.o0.d(r718) == false) goto L134;
        r510.put("collection_id", r718);     // Catch: JSONException -> L146
    L134:
        if (com.larus.utils.o0.d(r719) == false) goto L137;
        r510.put("collection_name", r719);     // Catch: JSONException -> L146
    L137:
        if (com.larus.utils.o0.d(r810) == false) goto L140;
        r510.put("content_type", r810);     // Catch: JSONException -> L146
    L140:
        if (com.larus.utils.o0.d(r811) == false) goto L143;
        r510.put("content_sec_type", r811);     // Catch: JSONException -> L146
    L143:
        if (com.larus.utils.o0.d(r813) == false) goto L148;
        r510.put("spreadsheet_id", r813);     // Catch: JSONException -> L146
    L146:
        e = move-exception;
        FLogger.f375446a.e("ReadEventHelper", "error in ReadEventHelper readMessage " + e.getLocalizedMessage());
    L148:
        TrackParams r100 = new TrackParams().merge(r510);
        by7.a r101 = new by7.a("read_message");
        if (r511 == null) goto L151;
        r101.f21464b = r511;
    L151:
        r101.f21463a.merge(r100);
        r101.b();
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("read_message", r100.makeJSONObject(), null, null);
        return;
    L153:
        Iterator r112 = r812.entrySet().iterator();     // Catch: JSONException -> L146
    L6:
        if (r112.hasNext() == false) goto L8;
        Map.Entry r113 = (Map.Entry) r112.next();     // Catch: JSONException -> L146
        r510.put((String) r113.getKey(), r113.getValue());     // Catch: JSONException -> L146
        r112 = r112;
        goto L6
    }
}
