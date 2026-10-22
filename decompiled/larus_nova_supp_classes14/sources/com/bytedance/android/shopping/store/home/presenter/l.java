package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l<T> implements Observer {
    public final /* synthetic */ ECShopBackgroundPresenterBrand.a a;

    public l(ECShopBackgroundPresenterBrand.a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Float r4 = (Float) r3;
        if (r4.floatValue() < 0) goto L7;
        ECShopBackgroundPresenterBrand r0 = this.a.a;
        int r1 = ECShopBackgroundPresenterBrand.G;
        ECShopBackgroundPresenterBrand.r0(r0, r0.t0(), r4.floatValue());
        return;
    }
}
