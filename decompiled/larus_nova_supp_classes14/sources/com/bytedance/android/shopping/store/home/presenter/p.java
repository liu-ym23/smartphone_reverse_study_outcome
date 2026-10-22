package com.bytedance.android.shopping.store.home.presenter;

import android.view.ViewGroup;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ ECShopBackgroundPresenterBrand.a a;

    public p(ECShopBackgroundPresenterBrand.a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Float r6 = (Float) r5;
        if (r6.floatValue() < 0) goto L10;
        ECShopBackgroundPresenterBrand r0 = this.a.a;
        int r1 = ECShopBackgroundPresenterBrand.G;
        ViewGroup r2 = r0.v0();
        if (r2 == null) goto L9;
        float r3 = 1;
        ViewExtensionsKt.g(r2, (r3 - r6.floatValue()) * 20.0f, (r3 - r6.floatValue()) * 20.0f, 0.0f, 0.0f);
        return;
    L9:
        return;
    }
}
