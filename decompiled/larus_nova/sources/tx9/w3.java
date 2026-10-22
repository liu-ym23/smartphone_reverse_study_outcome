package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class w3 {
    public static void a(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, by7.e r310, int r311) {
        by7.e r100 = null;
        if ((r311 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r311 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r311 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r311 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r311 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r311 & 128) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r311 & 256) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r311 & 512) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r311 & 2048) == 0) goto L37;
        String r113 = null;
    L39:
        if ((r311 & 4096) == 0) goto L41;
        String r114 = null;
    L43:
        if ((r311 & 8192) == 0) goto L45;
        String r115 = null;
    L47:
        if ((r311 & 16384) == 0) goto L49;
        String r116 = null;
    L51:
        if ((32768 & r311) == 0) goto L53;
        String r117 = null;
    L55:
        if ((65536 & r311) == 0) goto L57;
        JSONObject r118 = new JSONObject();
    L59:
        if ((r311 & 131072) != 0) goto L62;
        r100 = r310;
    L62:
        Intrinsics.checkNotNullParameter(r118, "params");
        if (r101 != null) goto L98;
    L67:
        if (r102 == null) goto L69;
        r118.put("click_from", r102);     // Catch: JSONException -> L65
    L69:
        if (r103 == null) goto L71;
        r118.put("current_page", r103);     // Catch: JSONException -> L65
    L71:
        if (r104 == null) goto L73;
        r118.put("is_immersive_background", r104);     // Catch: JSONException -> L65
    L73:
        if (r105 == null) goto L75;
        r118.put("previous_page", r105);     // Catch: JSONException -> L65
    L75:
        if (r106 == null) goto L77;
        r118.put("rank", r106);     // Catch: JSONException -> L65
    L77:
        if (r107 == null) goto L79;
        r118.put("recommend_from", r107);     // Catch: JSONException -> L65
    L79:
        if (r108 == null) goto L81;
        r118.put("req_id", r108);     // Catch: JSONException -> L65
    L81:
        if (r113 == null) goto L83;
        r118.put("search_id", r113);     // Catch: JSONException -> L65
    L83:
        if (r114 == null) goto L85;
        r118.put("search_request_id", r114);     // Catch: JSONException -> L65
    L85:
        if (r115 == null) goto L87;
        r118.put("search_result_id", r115);     // Catch: JSONException -> L65
    L87:
        if (r116 == null) goto L89;
        r118.put("is_call_bot", r116);     // Catch: JSONException -> L65
    L89:
        if (r117 == null) goto L93;
        r118.put("is_navigation_sidebar", r117);     // Catch: JSONException -> L65
    L65:
        e = move-exception;
        FLogger.f375446a.e("UnfollowEventHelper", "error in UnfollowEventHelper unfollowBot " + e.getLocalizedMessage());
    L93:
        TrackParams r109 = new TrackParams().merge(r118);
        by7.a r119 = new by7.a("unfollow_bot");
        if (r100 == null) goto L96;
        r119.f21464b = r100;
    L96:
        r119.f21463a.merge(r109);
        r119.b();
        return;
    L98:
        r118.put("bot_id", r101);     // Catch: JSONException -> L65
        goto L67
    L57:
        r118 = null;
        goto L59
    L53:
        r117 = r219;
        goto L55
    L49:
        r116 = r218;
        goto L51
    L45:
        r115 = r217;
        goto L47
    L41:
        r114 = r216;
        goto L43
    L37:
        r113 = r215;
        goto L39
    L33:
        r108 = r214;
        goto L35
    L29:
        r107 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
