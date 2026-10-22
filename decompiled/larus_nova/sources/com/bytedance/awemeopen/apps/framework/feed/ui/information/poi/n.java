package com.bytedance.awemeopen.apps.framework.feed.ui.information.poi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class n extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f196297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f196298b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f196297a.setAlpha(0.0f);
        ViewGroup r101 = this.f196298b.k();
        ViewGroup.LayoutParams r102 = this.f196298b.k().getLayoutParams();
        r102.height = -2;
        r101.setLayoutParams(r102);
        this.f196298b.k().requestLayout();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f196297a.getVisibility() == 0) goto L5;
        return;
    L5:
        this.f196297a.setAlpha(1.0f);
        ViewGroup r101 = this.f196298b.k();
        ViewGroup.LayoutParams r102 = this.f196298b.k().getLayoutParams();
        r102.height = -2;
        r101.setLayoutParams(r102);
        this.f196298b.k().requestLayout();
        this.f196297a.requestLayout();
    }

    public n(ViewGroup r100, m r101) {
        this.f196297a = r100;
        this.f196298b = r101;
    }
}
