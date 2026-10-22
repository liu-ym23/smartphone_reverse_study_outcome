package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ PdpDataFetchService a;

    public l(PdpDataFetchService r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r4) {
        com.bytedance.android.shopping.prepurchase.arch.container.intf.k r5 = (com.bytedance.android.shopping.prepurchase.arch.container.intf.k) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.c(this.a, "select dataState = " + r5);
    }
}
