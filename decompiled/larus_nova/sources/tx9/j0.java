package tx9;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class j0 {
    public static void a(String r310, String r410, String r411, String r412, String r413, String r414, String r415, String r416, String r417, Long r418, String r419, String r510, String r511, Boolean r512, String r513, Boolean r514, String r515, String r516, String r517, Boolean r518, String r519, String r610, String r611, String r612, String r613, String r614, String r615, String r616, String r617, String r618, String r619, String r710, String r711, String r712, String r713, String r714, Map r715, String r716, String r717, String r718, JSONObject r719, by7.e r810, Function0 r811, int r812, int r813) {
        if ((r812 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r812 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r812 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r812 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r812 & 64) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r812 & 128) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r812 & 256) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r812 & 4096) == 0) goto L33;
        String r110 = null;
    L35:
        if ((r812 & 524288) == 0) goto L37;
        String r111 = null;
    L39:
        if ((r812 & 1048576) == 0) goto L41;
        Long r112 = null;
    L43:
        if ((r812 & 2097152) == 0) goto L45;
        String r107 = null;
    L47:
        if ((r812 & 4194304) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r812 & 8388608) == 0) goto L53;
        String r210 = null;
    L55:
        if ((r812 & 16777216) == 0) goto L57;
        Boolean r114 = null;
    L59:
        if ((r812 & 33554432) == 0) goto L61;
        String r211 = null;
    L63:
        if ((r812 & 67108864) == 0) goto L65;
        Boolean r212 = null;
    L67:
        if ((r812 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L69;
        String r213 = null;
    L71:
        if ((r812 & 268435456) == 0) goto L73;
        String r214 = null;
    L75:
        if ((r812 & 536870912) == 0) goto L77;
        String r215 = null;
    L79:
        if ((r812 & 1073741824) == 0) goto L81;
        Boolean r216 = null;
    L83:
        if ((r812 & Integer.MIN_VALUE) == 0) goto L85;
        String r108 = null;
    L87:
        if ((r813 & 1) == 0) goto L89;
        String r217 = null;
    L91:
        if ((r813 & 2) == 0) goto L93;
        String r218 = null;
    L95:
        if ((r813 & 4) == 0) goto L97;
        String r311 = null;
    L99:
        if ((r813 & 8) == 0) goto L101;
        String r312 = null;
    L103:
        if ((r813 & 16) == 0) goto L105;
        String r313 = null;
    L107:
        if ((r813 & 32) == 0) goto L109;
        String r314 = null;
    L111:
        if ((r813 & 64) == 0) goto L113;
        String r315 = null;
    L115:
        if ((r813 & 128) == 0) goto L117;
        String r115 = null;
    L119:
        if ((r813 & 256) == 0) goto L121;
        String r116 = null;
    L123:
        if ((r813 & 512) == 0) goto L125;
        String r117 = null;
    L126:
        String r420 = r117;
        if ((r813 & 1024) == 0) goto L129;
        String r118 = null;
    L130:
        String r421 = r118;
        if ((r813 & 2048) == 0) goto L133;
        String r119 = null;
    L134:
        String r422 = r119;
        if ((r813 & 4096) == 0) goto L137;
        String r120 = null;
    L138:
        String r423 = r120;
        if ((r813 & 8192) == 0) goto L141;
        String r121 = null;
    L142:
        String r424 = r121;
        if ((r813 & 16384) == 0) goto L145;
        String r122 = null;
    L147:
        if ((r813 & 65536) == 0) goto L149;
        Map r219 = null;
    L151:
        if ((r813 & 131072) == 0) goto L153;
        String r425 = null;
    L155:
        if ((r813 & 262144) == 0) goto L157;
        String r316 = null;
    L159:
        if ((r813 & 524288) == 0) goto L161;
        String r317 = null;
    L163:
        if ((r813 & 1048576) == 0) goto L165;
        JSONObject r123 = new JSONObject();
        int r318 = 2097152;
    L167:
        if ((r813 & r318) == 0) goto L169;
        by7.e r319 = null;
    L171:
        if ((r813 & 4194304) == 0) goto L173;
        Function0 r320 = null;
    L174:
        Intrinsics.checkNotNullParameter(r123, "params");
        if (r219 != null) goto L315;
    L182:
        String r426 = r116;
        if (r100 == null) goto L185;
        r123.put("bot_id", r100);     // Catch: JSONException -> L180
    L185:
        if (r101 == null) goto L187;
        r123.put("chat_type", r101);     // Catch: JSONException -> L180
    L187:
        if (r102 == null) goto L189;
        r123.put("click_from", r102);     // Catch: JSONException -> L180
    L189:
        if (r103 == null) goto L192;
        r123.put("current_page", r103);     // Catch: JSONException -> L180
    L192:
        if (r316 != null) goto L194;
    L197:
        boolean r109 = true;
    L199:
        if ((true ^ r109) == true) goto L202;
        r316 = null;
    L202:
        String r124 = "0";
        if (r316 != null) goto L205;
        Object r125 = "0";
    L206:
        r123.put("is_general_agent", r125);     // Catch: JSONException -> L180
        if (r317 != null) goto L209;
        r317 = "";
    L209:
        r123.put("chat_id", r317);     // Catch: JSONException -> L180
        if (r104 == null) goto L212;
        r123.put("is_immersive_background", r104);     // Catch: JSONException -> L180
    L212:
        if (r105 == null) goto L214;
        r123.put(MusicAppletPage.KEY_MESSAGE_ID, r105);     // Catch: JSONException -> L180
    L214:
        if (r106 == null) goto L216;
        r123.put("previous_page", r106);     // Catch: JSONException -> L180
    L216:
        if (r110 == null) goto L218;
        r123.put("recommend_from", r110);     // Catch: JSONException -> L180
    L218:
        if (r111 == null) goto L220;
        r123.put("message_is_interrupted", r111);     // Catch: JSONException -> L180
    L220:
        String r126 = r113;
        if (r126 == null) goto L223;
        r123.put("conversation_id", r126);     // Catch: JSONException -> L180
    L223:
        String r127 = r210;
        if (r127 == null) goto L226;
        r123.put("section_id", r127);     // Catch: JSONException -> L180
    L226:
        if (r112 == null) goto L228;
        r123.put("with_code", r112.longValue());     // Catch: JSONException -> L180
    L228:
        if (r107 == null) goto L230;
        r123.put("code_type", r107);     // Catch: JSONException -> L180
    L230:
        String r128 = r211;
        if (r128 == null) goto L234;
        r123.put("is_call_bot", r128);     // Catch: JSONException -> L180
    L234:
        if (r114 != null) goto L236;
    L240:
        if (r212 == null) goto L242;
        r123.put("is_multiple", r212.booleanValue() ? 1 : 0);     // Catch: JSONException -> L180
    L242:
        String r129 = r213;
        if (r129 == null) goto L245;
        r123.put("user_type", r129);     // Catch: JSONException -> L180
    L245:
        String r130 = r214;
        if (r130 == null) goto L248;
        r123.put("message_type", r130);     // Catch: JSONException -> L180
    L248:
        String r131 = r215;
        if (r131 == null) goto L251;
        r123.put("click_module", r131);     // Catch: JSONException -> L180
    L251:
        if (r216 != null) goto L253;
    L256:
        if (r108 == null) goto L258;
        r123.put("deep_research_id", r108);     // Catch: JSONException -> L180
    L258:
        String r132 = r217;
        if (r132 == null) goto L261;
        r123.put("user_case_item_id", r132);     // Catch: JSONException -> L180
    L261:
        String r133 = r218;
        if (r133 == null) goto L264;
        r123.put("user_case_reco_request_id", r133);     // Catch: JSONException -> L180
    L264:
        String r134 = r311;
        if (r134 == null) goto L267;
        r123.put("select_range", r134);     // Catch: JSONException -> L180
    L267:
        String r135 = r312;
        if (r135 == null) goto L270;
        r123.put("corresponding_reply_status", r135);     // Catch: JSONException -> L180
    L270:
        String r136 = r313;
        if (r136 == null) goto L273;
        r123.put("reply_status", r136);     // Catch: JSONException -> L180
    L273:
        String r137 = r314;
        if (r137 == null) goto L276;
        r123.put("aippt_task_id", r137);     // Catch: JSONException -> L180
    L276:
        String r138 = r315;
        if (r138 == null) goto L279;
        r123.put("presentation_id", r138);     // Catch: JSONException -> L180
    L279:
        if (r115 == null) goto L281;
        r123.put("resource_id", r115);     // Catch: JSONException -> L180
    L281:
        if (r426 == null) goto L283;
        r123.put("resource_type", r426);     // Catch: JSONException -> L180
    L283:
        if (r420 == null) goto L285;
        r123.put("artifact_meta_id", r420);     // Catch: JSONException -> L180
    L285:
        if (r421 == null) goto L287;
        r123.put("artifact_type", r421);     // Catch: JSONException -> L180
    L287:
        if (r422 == null) goto L289;
        r123.put("base_id", r422);     // Catch: JSONException -> L180
    L289:
        if (r423 == null) goto L291;
        r123.put("canvas_type", r423);     // Catch: JSONException -> L180
    L291:
        if (r424 == null) goto L293;
        r123.put("content_type", r424);     // Catch: JSONException -> L180
    L293:
        if (r122 == 0) goto L296;
        r123.put("call_id", r122);     // Catch: JSONException -> L180
    L296:
        if (com.larus.utils.o0.d(null) == false) goto L299;
        r123.put("artifact_create_method", null);     // Catch: JSONException -> L180
    L299:
        if (com.larus.utils.o0.d(r425) == false) goto L301;
        r123.put("spreadsheet_id", r425);     // Catch: JSONException -> L180
    L301:
        if (r320 == null) goto L310;
        Map r139 = (Map) r320.invoke();     // Catch: JSONException -> L180
        if (r139 == null) goto L310;
        Iterator r140 = r139.entrySet().iterator();     // Catch: JSONException -> L180
    L305:
        if (r140.hasNext() == false) goto L310;
        Map.Entry r141 = (Map.Entry) r140.next();     // Catch: JSONException -> L180
        r123.put((String) r141.getKey(), r141.getValue());     // Catch: JSONException -> L180
    L180:
        e = move-exception;
        FLogger.f375446a.e("CopyEventHelper", "error in CopyEventHelper copy " + e.getLocalizedMessage());
    L310:
        TrackParams r142 = new TrackParams().merge(r123);
        by7.a r143 = new by7.a("copy");
        by7.e r144 = r319;
        if (r144 == null) goto L313;
        r143.f21464b = r144;
    L313:
        r143.f21463a.merge(r142);
        r143.b();
        return;
    L253:
        if (r216.booleanValue() == false) goto L255;
        r124 = "1";
    L255:
        r123.put("is_thinking_generating", r124);     // Catch: JSONException -> L180
        goto L256
    L236:
        if (r114.booleanValue() == false) goto L238;
        Object r145 = "1";
    L239:
        r123.put("is_message_generating", r145);     // Catch: JSONException -> L180
        goto L240
    L238:
        r145 = "0";
        goto L239
    L205:
        r125 = r316;
        goto L206
    L194:
        if (r316.length() == 0) goto L197;
        r109 = false;
        goto L199
    L315:
        Iterator r146 = r219.entrySet().iterator();     // Catch: JSONException -> L180
    L178:
        if (r146.hasNext() == false) goto L182;
        Map.Entry r147 = (Map.Entry) r146.next();     // Catch: JSONException -> L180
        r123.put((String) r147.getKey(), r147.getValue());     // Catch: JSONException -> L180
        r146 = r146;
        r116 = r116;
        goto L178
    L173:
        r320 = r811;
        goto L174
    L169:
        r319 = r810;
        goto L171
    L165:
        r318 = 2097152;
        r123 = r719;
        goto L167
    L161:
        r317 = r718;
        goto L163
    L157:
        r316 = r717;
        goto L159
    L153:
        r425 = r716;
        goto L155
    L149:
        r219 = r715;
        goto L151
    L145:
        r122 = r714;
        goto L147
    L141:
        r121 = r713;
        goto L142
    L137:
        r120 = r712;
        goto L138
    L133:
        r119 = r711;
        goto L134
    L129:
        r118 = r710;
        goto L130
    L125:
        r117 = r619;
        goto L126
    L121:
        r116 = r618;
        goto L123
    L117:
        r115 = r617;
        goto L119
    L113:
        r315 = r616;
        goto L115
    L109:
        r314 = r615;
        goto L111
    L105:
        r313 = r614;
        goto L107
    L101:
        r312 = r613;
        goto L103
    L97:
        r311 = r612;
        goto L99
    L93:
        r218 = r611;
        goto L95
    L89:
        r217 = r610;
        goto L91
    L85:
        r108 = r519;
        goto L87
    L81:
        r216 = r518;
        goto L83
    L77:
        r215 = r517;
        goto L79
    L73:
        r214 = r516;
        goto L75
    L69:
        r213 = r515;
        goto L71
    L65:
        r212 = r514;
        goto L67
    L61:
        r211 = r513;
        goto L63
    L57:
        r114 = r512;
        goto L59
    L53:
        r210 = r511;
        goto L55
    L49:
        r113 = r510;
        goto L51
    L45:
        r107 = r419;
        goto L47
    L41:
        r112 = r418;
        goto L43
    L37:
        r111 = r417;
        goto L39
    L33:
        r110 = r416;
        goto L35
    L29:
        r106 = r415;
        goto L31
    L25:
        r105 = r414;
        goto L27
    L21:
        r104 = r413;
        goto L23
    L17:
        r103 = r412;
        goto L19
    L13:
        r102 = r411;
        goto L15
    L9:
        r101 = r410;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
