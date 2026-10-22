package com.bytedance.locallife.pdp.view;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes21.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GoodsDetailDialogFragment f261911a;

    public e(GoodsDetailDialogFragment r100) {
        this.f261911a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        GoodsDetailDialogFragment r102 = this.f261911a;
        int r103 = GoodsDetailDialogFragment.E;
        r102.V90();
    }
}
