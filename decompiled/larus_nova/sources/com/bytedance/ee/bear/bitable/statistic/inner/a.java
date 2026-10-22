package com.bytedance.ee.bear.bitable.statistic.inner;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableNormalTrace f215699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitableStatisticEventModel$NormalPointModel f215700b;

    public a(BitableNormalTrace r100, BitableStatisticEventModel$NormalPointModel r101) {
        this.f215699a = r100;
        this.f215700b = r101;
    }

    public final void a() {
        BitableNormalTrace r100 = this.f215699a;     // Catch: Throwable -> L5 Exception -> L7
        r100.n(r100.f215694o, this.f215700b, 0);     // Catch: Throwable -> L5 Exception -> L7
    L9:
        this.f215699a.f215685f.set(false);
        return;
    L7:
        int r101 = com.bytedance.ee.bear.bitable.statistic.common.d.f215627a;     // Catch: Throwable -> L5
        BitableNormalTrace r102 = this.f215699a;     // Catch: Throwable -> L5
        com.bytedance.ee.bear.bitable.statistic.common.d.a(r102, r102.f215690k.getLogger(), this.f215700b, "add_point_exception", null);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        this.f215699a.f215685f.set(false);
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
