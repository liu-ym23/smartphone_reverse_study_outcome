package com.larus.dora.obric.onboarding;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes27.dex */
public final class d0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f340841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ObricDoraGOnboardingTopicView f340842b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f340841a.element = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f340841a.element == true) goto L6;
        ObricDoraGOnboardingTopicView r101 = this.f340842b;
        r101.f340750t = null;
        ObricDoraGOnboardingTopicView.b(r101);
        this.f340842b.p();
        this.f340842b.d();
        this.f340842b.f340744n = false;
        return;
    }

    public d0(Ref.BooleanRef r100, ObricDoraGOnboardingTopicView r101) {
        this.f340841a = r100;
        this.f340842b = r101;
    }
}
