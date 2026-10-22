package tx9;

import androidx.core.app.NotificationCompat;
import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.trace.RealtimeCallEntry;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class c3 {
    public static void c(RealtimeCallEntry r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        JSONObject r101 = new JSONObject();
        r101.put(SoloKtvContext.SOLO_PAGE_ENTRANCE, r100.getTrackName());
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("voicecall_entrance_show");
        r103.f21463a.merge(r102);
        r103.b();
    }

    public static final void a(String r100, long r101) {
        JSONObject r102 = new JSONObject();
        if (r100 == null) goto L5;
        r102.put(MusicAppletPage.KEY_MESSAGE_ID, r100);
    L5:
        r102.put("asr_tail_time", r101);
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("vui_asr_tail_info");
        r104.f21463a.merge(r103);
        r104.b();
    }

    public static void g(Long r100, Long r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        if (r100 != null) goto L13;
    L7:
        if (r101 == null) goto L11;
        r102.put("reason", r101.longValue());     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("RealtimeEventHelper", "error in RealtimeEventHelper realtimeCallSettingsResponseErrorFix " + e.getLocalizedMessage());
    L11:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("realtime_call_settings_response_error_fix");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L13:
        r102.put("enable", r100.longValue());     // Catch: JSONException -> L5
        goto L7
    }

    public static void b(String r100, String r101, Long r102, String r103, by7.e r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 16) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 32) == 0) goto L17;
        JSONObject r106 = new JSONObject();
    L19:
        if ((r105 & 64) == 0) goto L21;
        r104 = null;
    L21:
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 != null) goto L39;
    L26:
        if (r101 == null) goto L28;
        r106.put("position", r101);     // Catch: JSONException -> L24
    L28:
        if (r102 == null) goto L30;
        r106.put("reason", r102.longValue());     // Catch: JSONException -> L24
    L30:
        if (r103 == null) goto L34;
        r106.put("red_dot", r103);     // Catch: JSONException -> L24
    L24:
        e = move-exception;
        FLogger.f375446a.e("RealtimeEventHelper", "error in RealtimeEventHelper realtimeCallEntranceShow " + e.getLocalizedMessage());
    L34:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("realtime_call_entrance_show");
        if (r104 == null) goto L37;
        r108.f21464b = r104;
    L37:
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L39:
        r106.put("bot_id", r100);     // Catch: JSONException -> L24
        goto L26
    L17:
        r106 = null;
        goto L19
    }

    public static void e(String r110, String r210, String r211, Long r212, String r213, Long r214, Long r215, Long r216, String r217, Long r218, String r219, String r310, Long r311, String r312, Integer r313, String r314, JSONObject r315, Integer r316, int r317) {
        if ((r317 & 2) == 0) goto L5;
        Object r100 = null;
    L7:
        if ((r317 & 4) == 0) goto L9;
        Object r101 = null;
    L11:
        if ((r317 & 8) == 0) goto L13;
        Object r102 = null;
    L15:
        if ((r317 & 16) == 0) goto L17;
        Long r103 = null;
    L19:
        if ((r317 & 32) == 0) goto L21;
        Object r104 = null;
    L23:
        if ((r317 & 64) == 0) goto L25;
        Long r105 = null;
    L27:
        if ((r317 & 128) == 0) goto L29;
        Long r106 = null;
    L31:
        if ((r317 & 256) == 0) goto L33;
        Long r107 = null;
    L35:
        if ((r317 & 512) == 0) goto L37;
        Object r111 = null;
    L39:
        if ((r317 & 1024) == 0) goto L41;
        Long r112 = null;
    L43:
        if ((r317 & 2048) == 0) goto L45;
        Object r113 = null;
    L47:
        if ((r317 & 4096) == 0) goto L49;
        Object r114 = null;
    L51:
        if ((r317 & 8192) == 0) goto L53;
        Long r115 = null;
    L55:
        if ((r317 & 16384) == 0) goto L57;
        Object r116 = null;
    L59:
        if ((r317 & 262144) == 0) goto L61;
        Integer r117 = null;
    L63:
        if ((r317 & 524288) == 0) goto L65;
        Object r108 = null;
    L67:
        if ((r317 & 2097152) == 0) goto L69;
        JSONObject r109 = new JSONObject();
    L71:
        if ((r317 & 8388608) == 0) goto L73;
        Integer r118 = null;
    L74:
        Intrinsics.checkNotNullParameter(r109, "params");
        if (r100 != null) goto L115;
    L79:
        if (r101 == null) goto L81;
        r109.put("call_id", r101);     // Catch: JSONException -> L77
    L81:
        if (r102 == null) goto L83;
        r109.put("conversation_id", r102);     // Catch: JSONException -> L77
    L83:
        if (r103 == null) goto L85;
        r109.put("error_code", r103.longValue());     // Catch: JSONException -> L77
    L85:
        if (r104 == null) goto L87;
        r109.put("error_msg", r104);     // Catch: JSONException -> L77
    L87:
        if (r105 == null) goto L89;
        r109.put("from_status", r105.longValue());     // Catch: JSONException -> L77
    L89:
        if (r106 == null) goto L91;
        r109.put("is_ai_in_motion", r106.longValue());     // Catch: JSONException -> L77
    L91:
        if (r107 == null) goto L93;
        r109.put("is_mock_chat", r107.longValue());     // Catch: JSONException -> L77
    L93:
        if (r111 == null) goto L95;
        r109.put("llm_model", r111);     // Catch: JSONException -> L77
    L95:
        if (r112 == null) goto L97;
        r109.put("pre_query", r112.longValue());     // Catch: JSONException -> L77
    L97:
        if (r113 == null) goto L99;
        r109.put("scene", r113);     // Catch: JSONException -> L77
    L99:
        if (r114 == null) goto L101;
        r109.put("task_id", r114);     // Catch: JSONException -> L77
    L101:
        if (r115 == null) goto L103;
        r109.put("user_interrupt", r115.longValue());     // Catch: JSONException -> L77
    L103:
        if (r116 == null) goto L105;
        r109.put("voice_style", r116);     // Catch: JSONException -> L77
    L105:
        if (r117 == null) goto L107;
        r109.put("is_session_started", r117.intValue());     // Catch: JSONException -> L77
    L107:
        if (r108 == 0) goto L109;
        r109.put(DyVerifyEventConstants.EventParam.BIZ_SCENE, r108);     // Catch: JSONException -> L77
    L109:
        if (r118 == null) goto L113;
        r109.put("is_dora_si", r118.intValue());     // Catch: JSONException -> L77
    L77:
        e = move-exception;
        FLogger.f375446a.e("RealtimeEventHelper", "error in RealtimeEventHelper realtimeCallError " + e.getLocalizedMessage());
    L113:
        TrackParams r119 = new TrackParams().merge(r109);
        by7.a r120 = new by7.a("flow_vui_error_report");
        r120.f21463a.merge(r119);
        r120.b();
        return;
    L115:
        r109.put("bot_id", r100);     // Catch: JSONException -> L77
        goto L79
    L73:
        r118 = r316;
        goto L74
    L69:
        r109 = r315;
        goto L71
    L65:
        r108 = r314;
        goto L67
    L61:
        r117 = r313;
        goto L63
    L57:
        r116 = r312;
        goto L59
    L53:
        r115 = r311;
        goto L55
    L49:
        r114 = r310;
        goto L51
    L45:
        r113 = r219;
        goto L47
    L41:
        r112 = r218;
        goto L43
    L37:
        r111 = r217;
        goto L39
    L33:
        r107 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static void d(String r210, String r211, String r212, String r213, Long r310, String r311, Integer r312, String r313, String r314, Long r315, Long r316, Long r317, String r318, Long r319, String r410, String r411, Long r412, String r413, Integer r414, Integer r415, Integer r416, Integer r417, String r418, String r419, Integer r510, Integer r511, Integer r512, JSONObject r513, int r514) {
        if ((r514 & 2) == 0) goto L5;
        Object r100 = null;
    L7:
        if ((r514 & 4) == 0) goto L9;
        Object r101 = null;
    L11:
        if ((r514 & 8) == 0) goto L13;
        Object r102 = null;
    L15:
        if ((r514 & 16) == 0) goto L17;
        Object r103 = null;
    L19:
        if ((r514 & 32) == 0) goto L21;
        Long r104 = null;
    L23:
        if ((r514 & 64) == 0) goto L25;
        Object r105 = null;
    L27:
        if ((r514 & 128) == 0) goto L29;
        Integer r106 = null;
    L31:
        if ((r514 & 256) == 0) goto L33;
        Object r107 = null;
    L35:
        if ((r514 & 512) == 0) goto L37;
        Object r110 = null;
    L39:
        if ((r514 & 1024) == 0) goto L41;
        Long r111 = null;
    L43:
        if ((r514 & 2048) == 0) goto L45;
        Long r112 = null;
    L47:
        if ((r514 & 4096) == 0) goto L49;
        Long r113 = null;
    L51:
        if ((r514 & 8192) == 0) goto L53;
        Object r114 = null;
    L55:
        if ((r514 & 16384) == 0) goto L57;
        Long r115 = null;
    L59:
        if ((r514 & 32768) == 0) goto L61;
        Object r108 = null;
    L62:
        Object r214 = r110;
        if ((r514 & 65536) == 0) goto L65;
        Object r116 = null;
    L67:
        if ((r514 & 131072) == 0) goto L69;
        Long r117 = null;
    L70:
        Object r215 = r107;
        if ((r514 & 262144) == 0) goto L73;
        Object r109 = null;
    L75:
        if ((r514 & 524288) == 0) goto L77;
        Integer r118 = null;
    L79:
        if ((r514 & 1048576) == 0) goto L81;
        Integer r119 = null;
    L83:
        if ((r514 & 2097152) == 0) goto L85;
        Integer r216 = null;
    L87:
        if ((r514 & 4194304) == 0) goto L89;
        Integer r217 = null;
    L90:
        Integer r218 = r106;
        if ((r514 & 8388608) == 0) goto L93;
        Object r120 = null;
    L95:
        if ((r514 & 16777216) == 0) goto L97;
        Object r219 = null;
    L99:
        if ((r514 & 33554432) == 0) goto L101;
        Integer r220 = null;
    L103:
        if ((r514 & 67108864) == 0) goto L105;
        Integer r221 = null;
    L107:
        if ((r514 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L109;
        Integer r121 = null;
    L111:
        if ((r514 & 268435456) == 0) goto L113;
        JSONObject r122 = new JSONObject();
    L114:
        Intrinsics.checkNotNullParameter(r122, "params");
        if (r100 != null) goto L176;
    L119:
        if (r101 == null) goto L121;
        r122.put("call_id", r101);     // Catch: JSONException -> L117
    L121:
        if (r102 == null) goto L123;
        r122.put("room_id", r102);     // Catch: JSONException -> L117
    L123:
        if (r103 == null) goto L125;
        r122.put("conversation_id", r103);     // Catch: JSONException -> L117
    L125:
        if (r104 == null) goto L127;
        r122.put("error_code", r104.longValue());     // Catch: JSONException -> L117
    L127:
        if (r105 == null) goto L129;
        r122.put("error_msg", r105);     // Catch: JSONException -> L117
    L129:
        if (r111 == null) goto L131;
        r122.put("from_status", r111.longValue());     // Catch: JSONException -> L117
    L131:
        if (r112 == null) goto L133;
        r122.put("is_ai_in_motion", r112.longValue());     // Catch: JSONException -> L117
    L133:
        if (r113 == null) goto L135;
        r122.put("is_mock_chat", r113.longValue());     // Catch: JSONException -> L117
    L135:
        if (r114 == null) goto L137;
        r122.put("llm_model", r114);     // Catch: JSONException -> L117
    L137:
        if (r115 == null) goto L139;
        r122.put("pre_query", r115.longValue());     // Catch: JSONException -> L117
    L139:
        if (r108 == null) goto L141;
        r122.put("scene", r108);     // Catch: JSONException -> L117
    L141:
        if (r116 == null) goto L143;
        r122.put("task_id", r116);     // Catch: JSONException -> L117
    L143:
        if (r117 == null) goto L145;
        r122.put("user_interrupt", r117.longValue());     // Catch: JSONException -> L117
    L145:
        if (r109 == null) goto L147;
        r122.put("voice_style", r109);     // Catch: JSONException -> L117
    L147:
        if (r118 == null) goto L149;
        r122.put("is_ai_motion_support", r118.intValue());     // Catch: JSONException -> L117
    L149:
        if (r119 == null) goto L151;
        r122.put("is_avatar_can_drive", r119.intValue());     // Catch: JSONException -> L117
    L151:
        if (r216 == null) goto L153;
        r122.put("is_algorithm_model_downloaded", r216.intValue());     // Catch: JSONException -> L117
    L153:
        if (r217 == null) goto L155;
        r122.put("is_session_started", r217.intValue());     // Catch: JSONException -> L117
    L155:
        if (r120 == 0) goto L157;
        r122.put(DyVerifyEventConstants.EventParam.BIZ_SCENE, r120);     // Catch: JSONException -> L117
    L157:
        Object r123 = r219;
        if (r123 == null) goto L160;
        r122.put("dora_mode", r123);     // Catch: JSONException -> L117
    L160:
        if (r220 == null) goto L162;
        r122.put("is_rtc", r220.intValue());     // Catch: JSONException -> L117
    L162:
        if (r221 == null) goto L164;
        r122.put("is_dora_si", r221.intValue());     // Catch: JSONException -> L117
    L164:
        if (r121 == null) goto L166;
        r122.put("av_session_type", r121.intValue());     // Catch: JSONException -> L117
    L166:
        if (r218 == null) goto L168;
        r122.put("sub_error_code", r218.intValue());     // Catch: JSONException -> L117
    L168:
        if (r215 == null) goto L170;
        r122.put("sub_error_msg", r215);     // Catch: JSONException -> L117
    L170:
        if (r214 == null) goto L174;
        r122.put("sub_extra_info", r214);     // Catch: JSONException -> L117
    L117:
        e = move-exception;
        FLogger.f375446a.e("RealtimeEventHelper", "error in RealtimeEventHelper realtimeCallError " + e.getLocalizedMessage());
    L174:
        TrackParams r124 = new TrackParams().merge(r122);
        by7.a r125 = new by7.a("realtime_call_error");
        r125.f21463a.merge(r124);
        r125.b();
        return;
    L176:
        r122.put("bot_id", r100);     // Catch: JSONException -> L117
        goto L119
    L113:
        r122 = r513;
        goto L114
    L109:
        r121 = r512;
        goto L111
    L105:
        r221 = r511;
        goto L107
    L101:
        r220 = r510;
        goto L103
    L97:
        r219 = r419;
        goto L99
    L93:
        r120 = r418;
        goto L95
    L89:
        r217 = r417;
        goto L90
    L85:
        r216 = r416;
        goto L87
    L81:
        r119 = r415;
        goto L83
    L77:
        r118 = r414;
        goto L79
    L73:
        r109 = r413;
        goto L75
    L69:
        r117 = r412;
        goto L70
    L65:
        r116 = r411;
        goto L67
    L61:
        r108 = r410;
        goto L62
    L57:
        r115 = r319;
        goto L59
    L53:
        r114 = r318;
        goto L55
    L49:
        r113 = r317;
        goto L51
    L45:
        r112 = r316;
        goto L47
    L41:
        r111 = r315;
        goto L43
    L37:
        r110 = r314;
        goto L39
    L33:
        r107 = r313;
        goto L35
    L29:
        r106 = r312;
        goto L31
    L25:
        r105 = r311;
        goto L27
    L21:
        r104 = r310;
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

    public static void f(Long r210, String r310, String r311, String r312, Long r313, Long r314, Long r315, Long r316, String r317, Long r318, String r319, Long r410, Long r411, Long r412, String r413, Long r414, String r415, Integer r416, Integer r417, Integer r418, String r419, String r510, String r511, String r512, Integer r513, Integer r514, JSONObject r515, String r516, int r517) {
        if ((r517 & 2) == 0) goto L5;
        Long r100 = null;
    L7:
        if ((r517 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r517 & 16) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r517 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r517 & 64) == 0) goto L21;
        Long r104 = null;
    L23:
        if ((r517 & 128) == 0) goto L25;
        Long r105 = null;
    L27:
        if ((r517 & 256) == 0) goto L29;
        Long r106 = null;
    L31:
        if ((r517 & 512) == 0) goto L33;
        Long r107 = null;
    L35:
        if ((r517 & 1024) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r517 & 4096) == 0) goto L41;
        Long r111 = null;
    L43:
        if ((r517 & 8192) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r517 & 16384) == 0) goto L49;
        Long r113 = null;
    L51:
        if ((32768 & r517) == 0) goto L53;
        Long r114 = null;
    L55:
        if ((65536 & r517) == 0) goto L57;
        Long r115 = null;
    L59:
        if ((r517 & 131072) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r517 & 262144) == 0) goto L65;
        Long r116 = null;
    L67:
        if ((r517 & 524288) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r517 & 1048576) == 0) goto L73;
        Integer r118 = null;
    L75:
        if ((r517 & 2097152) == 0) goto L77;
        Integer r211 = null;
    L79:
        if ((r517 & 4194304) == 0) goto L81;
        Integer r212 = null;
    L83:
        if ((r517 & 8388608) == 0) goto L85;
        String r213 = NotificationCompat.CATEGORY_CALL;
    L87:
        if ((r517 & 16777216) == 0) goto L89;
        String r214 = null;
    L91:
        if ((r517 & 33554432) == 0) goto L93;
        String r109 = null;
    L95:
        if ((r517 & 67108864) == 0) goto L97;
        String r119 = null;
    L99:
        if ((r517 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L101;
        Integer r215 = null;
    L103:
        if ((r517 & 268435456) == 0) goto L105;
        Integer r216 = null;
    L107:
        if ((r517 & 536870912) == 0) goto L109;
        JSONObject r120 = new JSONObject();
    L111:
        if ((r517 & Integer.MIN_VALUE) == 0) goto L113;
        String r320 = null;
    L114:
        Intrinsics.checkNotNullParameter(r120, "params");
        if (r119 != null) goto L178;
    L119:
        if (r109 == null) goto L121;
        r120.put("query_id", r109);     // Catch: JSONException -> L117
    L121:
        if (r100 == null) goto L123;
        r120.put("asr_tail", r100.longValue());     // Catch: JSONException -> L117
    L123:
        if (r101 == null) goto L125;
        r120.put("bot_id", r101);     // Catch: JSONException -> L117
    L125:
        if (r102 == null) goto L127;
        r120.put("call_id", r102);     // Catch: JSONException -> L117
    L127:
        if (r103 == null) goto L129;
        r120.put("conversation_id", r103);     // Catch: JSONException -> L117
    L129:
        if (r104 == null) goto L131;
        r120.put("if_proactive", r104.longValue());     // Catch: JSONException -> L117
    L131:
        if (r105 == null) goto L133;
        r120.put("is_ai_in_motion", r105.longValue());     // Catch: JSONException -> L117
    L133:
        if (r106 == null) goto L135;
        r120.put("is_mock_chat", r106.longValue());     // Catch: JSONException -> L117
    L135:
        if (r107 == null) goto L137;
        r120.put("llm", r107.longValue());     // Catch: JSONException -> L117
    L137:
        if (r110 == null) goto L139;
        r120.put("llm_model", r110);     // Catch: JSONException -> L117
    L139:
        if (r111 == null) goto L141;
        r120.put("pre_query", r111.longValue());     // Catch: JSONException -> L117
    L141:
        if (r112 == null) goto L143;
        r120.put("task_id", r112);     // Catch: JSONException -> L117
    L143:
        if (r113 == null) goto L145;
        r120.put("total", r113.longValue());     // Catch: JSONException -> L117
    L145:
        if (r114 == 0) goto L147;
        r120.put("tts_delay", r114.longValue());     // Catch: JSONException -> L117
    L147:
        if (r114 == 0) goto L149;
        r120.put("appease_play_duration", r115);     // Catch: JSONException -> L117
    L149:
        if (r114 == 0) goto L151;
        r120.put("comfortScene", r108);     // Catch: JSONException -> L117
    L151:
        if (r116 == null) goto L153;
        r120.put("user_interrupt", r116.longValue());     // Catch: JSONException -> L117
    L153:
        String r121 = r117;
        if (r121 == null) goto L156;
        r120.put("voice_style", r121);     // Catch: JSONException -> L117
    L156:
        if (r118 == null) goto L158;
        r120.put("is_ai_motion_support", r118.intValue());     // Catch: JSONException -> L117
    L158:
        if (r211 == null) goto L160;
        r120.put("is_avatar_can_drive", r211.intValue());     // Catch: JSONException -> L117
    L160:
        if (r212 == null) goto L162;
        r120.put("is_algorithm_model_downloaded", r212.intValue());     // Catch: JSONException -> L117
    L162:
        String r122 = r213;
        if (r122 == null) goto L165;
        r120.put("scene", r122);     // Catch: JSONException -> L117
    L165:
        String r123 = r214;
        if (r123 == null) goto L168;
        r120.put("dora_mode", r123);     // Catch: JSONException -> L117
    L168:
        if (r320 == null) goto L170;
        r120.put("call_scene", r320);     // Catch: JSONException -> L117
    L170:
        if (r215 == null) goto L172;
        r120.put("is_rtc", r215.intValue());     // Catch: JSONException -> L117
    L172:
        if (r216 == null) goto L176;
        r120.put("is_dora_si", r216.intValue());     // Catch: JSONException -> L117
    L117:
        e = move-exception;
        FLogger.f375446a.e("RealtimeEventHelper", "error in RealtimeEventHelper realtimeCallMessage " + e.getLocalizedMessage());
    L176:
        TrackParams r124 = new TrackParams().merge(r120);
        by7.a r125 = new by7.a("realtime_call_message");
        r125.f21463a.merge(r124);
        r125.b();
        return;
    L178:
        r120.put(NoticeInfo.KEY_REPLY_ID, r119);     // Catch: JSONException -> L117
        goto L119
    L113:
        r320 = r516;
        goto L114
    L109:
        r120 = r515;
        goto L111
    L105:
        r216 = r514;
        goto L107
    L101:
        r215 = r513;
        goto L103
    L97:
        r119 = r512;
        goto L99
    L93:
        r109 = r511;
        goto L95
    L89:
        r214 = r510;
        goto L91
    L85:
        r213 = r419;
        goto L87
    L81:
        r212 = r418;
        goto L83
    L77:
        r211 = r417;
        goto L79
    L73:
        r118 = r416;
        goto L75
    L69:
        r117 = r415;
        goto L71
    L65:
        r116 = r414;
        goto L67
    L61:
        r108 = r413;
        goto L63
    L57:
        r115 = r412;
        goto L59
    L53:
        r114 = r411;
        goto L55
    L49:
        r113 = r410;
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
}
