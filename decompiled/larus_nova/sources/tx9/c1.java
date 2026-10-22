package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class c1 {
    public static void a(String r110, String r111, String r210, String r211, String r212, String r213, String r214, String r215, Long r216, String r217, String r218, String r219, String r310, String r311, String r312, JSONObject r313, by7.e r314, int r315) {
        if ((r315 & 1) == 0) goto L5;
        Object r100 = null;
    L7:
        if ((r315 & 2) == 0) goto L9;
        Object r101 = null;
    L11:
        if ((r315 & 4) == 0) goto L13;
        Object r102 = null;
    L15:
        if ((r315 & 8) == 0) goto L17;
        Object r103 = null;
    L19:
        if ((r315 & 16) == 0) goto L21;
        Object r104 = null;
    L23:
        if ((r315 & 32) == 0) goto L25;
        Object r105 = null;
    L27:
        if ((r315 & 64) == 0) goto L29;
        Object r106 = null;
    L31:
        if ((r315 & 128) == 0) goto L33;
        Object r107 = null;
    L35:
        if ((r315 & 256) == 0) goto L37;
        Long r112 = null;
    L39:
        if ((r315 & 512) == 0) goto L41;
        Object r113 = null;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        Object r114 = null;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        Object r115 = null;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        Object r116 = null;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        Object r117 = null;
    L59:
        if ((r315 & 16384) == 0) goto L61;
        Object r108 = null;
    L63:
        if ((r315 & 32768) == 0) goto L65;
        JSONObject r109 = new JSONObject();
    L67:
        if ((r315 & 65536) == 0) goto L69;
        by7.e r118 = null;
    L70:
        Intrinsics.checkNotNullParameter(r109, "params");
        if (r100 != null) goto L110;
    L75:
        if (r101 == null) goto L77;
        r109.put("conversation_id", r101);     // Catch: JSONException -> L73
    L77:
        if (r102 == null) goto L79;
        r109.put("bot_id", r102);     // Catch: JSONException -> L73
    L79:
        if (r104 == null) goto L81;
        r109.put("voice_id", r104);     // Catch: JSONException -> L73
    L81:
        if (r105 == null) goto L83;
        r109.put("to_tts_speaker", r105);     // Catch: JSONException -> L73
    L83:
        if (r103 == null) goto L85;
        r109.put("chat_type", r103);     // Catch: JSONException -> L73
    L85:
        if (r106 == null) goto L87;
        r109.put(AiProactiveTaskViewModel.PARAM_START_METHOD, r106);     // Catch: JSONException -> L73
    L87:
        if (r107 == null) goto L89;
        r109.put("end_method", r107);     // Catch: JSONException -> L73
    L89:
        if (r112 == null) goto L91;
        r109.put("duration", r112.longValue());     // Catch: JSONException -> L73
    L91:
        if (r113 == null) goto L93;
        r109.put("speaker_id", r113);     // Catch: JSONException -> L73
    L93:
        if (r114 == null) goto L95;
        r109.put("speaker_name", r114);     // Catch: JSONException -> L73
    L95:
        if (r115 == null) goto L97;
        r109.put("intention_dialect", r115);     // Catch: JSONException -> L73
    L97:
        if (r116 == null) goto L99;
        r109.put("tts_dialect", r116);     // Catch: JSONException -> L73
    L99:
        if (r117 == null) goto L101;
        r109.put("is_deep_thinking", r117);     // Catch: JSONException -> L73
    L101:
        if (r108 == 0) goto L105;
        r109.put("is_simultaneous_interpretation", r108);     // Catch: JSONException -> L73
    L73:
        e = move-exception;
        FLogger.f375446a.e("FinishEventHelper", "error in FinishEventHelper finishTTS " + e.getLocalizedMessage());
    L105:
        TrackParams r119 = new TrackParams().merge(r109);
        by7.a r120 = new by7.a("finish_tts");
        by7.e r121 = r118;
        if (r121 == null) goto L108;
        r120.f21464b = r121;
    L108:
        r120.f21463a.merge(r119);
        r120.b();
        return;
    L110:
        r109.put(MusicAppletPage.KEY_MESSAGE_ID, r100);     // Catch: JSONException -> L73
        goto L75
    L69:
        r118 = r314;
        goto L70
    L65:
        r109 = r313;
        goto L67
    L61:
        r108 = r312;
        goto L63
    L57:
        r117 = r311;
        goto L59
    L53:
        r116 = r310;
        goto L55
    L49:
        r115 = r219;
        goto L51
    L45:
        r114 = r218;
        goto L47
    L41:
        r113 = r217;
        goto L43
    L37:
        r112 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
