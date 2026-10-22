package com.bytedance.android.shopping.store.home.presenter;

import android.view.ViewGroup;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d1<T> implements Observer {
    public final /* synthetic */ ECShopLoadStatusPresenter a;
    public final /* synthetic */ ViewGroup b;

    public d1(ECShopLoadStatusPresenter r1, ViewGroup r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r2) {
        ECStoreTabAreaVO r3 = (ECStoreTabAreaVO) r2;
        if (Intrinsics.areEqual((Boolean) this.a.T().getRestoreCoverVisible().getValue(), Boolean.TRUE) == true) goto L18;
        com.bytedance.android.shopping.store.home.entity.n r4 = (com.bytedance.android.shopping.store.home.entity.n) this.a.T().getHeaderArea().getValue();
        if (r4 == null) goto L10;
        com.bytedance.android.shopping.store.home.entity.i r5 = r4.g;
        if (r5 == null) goto L10;
        Integer r6 = r5.c;
    L11:
        if (r6 != null) goto L14;
        return;
    L14:
        if (r6.intValue() != 1) goto L17;
        this.b.setVisibility(8);
        return;
    L17:
        return;
    L10:
        r6 = null;
        goto L11
    }
}
