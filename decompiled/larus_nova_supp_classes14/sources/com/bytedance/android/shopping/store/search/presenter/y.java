package com.bytedance.android.shopping.store.search.presenter;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.ec.store.status.StoreSearchProductLoadingStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y<T> implements Observer {
    public final /* synthetic */ z a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ LazyStatusView c;
    public final /* synthetic */ Context d;

    public y(z r1, ViewGroup r2, LazyStatusView r3, Context r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void onChanged(Object r4) {
        LoadStatus r5 = (LoadStatus) r4;
        this.b.setVisibility(0);
        if (this.a.g == false) goto L6;
        this.c.a(new StoreSearchProductLoadingStatusView(this.d).a());
    L6:
        if (r5 == null) goto L16;
        int r6 = w.a[r5.ordinal()];
        if (r6 != 1) goto L11;
        this.c.b(com.bytedance.android.ec.store.status.b.c.a);
    L21:
        this.a.g = true;
        return;
    L11:
        if (r6 != 2) goto L13;
        this.b.setVisibility(8);
        goto L21
    L13:
        if (r6 != 3) goto L15;
        this.c.b(com.bytedance.android.ec.store.status.b.b.a);
        goto L21
    L15:
        if (r6 != 4) goto L16;
        this.c.b(com.bytedance.android.ec.store.status.b.a.a);
    L16:
        this.b.setVisibility(8);
        goto L21
    }
}
