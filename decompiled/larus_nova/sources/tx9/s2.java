package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class s2 {
    public static void a(String r100, by7.e r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        JSONObject r103 = new JSONObject();
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = null;
    L12:
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r100 != null) goto L23;
    L18:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("personal_info_pv");
        if (r101 == null) goto L21;
        r105.f21464b = r101;
    L21:
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L23:
        r103.put("previous_page", r100);     // Catch: JSONException -> L16
    L16:
        e = move-exception;
        FLogger.f375446a.e("PersonalEventHelper", "error in PersonalEventHelper personalInfoPv " + e.getLocalizedMessage());
        goto L18
    L8:
        r103 = null;
        goto L10
    }
}
