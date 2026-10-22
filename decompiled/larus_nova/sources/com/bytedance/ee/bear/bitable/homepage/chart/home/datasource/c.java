package com.bytedance.ee.bear.bitable.homepage.chart.home.datasource;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChartListDataCache f212527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f212528b;

    public c(ChartListDataCache r100, d r101) {
        this.f212527a = r100;
        this.f212528b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChartListDataCache r100 = this.f212527a;     // Catch: Throwable -> L4
        r100.f212521c = this.f212528b;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
