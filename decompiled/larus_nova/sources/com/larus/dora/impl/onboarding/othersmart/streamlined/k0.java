package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class k0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f337277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f337278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DoraHStreamlinedWakeupFragment f337279c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ImageView r101 = this.f337277a;
        r101.setTranslationX(this.f337278b - r101.getLeft());
        this.f337279c.C = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ImageView r101 = this.f337277a;
        r101.setTranslationX(this.f337278b - r101.getLeft());
        this.f337279c.C = null;
    }

    public k0(ImageView r100, float r101, DoraHStreamlinedWakeupFragment r102) {
        this.f337277a = r100;
        this.f337278b = r101;
        this.f337279c = r102;
    }
}
