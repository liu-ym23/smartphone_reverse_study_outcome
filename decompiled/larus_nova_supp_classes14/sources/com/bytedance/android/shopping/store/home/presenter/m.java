package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ ECShopBackgroundPresenterBrand.a a;

    public m(ECShopBackgroundPresenterBrand.a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        ECShopBackgroundPresenterBrand r0 = this.a.a;
        int r1 = ECShopBackgroundPresenterBrand.G;
        ECShopBackgroundPresenterBrand.s0(r0, r0.u0(), ((Float) r3).floatValue());
    }
}
