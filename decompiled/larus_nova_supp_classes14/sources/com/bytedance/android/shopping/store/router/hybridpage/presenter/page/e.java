package com.bytedance.android.shopping.store.router.hybridpage.presenter.page;

import android.view.ViewGroup;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ LazyStatusView b;

    public e(ViewGroup r1, LazyStatusView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r2) {
        LoadStatus r3 = (LoadStatus) r2;
        if (r3 != null) goto L6;
    L7:
        this.a.setVisibility(8);
        return;
    L6:
        if (d.a[r3.ordinal()] != 1) goto L7;
        this.a.setVisibility(0);
        this.b.b(com.bytedance.android.ec.store.status.b.b.a);
    }
}
