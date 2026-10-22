package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.trace.tracknode.TraceFragment;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class d0 {
    public static void a(TraceFragment r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("click_sky_luck_entrance");
        if (r100 == null) goto L5;
        r103.f21464b = r100;
    L5:
        r103.f21463a.merge(r102);
        r103.b();
    }
}
