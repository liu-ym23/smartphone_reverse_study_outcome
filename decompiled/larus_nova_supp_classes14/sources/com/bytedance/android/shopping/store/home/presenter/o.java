package com.bytedance.android.shopping.store.home.presenter;

import android.view.ViewGroup;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o<T> implements Observer {
    public final /* synthetic */ ECShopBackgroundPresenterBrand.a a;
    public final /* synthetic */ float b;

    public o(ECShopBackgroundPresenterBrand.a r1, float r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        ECShopBackgroundPresenterBrand r0 = this.a.a;
        int r1 = ECShopBackgroundPresenterBrand.G;
        ViewGroup r2 = r0.v0();
        if (r2 == null) goto L6;
        r2.setY(this.b - r4.intValue());
        return;
    }
}
