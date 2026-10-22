package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ ECShopAbsFloatPresenter a;

    public d(ECShopAbsFloatPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        ((z3) this.a.g.getValue()).onClick();
    }
}
