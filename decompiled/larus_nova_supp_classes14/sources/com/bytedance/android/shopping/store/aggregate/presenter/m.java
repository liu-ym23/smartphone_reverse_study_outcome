package com.bytedance.android.shopping.store.aggregate.presenter;

import com.bytedance.android.ec.store.repository.vo.r;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ ShopAggregatePageSortBarPresenter a;

    public m(ShopAggregatePageSortBarPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Iterator<T> r6 = ((List) r5).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r r0 = (r) r6.next();
        this.a.k0().doEventAction("show_ecommerce_store_sort", new Pair[]{TuplesKt.to("tab_name", "classification")});
        goto L4
    }
}
