package tx9;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class x0 {
    public static void a(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("scene", r100);
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("spring_client_downgrade_toast");
        r103.f21463a.merge(r102);
        r103.b();
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("spring_client_downgrade_toast", r101, null, null);
    }
}
