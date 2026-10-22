package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class x<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ PdpRootComponent b;

    public x(Function1 r1, PdpRootComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r3) {
        this.a.invoke(Integer.valueOf((int) (RangesKt.coerceAtLeast(0.0f, 1.0f - RangesKt.coerceAtLeast(0.0f, ((Number) r3).floatValue())) * this.b.n)));
    }
}
