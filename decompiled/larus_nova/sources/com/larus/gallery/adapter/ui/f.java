package com.larus.gallery.adapter.ui;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f343767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f343768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f343769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f343770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BaseScaleGalleryView f343771e;

    public f(BaseScaleGalleryView r100) {
        this.f343771e = r100;
        this.f343767a = r100.getScalableView().getWidth();
        this.f343768b = r100.getScalableView().getHeight();
        FrameLayout.LayoutParams r101 = r100.f343748t;
        this.f343769c = r101.width;
        this.f343770d = r101.height;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
        float r102 = ((Float) r101).floatValue();
        int r103 = this.f343767a;
        int r104 = r103 + ((int) ((this.f343769c - r103) * r102));
        int r105 = this.f343768b;
        int r106 = r105 + ((int) ((this.f343770d - r105) * r102));
        ViewGroup.LayoutParams r107 = this.f343771e.getScalableView().getLayoutParams();
        r107.width = r104;
        r107.height = r106;
        this.f343771e.getScalableView().setLayoutParams(r107);
        this.f343771e.i(1.0f - r102, false);
    }
}
