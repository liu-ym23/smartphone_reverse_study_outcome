package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ PdpDataFetchService a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Function1 c;

    public k(PdpDataFetchService r1, long r2, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        if (this.b != this.a.w.get()) goto L10;
        Function1 r7 = this.c;
        if (r7 == null) goto L9;
        Unit r8 = (Unit) r7.invoke(PDPRefreshStatus.FAILED);
        return;
    L9:
        return;
    }
}
