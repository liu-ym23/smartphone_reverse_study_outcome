package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ValueAnimator a;
    public final /* synthetic */ WindowManager b;
    public final /* synthetic */ ECDraweeView c;
    public final /* synthetic */ WindowManager.LayoutParams d;

    public c(ValueAnimator r1, WindowManager r2, ECDraweeView r3, WindowManager.LayoutParams r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r6) {
        Object r7 = this.a.getAnimatedValue();     // Catch: Throwable -> L10
        if (r7 == null) goto L9;
        Point r8 = (Point) r7;     // Catch: Throwable -> L10
        float r0 = 1 - this.a.getAnimatedFraction();     // Catch: Throwable -> L10
        WindowManager r1 = this.b;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        View r2 = this.c;     // Catch: Throwable -> L10
        WindowManager.LayoutParams r3 = this.d;     // Catch: Throwable -> L10
        r3.x = r8.x;     // Catch: Throwable -> L10
        r3.y = r8.y;     // Catch: Throwable -> L10
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r1.updateViewLayout(r2, r3);     // Catch: Throwable -> L10
    L7:
        this.c.setAlpha(r0);     // Catch: Throwable -> L10
        this.c.setScaleX(0.3f - (this.a.getAnimatedFraction() * 0.25f));     // Catch: Throwable -> L10
        this.c.setScaleY(0.3f - (this.a.getAnimatedFraction() * 0.25f));     // Catch: Throwable -> L10
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Point");     // Catch: Throwable -> L10
    L10:
        this.c.setVisibility(4);
    }
}
