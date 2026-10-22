package com.larus.dora.obric.onboarding;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Typeface;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes27.dex */
public final class e0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f340846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ObricDoraGOnboardingTopicView f340847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f340848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f340849d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f340846a.element = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f340846a.element == true) goto L6;
        ObricDoraGOnboardingTopicView r101 = this.f340847b;
        int r102 = this.f340848c;
        boolean r103 = this.f340849d;
        Typeface r104 = ObricDoraGOnboardingTopicView.F;
        r101.f(r102, r103);
        return;
    }

    public e0(Ref.BooleanRef r100, ObricDoraGOnboardingTopicView r101, int r102, boolean r103) {
        this.f340846a = r100;
        this.f340847b = r101;
        this.f340848c = r102;
        this.f340849d = r103;
    }
}
