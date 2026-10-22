package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f210418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeBaseMainHeaderAppBarBehavior f210419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f210420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f210421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f210422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f210423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f210424g;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f210418a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        r100.removeListener(this);
        OfficeBaseMainHeaderAppBarBehavior r101 = this.f210419b;
        if (r101.f210315c != r100) goto L6;
        r101.f210315c = null;
    L6:
        if (this.f210418a == false) goto L8;
        return;
    L8:
        this.f210420c.setVisibility(0);
        this.f210421d.setVisibility(0);
        this.f210421d.setTranslationY(0.0f);
        this.f210421d.setAlpha(1.0f);
        int r102 = this.f210422e;
        if (r102 > 0) goto L11;
    L13:
        this.f210423f.requestLayout();
        this.f210424g.dispatchDependentViewsChanged(this.f210423f);
        return;
    L11:
        if (r102 != this.f210419b.f210314b) goto L13;
        View r103 = this.f210420c;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        r104.height = -2;
        r103.setLayoutParams(r104);
        goto L13
    }

    public g(OfficeBaseMainHeaderAppBarBehavior r100, View r101, View r102, int r103, AppBarLayout r104, CoordinatorLayout r105) {
        this.f210419b = r100;
        this.f210420c = r101;
        this.f210421d = r102;
        this.f210422e = r103;
        this.f210423f = r104;
        this.f210424g = r105;
    }
}
