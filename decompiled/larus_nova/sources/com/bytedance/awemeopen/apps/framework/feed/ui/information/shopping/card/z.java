package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class z extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f196468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f196469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y f196470c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f196468a.setAlpha(0.0f);
        LinearLayout r101 = this.f196469b;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.height = -2;
        r101.setLayoutParams(r102);
        this.f196469b.requestLayout();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f196468a.getVisibility() == 0) goto L5;
        return;
    L5:
        this.f196468a.setAlpha(1.0f);
        LinearLayout r101 = this.f196469b;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.height = -2;
        r101.setLayoutParams(r102);
        this.f196469b.requestLayout();
        this.f196468a.requestLayout();
        this.f196470c.f196465u = null;
    }

    public z(LinearLayout r100, LinearLayout r101, y r102) {
        this.f196468a = r100;
        this.f196469b = r101;
        this.f196470c = r102;
    }
}
