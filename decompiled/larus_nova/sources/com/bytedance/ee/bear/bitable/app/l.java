package com.bytedance.ee.bear.bitable.app;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class l implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableAppUIContainer f206945a;

    public l(BitableAppUIContainer r100) {
        this.f206945a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        this.f206945a.p();
        this.f206945a.q();
    }
}
