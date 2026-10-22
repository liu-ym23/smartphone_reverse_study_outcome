package tx9;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class s0 {
    public static void a(String r210, String r211, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, JSONObject r318, by7.e r319, String r410, String r411, Integer r412, String r413, String r414, String r415, String r416, String r417, Integer r418, Integer r419, boolean r510, String r511, String r512, String r513, String r514, int r515, int r516) {
        if ((r515 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r515 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r515 & 64) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r515 & 128) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r515 & 4096) == 0) goto L21;
        String r104 = null;
    L23:
        if ((524288 & r515) == 0) goto L25;
        String r105 = null;
    L27:
        if ((1048576 & r515) == 0) goto L29;
        String r106 = null;
    L31:
        if ((2097152 & r515) == 0) goto L33;
        String r110 = null;
    L35:
        if ((4194304 & r515) == 0) goto L37;
        String r111 = null;
    L39:
        if ((8388608 & r515) == 0) goto L41;
        String r112 = null;
    L43:
        if ((16777216 & r515) == 0) goto L45;
        JSONObject r113 = new JSONObject();
    L47:
        if ((33554432 & r515) == 0) goto L49;
        by7.e r114 = null;
    L51:
        if ((67108864 & r515) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r515 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L57;
        String r107 = null;
    L59:
        if ((r515 & 268435456) == 0) goto L61;
        Integer r116 = null;
    L62:
        by7.e r212 = r114;
        if ((r515 & 536870912) == 0) goto L65;
        String r117 = null;
    L67:
        if ((r515 & 1073741824) == 0) goto L69;
        String r118 = null;
    L71:
        if ((r515 & Integer.MIN_VALUE) == 0) goto L73;
        String r108 = null;
    L75:
        if ((r516 & 1) == 0) goto L77;
        String r213 = null;
    L79:
        if ((r516 & 2) == 0) goto L81;
        String r214 = null;
    L83:
        if ((r516 & 4) == 0) goto L85;
        Integer r119 = null;
    L87:
        if ((r516 & 8) == 0) goto L89;
        Integer r215 = null;
    L91:
        if ((r516 & 16) == 0) goto L93;
        boolean r216 = false;
    L95:
        if ((r516 & 32) == 0) goto L97;
        String r217 = null;
    L99:
        if ((r516 & 64) == 0) goto L101;
        String r218 = null;
    L102:
        String r219 = r108;
        if ((r516 & 128) == 0) goto L105;
        String r109 = null;
    L107:
        if ((r516 & 256) == 0) goto L109;
        String r320 = null;
    L110:
        Intrinsics.checkNotNullParameter(r113, "params");
        if (r100 != null) goto L190;
    L115:
        if (r101 == null) goto L117;
        r113.put("click_from", r101);     // Catch: JSONException -> L113
    L117:
        if (r102 == null) goto L119;
        r113.put("is_immersive_background", r102);     // Catch: JSONException -> L113
    L119:
        if (r103 == null) goto L121;
        r113.put(MusicAppletPage.KEY_MESSAGE_ID, r103);     // Catch: JSONException -> L113
    L121:
        if (r104 == null) goto L123;
        r113.put("recommend_from", r104);     // Catch: JSONException -> L113
    L123:
        if (r105 == null) goto L125;
        r113.put("message_is_interrupted", r105);     // Catch: JSONException -> L113
    L125:
        if (r106 == null) goto L127;
        r113.put("is_call_bot", r106);     // Catch: JSONException -> L113
    L127:
        if (r110 == null) goto L129;
        r113.put("agent_id", r110);     // Catch: JSONException -> L113
    L129:
        if (r111 == null) goto L131;
        r113.put("user_case_item_id", r111);     // Catch: JSONException -> L113
    L131:
        if (r112 == null) goto L133;
        r113.put("user_case_reco_request_id", r112);     // Catch: JSONException -> L113
    L133:
        int r120 = 1;
        if (r115 != null) goto L136;
    L141:
        if (r107 != null) goto L143;
    L148:
        if (r116 == null) goto L150;
        r113.put("artifact_type", r116.intValue());     // Catch: JSONException -> L113
    L150:
        if (r119 == null) goto L152;
        r113.put("is_float_chat", r119.intValue());     // Catch: JSONException -> L113
    L152:
        if (r215 == null) goto L154;
        r113.put("float_chat_shown_pct", r215.intValue());     // Catch: JSONException -> L113
    L154:
        if (r117 == null) goto L156;
        r113.put("aippt_task_id", r117);     // Catch: JSONException -> L113
    L156:
        String r121 = r118;
        if (r121 == null) goto L159;
        r113.put("presentation_id", r121);     // Catch: JSONException -> L113
    L159:
        if (r219 == null) goto L161;
        r113.put("resource_id", r219);     // Catch: JSONException -> L113
    L161:
        String r122 = r213;
        if (r122 == null) goto L164;
        r113.put("resource_type", r122);     // Catch: JSONException -> L113
    L164:
        String r123 = r214;
        if (r123 == null) goto L168;
        r113.put("canvas_type", r123);     // Catch: JSONException -> L113
    L168:
        if (r216 == true) goto L171;
        r120 = 0;
    L171:
        r113.put("is_with_ai_doc", r120);     // Catch: JSONException -> L113
        String r124 = r217;
        if (r124 == null) goto L174;
        r113.put("click_module", r124);     // Catch: JSONException -> L113
    L174:
        String r125 = r218;
        if (r125 == null) goto L178;
        r113.put("call_id", r125);     // Catch: JSONException -> L113
    L178:
        if (com.larus.utils.o0.d(r109) == false) goto L181;
        r113.put("spreadsheet_id", r109);     // Catch: JSONException -> L113
    L181:
        if (com.larus.utils.o0.d(r320) == false) goto L185;
        r113.put("base_id", r320);     // Catch: JSONException -> L113
    L113:
        e = move-exception;
        FLogger.f375446a.e("DislikeEventHelper", "error in DislikeEventHelper dislike " + e.getLocalizedMessage());
    L185:
        TrackParams r126 = new TrackParams().merge(r113);
        by7.a r127 = new by7.a(AppConstants.BUNDLE_DISLIKE);
        if (r212 == null) goto L188;
        r127.f21464b = r212;
    L188:
        r127.f21463a.merge(r126);
        r127.b();
        return;
    L143:
        if (r107.length() <= 0) goto L145;
        boolean r128 = true;
    L146:
        if (r128 == false) goto L148;
        r113.put("artifact_meta_id", r107);     // Catch: JSONException -> L113
        goto L148
    L145:
        r128 = false;
        goto L146
    L136:
        if (r115.length() <= 0) goto L138;
        boolean r129 = true;
    L139:
        if (r129 == false) goto L141;
        r113.put("page_token", r115);     // Catch: JSONException -> L113
        goto L141
    L138:
        r129 = false;
        goto L139
    L190:
        r113.put("bot_id", r100);     // Catch: JSONException -> L113
        goto L115
    L109:
        r320 = r514;
        goto L110
    L105:
        r109 = r513;
        goto L107
    L101:
        r218 = r512;
        goto L102
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
        r119 = r418;
        goto L87
    L81:
        r214 = r417;
        goto L83
    L77:
        r213 = r416;
        goto L79
    L73:
        r108 = r415;
        goto L75
    L69:
        r118 = r414;
        goto L71
    L65:
        r117 = r413;
        goto L67
    L61:
        r116 = r412;
        goto L62
    L57:
        r107 = r411;
        goto L59
    L53:
        r115 = r410;
        goto L55
    L49:
        r114 = r319;
        goto L51
    L45:
        r113 = r318;
        goto L47
    L41:
        r112 = r317;
        goto L43
    L37:
        r111 = r316;
        goto L39
    L33:
        r110 = r315;
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
}
