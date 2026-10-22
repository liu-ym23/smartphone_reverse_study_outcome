package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements View.OnLayoutChangeListener {
    public final /* synthetic */ MoreVideoComponent a;

    public k(MoreVideoComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        MoreVideoComponent.b r10 = MoreVideoComponent.i2(this.a);
        if (r10 == null) goto L5;
        r10.setAlpha(1.0f);
    L5:
        r1.setTranslationX(r1.getWidth() + com.bytedance.android.shopping.extensions.b.a(12));
        r1.animate().translationX(0.0f).setDuration(1000).start();
    }
}
