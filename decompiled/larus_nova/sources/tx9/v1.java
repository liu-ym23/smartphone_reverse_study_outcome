package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class v1 {
    public static void a(String r100, String r101, int r102, String r103, int r104) {
        JSONObject r105 = null;
        if ((r104 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r104 & 16) == 0) goto L8;
        r105 = new JSONObject();
    L8:
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r105, "params");
        r105.put("scene", r100);     // Catch: JSONException -> L13
        r105.put(com.alipay.sdk.m.p.e.f25671s, r101);     // Catch: JSONException -> L13
        r105.put("result", r102);     // Catch: JSONException -> L13
        if (r103 == null) goto L15;
        r105.put("error_msg", r103);     // Catch: JSONException -> L13
    L15:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("jump_luna_triggered");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L13:
        e = move-exception;
        FLogger.f375446a.e("LunaEventHelper", "error in LunaEventHelper mobJumpLunaTriggered " + e.getLocalizedMessage());
        goto L15
    }
}
