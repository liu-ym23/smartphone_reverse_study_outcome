package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class r1 {
    public static void a(String r210, String r211, String r212, String r310, String r311, String r312, String r313, String r314, String r315, String r316, JSONObject r317, by7.e r318, String r319, String r410, Integer r411, Integer r412, Integer r413, boolean r414, String r415, String r416, String r417, String r418, String r419, String r510, String r511, String r512, String r513, int r514, int r515) {
        if ((r514 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r514 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r514 & 128) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r514 & 256) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r514 & 8192) == 0) goto L21;
        String r104 = null;
    L23:
        if ((1048576 & r514) == 0) goto L25;
        String r105 = null;
    L27:
        if ((2097152 & r514) == 0) goto L29;
        String r106 = null;
    L31:
        if ((4194304 & r514) == 0) goto L33;
        String r110 = null;
    L35:
        if ((8388608 & r514) == 0) goto L37;
        String r111 = null;
    L39:
        if ((16777216 & r514) == 0) goto L41;
        String r112 = null;
    L43:
        if ((33554432 & r514) == 0) goto L45;
        JSONObject r113 = new JSONObject();
    L47:
        if ((67108864 & r514) == 0) goto L49;
        by7.e r114 = null;
    L51:
        if ((134217728 & r514) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r514 & 268435456) == 0) goto L57;
        String r107 = null;
    L59:
        if ((r514 & 536870912) == 0) goto L61;
        Integer r116 = null;
    L63:
        if ((r514 & 1073741824) == 0) goto L65;
        Integer r117 = null;
    L67:
        if ((r514 & Integer.MIN_VALUE) == 0) goto L69;
        Integer r108 = null;
    L71:
        if ((r515 & 1) == 0) goto L73;
        boolean r118 = false;
    L74:
        by7.e r213 = r114;
        if ((r515 & 2) == 0) goto L77;
        String r119 = null;
    L79:
        if ((r515 & 4) == 0) goto L81;
        String r214 = null;
    L83:
        if ((r515 & 8) == 0) goto L85;
        String r215 = null;
    L87:
        if ((r515 & 16) == 0) goto L89;
        String r216 = null;
    L91:
        if ((r515 & 32) == 0) goto L93;
        String r217 = null;
    L95:
        if ((r515 & 64) == 0) goto L97;
        String r218 = null;
    L98:
        String r219 = r119;
        if ((r515 & 128) == 0) goto L101;
        String r120 = null;
    L102:
        String r220 = r120;
        if ((r515 & 256) == 0) goto L105;
        String r121 = null;
    L107:
        if ((r515 & 512) == 0) goto L109;
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
        int r109 = 1;
        if (r115 != null) goto L136;
    L141:
        if (r107 != null) goto L143;
    L148:
        if (r116 == null) goto L150;
        r113.put("artifact_type", r116.intValue());     // Catch: JSONException -> L113
    L150:
        if (r117 == null) goto L152;
        r113.put("is_float_chat", r117.intValue());     // Catch: JSONException -> L113
    L152:
        if (r108 == null) goto L154;
        r113.put("float_chat_shown_pct", r108.intValue());     // Catch: JSONException -> L113
    L154:
        if (r219 == null) goto L156;
        r113.put("aippt_task_id", r219);     // Catch: JSONException -> L113
    L156:
        String r122 = r214;
        if (r122 == null) goto L159;
        r113.put("presentation_id", r122);     // Catch: JSONException -> L113
    L159:
        String r123 = r215;
        if (r123 == null) goto L162;
        r113.put("resource_id", r123);     // Catch: JSONException -> L113
    L162:
        String r124 = r216;
        if (r124 == null) goto L165;
        r113.put("resource_type", r124);     // Catch: JSONException -> L113
    L165:
        String r125 = r217;
        if (r125 == null) goto L169;
        r113.put("canvas_type", r125);     // Catch: JSONException -> L113
    L169:
        if (r118 == true) goto L172;
        r109 = 0;
    L172:
        r113.put("is_with_ai_doc", r109);     // Catch: JSONException -> L113
        String r126 = r218;
        if (r126 == null) goto L175;
        r113.put("click_module", r126);     // Catch: JSONException -> L113
    L175:
        if (r220 == null) goto L178;
        r113.put("call_id", r220);     // Catch: JSONException -> L113
    L178:
        if (com.larus.utils.o0.d(r121) == false) goto L181;
        r113.put("spreadsheet_id", r121);     // Catch: JSONException -> L113
    L181:
        if (com.larus.utils.o0.d(r320) == false) goto L185;
        r113.put("base_id", r320);     // Catch: JSONException -> L113
    L113:
        e = move-exception;
        FLogger.f375446a.e("LikeEventHelper", "error in LikeEventHelper like " + e.getLocalizedMessage());
    L185:
        TrackParams r127 = new TrackParams().merge(r113);
        by7.a r128 = new by7.a(IStrategyStateSupplier.KEY_INFO_LIKE);
        if (r213 == null) goto L188;
        r128.f21464b = r213;
    L188:
        r128.f21463a.merge(r127);
        r128.b();
        return;
    L143:
        if (r107.length() <= 0) goto L145;
        boolean r129 = true;
    L146:
        if (r129 == false) goto L148;
        r113.put("artifact_meta_id", r107);     // Catch: JSONException -> L113
        goto L148
    L145:
        r129 = false;
        goto L146
    L136:
        if (r115.length() <= 0) goto L138;
        boolean r130 = true;
    L139:
        if (r130 == false) goto L141;
        r113.put("page_token", r115);     // Catch: JSONException -> L113
        goto L141
    L138:
        r130 = false;
        goto L139
    L190:
        r113.put("bot_id", r100);     // Catch: JSONException -> L113
        goto L115
    L109:
        r320 = r513;
        goto L110
    L105:
        r121 = r512;
        goto L107
    L101:
        r120 = r511;
        goto L102
    L97:
        r218 = r510;
        goto L98
    L93:
        r217 = r419;
        goto L95
    L89:
        r216 = r418;
        goto L91
    L85:
        r215 = r417;
        goto L87
    L81:
        r214 = r416;
        goto L83
    L77:
        r119 = r415;
        goto L79
    L73:
        r118 = r414;
        goto L74
    L69:
        r108 = r413;
        goto L71
    L65:
        r117 = r412;
        goto L67
    L61:
        r116 = r411;
        goto L63
    L57:
        r107 = r410;
        goto L59
    L53:
        r115 = r319;
        goto L55
    L49:
        r114 = r318;
        goto L51
    L45:
        r113 = r317;
        goto L47
    L41:
        r112 = r316;
        goto L43
    L37:
        r111 = r315;
        goto L39
    L33:
        r110 = r314;
        goto L35
    L29:
        r106 = r313;
        goto L31
    L25:
        r105 = r312;
        goto L27
    L21:
        r104 = r311;
        goto L23
    L17:
        r103 = r310;
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
}
