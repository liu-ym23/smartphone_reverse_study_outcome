package com.bytedance.android.shopping.feed.viewmodel;

import com.bytedance.android.shopping.feed.model.InflowGuessFeedResponse;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ InflowGuessFeedResponse a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ProductFeedViewModel.m c;

    public c(InflowGuessFeedResponse r1, String r2, ProductFeedViewModel.m r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProductFeedViewModel r0 = this.c.a;     // Catch: Throwable -> L4
        InflowGuessFeedResponse r1 = this.a;     // Catch: Throwable -> L4
        int r2 = ProductFeedViewModel.access$getSearchCardPos(r0, this.b);     // Catch: Throwable -> L4
        String r3 = this.b;     // Catch: Throwable -> L4
        r0.handleSearchCardResource(r1, r2, r3, ProductFeedViewModel.access$getGuessULikeRank(this.c.a, r3));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
