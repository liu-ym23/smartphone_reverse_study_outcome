package com.ss.android.ugc.tools.view.widget;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes40.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CircularProgressView f455136a;

    public d(CircularProgressView r100) {
        this.f455136a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        CircularProgressView r101 = this.f455136a;
        r101.f455014k = ((Float) r100.getAnimatedValue()).floatValue();
    }
}
