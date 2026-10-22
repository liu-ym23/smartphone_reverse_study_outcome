package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ ShopSlicedProductCardPresenter a;

    public e0(ShopSlicedProductCardPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        ShopSlicedProductCardPresenter r10 = this.a;
        com.bytedance.android.ec.store.repository.vo.l r11 = ((sm.l) r10).k;
        if (r11 == null) goto L5;
        ((sm.l) r10).g.e(r11);
    L5:
        ShopSlicedProductCardPresenter r12 = this.a;
        com.bytedance.android.ecom.arch.slice.render.r r13 = r12.p;
        if (r13 == null) goto L11;
        View r14 = r13.c;
        if (r14 == null) goto L12;
        r14.removeOnLayoutChangeListener(r12.n);
        return;
    L12:
        return;
    }
}
