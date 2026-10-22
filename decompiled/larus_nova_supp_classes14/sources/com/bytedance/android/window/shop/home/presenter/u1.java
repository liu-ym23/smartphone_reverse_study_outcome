package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;
import com.bytedance.android.ec.window.base.status.WindowLazyStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u1<T> implements Observer {
    public final /* synthetic */ WindowLazyStatusView a;
    public final /* synthetic */ View b;

    public u1(WindowLazyStatusView r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r2) {
        WindowLoadStatus r3 = (WindowLoadStatus) r2;
        if (r3 == null) goto L18;
        int r4 = r1.a[r3.ordinal()];
        if (r4 != 1) goto L8;
        this.a.b(com.bytedance.android.ec.window.base.status.c.d.a);
        return;
    L8:
        if (r4 != 2) goto L10;
        this.a.a();
        this.b.setVisibility(8);
        return;
    L10:
        if (r4 != 3) goto L19;
        this.a.b(com.bytedance.android.ec.window.base.status.c.c.a);
        return;
    L19:
        return;
    }
}
