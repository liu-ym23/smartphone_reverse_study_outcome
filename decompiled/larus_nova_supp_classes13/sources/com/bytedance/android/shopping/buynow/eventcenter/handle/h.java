package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import io.reactivex.functions.Action;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements Action {
    public final /* synthetic */ Function1 a;

    public h(Function1 r1) {
        this.a = r1;
    }

    public final void run() {
        BuyNowLog.d("selfDelay", "selfDelay finishes");
        Function1 r0 = this.a;
        int r1 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r0.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
