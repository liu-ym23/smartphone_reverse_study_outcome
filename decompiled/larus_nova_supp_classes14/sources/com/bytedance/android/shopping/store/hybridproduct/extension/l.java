package com.bytedance.android.shopping.store.hybridproduct.extension;

import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductListPresenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l<T> implements Observer {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public l(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        if (((Boolean) r5).booleanValue() == false) goto L26;
        dm.a.b r6 = dm.a.a("ECShopMemberCardPresenter");
        StringBuilder r0 = new StringBuilder("addRemoveVipCard：");
        ECHybridListEngine r1 = this.a.n;
        if (r1 == null) goto L8;
        Integer r2 = r1.d("__PRODUCTS_SECTION__", "shop_products_member_card");
    L9:
        r0.append(r2);
        r6.a(r0.toString());
        ECHybridListEngine r7 = this.a.n;
        if (r7 == null) goto L22;
        Integer r8 = r7.d("__PRODUCTS_SECTION__", "shop_products_member_card");
        if (r8 == null) goto L23;
        int r9 = r8.intValue();
        ECHybridListEngine r3 = this.a.n;
        if (r3 == null) goto L16;
        r3.c.hB(r9);
    L16:
        ECHybridListEngine r10 = this.a.n;
        if (r10 == null) goto L24;
        ECHybridListAdapter r11 = r10.a;
        if (r11 == null) goto L25;
        r11.notifyDataSetChanged();
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L8:
        r2 = null;
        goto L9
    }
}
