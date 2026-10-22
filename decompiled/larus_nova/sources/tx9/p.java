package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class p {
    public static void a(String r100, String r101, String r102, String r103, String r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L18;
    L7:
        if (r101 == null) goto L9;
        r105.put("chat_type", r101);     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L11;
        r105.put("current_page", r102);     // Catch: JSONException -> L5
    L11:
        if (r103 == null) goto L13;
        r105.put("req_id", r103);     // Catch: JSONException -> L5
    L13:
        r105.put("recommend_from", r104);     // Catch: JSONException -> L5
    L16:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("bot_feedback_banner_show");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("BotFeedbackHelper", "error in mobBotFeedbackBannerShow " + e.getLocalizedMessage());
        goto L16
    L18:
        r105.put("bot_id", r100);     // Catch: JSONException -> L5
        goto L7
    }
}
