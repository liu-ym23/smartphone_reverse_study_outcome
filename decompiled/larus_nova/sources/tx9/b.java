package tx9;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ixigua.lib.track.TrackParams;
import com.larus.livetutor.impl.home.viewmodel.LiveTutorHomeVM;
import com.larus.utils.logger.FLogger;
import com.obric.trace.ObricActionBarTrackType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class b {
    public static void a(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        if (r100 != null) goto L14;
    L7:
        r102.put("action_bar_recommend_from", "chat_action_bar");     // Catch: JSONException -> L5
        if (r101 == null) goto L12;
        r102.put("req_id", r101);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("ActionBarEventHelper", "error in ActionBarEventHelper chatActionBarSlide " + e.getLocalizedMessage());
    L12:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("action_bar_slide");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L14:
        r102.put("bot_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void i(String r100, String r101, JSONObject r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = new JSONObject();
    L11:
        Intrinsics.checkNotNullParameter(r102, "params");
        if (r100 != null) goto L22;
    L16:
        if (r101 == null) goto L20;
        r102.put("limited_biz", r101);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        FLogger.f375446a.e("ActionBarEventHelper", "error in ActionBarEventHelper to_limited_toast_show " + e.getLocalizedMessage());
    L20:
        TrackParams r104 = new TrackParams().merge(r102);
        by7.a r105 = new by7.a("to_limited_toast_show");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L22:
        r102.put("limited_trigger", r100);     // Catch: JSONException -> L14
        goto L16
    }

    public static void c(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Integer r107) {
        JSONObject r108 = new JSONObject();
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r100 != null) goto L25;
    L7:
        if (r101 == null) goto L9;
        r108.put("chat_type", r101);     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L11;
        r108.put("action_bar_template_type", r102);     // Catch: JSONException -> L5
    L11:
        if (r103 == null) goto L13;
        r108.put(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r103);     // Catch: JSONException -> L5
    L13:
        if (r104 == null) goto L15;
        r108.put("action_bar_key", r104);     // Catch: JSONException -> L5
    L15:
        if (r107 == null) goto L17;
        r108.put(ObricActionBarTrackType.KEY_SHOW_POSITION, r107.intValue());     // Catch: JSONException -> L5
    L17:
        if (r105 == null) goto L19;
        r108.put("command_text", r105);     // Catch: JSONException -> L5
    L19:
        if (r106 == null) goto L23;
        r108.put("command_id", r106);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("ActionBarEventHelper", "error in ActionBarEventHelper chatActionBarClick " + e.getLocalizedMessage());
    L23:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r110 = new by7.a("action_bar_command_click");
        r110.f21463a.merge(r109);
        r110.b();
        return;
    L25:
        r108.put("bot_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void d(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Integer r107) {
        JSONObject r108 = new JSONObject();
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r100 != null) goto L25;
    L7:
        if (r101 == null) goto L9;
        r108.put("chat_type", r101);     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L11;
        r108.put("action_bar_template_type", r102);     // Catch: JSONException -> L5
    L11:
        if (r103 == null) goto L13;
        r108.put(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r103);     // Catch: JSONException -> L5
    L13:
        if (r104 == null) goto L15;
        r108.put("action_bar_key", r104);     // Catch: JSONException -> L5
    L15:
        if (r107 == null) goto L17;
        r108.put(ObricActionBarTrackType.KEY_SHOW_POSITION, r107.intValue());     // Catch: JSONException -> L5
    L17:
        if (r105 == null) goto L19;
        r108.put("command_text", r105);     // Catch: JSONException -> L5
    L19:
        if (r106 == null) goto L23;
        r108.put("command_id", r106);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("ActionBarEventHelper", "error in ActionBarEventHelper chatActionBarClick " + e.getLocalizedMessage());
    L23:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r110 = new by7.a("action_bar_command_show");
        r110.f21463a.merge(r109);
        r110.b();
        return;
    L25:
        r108.put("bot_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void h(String r100, Boolean r101, String r102, String r103, Long r104, String r105, String r110, String r111, Long r112) {
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 != null) goto L33;
    L7:
        if (r102 == null) goto L9;
        r106.put("bot_id", r102);     // Catch: JSONException -> L5
    L9:
        if (r101 != null) goto L11;
    L15:
        if (r103 == null) goto L17;
        r106.put("req_id", r103);     // Catch: JSONException -> L5
    L17:
        r106.put("action_bar_recommend_from", "chat_action_bar");     // Catch: JSONException -> L5
        if (r104 == null) goto L20;
        r106.put("conversation_id", r104.toString());     // Catch: JSONException -> L5
    L20:
        r106.put("current_page", "chat");     // Catch: JSONException -> L5
        if (r105 == null) goto L23;
        r106.put("previous_page", r105);     // Catch: JSONException -> L5
    L23:
        if (r110 == null) goto L25;
        r106.put("leave_reason", r110);     // Catch: JSONException -> L5
    L25:
        if (r111 == null) goto L27;
        r106.put("leave_action_bar_template_id", r111);     // Catch: JSONException -> L5
    L27:
        if (r112 == null) goto L31;
        r106.put("duration", r112.longValue());     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("ActionBarEventHelper", "error in ActionBarEventHelper chatActionBarClick " + e.getLocalizedMessage());
    L31:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("leave_action_bar_board");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L11:
        if (r101.booleanValue() == false) goto L13;
        int r109 = 1;
    L14:
        r106.put("is_red_dot", r109);     // Catch: JSONException -> L5
        goto L15
    L13:
        r109 = 0;
        goto L14
    L33:
        r106.put("show_from", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void f(String r210, String r211, String r212, String r213, String r214, String r215, String r310, String r311, String r312, Integer r313, Integer r314, Integer r315, Long r316, Long r317, JSONObject r318, String r319, String r410, String r411, Integer r412, String r413, String r414, Boolean r415, int r416) {
        if ((r416 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r416 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r416 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r416 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r416 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r416 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r416 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r416 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r416 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r416 & 512) == 0) goto L41;
        Integer r111 = null;
    L43:
        if ((r416 & 1024) == 0) goto L45;
        Integer r112 = null;
    L47:
        if ((r416 & 2048) == 0) goto L49;
        Integer r113 = null;
    L51:
        if ((r416 & 4096) == 0) goto L53;
        Long r114 = null;
    L55:
        if ((r416 & 8192) == 0) goto L57;
        Long r115 = null;
    L59:
        if ((r416 & 16384) == 0) goto L61;
        JSONObject r108 = new JSONObject();
    L63:
        if ((r416 & 65536) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r416 & 131072) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r416 & 262144) == 0) goto L73;
        String r216 = null;
    L75:
        if ((r416 & 524288) == 0) goto L77;
        Integer r118 = null;
    L79:
        if ((r416 & 1048576) == 0) goto L81;
        String r217 = null;
    L83:
        if ((r416 & 2097152) == 0) goto L85;
        String r218 = null;
    L87:
        if ((r416 & 4194304) == 0) goto L89;
        Boolean r119 = null;
    L90:
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r100 != null) goto L144;
    L95:
        if (r101 == null) goto L97;
        r108.put("chat_type", r101);     // Catch: JSONException -> L93
    L97:
        if (r102 == null) goto L99;
        r108.put("action_bar_template_type", r102);     // Catch: JSONException -> L93
    L99:
        if (r103 == null) goto L101;
        r108.put(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r103);     // Catch: JSONException -> L93
    L101:
        if (r104 == null) goto L103;
        r108.put("action_bar_key", r104);     // Catch: JSONException -> L93
    L103:
        if (r113 == null) goto L105;
        r108.put(ObricActionBarTrackType.KEY_SHOW_POSITION, r113.intValue());     // Catch: JSONException -> L93
    L105:
        if (r105 == null) goto L107;
        r108.put("option_label", r105);     // Catch: JSONException -> L93
    L107:
        if (r106 == null) goto L109;
        r108.put("option_sub_label", r106);     // Catch: JSONException -> L93
    L109:
        if (r107 == null) goto L111;
        r108.put("option_text", r107);     // Catch: JSONException -> L93
    L111:
        if (r110 == null) goto L113;
        r108.put("option_id", r110);     // Catch: JSONException -> L93
    L113:
        if (r111 == null) goto L115;
        r108.put("is_default", r111.intValue());     // Catch: JSONException -> L93
    L115:
        if (r112 == null) goto L117;
        r108.put("is_choose_required", r112.intValue());     // Catch: JSONException -> L93
    L117:
        if (r114 == null) goto L119;
        r108.put(LiveTutorHomeVM.ACTION_BAR_ITEM_ID, r114.longValue());     // Catch: JSONException -> L93
    L119:
        if (r115 == null) goto L121;
        r108.put("conversation_id", r115.longValue());     // Catch: JSONException -> L93
    L121:
        String r109 = r116;
        if (r109 == null) goto L124;
        r108.put("action_bar_scene", r109);     // Catch: JSONException -> L93
    L124:
        String r120 = r117;
        if (r120 == null) goto L127;
        r108.put("page_token", r120);     // Catch: JSONException -> L93
    L127:
        String r121 = r216;
        if (r121 == null) goto L130;
        r108.put("artifact_meta_id", r121);     // Catch: JSONException -> L93
    L130:
        if (r118 == null) goto L132;
        r108.put("resource_type", r118.intValue());     // Catch: JSONException -> L93
    L132:
        String r122 = r217;
        if (r122 == null) goto L135;
        r108.put("current_page", r122);     // Catch: JSONException -> L93
    L135:
        if (r119 == null) goto L137;
        r108.put("is_creation_action_bar", r119.booleanValue());     // Catch: JSONException -> L93
    L137:
        String r123 = r218;
        if (r123 == null) goto L142;
        r108.put("previous_page", r123);     // Catch: JSONException -> L93
    L93:
        e = move-exception;
        FLogger.f375446a.e("ActionBarEventHelper", "error in ActionBarEventHelper chatActionBarClick " + e.getLocalizedMessage());
    L142:
        TrackParams r124 = new TrackParams().merge(r108);
        by7.a r125 = new by7.a("action_bar_option_show");
        r125.f21463a.merge(r124);
        r125.b();
        return;
    L144:
        r108.put("bot_id", r100);     // Catch: JSONException -> L93
        goto L95
    L89:
        r119 = r415;
        goto L90
    L85:
        r218 = r414;
        goto L87
    L81:
        r217 = r413;
        goto L83
    L77:
        r118 = r412;
        goto L79
    L73:
        r216 = r411;
        goto L75
    L69:
        r117 = r410;
        goto L71
    L65:
        r116 = r319;
        goto L67
    L61:
        r108 = r318;
        goto L63
    L57:
        r115 = r317;
        goto L59
    L53:
        r114 = r316;
        goto L55
    L49:
        r113 = r315;
        goto L51
    L45:
        r112 = r314;
        goto L47
    L41:
        r111 = r313;
        goto L43
    L37:
        r110 = r312;
        goto L39
    L33:
        r107 = r311;
        goto L35
    L29:
        r106 = r310;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public static void g(String r210, Long r211, String r310, String r311, String r312, String r313, Integer r314, String r315, Integer r316, String r317, by7.e r318, Integer r319, String r410, String r411, Boolean r412, Integer r413, Long r414, String r415, boolean r416, Integer r417, Integer r418, Integer r419, String r510, String r511, String r512, Integer r513, String r514, Boolean r515, int r516) {
        if ((r516 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r516 & 2) == 0) goto L9;
        Long r101 = null;
    L11:
        if ((r516 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r516 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r516 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r516 & 128) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r516 & 512) == 0) goto L29;
        Integer r106 = null;
    L31:
        if ((r516 & 1024) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r516 & 2048) == 0) goto L37;
        Integer r110 = null;
    L39:
        if ((r516 & 4096) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r516 & 8192) == 0) goto L45;
        JSONObject r112 = new JSONObject();
    L47:
        if ((r516 & 16384) == 0) goto L49;
        by7.e r113 = null;
    L51:
        if ((32768 & r516) == 0) goto L53;
        Integer r114 = null;
    L55:
        if ((65536 & r516) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r516 & 131072) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r516 & 262144) == 0) goto L65;
        Boolean r116 = null;
    L67:
        if ((r516 & 524288) == 0) goto L69;
        Integer r117 = null;
    L71:
        if ((r516 & 1048576) == 0) goto L73;
        Long r118 = null;
    L74:
        by7.e r212 = r113;
        if ((r516 & 2097152) == 0) goto L77;
        String r119 = null;
    L79:
        if ((r516 & 8388608) == 0) goto L81;
        Integer r213 = null;
    L83:
        if ((r516 & 16777216) == 0) goto L85;
        Integer r214 = null;
    L87:
        if ((r516 & 33554432) == 0) goto L89;
        Integer r215 = null;
    L91:
        if ((r516 & 67108864) == 0) goto L93;
        String r216 = null;
    L95:
        if ((r516 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L97;
        String r217 = null;
    L99:
        if ((r516 & 268435456) == 0) goto L101;
        String r218 = null;
    L103:
        if ((r516 & 536870912) == 0) goto L105;
        Integer r219 = null;
    L106:
        String r220 = r119;
        if ((r516 & 1073741824) == 0) goto L109;
        String r120 = null;
    L111:
        if ((r516 & Integer.MIN_VALUE) == 0) goto L113;
        Boolean r109 = null;
    L114:
        Boolean r320 = r109;
        Intrinsics.checkNotNullParameter(r112, "params");
    L193:
        e = move-exception;
        FLogger.f375446a.e("ActionBarEventHelper", "error in ActionBarEventHelper chatActionBarShow " + e.getLocalizedMessage());
    L195:
        TrackParams r121 = new TrackParams().merge(r112);
        by7.a r122 = new by7.a("chat_action_bar_show");
        if (r212 == null) goto L198;
        r122.f21464b = r212;
    L198:
        r122.f21463a.merge(r121);
        r122.b();
        String r123 = (String) TrackParams.get$default(r122.f21463a, "current_page", null, 2, null);
        if (r123 == null) goto L201;
        r112.put("current_page", r123);
    L201:
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("chat_action_bar_show", r112, new JSONObject(), null);
        return;
    L116:
        if (Intrinsics.areEqual(r107, "coco_message_history") == false) goto L119;
        return;
    L119:
        if (Intrinsics.areEqual(r107, "coco_bot_like") == false) goto L122;
        return;
    L122:
        if (r416 == false) goto L124;
        String r221 = "1";
    L125:
        Integer r321 = r114;
        r112.put("is_tourist_mode", r221);     // Catch: JSONException -> L193
        if (r100 == null) goto L128;
        r112.put("bot_id", r100);     // Catch: JSONException -> L193
    L128:
        if (r101 == null) goto L131;
        r112.put("conversation_id", r101.longValue());     // Catch: JSONException -> L193
    L131:
        if (r102 == null) goto L133;
        r112.put("current_page", r102);     // Catch: JSONException -> L193
    L133:
        if (r103 == null) goto L135;
        r112.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_TYPE, r103);     // Catch: JSONException -> L193
    L135:
        if (r104 == null) goto L137;
        r112.put("chat_type", r104);     // Catch: JSONException -> L193
    L137:
        if (r105 == null) goto L139;
        r112.put("req_id", r105);     // Catch: JSONException -> L193
    L139:
        if (r106 == null) goto L141;
        r112.put("template_name", r106.intValue());     // Catch: JSONException -> L193
        r112.put(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r106.intValue());     // Catch: JSONException -> L193
    L141:
        if (r115 == null) goto L143;
        r112.put("template_type", r115);     // Catch: JSONException -> L193
        r112.put("action_bar_template_type", r115);     // Catch: JSONException -> L193
    L143:
        if (r120 == null) goto L145;
        r112.put("template_page_type", r120);     // Catch: JSONException -> L193
    L145:
        if (r107 == null) goto L147;
        r112.put("action_name", r107);     // Catch: JSONException -> L193
        r112.put("action_bar_key", r107);     // Catch: JSONException -> L193
    L147:
        if (r110 == 0) goto L149;
        r112.put("is_switch_on", r110.intValue());     // Catch: JSONException -> L193
    L149:
        if (r111 == 0) goto L151;
        r112.put("go_to_url", r111);     // Catch: JSONException -> L193
    L151:
        int r124 = 1;
        if (r321 == null) goto L154;
        r112.put(ObricActionBarTrackType.KEY_SHOW_POSITION, r321.intValue() - 1);     // Catch: JSONException -> L193
    L154:
        if (r108 == 0) goto L157;
        r112.put("show_from", r108);     // Catch: JSONException -> L193
    L157:
        if (r116 != null) goto L159;
    L163:
        if (r117 == null) goto L165;
        r112.put("show_position_row", r117.intValue());     // Catch: JSONException -> L193
    L165:
        if (r118 == null) goto L167;
        r112.put(LiveTutorHomeVM.ACTION_BAR_ITEM_ID, r118.longValue());     // Catch: JSONException -> L193
    L167:
        if (r220 == null) goto L169;
        r112.put("action_bar_recommend_from", r220);     // Catch: JSONException -> L193
    L169:
        if (r213 == null) goto L171;
        r112.put("is_show_keyboard", r213.intValue());     // Catch: JSONException -> L193
    L171:
        if (r214 == null) goto L173;
        r112.put("is_replace_download", r214.intValue());     // Catch: JSONException -> L193
    L173:
        if (r215 == null) goto L175;
        r112.put("is_server_degrade", r215.intValue());     // Catch: JSONException -> L193
    L175:
        String r125 = r216;
        if (r125 == null) goto L178;
        r112.put("action_bar_scene", r125);     // Catch: JSONException -> L193
    L178:
        String r126 = r217;
        if (r126 == null) goto L181;
        r112.put("page_token", r126);     // Catch: JSONException -> L193
    L181:
        String r127 = r218;
        if (r127 == null) goto L184;
        r112.put("artifact_meta_id", r127);     // Catch: JSONException -> L193
    L184:
        if (r219 == null) goto L186;
        r112.put("resource_type", r219.intValue());     // Catch: JSONException -> L193
    L186:
        if (r320 == null) goto L195;
        r320.booleanValue();     // Catch: JSONException -> L193
        if (r320.booleanValue() == true) goto L191;
        r124 = 0;
    L191:
        r112.put("is_first_load", r124);     // Catch: JSONException -> L193
        goto L195
    L159:
        if (r116.booleanValue() == false) goto L161;
        int r128 = 1;
    L162:
        r112.put("is_red_dot", r128);     // Catch: JSONException -> L193
        goto L163
    L161:
        r128 = 0;
        goto L162
    L124:
        r221 = "0";
        goto L125
    L113:
        r109 = r515;
        goto L114
    L109:
        r120 = r514;
        goto L111
    L105:
        r219 = r513;
        goto L106
    L101:
        r218 = r512;
        goto L103
    L97:
        r217 = r511;
        goto L99
    L93:
        r216 = r510;
        goto L95
    L89:
        r215 = r419;
        goto L91
    L85:
        r214 = r418;
        goto L87
    L81:
        r213 = r417;
        goto L83
    L77:
        r119 = r415;
        goto L79
    L73:
        r118 = r414;
        goto L74
    L69:
        r117 = r413;
        goto L71
    L65:
        r116 = r412;
        goto L67
    L61:
        r108 = r411;
        goto L63
    L57:
        r115 = r410;
        goto L59
    L53:
        r114 = r319;
        goto L55
    L49:
        r113 = r318;
        goto L51
    L45:
        r112 = null;
        goto L47
    L41:
        r111 = r317;
        goto L43
    L37:
        r110 = r316;
        goto L39
    L33:
        r107 = r315;
        goto L35
    L29:
        r106 = r314;
        goto L31
    L25:
        r105 = r313;
        goto L27
    L21:
        r104 = r312;
        goto L23
    L17:
        r103 = r311;
        goto L19
    L13:
        r102 = r310;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public static void b(String r210, Long r310, Long r311, String r312, String r313, String r314, String r315, Integer r316, String r317, Integer r318, String r319, by7.e r410, String r411, String r412, String r413, Boolean r414, Boolean r415, Integer r416, Integer r417, Long r418, String r419, boolean r510, Integer r511, Integer r512, String r513, String r514, String r515, Integer r516, String r517, String r518, int r519, int r610) {
        if ((r519 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r519 & 2) == 0) goto L9;
        Long r101 = null;
    L11:
        if ((r519 & 4) == 0) goto L13;
        Long r102 = null;
    L15:
        if ((r519 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r519 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r519 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r519 & 256) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r519 & 1024) == 0) goto L33;
        Integer r107 = null;
    L35:
        if ((r519 & 2048) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r519 & 4096) == 0) goto L41;
        Integer r111 = null;
    L43:
        if ((r519 & 8192) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r519 & 16384) == 0) goto L49;
        JSONObject r113 = new JSONObject();
    L51:
        if ((32768 & r519) == 0) goto L53;
        by7.e r114 = null;
    L55:
        if ((65536 & r519) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r519 & 131072) == 0) goto L61;
        String r108 = null;
    L62:
        by7.e r211 = r114;
        if ((r519 & 262144) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r519 & 524288) == 0) goto L69;
        Boolean r117 = null;
    L71:
        if ((r519 & 1048576) == 0) goto L73;
        Boolean r118 = null;
    L75:
        if ((r519 & 2097152) == 0) goto L77;
        Integer r119 = null;
    L79:
        if ((r519 & 4194304) == 0) goto L81;
        Integer r212 = null;
    L83:
        if ((r519 & 8388608) == 0) goto L85;
        Long r213 = null;
    L87:
        if ((r519 & 16777216) == 0) goto L89;
        String r214 = null;
    L91:
        if ((r519 & 67108864) == 0) goto L93;
        Integer r215 = null;
    L95:
        if ((r519 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L97;
        Integer r216 = null;
    L99:
        if ((r519 & 268435456) == 0) goto L101;
        String r217 = null;
    L103:
        if ((r519 & 536870912) == 0) goto L105;
        String r218 = null;
    L107:
        if ((r519 & 1073741824) == 0) goto L109;
        String r219 = null;
    L111:
        if ((r519 & Integer.MIN_VALUE) == 0) goto L113;
        Integer r109 = null;
    L114:
        Integer r320 = r109;
        if ((r610 & 1) == 0) goto L117;
        String r120 = null;
    L119:
        if ((r610 & 2) == 0) goto L121;
        String r321 = null;
    L122:
        Intrinsics.checkNotNullParameter(r113, "params");
    L194:
        e = move-exception;
        FLogger.f375446a.e("ActionBarEventHelper", "error in ActionBarEventHelper chatActionBarClick " + e.getLocalizedMessage());
    L196:
        TrackParams r121 = new TrackParams().merge(r113);
        by7.a r122 = new by7.a("chat_action_bar_click");
        if (r211 == null) goto L199;
        r122.f21464b = r211;
    L199:
        r122.f21463a.merge(r121);
        r122.b();
        return;
    L124:
        if (Intrinsics.areEqual(r110, "coco_message_history") == false) goto L127;
        return;
    L127:
        if (r510 == false) goto L129;
        String r123 = "1";
    L130:
        String r322 = r115;
        r113.put("is_tourist_mode", r123);     // Catch: JSONException -> L194
        if (r100 == null) goto L133;
        r113.put("bot_id", r100);     // Catch: JSONException -> L194
    L133:
        if (r101 == null) goto L135;
        r113.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, r101.longValue());     // Catch: JSONException -> L194
    L135:
        if (r102 == null) goto L137;
        r113.put("conversation_id", r102.longValue());     // Catch: JSONException -> L194
    L137:
        if (r103 == null) goto L139;
        r113.put("current_page", r103);     // Catch: JSONException -> L194
    L139:
        if (r104 == null) goto L141;
        r113.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_TYPE, r104);     // Catch: JSONException -> L194
    L141:
        if (r105 == null) goto L143;
        r113.put("chat_type", r105);     // Catch: JSONException -> L194
    L143:
        if (r120 == null) goto L145;
        r113.put("camera_status", r120);     // Catch: JSONException -> L194
    L145:
        if (r106 == null) goto L147;
        r113.put("req_id", r106);     // Catch: JSONException -> L194
    L147:
        if (r107 == null) goto L149;
        r113.put("template_name", r107.intValue());     // Catch: JSONException -> L194
        r113.put(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r107.intValue());     // Catch: JSONException -> L194
    L149:
        if (r110 == null) goto L151;
        r113.put("action_name", r110);     // Catch: JSONException -> L194
        r113.put("action_bar_key", r110);     // Catch: JSONException -> L194
    L151:
        if (r111 == null) goto L153;
        r113.put("is_switch_on", r111.intValue());     // Catch: JSONException -> L194
    L153:
        if (r112 == null) goto L155;
        r113.put("go_to_url", r112);     // Catch: JSONException -> L194
    L155:
        if (r108 == null) goto L157;
        r113.put("show_from", r108);     // Catch: JSONException -> L194
    L157:
        if (r322 == null) goto L159;
        r113.put("template_type", r322);     // Catch: JSONException -> L194
        r113.put("action_bar_template_type", r322);     // Catch: JSONException -> L194
    L159:
        if (r321 == null) goto L161;
        r113.put("template_page_type", r321);     // Catch: JSONException -> L194
    L161:
        if (r116 == 0) goto L164;
        r113.put("click_from", r116);     // Catch: JSONException -> L194
    L164:
        if (r117 == null) goto L166;
        r113.put("is_has_replica", r117.booleanValue() ? 1 : 0);     // Catch: JSONException -> L194
    L167:
        if (r118 == null) goto L169;
        r113.put("is_red_dot", r118.booleanValue() ? 1 : 0);     // Catch: JSONException -> L194
    L169:
        if (r119 == null) goto L171;
        r113.put("show_position_row", r119.intValue());     // Catch: JSONException -> L194
    L171:
        if (r212 == null) goto L173;
        r113.put(ObricActionBarTrackType.KEY_SHOW_POSITION, r212.intValue() - 1);     // Catch: JSONException -> L194
    L173:
        if (r213 == null) goto L175;
        r113.put(LiveTutorHomeVM.ACTION_BAR_ITEM_ID, r213.longValue());     // Catch: JSONException -> L194
    L175:
        String r124 = r214;
        if (r124 == null) goto L178;
        r113.put("action_bar_recommend_from", r124);     // Catch: JSONException -> L194
    L178:
        if (r215 == null) goto L180;
        r113.put("is_show_keyboard", r215.intValue());     // Catch: JSONException -> L194
    L180:
        if (r216 == null) goto L182;
        r113.put("is_replace_download", r216.intValue());     // Catch: JSONException -> L194
    L182:
        String r125 = r217;
        if (r125 == null) goto L185;
        r113.put("action_bar_scene", r125);     // Catch: JSONException -> L194
    L185:
        String r126 = r218;
        if (r126 == null) goto L188;
        r113.put("page_token", r126);     // Catch: JSONException -> L194
    L188:
        String r127 = r219;
        if (r127 == null) goto L191;
        r113.put("artifact_meta_id", r127);     // Catch: JSONException -> L194
    L191:
        if (r320 == null) goto L196;
        r113.put("resource_type", r320.intValue());     // Catch: JSONException -> L194
        goto L196
    L166:
        r113.put("is_has_replica", 0);     // Catch: JSONException -> L194
        goto L167
    L129:
        r123 = "0";
        goto L130
    L121:
        r321 = r518;
        goto L122
    L117:
        r120 = r517;
        goto L119
    L113:
        r109 = r516;
        goto L114
    L109:
        r219 = r515;
        goto L111
    L105:
        r218 = r514;
        goto L107
    L101:
        r217 = r513;
        goto L103
    L97:
        r216 = r512;
        goto L99
    L93:
        r215 = r511;
        goto L95
    L89:
        r214 = r419;
        goto L91
    L85:
        r213 = r418;
        goto L87
    L81:
        r212 = r417;
        goto L83
    L77:
        r119 = r416;
        goto L79
    L73:
        r118 = r415;
        goto L75
    L69:
        r117 = r414;
        goto L71
    L65:
        r116 = r413;
        goto L67
    L61:
        r108 = r412;
        goto L62
    L57:
        r115 = r411;
        goto L59
    L53:
        r114 = r410;
        goto L55
    L49:
        r113 = null;
        goto L51
    L45:
        r112 = r319;
        goto L47
    L41:
        r111 = r318;
        goto L43
    L37:
        r110 = r317;
        goto L39
    L33:
        r107 = r316;
        goto L35
    L29:
        r106 = r315;
        goto L31
    L25:
        r105 = r314;
        goto L27
    L21:
        r104 = r313;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public static void e(String r310, String r311, String r312, String r410, String r411, String r412, String r413, String r414, String r415, Integer r416, Integer r417, Integer r418, String r419, String r510, Long r511, Long r512, JSONObject r513, String r514, String r515, String r516, String r517, Integer r518, String r519, String r610, Boolean r611, String r612, Boolean r613, Boolean r614, String r615, String r616, String r617, String r618, Integer r619, Integer r710, String r711, String r712, String r713, int r714, int r715) {
        if ((r714 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r714 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r714 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r714 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r714 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r714 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r714 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r714 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r714 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r714 & 512) == 0) goto L41;
        Integer r111 = null;
    L43:
        if ((r714 & 1024) == 0) goto L45;
        Integer r112 = null;
    L47:
        if ((r714 & 2048) == 0) goto L49;
        Integer r113 = null;
    L51:
        if ((r714 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r714 & 8192) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r714 & 16384) == 0) goto L61;
        Long r108 = null;
    L63:
        if ((r714 & 32768) == 0) goto L65;
        Long r116 = null;
    L67:
        if ((r714 & 65536) == 0) goto L69;
        JSONObject r109 = new JSONObject();
    L71:
        if ((r714 & 262144) == 0) goto L73;
        String r117 = null;
    L75:
        if ((r714 & 524288) == 0) goto L77;
        String r118 = null;
    L79:
        if ((r714 & 1048576) == 0) goto L81;
        String r210 = null;
    L83:
        if ((r714 & 2097152) == 0) goto L85;
        String r211 = null;
    L87:
        if ((r714 & 4194304) == 0) goto L89;
        Integer r119 = null;
    L91:
        if ((r714 & 8388608) == 0) goto L93;
        String r212 = null;
    L95:
        if ((r714 & 16777216) == 0) goto L97;
        String r213 = null;
    L99:
        if ((r714 & 33554432) == 0) goto L101;
        Boolean r214 = null;
    L103:
        if ((r714 & 67108864) == 0) goto L105;
        String r215 = null;
    L107:
        if ((r714 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L109;
        Boolean r216 = null;
    L111:
        if ((r714 & 536870912) == 0) goto L113;
        Boolean r217 = null;
    L115:
        if ((r714 & 1073741824) == 0) goto L117;
        String r218 = null;
    L119:
        if ((r714 & Integer.MIN_VALUE) == 0) goto L121;
        String r120 = null;
    L123:
        if ((r715 & 1) == 0) goto L125;
        String r313 = null;
    L127:
        if ((r715 & 2) == 0) goto L129;
        String r314 = null;
    L131:
        if ((r715 & 4) == 0) goto L133;
        Integer r219 = null;
    L135:
        if ((r715 & 8) == 0) goto L137;
        Integer r315 = null;
    L139:
        if ((r715 & 16) == 0) goto L141;
        String r316 = null;
    L143:
        if ((r715 & 32) == 0) goto L145;
        String r317 = null;
    L147:
        if ((r715 & 64) == 0) goto L149;
        String r318 = null;
    L150:
        Intrinsics.checkNotNullParameter(r109, "params");
        if (r100 != null) goto L240;
    L155:
        if (r101 == null) goto L157;
        r109.put("chat_type", r101);     // Catch: JSONException -> L153
    L157:
        if (r102 == null) goto L159;
        r109.put("action_bar_template_type", r102);     // Catch: JSONException -> L153
    L159:
        if (r103 == null) goto L161;
        r109.put(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r103);     // Catch: JSONException -> L153
    L161:
        if (r104 == null) goto L163;
        r109.put("action_bar_key", r104);     // Catch: JSONException -> L153
    L163:
        if (r113 == null) goto L165;
        r109.put(ObricActionBarTrackType.KEY_SHOW_POSITION, r113.intValue());     // Catch: JSONException -> L153
    L165:
        if (r105 == null) goto L167;
        r109.put("option_label", r105);     // Catch: JSONException -> L153
    L167:
        if (r106 == null) goto L169;
        r109.put("option_sub_label", r106);     // Catch: JSONException -> L153
    L169:
        if (r107 == null) goto L171;
        r109.put("option_text", r107);     // Catch: JSONException -> L153
    L171:
        if (r110 == null) goto L173;
        r109.put("option_id", r110);     // Catch: JSONException -> L153
    L173:
        if (r111 == null) goto L175;
        r109.put("is_default", r111.intValue());     // Catch: JSONException -> L153
    L175:
        if (r112 == null) goto L177;
        r109.put("is_choose_required", r112.intValue());     // Catch: JSONException -> L153
    L177:
        if (r114 == null) goto L179;
        r109.put("action_type", r114);     // Catch: JSONException -> L153
    L179:
        if (r115 == null) goto L181;
        r109.put("to_status", r115);     // Catch: JSONException -> L153
    L181:
        String r121 = r117;
        if (r121 == null) goto L184;
        r109.put("option_source", r121);     // Catch: JSONException -> L153
    L184:
        if (r108 == 0) goto L186;
        r109.put(LiveTutorHomeVM.ACTION_BAR_ITEM_ID, r108.longValue());     // Catch: JSONException -> L153
    L186:
        if (r116 == null) goto L188;
        r109.put("conversation_id", r116.longValue());     // Catch: JSONException -> L153
    L188:
        String r122 = r118;
        if (r122 == null) goto L191;
        r109.put("action_bar_scene", r122);     // Catch: JSONException -> L153
    L191:
        String r123 = r210;
        if (r123 == null) goto L194;
        r109.put("page_token", r123);     // Catch: JSONException -> L153
    L194:
        String r124 = r211;
        if (r124 == null) goto L197;
        r109.put("artifact_meta_id", r124);     // Catch: JSONException -> L153
    L197:
        if (r119 == null) goto L199;
        r109.put("resource_type", r119.intValue());     // Catch: JSONException -> L153
    L199:
        String r125 = r212;
        if (r125 == null) goto L202;
        r109.put("current_page", r125);     // Catch: JSONException -> L153
    L202:
        String r126 = r213;
        if (r126 == null) goto L205;
        r109.put("previous_page", r126);     // Catch: JSONException -> L153
    L205:
        if (r214 == null) goto L207;
        r109.put("is_creation_action_bar", r214.booleanValue());     // Catch: JSONException -> L153
    L207:
        String r127 = r215;
        if (r127 == null) goto L210;
        r109.put("click_method", r127);     // Catch: JSONException -> L153
    L210:
        if (r216 == null) goto L212;
        r109.put("is_custom_model", r216.booleanValue());     // Catch: JSONException -> L153
    L212:
        if (r217 == null) goto L214;
        r109.put("is_folded", r217.booleanValue());     // Catch: JSONException -> L153
    L214:
        String r128 = r218;
        if (r128 == null) goto L217;
        r109.put("model_item_key", r128);     // Catch: JSONException -> L153
    L217:
        if (r120 == 0) goto L219;
        r109.put("click_from", r120);     // Catch: JSONException -> L153
    L219:
        String r129 = r313;
        if (r129 == null) goto L222;
        r109.put("option_type", r129);     // Catch: JSONException -> L153
    L222:
        String r130 = r314;
        if (r130 == null) goto L225;
        r109.put("mode_id", r130);     // Catch: JSONException -> L153
    L225:
        if (r219 == null) goto L227;
        r109.put("agent_mode", r219.intValue());     // Catch: JSONException -> L153
    L227:
        if (r315 == null) goto L229;
        r109.put("reasoning_effort", r315.intValue());     // Catch: JSONException -> L153
    L229:
        String r131 = r316;
        if (r131 == null) goto L232;
        r109.put("computer_type", r131);     // Catch: JSONException -> L153
    L232:
        String r132 = r317;
        if (r132 == null) goto L235;
        r109.put("computer_status", r132);     // Catch: JSONException -> L153
    L235:
        r109.putOpt("is_current_device", r318);     // Catch: JSONException -> L153
    L238:
        TrackParams r133 = new TrackParams().merge(r109);
        by7.a r134 = new by7.a("action_bar_option_click");
        r134.f21463a.merge(r133);
        r134.b();
        return;
    L153:
        e = move-exception;
        FLogger.f375446a.e("ActionBarEventHelper", "error in ActionBarEventHelper chatActionBarClick " + e.getLocalizedMessage());
        goto L238
    L240:
        r109.put("bot_id", r100);     // Catch: JSONException -> L153
        goto L155
    L149:
        r318 = r713;
        goto L150
    L145:
        r317 = r712;
        goto L147
    L141:
        r316 = r711;
        goto L143
    L137:
        r315 = r710;
        goto L139
    L133:
        r219 = r619;
        goto L135
    L129:
        r314 = r618;
        goto L131
    L125:
        r313 = r617;
        goto L127
    L121:
        r120 = r616;
        goto L123
    L117:
        r218 = r615;
        goto L119
    L113:
        r217 = r614;
        goto L115
    L109:
        r216 = r613;
        goto L111
    L105:
        r215 = r612;
        goto L107
    L101:
        r214 = r611;
        goto L103
    L97:
        r213 = r610;
        goto L99
    L93:
        r212 = r519;
        goto L95
    L89:
        r119 = r518;
        goto L91
    L85:
        r211 = r517;
        goto L87
    L81:
        r210 = r516;
        goto L83
    L77:
        r118 = r515;
        goto L79
    L73:
        r117 = r514;
        goto L75
    L69:
        r109 = r513;
        goto L71
    L65:
        r116 = r512;
        goto L67
    L61:
        r108 = r511;
        goto L63
    L57:
        r115 = r510;
        goto L59
    L53:
        r114 = r419;
        goto L55
    L49:
        r113 = r418;
        goto L51
    L45:
        r112 = r417;
        goto L47
    L41:
        r111 = r416;
        goto L43
    L37:
        r110 = r415;
        goto L39
    L33:
        r107 = r414;
        goto L35
    L29:
        r106 = r413;
        goto L31
    L25:
        r105 = r412;
        goto L27
    L21:
        r104 = r411;
        goto L23
    L17:
        r103 = r410;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
