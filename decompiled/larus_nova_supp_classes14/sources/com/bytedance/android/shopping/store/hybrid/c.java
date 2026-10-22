package com.bytedance.android.shopping.store.hybrid;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ ECStoreHybridTabPresenter a;

    public c(ECStoreHybridTabPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ECStoreHybridTabPresenter.h0(this.a).loadInitialData(this.a.B);
    }
}
