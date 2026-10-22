package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g1<T> implements Observer {
    public final /* synthetic */ ECShopLoadStatusPresenter a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ View c;
    public final /* synthetic */ LazyStatusView d;

    public g1(ECShopLoadStatusPresenter r1, ViewGroup r2, View r3, LazyStatusView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void onChanged(Object r4) {
        LoadStatus r5 = (LoadStatus) r4;
        if (r5 == null) goto L18;
        int r0 = x0.b[r5.ordinal()];
        if (r0 != 1) goto L8;
        this.a.v0(this.b, this.c, r5);
        this.d.b(com.bytedance.android.ec.store.status.b.c.a);
        return;
    L8:
        if (r0 != 2) goto L10;
        this.d.setVisibility(8);
        this.a.v0(this.b, this.c, r5);
        return;
    L10:
        if (r0 != 3) goto L19;
        this.d.b(com.bytedance.android.ec.store.status.b.b.a);
        this.a.v0(this.b, this.c, r5);
        return;
    L19:
        return;
    }
}
