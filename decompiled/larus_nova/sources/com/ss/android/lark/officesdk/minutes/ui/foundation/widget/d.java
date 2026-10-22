package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmSummaryLoadingTextView f435751a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    public d(MmSummaryLoadingTextView r100) {
        this.f435751a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        this.f435751a.f435715b.setVisibility(4);
        MmSummaryLoadingTextView r101 = this.f435751a;
        if (r101.f435718e == false) goto L8;
        e r102 = r101.f435717d;
        if (r102 == null) goto L9;
        r101.postDelayed(r102, r101.f435719f);
        return;
    L9:
        return;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        this.f435751a.f435715b.setVisibility(0);
    }
}
