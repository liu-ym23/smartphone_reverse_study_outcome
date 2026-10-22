package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class e3 {
    public static void a(Long r100, Long r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("current_page", "bot_list_discover");     // Catch: JSONException -> L9
        r102.put("recommend_from", "bot_list_discover");     // Catch: JSONException -> L9
        if (r100 == null) goto L6;
        r102.put("success", r100.longValue());     // Catch: JSONException -> L9
    L6:
        if (r101 == null) goto L11;
        r102.put("empty_data", r101.longValue());     // Catch: JSONException -> L9
    L11:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("refresh_bot_result");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L9:
        e = move-exception;
        FLogger.f375446a.e("RefreshEventHelper", "error in RefreshEventHelper refreshBotResult " + e.getLocalizedMessage());
        goto L11
    }
}
