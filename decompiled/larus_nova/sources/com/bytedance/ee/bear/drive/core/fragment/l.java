package com.bytedance.ee.bear.drive.core.fragment;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class l implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f224251a;

    public l(k r100) {
        this.f224251a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if (r104 <= r102) goto L10;
        k r109 = this.f224251a;
        if (r109.f224234p != null) goto L12;
        k.b(r109);
        this.f224251a.j();
        k r110 = this.f224251a;
        if (r110.f224234p == null) goto L11;
        r110.e();
        return;
    L11:
        return;
    L12:
        return;
    }
}
