package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ PdpRootComponent b;

    public y(Function1 r1, PdpRootComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r2) {
        boolean r3 = ((Boolean) r2).booleanValue();
        this.b.O1().getContainerAbility().e(r3);
        if (r3 == false) goto L6;
        this.a.invoke(0);
        return;
    }
}
