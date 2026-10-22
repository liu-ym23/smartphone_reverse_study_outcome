package com.bytedance.android.shopping.store.home.presenter;

import android.view.ViewGroup;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c1<T> implements Observer {
    public final /* synthetic */ ECShopLoadStatusPresenter a;
    public final /* synthetic */ LazyStatusView b;
    public final /* synthetic */ ViewGroup c;

    public c1(ECShopLoadStatusPresenter r1, LazyStatusView r2, ViewGroup r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r3) {
        LoadStatus r4 = (LoadStatus) r3;
        if (r4 == null) goto L32;
        int r5 = x0.a[r4.ordinal()];
        if (r5 != 1) goto L8;
        this.b.b(com.bytedance.android.ec.store.status.b.c.a);
        return;
    L8:
        if (r5 == 2) goto L14;
        if (r5 != 3) goto L33;
        this.b.b(com.bytedance.android.ec.store.status.b.b.a);
        return;
    L33:
        return;
    L14:
        if (Intrinsics.areEqual((Boolean) this.a.T().getRestoreCoverVisible().getValue(), Boolean.TRUE) == true) goto L34;
        com.bytedance.android.shopping.store.home.entity.n r6 = (com.bytedance.android.shopping.store.home.entity.n) this.a.T().getHeaderArea().getValue();
        if (r6 == null) goto L21;
        com.bytedance.android.shopping.store.home.entity.i r7 = r6.g;
        if (r7 == null) goto L21;
        Integer r8 = r7.c;
    L22:
        if (r8 != null) goto L25;
    L26:
        this.c.setVisibility(8);
        return;
    L25:
        if (r8.intValue() != 1) goto L26;
        return;
    L21:
        r8 = null;
        goto L22
    L34:
        return;
    }
}
