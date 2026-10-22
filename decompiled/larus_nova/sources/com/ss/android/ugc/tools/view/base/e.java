package com.ss.android.ugc.tools.view.base;

import android.animation.ValueAnimator;
import com.ss.android.ugc.aweme.transition.EmptyTransition;
import com.ss.android.ugc.aweme.transition.ITransition;
import com.ss.android.ugc.aweme.transition.TransitionListener;

/* JADX INFO: loaded from: classes40.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f454884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f454885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ITransition f454886c;

    public e(d r100, int r101, EmptyTransition r102) {
        this.f454884a = r100;
        this.f454885b = r101;
        this.f454886c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        float r101 = r100.getAnimatedFraction();
        int r102 = this.f454885b;
        TransitionListener r103 = this.f454884a.f454877a;
        if (r103 == null) goto L5;
        r103.h();
    L5:
        this.f454884a.f454880d.setTranslationY((r102 + 0) * r101);
        this.f454884a.f454880d.setAlpha(1 - r101);
        ITransition r104 = this.f454886c;
        if (r104 == null) goto L9;
        r104.h();
        return;
    }
}
