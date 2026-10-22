package com.bytedance.android.window.shop.search.presenter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a0 implements View.OnClickListener {
    public final /* synthetic */ WindowSearchTitlePresenter a;

    public a0(WindowSearchTitlePresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        WindowSearchTitlePresenter.F(this.a, WindowSearchBasePresenter.SearchMode.BUTTON);
    }
}
