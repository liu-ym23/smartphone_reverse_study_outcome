package com.bytedance.android.window.shop.search.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ WindowSearchResultOrderTypePresenter a;

    public k(WindowSearchResultOrderTypePresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Iterator<T> r6 = ((List) r5).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        com.bytedance.android.ec.window.base.repository.vo.k r0 = (com.bytedance.android.ec.window.base.repository.vo.k) r6.next();
        this.a.e0().doEventAction("show_ecommerce_store_sort", new Pair[]{TuplesKt.to("tab_name", "search")});
        goto L4
    }
}
