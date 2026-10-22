package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q<T> implements Observer {
    public final /* synthetic */ ECShopBackgroundPresenterBrand.a a;

    public q(ECShopBackgroundPresenterBrand.a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Float r5 = (Float) r4;
        if (r5.floatValue() < 0) goto L10;
        ECShopBackgroundPresenterBrand r0 = this.a.a;
        View r1 = r0.C;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("topbarBackgroundMask");
    L8:
        ECShopBackgroundPresenterBrand.r0(r0, r1, r5.floatValue());
        return;
    }
}
