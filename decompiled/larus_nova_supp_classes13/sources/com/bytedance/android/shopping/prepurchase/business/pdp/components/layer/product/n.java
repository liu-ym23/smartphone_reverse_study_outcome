package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ d c;

    @Override // java.lang.Runnable
    public final void run() {
        d r0 = this.c;
        BaseInfoServiceSnapshotTransitionController r1 = r0.b;
        if (r1 == null) goto L6;
        r1.i(Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r0.m)).b.d.a(), Boolean.TRUE));
        return;
    }

    public n(d r1) {
        this.c = r1;
        super("prepare_base_info_service_snapshot");
    }
}
