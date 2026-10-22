package ug3;

import com.bytedance.android.shopping.anchorv4.voavhs.lynx.d;
import com.bytedance.android.shopping.prepurchase.arch.container.component.j;
import kotlin.jvm.internal.Intrinsics;
import vg3.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements d {
    public final j a;

    public c(j r2) {
        Intrinsics.checkNotNullParameter(r2, "registry");
        this.a = r2;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.lynx.d
    public final void a(com.bytedance.android.shopping.anchorv4.log.c r3) {
        Intrinsics.checkNotNullParameter(r3, "watcher");
        m r0 = (m) this.a.getService(m.class);
        if (r0 == null) goto L6;
        r0.N0(r3);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.lynx.d
    public final void b(com.bytedance.android.shopping.anchorv4.log.d r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "watcher");
        Intrinsics.checkNotNullParameter(r4, "identifier");
        m r0 = (m) this.a.getService(m.class);
        if (r0 == null) goto L6;
        r0.y(r3, r4, 0);
        return;
    }
}
