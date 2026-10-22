package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ BaseInfoServiceSnapshotTransitionController a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        BaseInfoServiceSnapshotTransitionController r0 = this.a;
        BaseInfoServiceSnapshotTransitionController.f r1 = r0.b;
        if (r1 == null) goto L7;
        r0.m(r1);
        return true;
    L7:
        return true;
    }

    public a(BaseInfoServiceSnapshotTransitionController r1) {
        this.a = r1;
    }
}
