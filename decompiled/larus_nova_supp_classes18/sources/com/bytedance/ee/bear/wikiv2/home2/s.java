package com.bytedance.ee.bear.wikiv2.home2;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ WikiHomeRecentSpaceView a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        WikiHomeRecentSpaceView r0 = this.a;
        if (r0.c == null) goto L9;
        r0.getListRecyclerViewFromXml().getViewTreeObserver().removeOnPreDrawListener(this);
        WikiHomeRecentSpaceView.b r1 = this.a.k;
        if (r1 == null) goto L10;
        r1.L2();
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    public s(WikiHomeRecentSpaceView r1) {
        this.a = r1;
    }
}
