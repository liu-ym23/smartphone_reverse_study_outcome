package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeBaseMainHeaderAppBarBehavior f210413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f210414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f210415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f210416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View f210417e;

    public f(OfficeBaseMainHeaderAppBarBehavior r100, CoordinatorLayout r101, AppBarLayout r102, View r103, View r104) {
        this.f210413a = r100;
        this.f210414b = r101;
        this.f210415c = r102;
        this.f210416d = r103;
        this.f210417e = r104;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        OfficeBaseMainHeaderAppBarBehavior r101 = this.f210413a;
        CoordinatorLayout r102 = this.f210414b;
        AppBarLayout r103 = this.f210415c;
        View r104 = this.f210416d;
        View r105 = this.f210417e;
        Object r106 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Int");
        int r107 = ((Integer) r106).intValue();
        int r108 = OfficeBaseMainHeaderAppBarBehavior.f210312e;
        r101.a(r102, r103, r104, r105, r107, true);
    }
}
