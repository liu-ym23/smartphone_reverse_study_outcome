package com.ss.android.lark.keyboard.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.animation.PathInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class k extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoundedIconTextView f431051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f431052b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        RoundedIconTextView r101 = this.f431051a;
        float r102 = this.f431052b;
        PathInterpolator r103 = RoundedIconTextView.F;
        r101.b(r102);
    }

    public k(RoundedIconTextView r100, float r101) {
        this.f431051a = r100;
        this.f431052b = r101;
    }
}
