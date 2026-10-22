package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.shopping.store.home.view.ECStoreHeaderFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j implements ECStoreHeaderFrameLayout.a {
    public final /* synthetic */ ECShopAutoCollapsePresenter a;

    @Override // com.bytedance.android.shopping.store.home.view.ECStoreHeaderFrameLayout.a
    public final void onClick() {
        this.a.B = true;
    }

    public j(ECShopAutoCollapsePresenter r1) {
        this.a = r1;
    }
}
