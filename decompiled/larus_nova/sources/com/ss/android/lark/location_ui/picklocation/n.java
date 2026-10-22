package com.ss.android.lark.location_ui.picklocation;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes36.dex */
public final class n implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationView f431272a;

    public n(LocationView r100) {
        this.f431272a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        this.f431272a.mIvLocationIcon.invalidate();
    }
}
