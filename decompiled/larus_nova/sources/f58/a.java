package f58;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class a {
    public static void a(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("interact_type", r100);     // Catch: Exception -> L5
    L7:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("edit_box_interact");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("EditBoxInteractEventHelper", "error in EditBoxInteractEventHelper mobEditBoxInteractEvent " + e.getLocalizedMessage());
        goto L7
    }
}
