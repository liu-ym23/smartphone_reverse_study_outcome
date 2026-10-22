package com.bytedance.android.shopping.store.home.presenter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ ECShopAutoCollapsePresenter a;

    public f(ECShopAutoCollapsePresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        ECShopAutoCollapsePresenter r4 = this.a;
        if (r4.B == false) goto L5;
        return;
    L5:
        if ((!r4.x.isEmpty()) == true) goto L9;
        this.a.r0();
        return;
    }
}
