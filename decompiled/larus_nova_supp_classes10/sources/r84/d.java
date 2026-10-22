package r84;

import android.util.Log;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdnavigationsdk.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements e {
    public d() {
    }

    public static void a(String r0, Throwable r1) {
        if (r1 == null) goto L5;
        Log.getStackTraceString(r1);
        return;
    }

    @Override // com.bytedance.bdnavigationsdk.e
    public final void w(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter("BDNAAppContext 尝试重复初始化，但使用的不是同一个 Application Context", "msg");
        a("BDNAAppContext 尝试重复初始化，但使用的不是同一个 Application Context", r3);
    }

    @Override // com.bytedance.bdnavigationsdk.e
    public final void d(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "msg");
        a(r3, r4);
    }

    @Override // com.bytedance.bdnavigationsdk.e
    public final void e(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "msg");
        a(r3, r4);
    }

    @Override // com.bytedance.bdnavigationsdk.e
    public final void i(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "msg");
        a(r3, r4);
    }
}
