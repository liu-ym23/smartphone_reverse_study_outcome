package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class q1 {
    public static void a(Integer r210, String r211, String r212, String r213, String r214, String r215, String r216, Long r217, String r310, String r311, String r312, String r313, String r314, Boolean r315, String r316, String r317, String r318, String r319, String r410, int r411) {
        if ((r411 & 1) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r411 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r411 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r411 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r411 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r411 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r411 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r411 & 128) == 0) goto L33;
        Long r107 = null;
    L35:
        if ((r411 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r411 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r411 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r411 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r411 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r411 & 8192) == 0) goto L57;
        JSONObject r115 = new JSONObject();
    L59:
        if ((r411 & 32768) == 0) goto L61;
        Boolean r116 = null;
    L63:
        if ((r411 & 65536) == 0) goto L65;
        String r108 = null;
    L67:
        if ((r411 & 131072) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r411 & 262144) == 0) goto L73;
        String r218 = null;
    L75:
        if ((r411 & 524288) == 0) goto L77;
        String r219 = null;
    L79:
        if ((r411 & 1048576) == 0) goto L81;
        String r220 = null;
    L82:
        Intrinsics.checkNotNullParameter(r115, "params");
        if (r100 != null) goto L130;
    L87:
        if (r101 == null) goto L89;
        r115.put("is_best_match", r101);     // Catch: JSONException -> L85
    L89:
        if (r102 == null) goto L91;
        r115.put("is_public", r102);     // Catch: JSONException -> L85
    L91:
        if (r103 == null) goto L93;
        r115.put("recommend_from", r103);     // Catch: JSONException -> L85
    L93:
        if (r104 == null) goto L95;
        r115.put("req_id", r104);     // Catch: JSONException -> L85
    L95:
        if (r105 == null) goto L97;
        r115.put("voice_id", r105);     // Catch: JSONException -> L85
    L97:
        if (r106 == null) goto L99;
        r115.put("voice_type", r106);     // Catch: JSONException -> L85
    L99:
        if (r110 == null) goto L101;
        r115.put("voice_remix_id", r110);     // Catch: JSONException -> L85
    L101:
        if (r111 == null) goto L103;
        r115.put(com.alipay.sdk.m.p.e.f25671s, r111);     // Catch: JSONException -> L85
    L103:
        if (r114 == null) goto L105;
        r115.put("if_mix_voice", r114);     // Catch: JSONException -> L85
    L105:
        if (r107 == null) goto L107;
        r115.put("duration", r107.longValue());     // Catch: JSONException -> L85
    L107:
        if (r112 == null) goto L109;
        r115.put("speaker_id", r112);     // Catch: JSONException -> L85
    L109:
        if (r113 == null) goto L111;
        r115.put("speaker_name", r113);     // Catch: JSONException -> L85
    L111:
        if (r116 == null) goto L113;
        r115.put("if_voice_change", r116.booleanValue() ? 1 : 0);     // Catch: JSONException -> L85
    L113:
        if (r108 == null) goto L115;
        r115.put("scene", r108);     // Catch: JSONException -> L85
    L115:
        String r109 = r117;
        if (r109 == null) goto L118;
        r115.put("click_from", r109);     // Catch: JSONException -> L85
    L118:
        String r118 = r218;
        if (r118 == null) goto L121;
        r115.put("from_voice_id", r118);     // Catch: JSONException -> L85
    L121:
        String r119 = r219;
        if (r119 == null) goto L124;
        r115.put("to_tts_speaker", r119);     // Catch: JSONException -> L85
    L124:
        if (r220 == null) goto L128;
        r115.put("bot_id", r220);     // Catch: JSONException -> L85
    L85:
        e = move-exception;
        FLogger.f375446a.e("LeaveEventHelper", "error in LeaveEventHelper leaveChangeVoicePage " + e.getLocalizedMessage());
    L128:
        TrackParams r120 = new TrackParams().merge(r115);
        by7.a r121 = new by7.a("leave_change_voice_page");
        r121.f21463a.merge(r120);
        r121.b();
        return;
    L130:
        r115.put("change_voice_cnt", r100.intValue());     // Catch: JSONException -> L85
        goto L87
    L81:
        r220 = r410;
        goto L82
    L77:
        r219 = r319;
        goto L79
    L73:
        r218 = r318;
        goto L75
    L69:
        r117 = r317;
        goto L71
    L65:
        r108 = r316;
        goto L67
    L61:
        r116 = r315;
        goto L63
    L57:
        r115 = null;
        goto L59
    L53:
        r114 = r314;
        goto L55
    L49:
        r113 = r313;
        goto L51
    L45:
        r112 = r312;
        goto L47
    L41:
        r111 = r311;
        goto L43
    L37:
        r110 = r310;
        goto L39
    L33:
        r107 = r217;
        goto L35
    L29:
        r106 = r216;
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
}
