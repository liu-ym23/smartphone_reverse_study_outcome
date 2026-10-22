package com.ss.android.lark.widget.previewanimation.animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends ValueAnimator implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f448002g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.widget.previewanimation.animation.a f448003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f448004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f448005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f448006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f448007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f448008f;

    public static final class a {
    }

    static {
    }

    public d(com.ss.android.lark.widget.previewanimation.animation.a r100) {
        Intrinsics.checkNotNullParameter(r100, "animationContext");
        this.f448003a = r100;
        this.f448005c = 1;
        this.f448007e = 1.0f;
        this.f448008f = 400;
        addListener(this);
        addUpdateListener(this);
        addListener(r100);
        addUpdateListener(r100);
        setFloatValues(new float[]{1000.0f});
        setInterpolator(new DecelerateInterpolator());
    }

    public final void a(float r100) {
        this.f448004b = this.f448006d + (((r100 * this.f448007e) / 1000.0f) * this.f448005c);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        a(1000.0f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        a(1000.0f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        a(0.0f);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
        a(((Float) r101).floatValue());
    }
}
