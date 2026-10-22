package com.bytedance.ee.bear.bitable.statistic.inner;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements Runnable {
    public final /* synthetic */ BitableNormalTrace a;
    public final /* synthetic */ BitableStatisticEventModel$NormalPointModel b;

    public a(BitableNormalTrace r1, BitableStatisticEventModel$NormalPointModel r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        BitableNormalTrace r1 = this.a;     // Catch: Throwable -> L5 Exception -> L7
        r1.n(r1.o, this.b, 0);     // Catch: Throwable -> L5 Exception -> L7
    L9:
        this.a.f.set(false);
        return;
    L7:
        int r2 = com.bytedance.ee.bear.bitable.statistic.common.d.a;     // Catch: Throwable -> L5
        BitableNormalTrace r3 = this.a;     // Catch: Throwable -> L5
        com.bytedance.ee.bear.bitable.statistic.common.d.a(r3, r3.k.getLogger(), this.b, "add_point_exception", null);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        this.a.f.set(false);
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
