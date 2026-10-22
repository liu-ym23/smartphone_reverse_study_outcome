package com.obric.oui.titlebar.behavior;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.obric.oui.titlebar.OUnitedTitleBar;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f403519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OUnitedTitleBar f403520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseBehavior f403521c;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        this.f403521c.setHeaderTopBottomOffset(this.f403519a, this.f403520b, ((Integer) r100.getAnimatedValue()).intValue());
    }

    public a(BaseBehavior r100, CoordinatorLayout r101, OUnitedTitleBar r102) {
        this.f403521c = r100;
        this.f403519a = r101;
        this.f403520b = r102;
    }
}
