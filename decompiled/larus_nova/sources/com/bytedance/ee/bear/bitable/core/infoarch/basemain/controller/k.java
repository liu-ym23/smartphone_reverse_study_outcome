package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class k implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeBaseMainHeaderScrollController f210433a;

    public k(OfficeBaseMainHeaderScrollController r100) {
        this.f210433a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        OfficeBaseMainHeaderScrollController r109 = this.f210433a;
        if (r109.f210331n == false) goto L5;
        return;
    L5:
        if (r109.f210318a.f210515l.getMeasuredHeight() <= 0) goto L9;
        OfficeBaseMainHeaderScrollController r110 = this.f210433a;
        r110.f210329l = r110.f210318a.f210515l.getMeasuredHeight();
        return;
    }
}
