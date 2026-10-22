package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k3<T> implements Observer {
    public final /* synthetic */ ECShopTopBarSearchPresenterV2 a;

    public k3(ECShopTopBarSearchPresenterV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        com.bytedance.android.shopping.store.home.entity.n r3 = (com.bytedance.android.shopping.store.home.entity.n) r2;
        com.bytedance.android.shopping.store.home.view.a r4 = ECShopTopBarSearchPresenterV2.q0(this.a);
        if (r4 == null) goto L8;
        ECStoreCollapsibleTextView r0 = this.a.u;
        if (r0 == null) goto L9;
        r0.setBackground(r4);
        return;
    L9:
        return;
    }
}
