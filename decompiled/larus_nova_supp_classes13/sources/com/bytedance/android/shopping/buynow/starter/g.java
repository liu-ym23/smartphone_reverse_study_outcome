package com.bytedance.android.shopping.buynow.starter;

import com.bytedance.retrofit2.SsResponse;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g<T, R> implements Function {
    public final /* synthetic */ BuyNowStarter a;

    public g(BuyNowStarter r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        SsResponse r4 = (SsResponse) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        BuyNowStarter r0 = this.a;
        r0.j = true;
        Function0<Unit> r1 = r0.k;
        if (r1 == null) goto L5;
        Unit r2 = (Unit) r1.invoke();
    L5:
        return r4;
    }
}
