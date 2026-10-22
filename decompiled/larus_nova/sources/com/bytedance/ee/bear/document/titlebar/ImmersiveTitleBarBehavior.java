package com.bytedance.ee.bear.document.titlebar;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes16.dex */
public class ImmersiveTitleBarBehavior extends CoordinatorLayout.Behavior<AppBarLayout> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f222122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f222123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppBarLayout f222124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObjectAnimator f222125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObjectAnimator f222126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f222127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f222128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BaseTitlePlugin.a f222129h;

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        ObjectAnimator r100 = this.f222125d;
        if (r100 == null) goto L5;
        r100.end();
        this.f222125d.removeAllListeners();
    L8:
        ObjectAnimator r101 = this.f222126e;
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.isRunning() == false) goto L15;
        this.f222126e.removeAllListeners();
        this.f222126e.cancel();
        return;
    L15:
        return;
    L5:
        AppBarLayout r102 = this.f222124c;
        if (r102 == null) goto L8;
        r102.setVisibility(0);
        this.f222124c.setAlpha(1.0f);
        goto L8
    }

    public ImmersiveTitleBarBehavior() {
        this.f222127f = new int[2];
        this.f222128g = new int[2];
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, View r101, View r102, View r103, int r104, int r105) {
        AppBarLayout r106 = (AppBarLayout) r101;
        if ((r104 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int[] r105, int r110) {
        AppBarLayout r106 = (AppBarLayout) r101;
        this.f222124c = r106;
        if (this.f222122a > 0) goto L6;
        this.f222122a = ViewConfiguration.get(r106.getContext()).getScaledTouchSlop();
    L6:
        if (Math.abs(r103) <= Math.abs(r104)) goto L9;
        return;
    L9:
        if (Math.abs(this.f222123b) > this.f222122a) goto L11;
        this.f222123b += r104;
        return;
    L11:
        if (r104 > 0) goto L13;
        if (r104 < 0) goto L32;
    L47:
        this.f222123b = 0;
        return;
    L32:
        if (r106.getAlpha() >= 1.0f) goto L47;
        ObjectAnimator r107 = this.f222126e;
        if (r107 == null) goto L39;
        if (r107.isRunning() == false) goto L39;
        this.f222126e.cancel();
    L39:
        if (this.f222125d != null) goto L42;
        this.f222125d = ObjectAnimator.ofFloat(r106, "alpha", new float[]{0.0f, 1.0f}).setDuration(100);
    L42:
        if (this.f222125d.getListeners() != null) goto L45;
        this.f222125d.addListener(new c(this, r106));
    L45:
        if (this.f222125d.isRunning() == true) goto L47;
        tt5.a.h("ImmersiveTitleBarBehavior", "start showAnimator");
        this.f222125d.start();
        goto L47
    L13:
        if (r106.getAlpha() <= 0.0f) goto L47;
        r100.getLocationOnScreen(this.f222127f);
        r102.getLocationOnScreen(this.f222128g);
        if ((this.f222128g[1] - this.f222127f[1]) >= r106.getMeasuredHeight()) goto L47;
        ObjectAnimator r108 = this.f222125d;
        if (r108 == null) goto L22;
        if (r108.isRunning() == false) goto L22;
        this.f222125d.cancel();
    L22:
        if (this.f222126e != null) goto L25;
        this.f222126e = ObjectAnimator.ofFloat(r106, "alpha", new float[]{1.0f, 0.0f}).setDuration(100);
    L25:
        if (this.f222126e.getListeners() != null) goto L28;
        this.f222126e.addListener(new b(this, r106));
    L28:
        if (this.f222126e.isRunning() == true) goto L47;
        tt5.a.h("ImmersiveTitleBarBehavior", "start hideAnimator");
        this.f222126e.start();
        goto L47
    }
}
