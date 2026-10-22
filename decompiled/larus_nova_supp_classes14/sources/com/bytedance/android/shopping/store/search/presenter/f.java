package com.bytedance.android.shopping.store.search.presenter;

import com.bytedance.android.ec.store.search.history.HistoryView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ ShopSearchHistoryPresenter a;

    public f(ShopSearchHistoryPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if (Intrinsics.areEqual((Boolean) r3, Boolean.FALSE) == false) goto L10;
        HistoryView r4 = this.a.f;
        if (r4 != null) goto L7;
        return;
    L7:
        if (r4.c != true) goto L12;
        r4.d();
        return;
    L12:
        return;
    }
}
