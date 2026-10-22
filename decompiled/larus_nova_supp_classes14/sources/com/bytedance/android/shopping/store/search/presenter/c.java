package com.bytedance.android.shopping.store.search.presenter;

import com.bytedance.android.ec.store.search.history.HistoryBanner;
import com.bytedance.android.ec.store.search.history.HistoryView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements HistoryBanner.b {
    public final /* synthetic */ ShopSearchHistoryPresenter a;

    public final void a() {
        HistoryView r0 = this.a.f;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    public final void b() {
        HistoryView r0 = this.a.f;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    public final void c() {
        HistoryView r0 = this.a.f;
        if (r0 == null) goto L6;
        r0.h();
        return;
    }

    public c(ShopSearchHistoryPresenter r1) {
        this.a = r1;
    }
}
