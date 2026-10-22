package com.bytedance.locallife.pdp.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes21.dex */
public final class p0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OldGoodsHeaderView f261939a;

    public p0(OldGoodsHeaderView r100) {
        this.f261939a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        OldGoodsHeaderView r101 = this.f261939a;
        r101.N = ((com.bytedance.locallife.dito.data.u) r100).f258258d * 1.0f;
        r101.i0();
    }
}
