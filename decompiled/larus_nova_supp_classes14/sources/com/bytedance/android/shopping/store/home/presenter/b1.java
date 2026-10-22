package com.bytedance.android.shopping.store.home.presenter;

import android.view.ViewGroup;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b1<T> implements Observer {
    public final /* synthetic */ ECShopLoadStatusPresenter a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ LazyStatusView c;

    public b1(ECShopLoadStatusPresenter r1, ViewGroup r2, LazyStatusView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r2) {
        if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L6;
        this.b.setVisibility(0);
        this.c.b(com.bytedance.android.ec.store.status.b.c.a);
        return;
    L6:
        if (((LoadStatus) this.a.T().getLoadStatus().getValue()) != LoadStatus.InitializeSuccess) goto L20;
        com.bytedance.android.shopping.store.home.entity.n r3 = (com.bytedance.android.shopping.store.home.entity.n) this.a.T().getHeaderArea().getValue();
        if (r3 == null) goto L12;
        com.bytedance.android.shopping.store.home.entity.i r4 = r3.g;
        if (r4 == null) goto L12;
        Integer r5 = r4.c;
    L13:
        if (r5 != null) goto L16;
    L17:
        this.b.setVisibility(8);
        return;
    L16:
        if (r5.intValue() != 1) goto L17;
        return;
    L12:
        r5 = null;
        goto L13
    }
}
