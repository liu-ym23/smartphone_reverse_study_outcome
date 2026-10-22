package com.ss.android.ugc.tools.view.widget;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes40.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f455133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f455134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CircularProgressView f455135c;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        CircularProgressView r101 = this.f455135c;
        r101.f455020q = ((Float) r100.getAnimatedValue()).floatValue();
        CircularProgressView r102 = this.f455135c;
        r102.f455013j = (this.f455133a - r102.f455020q) + this.f455134b;
        r102.invalidate();
    }

    public c(CircularProgressView r100, float r101, float r102) {
        this.f455135c = r100;
        this.f455133a = r101;
        this.f455134b = r102;
    }
}
