package com.bytedance.ee.bear.wikiv2.home2;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes18.dex */
public final class s implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiHomeRecentSpaceView f240950a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        WikiHomeRecentSpaceView r100 = this.f240950a;
        if (r100.f240811c == null) goto L9;
        r100.getListRecyclerViewFromXml().getViewTreeObserver().removeOnPreDrawListener(this);
        WikiHomeRecentSpaceView.b r101 = this.f240950a.f240819k;
        if (r101 == null) goto L10;
        r101.L2();
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    public s(WikiHomeRecentSpaceView r100) {
        this.f240950a = r100;
    }
}
