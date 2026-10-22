package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.view.View;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ View a;
    public final /* synthetic */ PdpRootComponent b;

    public w(View r1, PdpRootComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r3) {
        float r4 = ((Number) r3).floatValue();
        PdpRootComponent r0 = this.b;
        View r1 = this.a;
        r0.getClass();
        r1.setAlpha(1.0f - (1.0f - RangesKt.coerceAtLeast(0.0f, r4)));
    }
}
