package com.bytedance.android.window.shop.search.presenter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ WindowSearchResultTopBarPresenter a;

    public m(WindowSearchResultTopBarPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.a.F().getData().putExtra("sug_enter_type", 2);
        WindowSearchResultTopBarPresenter.E(this.a, 10);
    }
}
