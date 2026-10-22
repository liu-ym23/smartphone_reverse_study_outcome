package com.bytedance.ee.bear.imageviewer;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.ee.bear.widgets.SwipeControlViewPager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f226814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f226815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f226816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f226817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f226818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f226819f;

    public c(SwipeControlViewPager r100, float r101, float r102, int r103, float r104, int r105) {
        this.f226814a = r100;
        this.f226815b = r101;
        this.f226816c = r102;
        this.f226817d = r103;
        this.f226818e = r104;
        this.f226819f = r105;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
        float r102 = ((Float) r101).floatValue();
        this.f226814a.setPivotX(0.0f);
        this.f226814a.setPivotY(0.0f);
        View r103 = this.f226814a;
        float r104 = this.f226815b;
        r103.setScaleX(r104 + ((1.0f - r104) * r102));
        View r105 = this.f226814a;
        r105.setScaleY(r105.getScaleX());
        float r106 = -(1.0f - r102);
        this.f226814a.setTranslationX((this.f226816c - this.f226817d) * r106);
        this.f226814a.setTranslationY(r106 * (this.f226818e - this.f226819f));
    }
}
