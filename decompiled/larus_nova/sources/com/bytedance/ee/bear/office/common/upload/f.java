package com.bytedance.ee.bear.office.common.upload;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f235361a;

    public f(g r100) {
        this.f235361a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        if (r100.getHeight() <= 0) goto L6;
        this.f235361a.a(r100.getHeight() + this.f235361a.f235364b);
        return;
    }
}
