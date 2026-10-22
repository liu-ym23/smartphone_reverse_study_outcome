package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements com.bytedance.android.shopping.prepurchase.arch.container.aware.a {
    public final AtomicBoolean a;
    public final com.bytedance.android.shopping.prepurchase.arch.container.aware.a b;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void t() {
        if (this.a.compareAndSet(false, true) == false) goto L6;
        this.b.t();
        return;
    }

    public b(com.bytedance.android.shopping.prepurchase.arch.container.aware.a r2) {
        Intrinsics.checkNotNullParameter(r2, "contentQueryListener");
        this.b = r2;
        this.a = new AtomicBoolean(false);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void u(com.bytedance.android.shopping.prepurchase.arch.container.intf.k.a r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        if (this.a.compareAndSet(true, false) == false) goto L6;
        this.b.u(r4);
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void v(com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        if (this.a.compareAndSet(true, false) == false) goto L6;
        this.b.v(r4);
        return;
    }
}
