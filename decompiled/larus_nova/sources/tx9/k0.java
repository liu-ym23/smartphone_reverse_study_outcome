package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class k0 {
    public static void a(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, Boolean r219, String r310, String r311, String r312, String r313, JSONObject r314, by7.e r315, String r316, Integer r317, int r318) {
        if ((r318 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r318 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r318 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r318 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r318 & 32) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r318 & 64) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r318 & 128) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r318 & 256) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r318 & 512) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r318 & 1024) == 0) goto L41;
        Boolean r111 = Boolean.TRUE;
    L43:
        if ((r318 & 2048) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r318 & 4096) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r318 & 8192) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r318 & 16384) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r318 & 32768) == 0) goto L61;
        JSONObject r108 = new JSONObject();
    L63:
        if ((r318 & 65536) == 0) goto L65;
        by7.e r116 = null;
    L67:
        if ((r318 & 131072) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r318 & 524288) == 0) goto L73;
        Integer r118 = null;
    L74:
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r100 != null) goto L121;
    L79:
        if (r101 == null) goto L81;
        r108.put("click_from", r101);     // Catch: JSONException -> L77
    L81:
        if (r102 == null) goto L83;
        r108.put("conversation_id", r102);     // Catch: JSONException -> L77
    L83:
        if (r103 == null) goto L85;
        r108.put("current_page", r103);     // Catch: JSONException -> L77
    L85:
        if (r104 == null) goto L87;
        r108.put("previous_page", r104);     // Catch: JSONException -> L77
    L87:
        if (r105 == null) goto L89;
        r108.put("previous_module", r105);     // Catch: JSONException -> L77
    L89:
        if (r106 == null) goto L91;
        r108.put("user_type", r106);     // Catch: JSONException -> L77
    L91:
        if (r107 == null) goto L93;
        r108.put("click_module", r107);     // Catch: JSONException -> L77
    L93:
        if (r110 == null) goto L95;
        r108.put(MusicAppletPage.KEY_MESSAGE_ID, r110);     // Catch: JSONException -> L77
    L95:
        if (r111 != null) goto L97;
    L101:
        if (r112 == null) goto L103;
        r108.put("chat_type", r112);     // Catch: JSONException -> L77
    L103:
        if (r113 == null) goto L105;
        r108.put("recommend_from", r113);     // Catch: JSONException -> L77
    L105:
        if (r114 == null) goto L107;
        r108.put("user_case_item_id", r114);     // Catch: JSONException -> L77
    L107:
        if (r115 == null) goto L109;
        r108.put("user_case_reco_request_id", r115);     // Catch: JSONException -> L77
    L109:
        String r109 = r117;
        if (r109 == null) goto L112;
        r108.put("page_token", r109);     // Catch: JSONException -> L77
    L112:
        if (r118 == null) goto L116;
        r108.put("resource_type", r118.intValue());     // Catch: JSONException -> L77
    L77:
        e = move-exception;
        FLogger.f375446a.e("CreateEventHelper", "error in CreateEventHelper createNewChat " + e.getLocalizedMessage());
    L116:
        TrackParams r119 = new TrackParams().merge(r108);
        by7.a r120 = new by7.a("create_new_chat");
        by7.e r121 = r116;
        if (r121 == null) goto L119;
        r120.f21464b = r121;
    L119:
        r120.f21463a.merge(r119);
        r120.b();
        return;
    L97:
        if (r111.booleanValue() == false) goto L99;
        int r122 = 1;
    L100:
        r108.put("success", r122);     // Catch: JSONException -> L77
        goto L101
    L99:
        r122 = 0;
        goto L100
    L121:
        r108.put("bot_id", r100);     // Catch: JSONException -> L77
        goto L79
    L73:
        r118 = r317;
        goto L74
    L69:
        r117 = r316;
        goto L71
    L65:
        r116 = r315;
        goto L67
    L61:
        r108 = r314;
        goto L63
    L57:
        r115 = r313;
        goto L59
    L53:
        r114 = r312;
        goto L55
    L49:
        r113 = r311;
        goto L51
    L45:
        r112 = r310;
        goto L47
    L41:
        r111 = r219;
        goto L43
    L37:
        r110 = r218;
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
