package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class p0 {
    public static void a(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        if (r100 != null) goto L13;
    L7:
        if (r101 == null) goto L11;
        r102.put("reason", r101);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("DeepResearchEventHelper", "error in DeepResearchEventHelper mobEndDeepSearch " + e.getLocalizedMessage());
    L11:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("end_deep_research");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L13:
        r102.put("deep_research_id", r100);     // Catch: JSONException -> L5
        goto L7
    }
}
