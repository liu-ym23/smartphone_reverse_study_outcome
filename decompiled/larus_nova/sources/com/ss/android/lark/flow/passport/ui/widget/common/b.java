package com.ss.android.lark.flow.passport.ui.widget.common;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CodeView f423838a;

    public b(CodeView r100) {
        this.f423838a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        if (r100.getAnimatedFraction() >= 0.5d) goto L5;
        this.f423838a.f423803b.setBackgroundColor(0);
        return;
    L5:
        CodeView r101 = this.f423838a;
        r101.f423803b.setBackgroundColor(r101.f423805d.f423809c);
    }
}
