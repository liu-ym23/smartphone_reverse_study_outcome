package com.bytedance.ee.bear.document.titlebar;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ImmersiveTitleBarBehavior extends CoordinatorLayout.Behavior<AppBarLayout> {
    public int a;
    public int b;
    public AppBarLayout c;
    public ObjectAnimator d;
    public ObjectAnimator e;
    public final int[] f;
    public final int[] g;
    public BaseTitlePlugin.a h;

    public final void onDetachedFromLayoutParams() {
        ObjectAnimator r0 = this.d;
        if (r0 == null) goto L5;
        r0.end();
        this.d.removeAllListeners();
    L8:
        ObjectAnimator r1 = this.e;
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.isRunning() == false) goto L15;
        this.e.removeAllListeners();
        this.e.cancel();
        return;
    L15:
        return;
    L5:
        AppBarLayout r2 = this.c;
        if (r2 == null) goto L8;
        r2.setVisibility(0);
        this.c.setAlpha(1.0f);
        goto L8
    }

    public ImmersiveTitleBarBehavior() {
        this.f = new int[2];
        this.g = new int[2];
    }

    public final boolean onStartNestedScroll(CoordinatorLayout r1, View r2, View r3, View r4, int r5, int r6) {
        AppBarLayout r7 = (AppBarLayout) r2;
        if ((r5 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void onNestedPreScroll(CoordinatorLayout r4, View r5, View r6, int r7, int r8, int[] r9, int r10) {
        AppBarLayout r11 = (AppBarLayout) r5;
        this.c = r11;
        if (this.a > 0) goto L6;
        this.a = ViewConfiguration.get(r11.getContext()).getScaledTouchSlop();
    L6:
        if (Math.abs(r7) <= Math.abs(r8)) goto L9;
        return;
    L9:
        if (Math.abs(this.b) > this.a) goto L11;
        this.b += r8;
        return;
    L11:
        if (r8 > 0) goto L13;
        if (r8 < 0) goto L32;
    L47:
        this.b = 0;
        return;
    L32:
        if (r11.getAlpha() >= 1.0f) goto L47;
        ObjectAnimator r12 = this.e;
        if (r12 == null) goto L39;
        if (r12.isRunning() == false) goto L39;
        this.e.cancel();
    L39:
        if (this.d != null) goto L42;
        this.d = ObjectAnimator.ofFloat(r11, "alpha", new float[]{0.0f, 1.0f}).setDuration(100);
    L42:
        if (this.d.getListeners() != null) goto L45;
        this.d.addListener(new c(this, r11));
    L45:
        if (this.d.isRunning() == true) goto L47;
        tt5.a.h("ImmersiveTitleBarBehavior", "start showAnimator");
        this.d.start();
        goto L47
    L13:
        if (r11.getAlpha() <= 0.0f) goto L47;
        r4.getLocationOnScreen(this.f);
        r6.getLocationOnScreen(this.g);
        if ((this.g[1] - this.f[1]) >= r11.getMeasuredHeight()) goto L47;
        ObjectAnimator r13 = this.d;
        if (r13 == null) goto L22;
        if (r13.isRunning() == false) goto L22;
        this.d.cancel();
    L22:
        if (this.e != null) goto L25;
        this.e = ObjectAnimator.ofFloat(r11, "alpha", new float[]{1.0f, 0.0f}).setDuration(100);
    L25:
        if (this.e.getListeners() != null) goto L28;
        this.e.addListener(new b(this, r11));
    L28:
        if (this.e.isRunning() == true) goto L47;
        tt5.a.h("ImmersiveTitleBarBehavior", "start hideAnimator");
        this.e.start();
        goto L47
    }
}
