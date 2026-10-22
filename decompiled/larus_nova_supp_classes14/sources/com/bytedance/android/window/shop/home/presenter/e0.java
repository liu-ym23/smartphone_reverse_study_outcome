package com.bytedance.android.window.shop.home.presenter;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ CoordinatorLayout.Behavior a;
    public final /* synthetic */ CoordinatorLayout b;
    public final /* synthetic */ AppBarLayout c;

    public e0(CoordinatorLayout.Behavior r1, CoordinatorLayout r2, AppBarLayout r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Object r0 = null;
        if (r4 == null) goto L5;
        Object r5 = r4.getAnimatedValue();
    L7:
        if ((r5 instanceof Integer) == false) goto L10;
        r0 = r5;
    L10:
        Integer r1 = (Integer) r0;
        if (r1 == null) goto L14;
        this.a.snapTo(r1.intValue(), this.b, this.c);
        return;
    L14:
        return;
    L5:
        r5 = null;
        goto L7
    }
}
