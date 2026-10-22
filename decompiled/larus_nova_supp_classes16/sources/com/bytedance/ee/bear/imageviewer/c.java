package com.bytedance.ee.bear.imageviewer;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.ee.bear.widgets.SwipeControlViewPager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ int d;
    public final /* synthetic */ float e;
    public final /* synthetic */ int f;

    public c(SwipeControlViewPager r1, float r2, float r3, int r4, float r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        Object r6 = r5.getAnimatedValue();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Float");
        float r7 = ((Float) r6).floatValue();
        this.a.setPivotX(0.0f);
        this.a.setPivotY(0.0f);
        View r0 = this.a;
        float r1 = this.b;
        r0.setScaleX(r1 + ((1.0f - r1) * r7));
        View r2 = this.a;
        r2.setScaleY(r2.getScaleX());
        float r8 = -(1.0f - r7);
        this.a.setTranslationX((this.c - this.d) * r8);
        this.a.setTranslationY(r8 * (this.e - this.f));
    }
}
