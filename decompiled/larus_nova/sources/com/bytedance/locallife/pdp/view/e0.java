package com.bytedance.locallife.pdp.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes21.dex */
public final class e0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MenuGoodsHeaderView f261912a;

    public e0(MenuGoodsHeaderView r100) {
        this.f261912a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        MenuGoodsHeaderView r101 = this.f261912a;
        r101.O = ((com.bytedance.locallife.dito.data.u) r100).f258258d * 1.0f;
        r101.i0();
    }
}
