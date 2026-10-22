package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.bytedance.android.ec.store.common.floatelement.StoreCartEntryConfig;
import com.bytedance.android.shopping.store.home.view.LottieAnimationViewWithPlayCount;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements a4 {
    public final /* synthetic */ ECStoreViewModel a;

    @Override // com.bytedance.android.shopping.store.home.presenter.a4
    public final jm.a<StoreCartEntryConfig> d() {
        return null;
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.a4
    public final void e(LottieAnimationViewWithPlayCount r1) {
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.a4
    public final void f(View r1) {
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.a4
    public final jm.a<Integer> a() {
        return this.a.getScrollState();
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.a4
    public final jm.a<Pair<Integer, Integer>> b() {
        return this.a.getSelectedTabLocation();
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.a4
    public final jm.a<Float> c() {
        return this.a.getCollapseFactor();
    }

    public b(ECStoreViewModel r1) {
        this.a = r1;
    }
}
