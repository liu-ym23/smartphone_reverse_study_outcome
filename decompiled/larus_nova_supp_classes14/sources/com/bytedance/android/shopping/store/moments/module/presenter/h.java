package com.bytedance.android.shopping.store.moments.module.presenter;

import android.view.ViewGroup;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ LazyStatusView b;

    public h(ViewGroup r1, LazyStatusView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r3) {
        LoadStatus r4 = (LoadStatus) r3;
        this.a.setVisibility(0);
        if (r4 == null) goto L13;
        int r5 = b.a[r4.ordinal()];
        if (r5 != 1) goto L8;
        this.b.b(com.bytedance.android.ec.store.status.b.c.a);
        return;
    L8:
        if (r5 != 2) goto L10;
        this.a.setVisibility(8);
        return;
    L10:
        if (r5 != 3) goto L12;
        this.b.b(com.bytedance.android.ec.store.status.b.b.a);
        return;
    L12:
        if (r5 != 4) goto L13;
        this.b.b(com.bytedance.android.ec.store.status.b.a.a);
        return;
    L13:
        this.a.setVisibility(8);
    }
}
