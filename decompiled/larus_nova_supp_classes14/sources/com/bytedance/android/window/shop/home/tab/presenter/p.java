package com.bytedance.android.window.shop.home.tab.presenter;

import com.bytedance.android.window.shop.home.WindowTabExtViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p implements com.bytedance.android.window.shop.home.viewmodel.b {
    public final /* synthetic */ ECWindowTabPresenter a;

    @Override // com.bytedance.android.window.shop.home.viewmodel.b
    public final void onRefresh() {
        ((WindowTabExtViewModel) this.a.i.getValue()).dropAll();
    }

    public p(ECWindowTabPresenter r1) {
        this.a = r1;
    }
}
