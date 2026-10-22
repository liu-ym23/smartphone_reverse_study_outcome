package bj2;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r2) {
        Intrinsics.checkNotNullParameter("ExplainPlaybackPresenter", LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r2, "message");
        dm.a.a("ExplainPlayback_ExplainPlaybackPresenter").a(r2);
    }

    public static void b(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r2, "message");
        dm.a.b r0 = dm.a.a;
        dm.a.a("ExplainPlayback_".concat(r1)).i(r2);
    }
}
