package tx9;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.livetutor.impl.home.viewmodel.LiveTutorHomeVM;
import com.larus.utils.logger.FLogger;
import com.obric.trace.ObricActionBarTrackType;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class d3 {
    public static /* synthetic */ void b(String r127, Integer r128, Long r129, String r130, String r131, String r132, Long r133, String r134, Long r135, Long r136, Long r137, Integer r138, Long r139, String r140, String r141, String r142, String r143, String r144, String r145, Long r146, Long r147, Long r148, Long r149, String r150, String r151, Long r152, String r153, String r154, String r155, String r156, Integer r157, JSONObject r158, by7.e r159, String r160, String r161, String r162, Integer r163, String r164, String r165, String r166, String r167, Integer r168, String r169, Integer r170, String r171, String r172, String r173, String r174, String r175, String r176, String r177, String r178, String r179, String r180, String r181, String r182, String r183, String r184, String r185, String r186, Long r187, String r188, Long r189, String r190, String r191, String r192, Integer r193, String r194, String r195, String r196, String r197, Integer r198, Integer r199, String r200, String r201, String r202, String r203, String r204, Integer r205, Integer r206, boolean r207, String r208, String r209, String r210, boolean r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, Map r220, String r221, String r222, String r223, Boolean r224, String r225, String r226, int r227, int r228, int r229, int r230) {
        if ((r227 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r227 & 4) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r227 & 8) == 0) goto L13;
        Long r102 = null;
    L15:
        if ((r227 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r227 & 32) == 0) goto L21;
        String r110 = null;
    L23:
        if ((r227 & 64) == 0) goto L25;
        String r111 = null;
    L27:
        if ((r227 & 128) == 0) goto L29;
        Long r112 = null;
    L31:
        if ((r227 & 256) == 0) goto L33;
        String r113 = null;
    L35:
        if ((r227 & 1024) == 0) goto L37;
        Long r114 = null;
    L39:
        if ((r227 & 8192) == 0) goto L41;
        Long r115 = null;
    L43:
        if ((r227 & 32768) == 0) goto L45;
        Long r231 = null;
    L47:
        if ((r227 & 65536) == 0) goto L49;
        Integer r232 = null;
    L51:
        if ((r227 & 131072) == 0) goto L53;
        Long r233 = null;
    L55:
        if ((r227 & 262144) == 0) goto L57;
        String r234 = null;
    L59:
        if ((r227 & 524288) == 0) goto L61;
        String r235 = null;
    L63:
        if ((r227 & 1048576) == 0) goto L65;
        String r310 = null;
    L67:
        if ((r227 & 2097152) == 0) goto L69;
        String r311 = null;
    L71:
        if ((r227 & 8388608) == 0) goto L73;
        String r312 = null;
    L75:
        if ((r227 & 16777216) == 0) goto L77;
        String r313 = null;
    L79:
        if ((r227 & 33554432) == 0) goto L81;
        Long r410 = null;
    L83:
        if ((r227 & 67108864) == 0) goto L85;
        Long r411 = null;
    L87:
        if ((r227 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L89;
        Long r412 = null;
    L91:
        if ((r227 & 268435456) == 0) goto L93;
        Long r413 = null;
    L95:
        if ((r227 & 536870912) == 0) goto L97;
        String r414 = null;
    L99:
        if ((r227 & 1073741824) == 0) goto L101;
        String r510 = null;
    L103:
        if ((r227 & Integer.MIN_VALUE) == 0) goto L105;
        Long r511 = null;
    L107:
        if ((r228 & 1) == 0) goto L109;
        String r512 = null;
    L111:
        if ((r228 & 2) == 0) goto L113;
        String r513 = null;
    L115:
        if ((r228 & 4) == 0) goto L117;
        String r514 = null;
    L119:
        if ((r228 & 8) == 0) goto L121;
        String r515 = null;
    L123:
        if ((r228 & 16) == 0) goto L125;
        Integer r516 = null;
    L127:
        if ((r228 & 32) == 0) goto L129;
        JSONObject r517 = new JSONObject();
    L131:
        if ((r228 & 64) == 0) goto L133;
        by7.e r518 = null;
    L135:
        if ((r228 & 128) == 0) goto L137;
        String r610 = null;
    L139:
        if ((r228 & 256) == 0) goto L141;
        String r611 = null;
    L143:
        if ((r228 & 512) == 0) goto L145;
        String r612 = null;
    L147:
        if ((r228 & 1024) == 0) goto L149;
        Integer r613 = null;
    L151:
        if ((r228 & 2048) == 0) goto L153;
        String r614 = null;
    L155:
        if ((r228 & 4096) == 0) goto L157;
        String r615 = null;
    L159:
        if ((r228 & 8192) == 0) goto L161;
        String r616 = null;
    L163:
        if ((r228 & 16384) == 0) goto L165;
        String r617 = null;
    L167:
        if ((r228 & 32768) == 0) goto L169;
        Integer r618 = null;
    L171:
        if ((r228 & 65536) == 0) goto L173;
        String r619 = null;
    L175:
        if ((r228 & 131072) == 0) goto L177;
        Integer r710 = null;
    L179:
        if ((r228 & 262144) == 0) goto L181;
        String r711 = null;
    L183:
        if ((r228 & 524288) == 0) goto L185;
        String r712 = null;
    L187:
        if ((r228 & 1048576) == 0) goto L189;
        String r713 = null;
    L191:
        if ((r228 & 2097152) == 0) goto L193;
        String r714 = "receive_stream";
    L195:
        if ((4194304 & r228) == 0) goto L197;
        String r715 = null;
    L199:
        if ((r228 & 8388608) == 0) goto L201;
        String r716 = null;
    L203:
        if ((r228 & 16777216) == 0) goto L205;
        String r717 = null;
    L207:
        if ((r228 & 33554432) == 0) goto L209;
        String r718 = null;
    L211:
        if ((r228 & 67108864) == 0) goto L213;
        String r719 = null;
    L215:
        if ((r228 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L217;
        String r810 = null;
    L219:
        if ((r228 & 268435456) == 0) goto L221;
        String r811 = null;
    L223:
        if ((r228 & 536870912) == 0) goto L225;
        String r812 = null;
    L227:
        if ((r228 & 1073741824) == 0) goto L229;
        String r813 = null;
    L231:
        if ((r228 & Integer.MIN_VALUE) == 0) goto L233;
        String r814 = null;
    L235:
        if ((r229 & 1) == 0) goto L237;
        String r815 = null;
    L239:
        if ((r229 & 2) == 0) goto L241;
        String r816 = null;
    L243:
        if ((r229 & 4) == 0) goto L245;
        Long r817 = null;
    L247:
        if ((r229 & 8) == 0) goto L249;
        String r818 = null;
    L251:
        if ((r229 & 16) == 0) goto L253;
        Long r819 = null;
    L255:
        if ((r229 & 32) == 0) goto L257;
        String r910 = null;
    L259:
        if ((r229 & 64) == 0) goto L261;
        String r911 = null;
    L263:
        if ((r229 & 128) == 0) goto L265;
        String r912 = null;
    L267:
        if ((r229 & 256) == 0) goto L269;
        Integer r913 = null;
    L271:
        if ((r229 & 512) == 0) goto L273;
        String r914 = null;
    L275:
        if ((r229 & 1024) == 0) goto L277;
        String r915 = null;
    L279:
        if ((r229 & 2048) == 0) goto L281;
        String r916 = null;
    L283:
        if ((r229 & 4096) == 0) goto L285;
        String r917 = null;
    L287:
        if ((r229 & 8192) == 0) goto L289;
        Integer r918 = null;
    L291:
        if ((r229 & 16384) == 0) goto L293;
        Integer r919 = null;
    L295:
        if ((r229 & 32768) == 0) goto L297;
        String r104 = null;
    L299:
        if ((r229 & 65536) == 0) goto L301;
        String r105 = null;
    L303:
        if ((r229 & 131072) == 0) goto L305;
        String r106 = null;
    L307:
        if ((r229 & 262144) == 0) goto L309;
        String r107 = null;
    L311:
        if ((r229 & 524288) == 0) goto L313;
        String r108 = null;
    L315:
        if ((r229 & 1048576) == 0) goto L317;
        Integer r109 = null;
    L319:
        if ((r229 & 2097152) == 0) goto L321;
        Integer r1010 = null;
    L323:
        if ((4194304 & r229) == 0) goto L325;
        boolean r1011 = false;
    L327:
        if ((r229 & 8388608) == 0) goto L329;
        String r1012 = null;
    L331:
        if ((r229 & 16777216) == 0) goto L333;
        String r1013 = null;
    L335:
        if ((r229 & 33554432) == 0) goto L337;
        String r116 = null;
    L339:
        if ((r229 & 67108864) == 0) goto L341;
        boolean r117 = false;
    L343:
        if ((r229 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L345;
        String r118 = null;
    L347:
        if ((r229 & 268435456) == 0) goto L349;
        String r119 = null;
    L351:
        if ((r229 & 536870912) == 0) goto L353;
        String r1110 = null;
    L355:
        if ((r229 & 1073741824) == 0) goto L357;
        String r1111 = null;
    L359:
        if ((r229 & Integer.MIN_VALUE) == 0) goto L361;
        String r1112 = null;
    L363:
        if ((r230 & 1) == 0) goto L365;
        String r1113 = null;
    L367:
        if ((r230 & 2) == 0) goto L369;
        String r1114 = null;
    L371:
        if ((r230 & 4) == 0) goto L373;
        String r1115 = null;
    L375:
        if ((r230 & 8) == 0) goto L377;
        Map r120 = null;
    L379:
        if ((r230 & 16) == 0) goto L381;
        String r121 = null;
    L383:
        if ((r230 & 32) == 0) goto L385;
        String r122 = null;
    L387:
        if ((r230 & 64) == 0) goto L389;
        String r123 = null;
    L391:
        if ((r230 & 128) == 0) goto L393;
        Boolean r124 = null;
    L395:
        if ((r230 & 256) == 0) goto L397;
        String r125 = null;
    L399:
        if ((r230 & 512) == 0) goto L401;
        String r126 = null;
    L402:
        a(null, r100, r101, r102, r103, r110, r111, r112, r113, null, r114, null, null, r115, null, r231, r232, r233, r234, r235, r310, r311, null, r312, r313, r410, r411, r412, r413, r414, r510, r511, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r104, r105, r106, r107, r108, r109, r1010, r1011, r1012, r1013, r116, r117, r118, r119, r1110, r1111, r1112, r1113, r1114, r1115, r120, r121, r122, r123, r124, r125, r126);
        return;
    L401:
        r126 = r226;
        goto L402
    L397:
        r125 = r225;
        goto L399
    L393:
        r124 = r224;
        goto L395
    L389:
        r123 = r223;
        goto L391
    L385:
        r122 = r222;
        goto L387
    L381:
        r121 = r221;
        goto L383
    L377:
        r120 = r220;
        goto L379
    L373:
        r1115 = r219;
        goto L375
    L369:
        r1114 = r218;
        goto L371
    L365:
        r1113 = r217;
        goto L367
    L361:
        r1112 = r216;
        goto L363
    L357:
        r1111 = r215;
        goto L359
    L353:
        r1110 = r214;
        goto L355
    L349:
        r119 = r213;
        goto L351
    L345:
        r118 = r212;
        goto L347
    L341:
        r117 = r211;
        goto L343
    L337:
        r116 = r210;
        goto L339
    L333:
        r1013 = r209;
        goto L335
    L329:
        r1012 = r208;
        goto L331
    L325:
        r1011 = r207;
        goto L327
    L321:
        r1010 = r206;
        goto L323
    L317:
        r109 = r205;
        goto L319
    L313:
        r108 = r204;
        goto L315
    L309:
        r107 = r203;
        goto L311
    L305:
        r106 = r202;
        goto L307
    L301:
        r105 = r201;
        goto L303
    L297:
        r104 = r200;
        goto L299
    L293:
        r919 = r199;
        goto L295
    L289:
        r918 = r198;
        goto L291
    L285:
        r917 = r197;
        goto L287
    L281:
        r916 = r196;
        goto L283
    L277:
        r915 = r195;
        goto L279
    L273:
        r914 = r194;
        goto L275
    L269:
        r913 = r193;
        goto L271
    L265:
        r912 = r192;
        goto L267
    L261:
        r911 = r191;
        goto L263
    L257:
        r910 = r190;
        goto L259
    L253:
        r819 = r189;
        goto L255
    L249:
        r818 = r188;
        goto L251
    L245:
        r817 = r187;
        goto L247
    L241:
        r816 = r186;
        goto L243
    L237:
        r815 = r185;
        goto L239
    L233:
        r814 = r184;
        goto L235
    L229:
        r813 = r183;
        goto L231
    L225:
        r812 = r182;
        goto L227
    L221:
        r811 = r181;
        goto L223
    L217:
        r810 = r180;
        goto L219
    L213:
        r719 = r179;
        goto L215
    L209:
        r718 = r178;
        goto L211
    L205:
        r717 = r177;
        goto L207
    L201:
        r716 = r176;
        goto L203
    L197:
        r715 = r175;
        goto L199
    L193:
        r714 = r174;
        goto L195
    L189:
        r713 = r173;
        goto L191
    L185:
        r712 = r172;
        goto L187
    L181:
        r711 = r171;
        goto L183
    L177:
        r710 = r170;
        goto L179
    L173:
        r619 = r169;
        goto L175
    L169:
        r618 = r168;
        goto L171
    L165:
        r617 = r167;
        goto L167
    L161:
        r616 = r166;
        goto L163
    L157:
        r615 = r165;
        goto L159
    L153:
        r614 = r164;
        goto L155
    L149:
        r613 = r163;
        goto L151
    L145:
        r612 = r162;
        goto L147
    L141:
        r611 = r161;
        goto L143
    L137:
        r610 = r160;
        goto L139
    L133:
        r518 = r159;
        goto L135
    L129:
        r517 = r158;
        goto L131
    L125:
        r516 = r157;
        goto L127
    L121:
        r515 = r156;
        goto L123
    L117:
        r514 = r155;
        goto L119
    L113:
        r513 = r154;
        goto L115
    L109:
        r512 = r153;
        goto L111
    L105:
        r511 = r152;
        goto L107
    L101:
        r510 = r151;
        goto L103
    L97:
        r414 = r150;
        goto L99
    L93:
        r413 = r149;
        goto L95
    L89:
        r412 = r148;
        goto L91
    L85:
        r411 = r147;
        goto L87
    L81:
        r410 = r146;
        goto L83
    L77:
        r313 = r145;
        goto L79
    L73:
        r312 = r144;
        goto L75
    L69:
        r311 = r143;
        goto L71
    L65:
        r310 = r142;
        goto L67
    L61:
        r235 = r141;
        goto L63
    L57:
        r234 = r140;
        goto L59
    L53:
        r233 = r139;
        goto L55
    L49:
        r232 = r138;
        goto L51
    L45:
        r231 = r137;
        goto L47
    L41:
        r115 = r136;
        goto L43
    L37:
        r114 = r135;
        goto L39
    L33:
        r113 = r134;
        goto L35
    L29:
        r112 = r133;
        goto L31
    L25:
        r111 = r132;
        goto L27
    L21:
        r110 = r131;
        goto L23
    L17:
        r103 = r130;
        goto L19
    L13:
        r102 = r129;
        goto L15
    L9:
        r101 = r128;
        goto L11
    L5:
        r100 = r127;
        goto L7
    }

    public static final void a(String r110, String r111, Integer r210, Long r211, String r212, String r213, String r214, Long r215, String r216, String r217, Long r218, String r219, String r310, Long r311, String r312, Long r313, Integer r314, Long r315, String r316, String r317, String r318, String r319, String r410, String r411, String r412, Long r413, Long r414, Long r415, Long r416, String r417, String r418, Long r419, String r510, String r511, String r512, String r513, Integer r514, JSONObject r515, by7.e r516, String r517, String r518, String r519, Integer r610, String r611, String r612, String r613, String r614, Integer r615, String r616, Integer r617, String r618, String r619, String r710, String r711, String r712, String r713, String r714, String r715, String r716, String r717, String r718, String r719, String r810, String r811, String r812, String r813, Long r814, String r815, Long r816, String r817, String r818, String r819, Integer r910, String r911, String r912, String r913, String r914, Integer r915, Integer r916, String r917, String r918, String r919, String r100, String r101, Integer r102, Integer r103, boolean r104, String r105, String r106, String r107, boolean r108, String r109, String r112, String r113, String r114, String r115, String r116, String r117, String r118, Map<String, String> r119, String r1110, String r1111, String r120, Boolean r121, String r122, String r123) {
        Intrinsics.checkNotNullParameter(r515, "params");
        Intrinsics.checkNotNullParameter(r711, "eventName");
        if (r119 == null) goto L13;
        Iterator<Map.Entry<String, String>> r124 = r119.entrySet().iterator();     // Catch: JSONException -> L9
    L6:
        if (r124.hasNext() == false) goto L8;
        Map.Entry<String, String> r125 = r124.next();     // Catch: JSONException -> L9
        r515.put(r125.getKey(), r125.getValue());     // Catch: JSONException -> L9
        r124 = r124;
        goto L6
    L8:
        Unit r126 = Unit.INSTANCE;     // Catch: JSONException -> L9
    L9:
        JSONException e100 = e;
        String r127 = r711;
    L11:
        JSONObject r128 = r515;
    L286:
        FLogger.f375446a.e("ReceiveEventHelper", "error in ReceiveEventHelper receiveStream " + e100.getLocalizedMessage());
    L287:
        TrackParams r129 = new TrackParams().merge(r128);
        by7.a r130 = new by7.a(r127);
        if (r516 == null) goto L290;
        r130.f21464b = r516;
    L290:
        r130.f21463a.merge(r129);
        r130.b();
        com.larus.platform.service.g.f365738a.monitorEventForSlardar(r127, r128, new JSONObject(), null);
        return;
    L13:
        if (r108 == false) goto L15;
        String r131 = "1";
    L16:
        r515.putOpt("is_contain_replica_create_button", r131);     // Catch: JSONException -> L9
        r515.putOpt("ai_creation_tool_list", r818);     // Catch: JSONException -> L9
        if (r810 != null) goto L19;
        String r132 = "";
    L20:
        r515.putOpt("ai_create_show_mode", r132);     // Catch: JSONException -> L9
        r515.putOpt("hit_pocket_lottery_raf", r109);     // Catch: JSONException -> L9
        r515.putOpt("is_lottery", r112);     // Catch: JSONException -> L9
        if (r110 == null) goto L23;
        r515.put("back_page", r110);     // Catch: JSONException -> L9
    L23:
        if (r111 == null) goto L25;
        r515.put("bot_id", r111);     // Catch: JSONException -> L9
    L25:
        if (r210 == null) goto L27;
        r515.put("bot_type", r210.intValue());     // Catch: JSONException -> L9
    L27:
        if (r211 == null) goto L29;
        r515.put("content_length", r211.longValue());     // Catch: JSONException -> L9
    L29:
        if (r212 == null) goto L31;
        r515.put("conversation_id", r212);     // Catch: JSONException -> L9
    L31:
        if (r213 == null) goto L33;
        r515.put(NoticeInfo.KEY_REPLY_ID, r213);     // Catch: JSONException -> L9
    L33:
        if (r214 == null) goto L35;
        r515.put("current_page", r214);     // Catch: JSONException -> L9
    L35:
        if (r215 == null) goto L37;
        r515.put("duration", r215.longValue());     // Catch: JSONException -> L9
    L37:
        if (r710 == null) goto L39;
        r515.put("is_contain_ecommerce", r710);     // Catch: JSONException -> L9
    L39:
        if (r216 == null) goto L41;
        r515.put("group_type", r216);     // Catch: JSONException -> L9
    L41:
        if (r217 == null) goto L43;
        r515.put("if_with_bot", r217);     // Catch: JSONException -> L9
    L43:
        if (r218 == null) goto L45;
        r515.put(LocationMonitorConst.IS_CACHE, r218.longValue());     // Catch: JSONException -> L9
    L45:
        if (r219 == null) goto L47;
        r515.put("is_cued", r219);     // Catch: JSONException -> L9
    L47:
        if (r310 == null) goto L49;
        r515.put("is_group_action_bar_cued", r310);     // Catch: JSONException -> L9
    L49:
        if (r311 == null) goto L51;
        r515.put("is_onboarding", r311.longValue());     // Catch: JSONException -> L9
    L51:
        if (r312 == null) goto L53;
        r515.put("is_search_link", r312);     // Catch: JSONException -> L9
    L53:
        if (r313 == null) goto L55;
        r515.put("is_soft_link", r313.longValue());     // Catch: JSONException -> L9
    L55:
        if (r314 == null) goto L57;
        r515.put("is_app_download_link", r314.intValue());     // Catch: JSONException -> L9
    L57:
        if (r315 == null) goto L59;
        r515.put("is_tts_open", r315.longValue());     // Catch: JSONException -> L9
    L59:
        if (r316 == null) goto L61;
        r515.put(MusicAppletPage.KEY_MESSAGE_ID, r316);     // Catch: JSONException -> L9
    L61:
        if (r317 == null) goto L64;
        r515.put("message_type", r317);     // Catch: JSONException -> L9
    L64:
        if (r318 == null) goto L66;
        r515.put("onboarding_content_source", r318);     // Catch: JSONException -> L9
    L66:
        r127 = r711;
        if (r319 == null) goto L72;
        r515.put("previous_page", r319);     // Catch: JSONException -> L69
    L69:
        e100 = e;
    L72:
        if (r410 == null) goto L74;
        r515.put("query", r410);     // Catch: JSONException -> L69
    L74:
        r128 = r515;
        if (r411 == null) goto L80;
        r128.put("result", r411);     // Catch: JSONException -> L77
    L77:
        e100 = e;
    L80:
        if (r412 == null) goto L82;
        r128.put("section_id", r412);     // Catch: JSONException -> L77
    L82:
        if (r413 == null) goto L84;
        r128.put("stream_handle_time", r413.longValue());     // Catch: JSONException -> L77
    L84:
        if (r414 == null) goto L86;
        r128.put("stream_receive_count", r414.longValue());     // Catch: JSONException -> L77
    L86:
        if (r415 == null) goto L88;
        r128.put("stream_receive_interval", r415.longValue());     // Catch: JSONException -> L77
    L88:
        if (r416 == null) goto L91;
        r128.put("success", r416.longValue());     // Catch: JSONException -> L77
    L91:
        if (r417 == null) goto L94;
        r128.put("type", r417);     // Catch: JSONException -> L77
    L94:
        if (r418 == null) goto L96;
        r128.put("use_nickname", r418);     // Catch: JSONException -> L77
    L96:
        if (r419 == null) goto L99;
        r128.put("voice_id", r419.longValue());     // Catch: JSONException -> L77
    L99:
        if (r510 == null) goto L102;
        r128.put("voice_type", r510);     // Catch: JSONException -> L77
    L102:
        if (r511 == null) goto L105;
        r128.put("is_baike_link", r511);     // Catch: JSONException -> L77
    L105:
        if (r512 == null) goto L108;
        r128.put("speaker_id", r512);     // Catch: JSONException -> L77
    L108:
        if (r513 == null) goto L111;
        r128.put("speaker_name", r513);     // Catch: JSONException -> L77
    L111:
        if (r517 == null) goto L114;
        r128.put("agent_id", r517);     // Catch: JSONException -> L77
    L114:
        if (r518 == null) goto L117;
        r128.put("agent_intention", r518);     // Catch: JSONException -> L77
    L117:
        if (r519 == null) goto L119;
        r128.put("scene", r519);     // Catch: JSONException -> L77
    L119:
        if (r514 == null) goto L121;
        r128.put("instruction_type", r514.intValue());     // Catch: JSONException -> L77
    L121:
        if (r610 == null) goto L124;
        r128.put("action_bar_template_name", r610.intValue());     // Catch: JSONException -> L77
        r128.put(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r610.intValue());     // Catch: JSONException -> L77
    L124:
        if (r611 == null) goto L126;
        r128.put("action_bar_template_type", r611);     // Catch: JSONException -> L77
    L126:
        if (r518 == null) goto L129;
        r128.put("agent_intention", r518);     // Catch: JSONException -> L77
    L129:
        if (r612 == null) goto L132;
        r128.put("action_bar_key", r612);     // Catch: JSONException -> L77
    L132:
        if (r613 == null) goto L135;
        r128.put("is_action_bar", r613);     // Catch: JSONException -> L77
    L135:
        if (r614 == null) goto L137;
        r128.put("chat_type", r614);     // Catch: JSONException -> L77
    L137:
        if (r615 == null) goto L140;
        r128.put("tts_speaker_volume", r615.intValue());     // Catch: JSONException -> L77
    L140:
        if (r616 == null) goto L142;
        r128.put("is_multi_question", r616);     // Catch: JSONException -> L77
    L142:
        if (r617 == null) goto L145;
        r128.put("multi_question_count", r617.intValue());     // Catch: JSONException -> L77
    L145:
        if (r618 == null) goto L148;
        r128.put("is_perspective_corrected", r618);     // Catch: JSONException -> L77
    L148:
        if (r619 == null) goto L151;
        r128.put("parent_message_id", r619);     // Catch: JSONException -> L77
    L151:
        if (r819 == null) goto L153;
        r128.put("call_id", r819);     // Catch: JSONException -> L77
    L153:
        if (r910 == null) goto L156;
        r128.put("is_realtime_call_hello", r910.intValue());     // Catch: JSONException -> L77
    L156:
        if (r911 == null) goto L159;
        r128.put("realtime_call_hello_tech_type", r911);     // Catch: JSONException -> L77
    L159:
        if (r912 == null) goto L162;
        r128.put("realtime_call_hello_type", r912);     // Catch: JSONException -> L77
    L162:
        if (r105 == null) goto L165;
        r128.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE, r105);     // Catch: JSONException -> L77
    L165:
        if (r107 == null) goto L168;
        r128.put("is_simultaneous_interpretation", r107);     // Catch: JSONException -> L77
    L168:
        if (r712 == null) goto L171;
        r128.put("is_deep_thinking_switch_on", r712);     // Catch: JSONException -> L77
    L171:
        if (r713 == null) goto L174;
        r128.put("is_deep_thinking", r713);     // Catch: JSONException -> L77
    L174:
        if (r113 == null) goto L177;
        r128.put("is_pro", r113);     // Catch: JSONException -> L77
    L177:
        if (r714 == null) goto L180;
        r128.put("is_crowd_testing", r714);     // Catch: JSONException -> L77
    L180:
        if (r716 == null) goto L183;
        r128.put("is_internet_switch_on", r716);     // Catch: JSONException -> L77
    L183:
        if (r717 == null) goto L186;
        r128.put("deep_research_phase", r717);     // Catch: JSONException -> L77
    L186:
        if (r718 == null) goto L189;
        r128.put("deep_research_id", r718);     // Catch: JSONException -> L77
    L189:
        if (r719 == null) goto L192;
        r128.put("thinking_content_card_type", r719);     // Catch: JSONException -> L77
    L192:
        if (r715 == null) goto L195;
        r128.put("is_video_comprehend", r715);     // Catch: JSONException -> L77
    L195:
        if (r811 == null) goto L198;
        r128.put("user_case_item_id", r811);     // Catch: JSONException -> L77
    L198:
        if (r812 == null) goto L201;
        r128.put("user_case_reco_request_id", r812);     // Catch: JSONException -> L77
    L201:
        if (r813 == null) goto L203;
        r128.put("recommend_from", r813);     // Catch: JSONException -> L77
    L203:
        if (r814 == null) goto L206;
        r128.put("action_bar_option_id", r814.longValue());     // Catch: JSONException -> L77
    L206:
        if (r815 == null) goto L208;
        r128.put("action_bar_option_text", r815);     // Catch: JSONException -> L77
    L208:
        if (r816 == null) goto L211;
        r128.put(LiveTutorHomeVM.ACTION_BAR_ITEM_ID, r816.longValue());     // Catch: JSONException -> L77
    L211:
        if (r817 == null) goto L214;
        r128.put("is_ai_podcast", r817);     // Catch: JSONException -> L77
    L214:
        if (r913 == null) goto L217;
        r128.put("page_token", r913);     // Catch: JSONException -> L77
    L217:
        if (r914 == null) goto L219;
        r128.put("artifact_meta_id", r914);     // Catch: JSONException -> L77
    L219:
        if (r915 == null) goto L221;
        r128.put("artifact_type", r915.intValue());     // Catch: JSONException -> L77
    L221:
        if (r916 == null) goto L224;
        r128.put("resource_type", r916.intValue());     // Catch: JSONException -> L77
    L224:
        if (r917 == null) goto L227;
        r128.put("presentation_id", r917);     // Catch: JSONException -> L77
    L227:
        if (r918 == null) goto L230;
        r128.put("resource_id", r918);     // Catch: JSONException -> L77
    L230:
        if (r919 == null) goto L233;
        r128.put("base_id", r919);     // Catch: JSONException -> L77
    L233:
        if (r100 == null) goto L236;
        r128.put("ai_base_cnt", r100);     // Catch: JSONException -> L77
    L236:
        if (r101 == null) goto L238;
        r128.put("aippt_task_id", r101);     // Catch: JSONException -> L77
    L238:
        if (r102 == null) goto L240;
        r128.put("is_float_chat", r102.intValue());     // Catch: JSONException -> L77
    L240:
        if (r103 == null) goto L243;
        r128.put("float_chat_shown_pct", r103.intValue());     // Catch: JSONException -> L77
    L243:
        if (r106 == null) goto L246;
        r128.put("credit_message_type", r106);     // Catch: JSONException -> L77
    L246:
        if (r104 == false) goto L248;
        int r133 = 1;
    L249:
        r128.put("is_with_ai_doc", r133);     // Catch: JSONException -> L77
        if (com.larus.utils.o0.d(r114) == false) goto L253;
        r128.put("collection_id", r114);     // Catch: JSONException -> L77
    L253:
        if (com.larus.utils.o0.d(r115) == false) goto L256;
        r128.put("collection_name", r115);     // Catch: JSONException -> L77
    L256:
        if (com.larus.utils.o0.d(r116) == false) goto L259;
        r128.put("content_type", r116);     // Catch: JSONException -> L77
    L259:
        if (com.larus.utils.o0.d(r117) == false) goto L262;
        r128.put("content_sec_type", r117);     // Catch: JSONException -> L77
    L262:
        if (com.larus.utils.o0.d(r118) == false) goto L265;
        r128.put("link_type", r118);     // Catch: JSONException -> L77
    L265:
        if (com.larus.utils.o0.d(r1110) == false) goto L268;
        r128.put("spreadsheet_id", r1110);     // Catch: JSONException -> L77
    L268:
        if (com.larus.utils.o0.d(r1111) == false) goto L271;
        r128.put("ai_sheet_cnt", r1111);     // Catch: JSONException -> L77
    L271:
        if (com.larus.utils.o0.d(r120) == false) goto L273;
        r128.put("ai_excel_cnt", r120);     // Catch: JSONException -> L77
    L273:
        if (r121 == null) goto L280;
        if (r121.booleanValue() == false) goto L277;
        String r134 = "true";
    L278:
        r128.put("button_invisible", r134);     // Catch: JSONException -> L77
        goto L280
    L277:
        r134 = "false";
    L280:
        if (com.larus.utils.o0.d(r122) == false) goto L283;
        r128.put("button_scene", r122);     // Catch: JSONException -> L77
    L283:
        if (r123 == null) goto L287;
        r128.put("clarify_id", r123);     // Catch: JSONException -> L77
        goto L287
    L248:
        r133 = 0;
        goto L249
    L19:
        r132 = r810;
        goto L20
    L15:
        r131 = "0";
        goto L16
    }
}
