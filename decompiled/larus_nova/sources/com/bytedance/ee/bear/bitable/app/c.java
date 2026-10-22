package com.bytedance.ee.bear.bitable.app;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableAppDrawerManager f206863a;

    public c(BitableAppDrawerManager r100) {
        this.f206863a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        int r109 = r103 - r101;
        BitableAppDrawerManager r110 = this.f206863a;
        Integer r111 = r110.f206824w;
        if (r111 != null) goto L6;
        r110.f206824w = Integer.valueOf(r109);
        return;
    L6:
        if (r111 != null) goto L9;
    L10:
        BitableAppDrawerManager r112 = this.f206863a;
        r112.f206823v = true;
        r112.f206824w = Integer.valueOf(r109);
        BitableAppDrawerManager r113 = this.f206863a;
        if (r113.f206808g == false) goto L15;
        r113.y();
        return;
    L15:
        return;
    L9:
        if (r111.intValue() != r109) goto L10;
    }
}
