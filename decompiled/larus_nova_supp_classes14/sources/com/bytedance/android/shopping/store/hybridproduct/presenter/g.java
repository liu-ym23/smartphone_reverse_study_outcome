package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ ECShopHorizonSortBarPresenter a;

    public g(ECShopHorizonSortBarPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r8) {
        List r9 = (List) r8;
        List r0 = r9;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L19;
        Iterator<T> r10 = r9.iterator();
    L13:
        if (r10.hasNext() == false) goto L23;
        com.bytedance.android.ec.store.repository.vo.r r2 = (com.bytedance.android.ec.store.repository.vo.r) r10.next();
        ECShopHybridProductViewModel r3 = this.a.h0();
        Pair<String, String>[] r4 = new Pair[3];
        r4[0] = TuplesKt.to("tab_name", "products");
        r4[1] = TuplesKt.to("order_type", r2.b);
        if (r2.d == false) goto L17;
        String r5 = String.valueOf(r2.e);
    L18:
        r4[2] = TuplesKt.to("order_ascending", r5);
        r3.doEventAction("show_ecommerce_store_sort", r4);
        goto L13
    L17:
        r5 = "";
        goto L18
    L23:
        return;
    L19:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
