package com.bytedance.ee.bear.office.space;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeSpaceFragment f236106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f236107b;

    public g(OfficeSpaceFragment r100, View r101) {
        this.f236106a = r100;
        this.f236107b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if ((r103 - r101) == (r107 - r105)) goto L6;
        OfficeSpaceFragment r109 = this.f236106a;
        View r110 = this.f236107b;
        int r111 = OfficeSpaceFragment.f236036v;
        r109.U90(r110);
        return;
    }
}
