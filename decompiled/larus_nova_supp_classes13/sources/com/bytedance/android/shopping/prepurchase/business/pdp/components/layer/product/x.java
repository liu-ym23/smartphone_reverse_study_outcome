package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class x implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ ProductDetailInfoComponent a;
    public final /* synthetic */ vg3.e b;
    public final /* synthetic */ int c;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Integer r0 = Integer.valueOf(this.b.d1());
        if (r0.intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L11;
        int r2 = r0.intValue();
    L12:
        int r3 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) this.a.O1().f().b).b.b - r2;
        int r4 = ProductDetailInfoComponent.h2(this.a).getHeight() - r3;
        int r5 = ProductDetailInfoComponent.h2(this.a).getPaddingBottom();
        if (r3 <= 0) goto L20;
        if (r4 > 0) goto L16;
        return;
    L16:
        if (this.b.Q0() == false) goto L22;
        if (r4 == r5) goto L23;
        this.a.k2(r4);
        return;
    L23:
        return;
    L22:
        return;
    L20:
        return;
    L11:
        r2 = this.c;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    public x(ProductDetailInfoComponent r1, vg3.e r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
