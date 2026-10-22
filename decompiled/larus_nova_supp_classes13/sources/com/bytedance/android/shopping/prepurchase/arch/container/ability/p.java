package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p implements k, com.bytedance.android.shopping.prepurchase.arch.container.intf.i {
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.i a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.i
    public final void ensureNotReachHere(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        this.a.ensureNotReachHere(r2);
    }

    public p(com.bytedance.android.shopping.prepurchase.arch.container.intf.i r2) {
        Intrinsics.checkNotNullParameter(r2, "monitorService");
        this.a = r2;
    }
}
