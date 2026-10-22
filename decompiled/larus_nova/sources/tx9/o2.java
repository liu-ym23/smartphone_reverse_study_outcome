package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class o2 {
    public static void b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        TrackParams r101 = new TrackParams().merge(r100);
        by7.a r102 = new by7.a("click_broadcast_news_play");
        r102.f21463a.merge(r101);
        r102.b();
    }

    public static void a(Long r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100 != null) goto L10;
    L8:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("click_broadcast_news_pause");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L10:
        r101.put("duration", r100.longValue());     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        FLogger.f375446a.e("NewsEventHelper", "error in NewsEventHelper clickBroadcastNewsPause " + e.getLocalizedMessage());
        goto L8
    }
}
