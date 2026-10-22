package com.bytedance.android.shopping.store.search.presenter;

import com.bytedance.android.ec.store.search.history.HistoryBanner;
import com.bytedance.android.ec.store.search.history.HistoryView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ ShopSearchHistoryPresenter a;

    public e(ShopSearchHistoryPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        List r5 = (List) r4;
        if (r5 == null) goto L16;
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L22;
        sj3.h r0 = (sj3.h) r6.next();
        ShopSearchHistoryPresenter r1 = this.a;
        HistoryView r2 = r1.f;
        if (r2 == null) goto L10;
        r2.c(r0);
    L10:
        HistoryBanner r3 = r1.g;
        if (r3 == null) goto L13;
        r3.setVisibility(0);
    L13:
        HistoryView r7 = r1.f;
        if (r7 == null) goto L6;
        r7.setVisibility(0);
        goto L6
    L22:
        return;
    }
}
