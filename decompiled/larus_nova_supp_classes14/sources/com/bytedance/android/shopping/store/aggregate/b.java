package com.bytedance.android.shopping.store.aggregate;

import android.view.View;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ ShopAggregatePageFragment a;

    public b(ShopAggregatePageFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        Lazy r2 = ECStoreFoldPhoneHelper.a;
        ECStoreFoldPhoneHelper.c(this.a);
    }
}
