package tx9;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.livetutor.impl.home.viewmodel.LiveTutorHomeVM;
import com.larus.utils.logger.FLogger;
import com.obric.trace.ObricActionBarTrackType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class y3 {
    public static void b(String r100, String r101, Integer r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r100 != null) goto L14;
    L7:
        r103.put("error_message", r101);     // Catch: JSONException -> L5
        r103.put("message_type", "multi_file");     // Catch: JSONException -> L5
        if (r102 == null) goto L12;
        r103.put("file_cnt", r102.intValue());     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("UploadEventHelper", "error in UploadEventHelper uploadMultiAttachmentWholeProblem " + e.getLocalizedMessage());
    L12:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("upload_multi_attachment_whole_problem");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L14:
        r103.put("bot_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void a(String r310, String r410, String r411, String r412, String r413, String r414, String r415, String r416, Integer r417, String r418, String r419, String r510, String r511, String r512, String r513, String r514, String r515, String r516, String r517, String r518, String r519, String r610, String r611, Integer r612, String r613, String r614, String r615, String r616, String r617, Long r618, String r619, String r710, String r711, String r712, Integer r713, String r714, Integer r715, String r716, String r717, String r718, String r719, String r810, String r811, String r812, String r813, int r814, int r815) {
        if ((r814 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r814 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r814 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r814 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r814 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r814 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r814 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r814 & 128) == 0) goto L33;
        String r110 = null;
    L35:
        if ((r814 & 256) == 0) goto L37;
        Integer r111 = null;
    L39:
        if ((r814 & 512) == 0) goto L41;
        JSONObject r112 = new JSONObject();
    L43:
        if ((r814 & 2048) == 0) goto L45;
        String r113 = null;
    L47:
        if ((r814 & 4096) == 0) goto L49;
        String r114 = null;
    L51:
        if ((r814 & 8192) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r814 & 16384) == 0) goto L57;
        String r107 = null;
    L59:
        if ((r814 & 32768) == 0) goto L61;
        String r116 = null;
    L63:
        if ((r814 & 65536) == 0) goto L65;
        String r108 = null;
    L67:
        if ((r814 & 131072) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r814 & 262144) == 0) goto L73;
        String r118 = null;
    L74:
        String r311 = r102;
        if ((r814 & 524288) == 0) goto L77;
        String r109 = null;
    L79:
        if ((r814 & 1048576) == 0) goto L81;
        String r210 = null;
    L83:
        if ((r814 & 2097152) == 0) goto L85;
        String r211 = null;
    L87:
        if ((r814 & 4194304) == 0) goto L89;
        String r212 = "-1";
    L91:
        if ((r814 & 8388608) == 0) goto L93;
        String r213 = "0";
    L95:
        if ((r814 & 16777216) == 0) goto L97;
        String r214 = "0";
    L99:
        if ((r814 & 33554432) == 0) goto L101;
        Integer r215 = null;
    L103:
        if ((r814 & 67108864) == 0) goto L105;
        String r216 = null;
    L107:
        if ((r814 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L109;
        String r217 = null;
    L111:
        if ((r814 & 268435456) == 0) goto L113;
        String r312 = null;
    L115:
        if ((r814 & 536870912) == 0) goto L117;
        String r313 = null;
    L119:
        if ((r814 & Integer.MIN_VALUE) == 0) goto L121;
        String r119 = null;
    L122:
        String r420 = r109;
        if ((r815 & 1) == 0) goto L125;
        Long r120 = null;
    L127:
        if ((r815 & 2) == 0) goto L129;
        String r314 = null;
    L131:
        if ((r815 & 4) == 0) goto L133;
        String r315 = null;
    L135:
        if ((r815 & 8) == 0) goto L137;
        String r316 = null;
    L139:
        if ((r815 & 16) == 0) goto L141;
        String r317 = null;
    L143:
        if ((r815 & 32) == 0) goto L145;
        Integer r218 = null;
    L147:
        if ((r815 & 64) == 0) goto L149;
        String r318 = null;
    L150:
        String r421 = r118;
        if ((r815 & 128) == 0) goto L153;
        Integer r121 = null;
    L154:
        Integer r422 = r121;
        if ((r815 & 256) == 0) goto L157;
        String r122 = null;
    L158:
        String r423 = r122;
        if ((r815 & 512) == 0) goto L161;
        String r123 = null;
    L162:
        String r424 = r114;
        if ((r815 & 1024) == 0) goto L165;
        String r124 = null;
    L166:
        String r425 = r113;
        if ((r815 & 2048) == 0) goto L169;
        String r125 = null;
    L170:
        Integer r426 = r111;
        if ((r815 & 4096) == 0) goto L173;
        String r126 = null;
    L174:
        String r427 = r126;
        if ((r815 & 8192) == 0) goto L177;
        String r127 = null;
    L178:
        String r319 = r110;
        if ((r815 & 16384) == 0) goto L181;
        String r128 = null;
    L183:
        if ((r815 & 32768) == 0) goto L185;
        String r129 = null;
    L186:
        String r320 = r105;
        Intrinsics.checkNotNullParameter(r112, "params");
        r112.putOpt("spring_guide_card_id", r123);     // Catch: JSONException -> L349
        r112.putOpt("action_bar_key", r108);     // Catch: JSONException -> L349
        r112.putOpt("duration", r120);     // Catch: JSONException -> L349
        r112.putOpt("upload_from", r124);     // Catch: JSONException -> L349
        r112.putOpt("upload_way", r125);     // Catch: JSONException -> L349
        r112.putOpt("upload_file_size", r127);     // Catch: JSONException -> L349
        if (r119 != null) goto L191;
        r119 = "";
    L191:
        r112.putOpt(MusicAppletPage.KEY_MESSAGE_ID, r119);     // Catch: JSONException -> L349
        boolean r130 = true;
        if (r128 != null) goto L194;
    L196:
        r128 = null;
    L197:
        r112.putOpt("display_type", r128);     // Catch: JSONException -> L349
        if (r129 != null) goto L200;
    L202:
        r129 = null;
    L203:
        r112.putOpt("agent_type", r129);     // Catch: JSONException -> L349
        r112.putOpt("cited_message_id", "");     // Catch: JSONException -> L349
        if (r100 == null) goto L206;
        r112.put("bot_id", r100);     // Catch: JSONException -> L349
    L206:
        if (r101 == null) goto L208;
        r112.put("current_page", r101);     // Catch: JSONException -> L349
    L208:
        if (r103 == null) goto L210;
        r112.put("error_message", r103);     // Catch: JSONException -> L349
    L210:
        if (r104 == null) goto L213;
        r112.put("message_type", r104);     // Catch: JSONException -> L349
    L213:
        if (r320 != null) goto L215;
        String r131 = "";
    L216:
        r112.putOpt("message_type_detail", r131);     // Catch: JSONException -> L349
        if (r106 == 0) goto L219;
        r112.put("success", r106);     // Catch: JSONException -> L349
    L219:
        if (r319 == null) goto L221;
        r112.put("uri", r319);     // Catch: JSONException -> L349
    L221:
        if (r426 == null) goto L224;
        r112.put("is_multi_file", r426.intValue());     // Catch: JSONException -> L349
    L224:
        if (r425 != null) goto L226;
    L229:
        boolean r132 = true;
    L230:
        if (r132 == true) goto L232;
        r112.put("click_from", r425);     // Catch: JSONException -> L349
    L232:
        if (r424 != null) goto L234;
    L237:
        boolean r133 = true;
    L238:
        if (r133 == true) goto L240;
        r112.put("action_bar_template_name", r424);     // Catch: JSONException -> L349
    L240:
        if (r421 != null) goto L242;
    L245:
        boolean r134 = true;
    L246:
        if (r134 == true) goto L248;
        r112.put("is_multi_choose_mode", r421);     // Catch: JSONException -> L349
    L248:
        if (r420 != null) goto L250;
    L253:
        boolean r135 = true;
    L254:
        if (r135 == true) goto L256;
        r112.put("chat_type", r420);     // Catch: JSONException -> L349
    L256:
        String r136 = r210;
        if (r136 != null) goto L259;
    L262:
        boolean r137 = true;
    L263:
        if (r137 == true) goto L265;
        r112.put("previous_page", r136);     // Catch: JSONException -> L349
    L265:
        String r138 = r211;
        if (r138 != null) goto L268;
    L271:
        boolean r139 = true;
    L272:
        if (r139 == true) goto L274;
        r112.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE, r138);     // Catch: JSONException -> L349
    L274:
        String r140 = r212;
        if (r140 != null) goto L277;
    L280:
        boolean r141 = true;
    L281:
        if (r141 == true) goto L283;
        r112.put("if_edu_intention", r140);     // Catch: JSONException -> L349
    L283:
        String r142 = r213;
        if (r142 != null) goto L286;
    L289:
        boolean r143 = true;
    L290:
        if (r143 == true) goto L292;
        r112.put("is_crop", r142);     // Catch: JSONException -> L349
    L292:
        String r144 = r214;
        if (r144 != null) goto L295;
    L298:
        boolean r145 = true;
    L299:
        if (r145 == true) goto L301;
        r112.put("is_mark", r144);     // Catch: JSONException -> L349
    L301:
        if (r215 == null) goto L303;
        r112.put("is_ai_doc", r215.intValue());     // Catch: JSONException -> L349
    L303:
        String r146 = r216;
        if (r146 == null) goto L310;
        if (r146.length() == 0) goto L310;
        r130 = false;
    L310:
        if (r130 == false) goto L312;
        r112.put("cited_from_user_type", "no_cite");     // Catch: JSONException -> L349
    L313:
        String r147 = r217;
        if (r147 == null) goto L316;
        r112.put("cited_message_id", r147);     // Catch: JSONException -> L349
    L316:
        if (r311 == null) goto L318;
        r112.put("template_page_type", r311);     // Catch: JSONException -> L349
    L318:
        String r148 = r312;
        if (r148 == null) goto L321;
        r112.put("from_template_id", r148);     // Catch: JSONException -> L349
    L321:
        String r149 = r313;
        if (r149 == null) goto L324;
        r112.put("from_template_sub_type", r149);     // Catch: JSONException -> L349
    L324:
        String r150 = r314;
        if (r150 == null) goto L327;
        r112.put("template_rec_req_id", r150);     // Catch: JSONException -> L349
    L327:
        String r151 = r315;
        if (r151 == null) goto L330;
        r112.put("canvas_type", r151);     // Catch: JSONException -> L349
    L330:
        String r152 = r316;
        if (r152 == null) goto L333;
        r112.put("presentation_id", r152);     // Catch: JSONException -> L349
    L333:
        String r153 = r317;
        if (r153 == null) goto L336;
        r112.put("resource_id", r153);     // Catch: JSONException -> L349
    L336:
        if (r218 == null) goto L338;
        r112.put("resource_type", r218.intValue());     // Catch: JSONException -> L349
    L338:
        String r154 = r318;
        if (r154 == null) goto L341;
        r112.put("artifact_meta_id", r154);     // Catch: JSONException -> L349
    L341:
        if (r422 == null) goto L343;
        r112.put("artifact_type", r422.intValue());     // Catch: JSONException -> L349
    L343:
        if (r423 == null) goto L345;
        r112.put("aippt_task_id", r423);     // Catch: JSONException -> L349
    L345:
        if (r427 == null) goto L347;
        r112.put("clarify_id", r427);     // Catch: JSONException -> L349
    L347:
        r112.putOpt("enter_method", r117);     // Catch: JSONException -> L349
        r112.putOpt(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r115);     // Catch: JSONException -> L349
        r112.putOpt("action_bar_template_type", r107);     // Catch: JSONException -> L349
        r112.putOpt(LiveTutorHomeVM.ACTION_BAR_ITEM_ID, r116);     // Catch: JSONException -> L349
    L351:
        TrackParams r155 = new TrackParams().merge(r112);
        by7.a r156 = new by7.a("upload_attachment_status");
        r156.f21463a.merge(r155);
        r156.b();
        return;
    L312:
        r112.put("cited_from_user_type", r146);     // Catch: JSONException -> L349
        goto L313
    L295:
        if (r144.length() == 0) goto L298;
        r145 = false;
        goto L299
    L286:
        if (r142.length() == 0) goto L289;
        r143 = false;
        goto L290
    L277:
        if (r140.length() == 0) goto L280;
        r141 = false;
        goto L281
    L268:
        if (r138.length() == 0) goto L271;
        r139 = false;
        goto L272
    L259:
        if (r136.length() == 0) goto L262;
        r137 = false;
        goto L263
    L250:
        if (r420.length() == 0) goto L253;
        r135 = false;
        goto L254
    L242:
        if (r421.length() == 0) goto L245;
        r134 = false;
        goto L246
    L234:
        if (r424.length() == 0) goto L237;
        r133 = false;
        goto L238
    L226:
        if (r425.length() == 0) goto L229;
        r132 = false;
        goto L230
    L215:
        r131 = r320;
        goto L216
    L200:
        if ((!StringsKt.isBlank(r129)) == false) goto L202;
    L194:
        if ((!StringsKt.isBlank(r128)) == false) goto L196;
    L349:
        e = move-exception;
        FLogger.f375446a.e("UploadEventHelper", "error in UploadEventHelper uploadAttachmentStatus " + e.getLocalizedMessage());
        goto L351
    L185:
        r129 = r813;
        goto L186
    L181:
        r128 = r812;
        goto L183
    L177:
        r127 = r811;
        goto L178
    L173:
        r126 = r810;
        goto L174
    L169:
        r125 = r719;
        goto L170
    L165:
        r124 = r718;
        goto L166
    L161:
        r123 = r717;
        goto L162
    L157:
        r122 = r716;
        goto L158
    L153:
        r121 = r715;
        goto L154
    L149:
        r318 = r714;
        goto L150
    L145:
        r218 = r713;
        goto L147
    L141:
        r317 = r712;
        goto L143
    L137:
        r316 = r711;
        goto L139
    L133:
        r315 = r710;
        goto L135
    L129:
        r314 = r619;
        goto L131
    L125:
        r120 = r618;
        goto L127
    L121:
        r119 = r617;
        goto L122
    L117:
        r313 = r616;
        goto L119
    L113:
        r312 = r615;
        goto L115
    L109:
        r217 = r614;
        goto L111
    L105:
        r216 = r613;
        goto L107
    L101:
        r215 = r612;
        goto L103
    L97:
        r214 = r611;
        goto L99
    L93:
        r213 = r610;
        goto L95
    L89:
        r212 = r519;
        goto L91
    L85:
        r211 = r518;
        goto L87
    L81:
        r210 = r517;
        goto L83
    L77:
        r109 = r516;
        goto L79
    L73:
        r118 = r515;
        goto L74
    L69:
        r117 = r514;
        goto L71
    L65:
        r108 = r513;
        goto L67
    L61:
        r116 = r512;
        goto L63
    L57:
        r107 = r511;
        goto L59
    L53:
        r115 = r510;
        goto L55
    L49:
        r114 = r419;
        goto L51
    L45:
        r113 = r418;
        goto L47
    L41:
        r112 = null;
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
