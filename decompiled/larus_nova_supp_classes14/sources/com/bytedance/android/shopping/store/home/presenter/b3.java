package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b3 implements View.OnClickListener {
    public final /* synthetic */ t2 a;

    public b3(t2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        ECStoreViewModel r2 = this.a.T();
        if (r2 == null) goto L8;
        com.bytedance.android.shopping.store.home.y r3 = r2.getIShopInfoAreaAbility();
        if (r3 == null) goto L9;
        r3.a();
        return;
    L9:
        return;
    }
}
