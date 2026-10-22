package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d2<T> implements Observer {
    public final /* synthetic */ ECShopSliceTopBarPresenter.b a;

    public d2(ECShopSliceTopBarPresenter.b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        com.bytedance.android.shopping.store.home.a0 r4 = (com.bytedance.android.shopping.store.home.a0) r3;
        Intrinsics.checkNotNullParameter(r4, "followConfig");
        com.bytedance.android.shopping.store.home.slice.h.a(this.a.a.B, r4, "ECShopSliceTopInfoPresenter");
        ECShopSliceTopBarPresenter.q0(this.a.a);
    }
}
