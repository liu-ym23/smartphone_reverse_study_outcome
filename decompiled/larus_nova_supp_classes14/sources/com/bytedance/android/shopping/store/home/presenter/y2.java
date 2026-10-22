package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y2 implements com.bytedance.android.shopping.store.viewmodel.g {
    public final /* synthetic */ t2 a;
    public final /* synthetic */ ECShopMarqueeTextView b;

    @Override // com.bytedance.android.shopping.store.viewmodel.g
    public final ECTagListView b() {
        return com.bytedance.android.ec.store.product.presenter.utils.f.a(this.a.w().b(2131371097));
    }

    @Override // com.bytedance.android.shopping.store.viewmodel.g
    public final View getContainerView() {
        return this.a.v;
    }

    @Override // com.bytedance.android.shopping.store.viewmodel.g
    public final ECShopMarqueeTextView getView() {
        return this.b;
    }

    public y2(t2 r1, ECShopMarqueeTextView r2) {
        this.a = r1;
        this.b = r2;
    }
}
