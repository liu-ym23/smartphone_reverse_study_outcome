package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class h implements WikiCoverCoordinatorLayout.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f241562a;

    public /* synthetic */ h(l r100) {
        this.f241562a = r100;
    }

    public final boolean a(MotionEvent r100) {
        l r101 = this.f241562a;
        r101.getClass();
        float r102 = r100.getY() - r101.f241577k.y;
        float r103 = r100.getX() - r101.f241577k.x;
        if (r100.getAction() == 2) goto L5;
    L11:
        r101.f241577k.x = r100.getX();
        r101.f241577k.y = r100.getY();
        return false;
    L5:
        if (r101.f241575i != 0) goto L11;
        if (r102 <= r101.f241574h.getScaledTouchSlop()) goto L11;
        if (r102 <= Math.abs(r103)) goto L11;
        return true;
    }
}
