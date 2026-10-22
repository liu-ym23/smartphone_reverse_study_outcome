package com.bytedance.android.shopping.new_cart.container;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ ViewTreeObserver a;
    public final /* synthetic */ CartDialogFragment b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        CartDialogFragment r0 = this.b;
        com.bytedance.kmp.ec.yata.common.perf.c r1 = CartDialogFragment.R;
        com.bytedance.android.shopping.new_cart.components.f r2 = (com.bytedance.android.shopping.new_cart.components.f) r0.m.getValue();
        if (r2 == null) goto L5;
        Integer r3 = Integer.valueOf(r2.n());
    L6:
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.intValue() > 0) goto L10;
        return;
    L10:
        if (this.a.isAlive() == false) goto L12;
        this.a.removeOnGlobalLayoutListener(this);
    L12:
        LinearLayout r4 = this.b.E;
        if (r4 == null) goto L20;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L21;
        r5.height = r3.intValue();
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public e(ViewTreeObserver r1, CartDialogFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
