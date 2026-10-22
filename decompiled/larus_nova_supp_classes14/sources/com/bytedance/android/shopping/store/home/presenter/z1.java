package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z1 implements View.OnClickListener {
    public final /* synthetic */ ECShopSliceTopBarPresenter a;

    public z1(ECShopSliceTopBarPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        ECShopSliceTopBarPresenter r0 = this.a;
        ECStoreCollapsibleTextView r9 = r0.x;
        if (r9 == null) goto L5;
        Integer r10 = Integer.valueOf(r9.getId());
    L6:
        ECShopBasePresenter.l0(r0, "", "", r10, null, null, 24);
        return;
    L5:
        r10 = null;
        goto L6
    }
}
