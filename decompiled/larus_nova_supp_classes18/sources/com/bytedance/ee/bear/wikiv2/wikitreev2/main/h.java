package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.view.MotionEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class h implements WikiCoverCoordinatorLayout.a {
    public final /* synthetic */ l a;

    public /* synthetic */ h(l r1) {
        this.a = r1;
    }

    public final boolean a(MotionEvent r6) {
        l r0 = this.a;
        r0.getClass();
        float r1 = r6.getY() - r0.k.y;
        float r2 = r6.getX() - r0.k.x;
        if (r6.getAction() == 2) goto L5;
    L11:
        r0.k.x = r6.getX();
        r0.k.y = r6.getY();
        return false;
    L5:
        if (r0.i != 0) goto L11;
        if (r1 <= r0.h.getScaledTouchSlop()) goto L11;
        if (r1 <= Math.abs(r2)) goto L11;
        return true;
    }
}
