package com.obric.assistant.omnidetailpage.blockview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.obric.assistant.card.databinding.ObricOmniBlockLocalSearchBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class s extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocalSearchResultView f390714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ObricOmniBlockLocalSearchBinding f390715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f390716c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationCancel(r100);
        this.f390714a.f390562f = null;
        LocalSearchResultView.c(this.f390715b, this.f390716c);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        this.f390714a.f390562f = null;
        LocalSearchResultView.c(this.f390715b, this.f390716c);
    }

    public s(LocalSearchResultView r100, ObricOmniBlockLocalSearchBinding r101, boolean r102) {
        this.f390714a = r100;
        this.f390715b = r101;
        this.f390716c = r102;
    }
}
