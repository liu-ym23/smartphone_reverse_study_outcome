package com.bytedance.locallife.pdp.view;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes21.dex */
public final class a0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MenuGoodsHeaderView f261904a;

    public a0(MenuGoodsHeaderView r100) {
        this.f261904a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f261904a.S();
        this.f261904a.P();
    }
}
