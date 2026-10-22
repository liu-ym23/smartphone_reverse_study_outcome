package tx9;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class f0 {
    public static void b(String r100, String r101, String r102, String r103, String r104, JSONObject r105, by7.e r106) {
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L21;
    L7:
        if (r101 == null) goto L9;
        r105.put("is_immersive_background", r101);     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L11;
        r105.put("recommend_from", r102);     // Catch: JSONException -> L5
    L11:
        if (r103 == null) goto L13;
        r105.put("req_id", r103);     // Catch: JSONException -> L5
    L13:
        r105.put("is_call_bot", r104);     // Catch: JSONException -> L5
    L16:
        TrackParams r107 = new TrackParams().merge(r105);
        by7.a r108 = new by7.a("complete_report_bot_reason");
        if (r106 == null) goto L19;
        r108.f21464b = r106;
    L19:
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("CompleteEventHelper", "error in CompleteEventHelper completeReportBotReason " + e.getLocalizedMessage());
        goto L16
    L21:
        r105.put("bot_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void c(String r100, String r101, String r102, String r103, String r104, String r105, String r106, JSONObject r107, by7.e r108) {
        Intrinsics.checkNotNullParameter(r107, "params");
        if (r100 != null) goto L25;
    L7:
        if (r101 == null) goto L9;
        r107.put("is_immersive_background", r101);     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L11;
        r107.put("recommend_from", r102);     // Catch: JSONException -> L5
    L11:
        if (r103 == null) goto L13;
        r107.put("req_id", r103);     // Catch: JSONException -> L5
    L13:
        r107.put("is_call_bot", r104);     // Catch: JSONException -> L5
        if (r105 == null) goto L16;
        r107.put("user_case_item_id", r105);     // Catch: JSONException -> L5
    L16:
        if (r106 == null) goto L20;
        r107.put("user_case_reco_request_id", r106);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("CompleteEventHelper", "error in CompleteEventHelper completeReportReason " + e.getLocalizedMessage());
    L20:
        TrackParams r109 = new TrackParams().merge(r107);
        by7.a r110 = new by7.a("complete_report_reason");
        if (r108 == null) goto L23;
        r110.f21464b = r108;
    L23:
        r110.f21463a.merge(r109);
        r110.b();
        return;
    L25:
        r107.put("bot_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void a(String r310, String r311, String r312, String r313, String r314, String r410, String r411, String r412, String r413, String r414, String r415, String r416, Boolean r417, Integer r418, Boolean r419, String r510, String r511, String r512, Boolean r513, String r514, String r515, String r516, String r517, String r518, String r519, String r610, String r611, String r612, Boolean r613, Boolean r614, Integer r615, String r616, String r617, Boolean r618, Boolean r619, by7.e r710, int r711, int r712) {
        if ((r711 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r711 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r711 & 16) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r711 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r711 & 64) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r711 & 128) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r711 & 256) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r711 & 512) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r711 & 1024) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r711 & 2048) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r711 & 4096) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r711 & 8192) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r711 & 16384) == 0) goto L53;
        Boolean r114 = null;
    L55:
        if ((32768 & r711) == 0) goto L57;
        Integer r115 = null;
    L59:
        if ((r711 & 65536) == 0) goto L61;
        Boolean r116 = null;
    L63:
        if ((r711 & 131072) == 0) goto L65;
        String r108 = null;
    L67:
        if ((r711 & 262144) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r711 & 524288) == 0) goto L73;
        String r210 = null;
    L75:
        if ((r711 & 1048576) == 0) goto L77;
        Boolean r118 = null;
    L79:
        if ((r711 & 2097152) == 0) goto L81;
        String r211 = null;
    L83:
        if ((r711 & 4194304) == 0) goto L85;
        String r212 = null;
    L87:
        if ((r711 & 8388608) == 0) goto L89;
        String r213 = null;
    L91:
        if ((r711 & 16777216) == 0) goto L93;
        String r214 = null;
    L95:
        if ((r711 & 33554432) == 0) goto L97;
        String r215 = null;
    L99:
        if ((r711 & 67108864) == 0) goto L101;
        String r216 = null;
    L103:
        if ((r711 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L105;
        String r315 = null;
    L107:
        if ((r711 & 268435456) == 0) goto L109;
        String r316 = null;
    L111:
        if ((r711 & 536870912) == 0) goto L113;
        String r317 = null;
    L115:
        if ((r711 & 1073741824) == 0) goto L117;
        Boolean r217 = null;
    L119:
        if ((r711 & Integer.MIN_VALUE) == 0) goto L121;
        Boolean r109 = null;
    L123:
        if ((r712 & 1) == 0) goto L125;
        Integer r218 = null;
    L127:
        if ((r712 & 2) == 0) goto L129;
        String r318 = null;
    L131:
        if ((r712 & 4) == 0) goto L133;
        String r319 = null;
    L135:
        if ((r712 & 8) == 0) goto L137;
        Boolean r219 = null;
    L139:
        if ((r712 & 16) == 0) goto L141;
        Boolean r320 = null;
    L143:
        if ((r712 & 32) == 0) goto L145;
        JSONObject r119 = new JSONObject();
    L147:
        if ((r712 & 64) == 0) goto L149;
        by7.e r321 = null;
    L150:
        Intrinsics.checkNotNullParameter(r119, "params");
        if (r112 != null) goto L264;
    L155:
        if (r113 == null) goto L157;
        r119.put("creation_id", r113);     // Catch: JSONException -> L153
    L157:
        String r120 = "0";
        if (r114 != null) goto L160;
    L164:
        if (r115 == null) goto L166;
        r119.put("sp_cnt", r115.intValue());     // Catch: JSONException -> L153
    L166:
        if (r116 != null) goto L168;
    L172:
        if (r100 == null) goto L174;
        r119.put("bot_id", r100);     // Catch: JSONException -> L153
    L174:
        if (r101 == null) goto L176;
        r119.put("enter_from", r101);     // Catch: JSONException -> L153
    L176:
        if (r102 == null) goto L178;
        r119.put("enter_method", r102);     // Catch: JSONException -> L153
    L178:
        if (r103 == null) goto L180;
        r119.put("if_allow_search", r103);     // Catch: JSONException -> L153
    L180:
        if (r104 == null) goto L182;
        r119.put("if_auto_filled", r104);     // Catch: JSONException -> L153
    L182:
        if (r105 == null) goto L184;
        r119.put("if_generate_picture", r105);     // Catch: JSONException -> L153
    L184:
        if (r106 == null) goto L186;
        r119.put("if_has_voice", r106);     // Catch: JSONException -> L153
    L186:
        if (r107 == null) goto L188;
        r119.put("if_system_prompt_added", r107);     // Catch: JSONException -> L153
    L188:
        if (r110 == null) goto L190;
        r119.put("previous_page", r110);     // Catch: JSONException -> L153
    L190:
        if (r111 == null) goto L192;
        r119.put("profile_photo_type", r111);     // Catch: JSONException -> L153
    L192:
        if (r108 == 0) goto L194;
        r119.put("from_activity_name", r108);     // Catch: JSONException -> L153
    L194:
        String r121 = r117;
        if (r121 == null) goto L197;
        r119.put("from_activity_module", r121);     // Catch: JSONException -> L153
    L197:
        String r122 = r210;
        if (r122 == null) goto L200;
        r119.put("image_type", r122);     // Catch: JSONException -> L153
    L200:
        if (r118 != null) goto L202;
    L206:
        String r123 = r211;
        if (r123 == null) goto L209;
        r119.put("voice_id", r123);     // Catch: JSONException -> L153
    L209:
        String r124 = r212;
        if (r124 == null) goto L213;
        r119.put("voice_type", r124);     // Catch: JSONException -> L153
    L213:
        if (com.larus.utils.o0.d(r315) == false) goto L216;
        r119.put("suggested_prompt_add_type", r315);     // Catch: JSONException -> L153
    L216:
        if (com.larus.utils.o0.d(r316) == false) goto L219;
        r119.put("bio_add_type", r316);     // Catch: JSONException -> L153
    L219:
        if (com.larus.utils.o0.d(r317) == false) goto L221;
        r119.put("onboarding_add_type", r317);     // Catch: JSONException -> L153
    L221:
        if (r217 != null) goto L223;
    L227:
        if (r109 != 0) goto L229;
    L233:
        if (r218 == null) goto L235;
        r119.put("polish_cnt", String.valueOf(r218.intValue()));     // Catch: JSONException -> L153
    L235:
        String r125 = r318;
        if (r125 == null) goto L238;
        r119.put("polish_status", r125);     // Catch: JSONException -> L153
    L238:
        String r126 = r319;
        if (r126 == null) goto L241;
        r119.put("private_status", r126);     // Catch: JSONException -> L153
    L241:
        if (r219 == null) goto L249;
        boolean r127 = r219.booleanValue();     // Catch: JSONException -> L153
        if (Intrinsics.areEqual(r125, "1") == false) goto L249;
        if (r127 == false) goto L247;
        Object r128 = "1";
    L248:
        r119.put("if_polish_use_internet", r128);     // Catch: JSONException -> L153
        goto L249
    L247:
        r128 = "0";
    L249:
        if (r320 == null) goto L256;
        boolean r129 = r320.booleanValue();     // Catch: JSONException -> L153
        if (Intrinsics.areEqual(r104, "1") == false) goto L256;
        if (r129 == false) goto L255;
        r120 = "1";
    L255:
        r119.put("if_auto_fill_use_internet", r120);     // Catch: JSONException -> L153
    L256:
        r119.putOpt("name_add_type", r213).putOpt("sp_add_type", r214).putOpt("profile_photo_add_type", r215).putOpt("voice_add_type", r216);     // Catch: JSONException -> L153
    L259:
        TrackParams r130 = new TrackParams().merge(r119);
        by7.a r131 = new by7.a("complete_create_new_bot");
        by7.e r132 = r321;
        if (r132 == null) goto L262;
        r131.f21464b = r132;
    L262:
        r131.f21463a.merge(r130);
        r131.b();
        return;
    L153:
        e = move-exception;
        FLogger.f375446a.e("CompleteEventHelper", "error in CompleteEventHelper completeCreateNewBot " + e.getLocalizedMessage());
        goto L259
    L229:
        if (r109.booleanValue() == false) goto L231;
        Object r133 = "1";
    L232:
        r119.put("if_polish", r133);     // Catch: JSONException -> L153
        goto L233
    L231:
        r133 = "0";
        goto L232
    L223:
        if (r217.booleanValue() == false) goto L225;
        Object r134 = "1";
    L226:
        r119.put("if_has_bio", r134);     // Catch: JSONException -> L153
        goto L227
    L225:
        r134 = "0";
        goto L226
    L202:
        if (r118.booleanValue() == false) goto L204;
        Object r135 = "1";
    L205:
        r119.put("background_status", r135);     // Catch: JSONException -> L153
        goto L206
    L204:
        r135 = "0";
        goto L205
    L168:
        if (r116.booleanValue() == false) goto L170;
        Object r136 = "1";
    L171:
        r119.put("sp_status", r136);     // Catch: JSONException -> L153
        goto L172
    L170:
        r136 = "0";
        goto L171
    L160:
        if (r114.booleanValue() == false) goto L162;
        Object r137 = "1";
    L163:
        r119.put("if_has_onboarding", r137);     // Catch: JSONException -> L153
        goto L164
    L162:
        r137 = "0";
        goto L163
    L264:
        r119.put("create_way", r112);     // Catch: JSONException -> L153
        goto L155
    L149:
        r321 = r710;
        goto L150
    L145:
        r119 = null;
        goto L147
    L141:
        r320 = r619;
        goto L143
    L137:
        r219 = r618;
        goto L139
    L133:
        r319 = r617;
        goto L135
    L129:
        r318 = r616;
        goto L131
    L125:
        r218 = r615;
        goto L127
    L121:
        r109 = r614;
        goto L123
    L117:
        r217 = r613;
        goto L119
    L113:
        r317 = r612;
        goto L115
    L109:
        r316 = r611;
        goto L111
    L105:
        r315 = r610;
        goto L107
    L101:
        r216 = r519;
        goto L103
    L97:
        r215 = r518;
        goto L99
    L93:
        r214 = r517;
        goto L95
    L89:
        r213 = r516;
        goto L91
    L85:
        r212 = r515;
        goto L87
    L81:
        r211 = r514;
        goto L83
    L77:
        r118 = r513;
        goto L79
    L73:
        r210 = r512;
        goto L75
    L69:
        r117 = r511;
        goto L71
    L65:
        r108 = r510;
        goto L67
    L61:
        r116 = r419;
        goto L63
    L57:
        r115 = r418;
        goto L59
    L53:
        r114 = r417;
        goto L55
    L49:
        r113 = r416;
        goto L51
    L45:
        r112 = r415;
        goto L47
    L41:
        r111 = r414;
        goto L43
    L37:
        r110 = r413;
        goto L39
    L33:
        r107 = r412;
        goto L35
    L29:
        r106 = r411;
        goto L31
    L25:
        r105 = r410;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
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
