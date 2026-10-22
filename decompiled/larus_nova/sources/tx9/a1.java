package tx9;

import android.text.TextUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.livetutor.impl.home.viewmodel.LiveTutorHomeVM;
import com.larus.utils.logger.FLogger;
import com.obric.trace.ObricActionBarTrackType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f547843a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f547844b = "";

    public static void d(String r100, String r101, String r102, String r103, int r104) {
        JSONObject r105 = null;
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r104 & 16) == 0) goto L17;
        r105 = new JSONObject();
    L17:
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L32;
    L22:
        if (r101 == null) goto L24;
        r105.put("enter_method", r101);     // Catch: JSONException -> L20
    L24:
        if (r102 == null) goto L26;
        r105.put("previous_page", r102);     // Catch: JSONException -> L20
    L26:
        if (r103 == null) goto L30;
        r105.put("style", r103);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.f375446a.e("EnterEventHelper", "error in EnterEventHelper enterVideoPlayer " + e.getLocalizedMessage());
    L30:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("enter_video_player");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L32:
        r105.put("current_page", r100);     // Catch: JSONException -> L20
        goto L22
    }

    public static void b(String r110, String r111, String r112, String r210, String r211, Integer r212, String r213, String r214, String r215, String r216, Integer r217, JSONObject r218, Long r219, String r310, Long r311, int r312) {
        Long r100 = null;
        if ((r312 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r312 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r312 & 16) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r312 & 32) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r312 & 64) == 0) goto L25;
        Integer r106 = null;
    L27:
        if ((r312 & 2048) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r312 & 4096) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r312 & 8192) == 0) goto L37;
        String r113 = null;
    L39:
        if ((r312 & 16384) == 0) goto L41;
        String r114 = null;
    L43:
        if ((32768 & r312) == 0) goto L45;
        Integer r115 = null;
    L47:
        if ((65536 & r312) == 0) goto L49;
        JSONObject r116 = new JSONObject();
    L51:
        if ((262144 & r312) == 0) goto L53;
        Long r117 = null;
    L55:
        if ((524288 & r312) == 0) goto L57;
        String r118 = null;
    L59:
        if ((r312 & 1048576) != 0) goto L62;
        r100 = r311;
    L62:
        Intrinsics.checkNotNullParameter(r116, "params");
        if (r101 != null) goto L102;
    L67:
        if (r102 == null) goto L69;
        r116.put("call_id", r102);     // Catch: JSONException -> L65
    L69:
        if (r103 == null) goto L71;
        r116.put("conversation_id", r103);     // Catch: JSONException -> L65
    L71:
        if (r104 == null) goto L73;
        r116.put("fail_reason", r104);     // Catch: JSONException -> L65
    L73:
        if (r105 == null) goto L80;
        r116.put("success", r105);     // Catch: JSONException -> L65
        if (Intrinsics.areEqual(r105, "1") == true) goto L78;
        r116.put("status", 1);     // Catch: JSONException -> L65
        goto L80
    L78:
        r116.put("status", 0);     // Catch: JSONException -> L65
    L80:
        if (r106 == null) goto L82;
        r116.put("session_status", r106.intValue());     // Catch: JSONException -> L65
    L82:
        if (r107 == null) goto L84;
        r116.put("enter_method", r107);     // Catch: JSONException -> L65
    L84:
        if (r108 == null) goto L86;
        r116.put("voice_id", r108);     // Catch: JSONException -> L65
    L86:
        if (r113 == null) goto L88;
        r116.put("speaker_id", r113);     // Catch: JSONException -> L65
    L88:
        if (r114 == null) goto L90;
        r116.put("speaker_name", r114);     // Catch: JSONException -> L65
    L90:
        if (r115 == null) goto L92;
        r116.put("error_code", r115.intValue());     // Catch: JSONException -> L65
    L92:
        if (r117 == null) goto L94;
        r116.put("duration", r117.longValue());     // Catch: JSONException -> L65
    L94:
        if (r118 == null) goto L96;
        r116.put("scene", r118);     // Catch: JSONException -> L65
    L96:
        if (r100 == null) goto L100;
        r116.put("pseudo_duration", r100.longValue());     // Catch: JSONException -> L65
    L65:
        e = move-exception;
        FLogger.f375446a.e("EnterEventHelper", "error in EnterEventHelper enterCallStatus " + e.getLocalizedMessage());
    L100:
        TrackParams r109 = new TrackParams().merge(r116);
        by7.a r119 = new by7.a("flow_vui_conversation_start");
        r119.f21463a.merge(r109);
        r119.b();
        return;
    L102:
        r116.put("bot_id", r101);     // Catch: JSONException -> L65
        goto L67
    L57:
        r118 = r310;
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

    public static void a(String r210, String r211, String r212, String r213, String r214, Integer r310, String r311, String r312, String r313, String r314, String r315, Integer r316, String r317, JSONObject r318, Long r319, String r410, String r411, String r412, String r413, String r414, String r415, String r416, Long r417, int r418) {
        if ((r418 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r418 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r418 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r418 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r418 & 32) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r418 & 64) == 0) goto L25;
        Integer r105 = null;
    L27:
        if ((r418 & 2048) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r418 & 4096) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r418 & 8192) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r418 & 16384) == 0) goto L41;
        String r111 = null;
    L43:
        if ((32768 & r418) == 0) goto L45;
        String r112 = null;
    L47:
        if ((65536 & r418) == 0) goto L49;
        Integer r113 = null;
    L51:
        if ((131072 & r418) == 0) goto L53;
        String r114 = null;
    L55:
        if ((262144 & r418) == 0) goto L57;
        JSONObject r115 = new JSONObject();
    L59:
        if ((r418 & 1048576) == 0) goto L61;
        Long r116 = 0L;
    L63:
        if ((r418 & 2097152) == 0) goto L65;
        String r108 = null;
    L67:
        if ((r418 & 4194304) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r418 & 8388608) == 0) goto L73;
        String r215 = null;
    L75:
        if ((r418 & 16777216) == 0) goto L77;
        String r216 = null;
    L79:
        if ((r418 & 33554432) == 0) goto L81;
        String r217 = null;
    L83:
        if ((r418 & 67108864) == 0) goto L85;
        String r218 = null;
    L87:
        if ((r418 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L89;
        String r219 = null;
    L91:
        if ((r418 & 268435456) == 0) goto L93;
        Long r220 = null;
    L94:
        Intrinsics.checkNotNullParameter(r115, "params");
        if (r100 != null) goto L151;
    L99:
        if (r101 == null) goto L101;
        r115.put("call_id", r101);     // Catch: JSONException -> L97
    L101:
        if (r102 == null) goto L103;
        r115.put("conversation_id", r102);     // Catch: JSONException -> L97
    L103:
        if (r103 == null) goto L105;
        r115.put("fail_reason", r103);     // Catch: JSONException -> L97
    L105:
        if (r104 == null) goto L107;
        r115.put("success", r104);     // Catch: JSONException -> L97
    L107:
        if (r105 == null) goto L109;
        r115.put("session_status", r105.intValue());     // Catch: JSONException -> L97
    L109:
        if (r106 == null) goto L111;
        r115.put("enter_method", r106);     // Catch: JSONException -> L97
    L111:
        if (r107 == null) goto L113;
        r115.put("current_page", r107);     // Catch: JSONException -> L97
    L113:
        if (r110 == null) goto L115;
        r115.put("voice_id", r110);     // Catch: JSONException -> L97
    L115:
        if (r111 == null) goto L117;
        r115.put("speaker_id", r111);     // Catch: JSONException -> L97
    L117:
        if (r112 == null) goto L119;
        r115.put("speaker_name", r112);     // Catch: JSONException -> L97
    L119:
        if (r113 == null) goto L121;
        r115.put("error_code", r113.intValue());     // Catch: JSONException -> L97
    L121:
        if (r116 == null) goto L123;
        r115.put("duration", r116.longValue());     // Catch: JSONException -> L97
    L123:
        if (r114 == null) goto L125;
        r115.put("is_immersive_background", r114);     // Catch: JSONException -> L97
    L125:
        if (r108 == null) goto L127;
        r115.put("is_continuous_speak", r108);     // Catch: JSONException -> L97
    L127:
        String r109 = r117;
        if (r109 == null) goto L130;
        r115.put("is_obric_continuous_talk", r109);     // Catch: JSONException -> L97
    L130:
        String r118 = r215;
        if (r118 == null) goto L133;
        r115.put("avatar", r118);     // Catch: JSONException -> L97
    L133:
        String r119 = r216;
        if (r119 == null) goto L136;
        r115.put("chat_type", r119);     // Catch: JSONException -> L97
    L136:
        String r120 = r217;
        if (r120 == null) goto L139;
        r115.put("action_bar_key", r120);     // Catch: JSONException -> L97
    L139:
        String r121 = r218;
        if (r121 == null) goto L142;
        r115.put(LiveTutorHomeVM.ACTION_BAR_ITEM_ID, r121);     // Catch: JSONException -> L97
    L142:
        String r122 = r219;
        if (r122 == null) goto L145;
        r115.put("call_scene", r122);     // Catch: JSONException -> L97
    L145:
        if (r220 == null) goto L149;
        r115.put("pseudo_duration", r220.longValue());     // Catch: JSONException -> L97
    L97:
        e = move-exception;
        FLogger.f375446a.e("EnterEventHelper", "error in EnterEventHelper enterCallStatus " + e.getLocalizedMessage());
    L149:
        TrackParams r123 = new TrackParams().merge(r115);
        by7.a r124 = new by7.a("enter_call_status");
        r124.f21463a.merge(r123);
        r124.b();
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("enter_call_status", r124.c(), null, null);
        return;
    L151:
        r115.put("bot_id", r100);     // Catch: JSONException -> L97
        goto L99
    L93:
        r220 = r417;
        goto L94
    L89:
        r219 = r416;
        goto L91
    L85:
        r218 = r415;
        goto L87
    L81:
        r217 = r414;
        goto L83
    L77:
        r216 = r413;
        goto L79
    L73:
        r215 = r412;
        goto L75
    L69:
        r117 = r411;
        goto L71
    L65:
        r108 = r410;
        goto L67
    L61:
        r116 = r319;
        goto L63
    L57:
        r115 = r318;
        goto L59
    L53:
        r114 = r317;
        goto L55
    L49:
        r113 = r316;
        goto L51
    L45:
        r112 = r315;
        goto L47
    L41:
        r111 = r314;
        goto L43
    L37:
        r110 = r313;
        goto L39
    L33:
        r107 = r312;
        goto L35
    L29:
        r106 = r311;
        goto L31
    L25:
        r105 = r310;
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

    public static void c(String r410, Integer r411, String r412, String r413, String r414, String r415, String r416, String r510, String r511, String r512, String r513, String r514, String r515, Long r516, String r517, String r518, String r519, String r610, String r611, String r612, String r613, String r614, String r615, String r616, String r617, String r618, String r619, String r710, String r711, String r712, String r713, String r714, String r715, String r716, Integer r717, String r718, String r719, String r810, String r811, String r812, String r813, String r814, Integer r815, JSONObject r816, by7.e r817, String r818, String r819, String r910, String r911, String r912, String r913, Boolean r914, int r915, int r916, int r917) {
        if ((r915 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r915 & 8) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r915 & 16) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r915 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r915 & 64) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r915 & 128) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r915 & 256) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r915 & 512) == 0) goto L33;
        String r110 = null;
    L35:
        if ((r915 & 1024) == 0) goto L37;
        String r111 = null;
    L39:
        if ((r915 & 2048) == 0) goto L41;
        String r112 = null;
    L43:
        if ((r915 & 16384) == 0) goto L45;
        String r113 = null;
    L47:
        if ((32768 & r915) == 0) goto L49;
        String r114 = null;
    L51:
        if ((r915 & 65536) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r915 & 131072) == 0) goto L57;
        Long r116 = null;
    L59:
        if ((r915 & 262144) == 0) goto L61;
        String r210 = null;
    L63:
        if ((r915 & 524288) == 0) goto L65;
        String r211 = null;
    L67:
        if ((r915 & 1048576) == 0) goto L69;
        String r212 = null;
    L71:
        if ((r915 & 16777216) == 0) goto L73;
        String r213 = null;
    L75:
        if ((r915 & 33554432) == 0) goto L77;
        String r214 = null;
    L79:
        if ((r915 & 67108864) == 0) goto L81;
        String r310 = null;
    L83:
        if ((r915 & Integer.MIN_VALUE) == 0) goto L85;
        String r107 = null;
    L87:
        if ((r916 & 1) == 0) goto L89;
        String r311 = null;
    L91:
        if ((r916 & 2) == 0) goto L93;
        String r312 = null;
    L95:
        if ((r916 & 4) == 0) goto L97;
        String r313 = null;
    L99:
        if ((r916 & 8) == 0) goto L101;
        String r314 = null;
    L103:
        if ((r916 & 16) == 0) goto L105;
        String r315 = "0";
    L107:
        if ((r916 & 32) == 0) goto L109;
        String r417 = "1";
    L111:
        if ((r916 & 64) == 0) goto L113;
        String r316 = null;
    L115:
        if ((r916 & 128) == 0) goto L117;
        String r108 = null;
    L119:
        if ((r916 & 256) == 0) goto L121;
        String r117 = null;
    L122:
        String r418 = r108;
        if ((r916 & 512) == 0) goto L125;
        String r109 = null;
    L126:
        String r419 = r109;
        if ((r916 & 1024) == 0) goto L129;
        String r118 = null;
    L130:
        String r420 = r118;
        if ((r916 & 2048) == 0) goto L133;
        String r119 = null;
    L134:
        String r421 = r119;
        if ((r916 & 4096) == 0) goto L137;
        String r120 = null;
    L138:
        String r422 = r120;
        if ((r916 & 8192) == 0) goto L141;
        Integer r121 = null;
    L142:
        Integer r520 = r121;
        if ((r916 & 16384) == 0) goto L145;
        String r122 = null;
    L146:
        String r423 = r117;
        if ((r916 & 65536) == 0) goto L149;
        String r123 = null;
    L150:
        String r521 = r107;
        if ((r916 & 131072) == 0) goto L153;
        String r124 = null;
    L155:
        if ((r916 & 262144) == 0) goto L157;
        String r424 = null;
    L159:
        if ((r916 & 524288) == 0) goto L161;
        String r522 = "";
    L163:
        if ((r916 & 1048576) == 0) goto L165;
        String r125 = "";
    L166:
        String r523 = r114;
        if ((r916 & 2097152) == 0) goto L169;
        String r126 = "";
    L171:
        if ((r916 & 4194304) == 0) goto L173;
        Integer r215 = null;
    L175:
        if ((r916 & 8388608) == 0) goto L177;
        JSONObject r127 = new JSONObject();
    L179:
        if ((r916 & 16777216) == 0) goto L181;
        by7.e r425 = null;
    L183:
        if ((r916 & 33554432) == 0) goto L185;
        String r524 = "";
    L187:
        if ((r916 & 67108864) == 0) goto L189;
        Object r128 = "";
    L191:
        if ((r916 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L193;
        Object r129 = "";
    L195:
        if ((r916 & 268435456) == 0) goto L197;
        String r525 = null;
    L199:
        if ((r916 & 536870912) == 0) goto L201;
        String r526 = null;
    L203:
        if ((r916 & 1073741824) == 0) goto L205;
        String r527 = null;
    L207:
        if ((r916 & Integer.MIN_VALUE) == 0) goto L209;
        String r130 = null;
    L211:
        if ((r917 & 2) == 0) goto L213;
        String r528 = null;
    L215:
        if ((r917 & 4) == 0) goto L217;
        Boolean r216 = null;
    L218:
        String r217 = r110;
        Intrinsics.checkNotNullParameter(r125, "presentationId");
        Intrinsics.checkNotNullParameter(r126, "resourceId");
        Intrinsics.checkNotNullParameter(r127, "params");
        r127.putOpt("is_associated", r129);     // Catch: JSONException -> L241
        r127.putOpt("template_page_type", r124);     // Catch: JSONException -> L241
        r127.putOpt("action_bar_key", null);     // Catch: JSONException -> L241
        if (r128 == null) goto L222;
        r127.put("lottery_round_type", r128);     // Catch: JSONException -> L241
    L222:
        if (r122 == null) goto L224;
        r127.put(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r122);     // Catch: JSONException -> L241
    L224:
        if (r123 == null) goto L226;
        r127.put("action_bar_template_type", r123);     // Catch: JSONException -> L241
    L226:
        r127.putOpt("template_page_type", r124);     // Catch: JSONException -> L241
        if (r100 == null) goto L229;
        r127.put("bot_id", r100);     // Catch: JSONException -> L241
    L229:
        if (r101 == null) goto L231;
        r127.put("bot_type", r101.intValue());     // Catch: JSONException -> L241
    L231:
        if (r102 == null) goto L233;
        r127.put("bot_position", r102);     // Catch: JSONException -> L241
    L233:
        if (r103 == null) goto L235;
        r127.put("chat_type", r103);     // Catch: JSONException -> L241
    L235:
        if (r104 == null) goto L237;
        r127.put("conversation_id", r104);     // Catch: JSONException -> L241
    L237:
        if (r105 == null) goto L239;
        r127.put("current_page", r105);     // Catch: JSONException -> L241
        f547843a = r105;     // Catch: JSONException -> L241
    L239:
        if (r217 == null) goto L243;
        r127.put("enter_from", r217);     // Catch: JSONException -> L241
    L243:
        if (r111 == 0) goto L245;
        r127.put("enter_method", r111);     // Catch: JSONException -> L241
    L245:
        if (r112 == 0) goto L247;
        r127.put("group_type", r112);     // Catch: JSONException -> L241
    L247:
        if (r113 == 0) goto L249;
        r127.put("is_from_ug", r113);     // Catch: JSONException -> L241
    L249:
        if (r523 == null) goto L251;
        r127.put("is_immersive_background", r523);     // Catch: JSONException -> L241
    L251:
        String r131 = r115;
        if (r131 == null) goto L254;
        r127.put("is_immersive_background_dynamic", r131);     // Catch: JSONException -> L241
    L254:
        if (r116 == null) goto L256;
        r127.put("is_tts", r116.longValue());     // Catch: JSONException -> L241
    L256:
        String r132 = r210;
        if (r132 == null) goto L259;
        r127.put("landing_tab", r132);     // Catch: JSONException -> L241
    L259:
        String r133 = r211;
        if (r133 == null) goto L262;
        r127.put("page", r133);     // Catch: JSONException -> L241
    L262:
        String r134 = r212;
        if (r134 == null) goto L265;
        r127.put("previous_page", r134);     // Catch: JSONException -> L241
        f547844b = r134;     // Catch: JSONException -> L241
    L265:
        String r135 = r213;
        if (r135 == null) goto L268;
        r127.put("recommend_from", r135);     // Catch: JSONException -> L241
    L268:
        String r136 = r313;
        if (r136 == null) goto L271;
        r127.put("open_method", r136);     // Catch: JSONException -> L241
    L271:
        String r137 = r214;
        if (r137 == null) goto L274;
        r127.put("req_id", r137);     // Catch: JSONException -> L241
    L274:
        String r138 = r310;
        if (r138 == null) goto L277;
        r127.put("request_id", r138);     // Catch: JSONException -> L241
    L277:
        if (r106 == 0) goto L279;
        r127.put("current_tab", r106);     // Catch: JSONException -> L241
    L279:
        if (r521 == null) goto L281;
        r127.put("create_way", r521);     // Catch: JSONException -> L241
    L281:
        String r139 = r311;
        if (r139 == null) goto L284;
        r127.put("from_activity_name", r139);     // Catch: JSONException -> L241
    L284:
        String r140 = r312;
        if (r140 == null) goto L287;
        r127.put("from_activity_module", r140);     // Catch: JSONException -> L241
    L287:
        String r141 = r314;
        if (r141 == null) goto L290;
        r127.put("item_id", r141);     // Catch: JSONException -> L241
    L290:
        String r142 = r315;
        if (r142 == null) goto L294;
        r127.put("is_call_bot", r142);     // Catch: JSONException -> L241
    L294:
        if (com.larus.utils.o0.d(r417) == false) goto L296;
        r127.put("is_having_content", r417);     // Catch: JSONException -> L241
    L296:
        String r143 = r316;
        if (r143 == null) goto L299;
        r127.put("from_notice_type", r143);     // Catch: JSONException -> L241
    L299:
        if (r423 == null) goto L301;
        r127.put("input_function", r423);     // Catch: JSONException -> L241
    L301:
        if (r419 == null) goto L303;
        r127.put(MusicAppletPage.KEY_MESSAGE_ID, r419);     // Catch: JSONException -> L241
    L303:
        if (r420 == null) goto L305;
        r127.put("deep_research_id", r420);     // Catch: JSONException -> L241
    L305:
        r127.putOpt("outer_link_source", r418);     // Catch: JSONException -> L241
        if (r421 == null) goto L308;
        r127.put("page_token", r421);     // Catch: JSONException -> L241
    L308:
        if (r422 == null) goto L310;
        r127.put("artifact_meta_id", r422);     // Catch: JSONException -> L241
    L310:
        if (r520 == null) goto L313;
        r127.put("artifact_type", r520.toString());     // Catch: JSONException -> L241
    L313:
        if (com.larus.utils.o0.d(r522) == false) goto L316;
        r127.put("aippt_task_id", r522);     // Catch: JSONException -> L241
    L316:
        if (com.larus.utils.o0.d(r125) == false) goto L319;
        r127.put("presentation_id", r125);     // Catch: JSONException -> L241
    L319:
        if (com.larus.utils.o0.d(r126) == false) goto L321;
        r127.put("resource_id", r126);     // Catch: JSONException -> L241
    L321:
        if (r215 == null) goto L323;
        r127.put("resource_type", r215.toString());     // Catch: JSONException -> L241
    L323:
        String r144 = r424;
        if (r144 == null) goto L327;
        r127.put("previous_camera_tab_name", r144);     // Catch: JSONException -> L241
    L327:
        if (com.larus.utils.o0.d(r524) == false) goto L330;
        r127.put("trigger_app", r524);     // Catch: JSONException -> L241
    L330:
        if (com.larus.utils.o0.d(r525) == false) goto L333;
        r127.put("collection_id", r525);     // Catch: JSONException -> L241
    L333:
        if (com.larus.utils.o0.d(r526) == false) goto L336;
        r127.put("collection_name", r526);     // Catch: JSONException -> L241
    L336:
        if (com.larus.utils.o0.d(r527) == false) goto L339;
        r127.put("content_type", r527);     // Catch: JSONException -> L241
    L339:
        if (com.larus.utils.o0.d(r130) == false) goto L342;
        r127.put("content_sec_type", r130);     // Catch: JSONException -> L241
    L342:
        if (com.larus.utils.o0.d(null) == false) goto L344;
        r127.put("artifact_create_method", null);     // Catch: JSONException -> L241
    L344:
        if (r216 == null) goto L351;
        if (r216.booleanValue() == false) goto L348;
        int r145 = 1;
    L349:
        r127.put("is_has_replica", r145);     // Catch: JSONException -> L241
        goto L351
    L348:
        r145 = 0;
    L351:
        if (com.larus.utils.o0.d(r528) == false) goto L355;
        r127.put("click_from", r528);     // Catch: JSONException -> L241
    L355:
        TrackParams r146 = new TrackParams().merge(r127);
        by7.a r147 = new by7.a(CheckPointType.ENTER_PAGE);
        by7.e r148 = r425;
        if (r148 == null) goto L358;
        r147.f21464b = r148;
    L358:
        r147.f21463a.merge(r146);
        r147.b();
        if (TextUtils.equals(r105, "chat") == false) goto L365;
        com.larus.platform.service.g.f365738a.monitorEventForSlardar(CheckPointType.ENTER_PAGE, r127, new JSONObject(), null);
        return;
    L365:
        return;
    L241:
        e = move-exception;
        FLogger.f375446a.e("EnterEventHelper", "error in EnterEventHelper enterPage " + e.getLocalizedMessage());
        goto L355
    L217:
        r216 = r914;
        goto L218
    L213:
        r528 = r913;
        goto L215
    L209:
        r130 = r912;
        goto L211
    L205:
        r527 = r911;
        goto L207
    L201:
        r526 = r910;
        goto L203
    L197:
        r525 = r819;
        goto L199
    L193:
        r129 = null;
        goto L195
    L189:
        r128 = null;
        goto L191
    L185:
        r524 = r818;
        goto L187
    L181:
        r425 = r817;
        goto L183
    L177:
        r127 = r816;
        goto L179
    L173:
        r215 = r815;
        goto L175
    L169:
        r126 = r814;
        goto L171
    L165:
        r125 = r813;
        goto L166
    L161:
        r522 = r812;
        goto L163
    L157:
        r424 = r811;
        goto L159
    L153:
        r124 = r810;
        goto L155
    L149:
        r123 = r719;
        goto L150
    L145:
        r122 = r718;
        goto L146
    L141:
        r121 = r717;
        goto L142
    L137:
        r120 = r716;
        goto L138
    L133:
        r119 = r715;
        goto L134
    L129:
        r118 = r714;
        goto L130
    L125:
        r109 = r713;
        goto L126
    L121:
        r117 = r712;
        goto L122
    L117:
        r108 = r711;
        goto L119
    L113:
        r316 = r710;
        goto L115
    L109:
        r417 = r619;
        goto L111
    L105:
        r315 = r618;
        goto L107
    L101:
        r314 = r617;
        goto L103
    L97:
        r313 = r616;
        goto L99
    L93:
        r312 = r615;
        goto L95
    L89:
        r311 = r614;
        goto L91
    L85:
        r107 = r613;
        goto L87
    L81:
        r310 = r612;
        goto L83
    L77:
        r214 = r611;
        goto L79
    L73:
        r213 = r610;
        goto L75
    L69:
        r212 = r519;
        goto L71
    L65:
        r211 = r518;
        goto L67
    L61:
        r210 = r517;
        goto L63
    L57:
        r116 = r516;
        goto L59
    L53:
        r115 = r515;
        goto L55
    L49:
        r114 = r514;
        goto L51
    L45:
        r113 = r513;
        goto L47
    L41:
        r112 = r512;
        goto L43
    L37:
        r111 = r511;
        goto L39
    L33:
        r110 = r510;
        goto L35
    L29:
        r106 = r416;
        goto L31
    L25:
        r105 = r415;
        goto L27
    L21:
        r104 = r414;
        goto L23
    L17:
        r103 = r413;
        goto L19
    L13:
        r102 = r412;
        goto L15
    L9:
        r101 = r411;
        goto L11
    L5:
        r100 = r410;
        goto L7
    }
}
