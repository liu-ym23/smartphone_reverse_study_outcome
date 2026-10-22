package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.view.View;
import android.webkit.WebView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FooterBehavior extends CoordinatorLayout.Behavior<View> {
    public final a a;
    public volatile boolean b;
    public final l c;

    public interface a {
        void a();

        boolean n0();
    }

    public final boolean onStartNestedScroll(CoordinatorLayout r1, View r2, View r3, View r4, int r5) {
        if (r5 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.drive.view.preview.wrapper.l] */
    public FooterBehavior(a r2) {
        this.b = false;
        this.c = new l(this);
        this.a = r2;
    }

    public final void onNestedScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int r6, int r7) {
        if (this.b == false) goto L5;
        return;
    L5:
        tt5.a.h("FooterBehavior", "dyConsumed= " + r5 + ", dyUnconsumed " + r7 + ",target =" + r3);
        if ((r3 instanceof WebView) == false) goto L16;
        if (r7 <= 1) goto L12;
        r3.getContext();
        if (this.a.n0() == true) goto L25;
        this.b = true;
        this.a.a();
    L25:
        if (this.b == true) goto L27;
        return;
    L27:
        if (com.bytedance.ee.util.ui.j.a(this.c) == true) goto L31;
        com.bytedance.ee.util.ui.j.d(this.c, 150);
        return;
    L31:
        return;
    L12:
        if (r7 >= (-1)) goto L25;
        r3.getContext();
        if (this.a.n0() == false) goto L25;
        this.b = true;
        this.a.a();
        goto L25
    L16:
        if (r5 <= 0) goto L20;
        r3.getContext();
        if (this.a.n0() == true) goto L25;
        this.b = true;
        this.a.a();
        goto L25
    L20:
        if (r5 >= 0) goto L25;
        r3.getContext();
        if (this.a.n0() == false) goto L25;
        this.b = true;
        this.a.a();
        goto L25
    }
}
