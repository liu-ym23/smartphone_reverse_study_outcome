package com.bytedance.android.window.shop.search.presenter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ WindowSearchResultTopBarPresenter a;

    public n(WindowSearchResultTopBarPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (this.a.F().isFormSearchActivity() == false) goto L5;
        WindowSearchResultTopBarPresenter.E(this.a, 11);
        return;
    L5:
        WindowSearchResultTopBarPresenter.D(this.a);
    }
}
