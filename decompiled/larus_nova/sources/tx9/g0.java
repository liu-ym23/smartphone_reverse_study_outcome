package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class g0 {
    public static void a(String r100, String r101, String r102, String r103, String r104, String r105, String r110, String r111, by7.e r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 2) == 0) goto L8;
        String r106 = null;
    L10:
        if ((r113 & 8) == 0) goto L13;
        r101 = null;
    L13:
        if ((r113 & 128) == 0) goto L16;
        r102 = null;
    L16:
        if ((r113 & 256) == 0) goto L19;
        r103 = null;
    L19:
        if ((r113 & 512) == 0) goto L22;
        r104 = null;
    L22:
        if ((r113 & 2048) == 0) goto L25;
        r105 = null;
    L25:
        if ((r113 & 4096) == 0) goto L28;
        r110 = null;
    L28:
        if ((r113 & 8192) == 0) goto L31;
        r111 = null;
    L31:
        if ((r113 & 16384) == 0) goto L33;
        JSONObject r107 = new JSONObject();
    L35:
        if ((r113 & 32768) == 0) goto L37;
        r112 = null;
    L37:
        Intrinsics.checkNotNullParameter(r107, "params");
        if (r100 != null) goto L65;
    L42:
        if (r106 == null) goto L44;
        r107.put("click_from", r106);     // Catch: JSONException -> L40
    L44:
        if (r101 == null) goto L46;
        r107.put("is_immersive_background", r101);     // Catch: JSONException -> L40
    L46:
        if (r102 == null) goto L48;
        r107.put("rank", r102);     // Catch: JSONException -> L40
    L48:
        if (r103 == null) goto L50;
        r107.put("recommend_from", r103);     // Catch: JSONException -> L40
    L50:
        if (r104 == null) goto L52;
        r107.put("req_id", r104);     // Catch: JSONException -> L40
    L52:
        if (r105 == null) goto L54;
        r107.put("search_id", r105);     // Catch: JSONException -> L40
    L54:
        if (r110 == null) goto L56;
        r107.put("search_request_id", r110);     // Catch: JSONException -> L40
    L56:
        if (r111 == null) goto L60;
        r107.put("search_result_id", r111);     // Catch: JSONException -> L40
    L40:
        e = move-exception;
        FLogger.f375446a.e("ConfirmEventHelper", "error in ConfirmEventHelper confirmUnfollowBot " + e.getLocalizedMessage());
    L60:
        TrackParams r108 = new TrackParams().merge(r107);
        by7.a r109 = new by7.a("confirm_unfollow_bot");
        if (r112 == null) goto L63;
        r109.f21464b = r112;
    L63:
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L65:
        r107.put("bot_id", r100);     // Catch: JSONException -> L40
        goto L42
    L33:
        r107 = null;
        goto L35
    L8:
        r106 = "click_check";
        goto L10
    }
}
