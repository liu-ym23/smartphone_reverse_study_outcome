package com.bytedance.locallife.pdp.view;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes21.dex */
public final class l0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OldGoodsHeaderView f261931a;

    public l0(OldGoodsHeaderView r100) {
        this.f261931a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f261931a.S();
        this.f261931a.P();
    }
}
