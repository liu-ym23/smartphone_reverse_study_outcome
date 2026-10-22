package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class e1 {
    public static void a(String r110, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, JSONObject r314, by7.e r315, int r316) {
        if ((r316 & 2) == 0) goto L5;
        Object r100 = null;
    L7:
        if ((r316 & 4) == 0) goto L9;
        Object r101 = null;
    L11:
        if ((r316 & 8) == 0) goto L13;
        Object r102 = null;
    L15:
        if ((r316 & 32) == 0) goto L17;
        Object r103 = null;
    L19:
        if ((r316 & 64) == 0) goto L21;
        Object r104 = null;
    L23:
        if ((r316 & 128) == 0) goto L25;
        Object r105 = null;
    L27:
        if ((r316 & 256) == 0) goto L29;
        Object r106 = null;
    L31:
        if ((r316 & 2048) == 0) goto L33;
        Object r107 = null;
    L35:
        if ((r316 & 4096) == 0) goto L37;
        Object r111 = null;
    L39:
        if ((r316 & 8192) == 0) goto L41;
        Object r112 = null;
    L43:
        if ((32768 & r316) == 0) goto L45;
        Object r113 = null;
    L47:
        if ((65536 & r316) == 0) goto L49;
        Object r114 = null;
    L51:
        if ((131072 & r316) == 0) goto L53;
        Object r115 = null;
    L55:
        if ((524288 & r316) == 0) goto L57;
        Object r116 = null;
    L59:
        if ((r316 & 1048576) == 0) goto L61;
        Object r108 = null;
    L63:
        if ((r316 & 2097152) == 0) goto L65;
        JSONObject r109 = new JSONObject();
    L67:
        if ((r316 & 4194304) == 0) goto L69;
        by7.e r117 = null;
    L70:
        Intrinsics.checkNotNullParameter(r109, "params");
        if (r100 != null) goto L110;
    L75:
        if (r101 == null) goto L77;
        r109.put("chat_type", r101);     // Catch: JSONException -> L73
    L77:
        if (r102 == null) goto L79;
        r109.put("click_from", r102);     // Catch: JSONException -> L73
    L79:
        if (r103 == null) goto L81;
        r109.put("discover_page_bot_type", r103);     // Catch: JSONException -> L73
    L81:
        if (r104 == null) goto L83;
        r109.put("enter_method", r104);     // Catch: JSONException -> L73
    L83:
        if (r105 == null) goto L85;
        r109.put("is_immersive_background", r105);     // Catch: JSONException -> L73
    L85:
        if (r106 == null) goto L87;
        r109.put("previous_page", r106);     // Catch: JSONException -> L73
    L87:
        if (r107 == null) goto L89;
        r109.put("rank", r107);     // Catch: JSONException -> L73
    L89:
        if (r111 == null) goto L91;
        r109.put("recommend_from", r111);     // Catch: JSONException -> L73
    L91:
        if (r112 == null) goto L93;
        r109.put("req_id", r112);     // Catch: JSONException -> L73
    L93:
        if (r113 == null) goto L95;
        r109.put("search_id", r113);     // Catch: JSONException -> L73
    L95:
        if (r114 == null) goto L97;
        r109.put("search_request_id", r114);     // Catch: JSONException -> L73
    L97:
        if (r115 == null) goto L99;
        r109.put("search_result_id", r115);     // Catch: JSONException -> L73
    L99:
        if (r116 == null) goto L101;
        r109.put("group_type", r116);     // Catch: JSONException -> L73
    L101:
        if (r108 == 0) goto L105;
        r109.put("item_id", r108);     // Catch: JSONException -> L73
    L73:
        e = move-exception;
        FLogger.f375446a.e("FollowEventHelper", "error in FollowEventHelper followBot " + e.getLocalizedMessage());
    L105:
        TrackParams r118 = new TrackParams().merge(r109);
        by7.a r119 = new by7.a("follow_bot");
        by7.e r120 = r117;
        if (r120 == null) goto L108;
        r119.f21464b = r120;
    L108:
        r119.f21463a.merge(r118);
        r119.b();
        return;
    L110:
        r109.put("bot_id", r100);     // Catch: JSONException -> L73
        goto L75
    L69:
        r117 = r315;
        goto L70
    L65:
        r109 = r314;
        goto L67
    L61:
        r108 = r313;
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
}
