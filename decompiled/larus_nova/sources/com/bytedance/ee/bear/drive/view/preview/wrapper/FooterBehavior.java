package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.view.View;
import android.webkit.WebView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes16.dex */
public class FooterBehavior extends CoordinatorLayout.Behavior<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f225725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f225726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f225727c;

    public interface a {
        void a();

        boolean n0();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, View r101, View r102, View r103, int r104) {
        if (r104 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.drive.view.preview.wrapper.l] */
    public FooterBehavior(a r100) {
        this.f225726b = false;
        this.f225727c = new l(this);
        this.f225725a = r100;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int r105, int r106) {
        if (this.f225726b == false) goto L5;
        return;
    L5:
        tt5.a.h("FooterBehavior", "dyConsumed= " + r104 + ", dyUnconsumed " + r106 + ",target =" + r102);
        if ((r102 instanceof WebView) == false) goto L16;
        if (r106 <= 1) goto L12;
        r102.getContext();
        if (this.f225725a.n0() == true) goto L25;
        this.f225726b = true;
        this.f225725a.a();
    L25:
        if (this.f225726b == true) goto L27;
        return;
    L27:
        if (com.bytedance.ee.util.ui.j.a(this.f225727c) == true) goto L31;
        com.bytedance.ee.util.ui.j.d(this.f225727c, 150);
        return;
    L31:
        return;
    L12:
        if (r106 >= (-1)) goto L25;
        r102.getContext();
        if (this.f225725a.n0() == false) goto L25;
        this.f225726b = true;
        this.f225725a.a();
        goto L25
    L16:
        if (r104 <= 0) goto L20;
        r102.getContext();
        if (this.f225725a.n0() == true) goto L25;
        this.f225726b = true;
        this.f225725a.a();
        goto L25
    L20:
        if (r104 >= 0) goto L25;
        r102.getContext();
        if (this.f225725a.n0() == false) goto L25;
        this.f225726b = true;
        this.f225725a.a();
        goto L25
    }
}
