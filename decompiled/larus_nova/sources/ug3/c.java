package ug3;

import com.bytedance.android.shopping.anchorv4.voavhs.lynx.d;
import com.bytedance.android.shopping.prepurchase.arch.container.component.j;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;
import vg3.m;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f549991a;

    public c(j r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        this.f549991a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.lynx.d
    public final void a(com.bytedance.android.shopping.anchorv4.log.c r100) {
        Intrinsics.checkNotNullParameter(r100, "watcher");
        m r101 = (m) this.f549991a.getService(m.class);
        if (r101 == null) goto L6;
        r101.N0(r100);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.lynx.d
    public final void b(com.bytedance.android.shopping.anchorv4.log.d r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "watcher");
        Intrinsics.checkNotNullParameter(r101, LocationMonitorConst.IDENTIFIER);
        m r102 = (m) this.f549991a.getService(m.class);
        if (r102 == null) goto L6;
        r102.y(r100, r101, 0);
        return;
    }
}
