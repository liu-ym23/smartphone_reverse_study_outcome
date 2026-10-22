package com.bytedance.android.shopping.buynow.opt;

import com.bytedance.android.shopping.model.buynow.BuyNowPrefetchType;
import io.reactivex.functions.Action;
import tf3.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Action {
    public final /* synthetic */ ql.a a;
    public final /* synthetic */ l b;
    public final /* synthetic */ BuyNowPrefetchType c;

    public b(ql.a r1, l r2, BuyNowPrefetchType r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void run() {
        dm.a.a("BuyNowPrefetchPitayaJudger").a("prefetchIfNeedWithDelay after 1s");
        int r0 = d.a;
        d.d(this.a, this.b, this.c);
    }
}
