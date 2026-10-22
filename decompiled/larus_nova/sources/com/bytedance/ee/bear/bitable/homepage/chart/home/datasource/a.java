package com.bytedance.ee.bear.bitable.homepage.chart.home.datasource;

import com.bytedance.ee.bear.bitable.homepage.chart.entity.HomeChartEntity;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChartListDataCache f212523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<HomeChartEntity> f212524b;

    public a(ChartListDataCache r100, List<HomeChartEntity> r101) {
        this.f212523a = r100;
        this.f212524b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChartListDataCache r100 = this.f212523a;     // Catch: Throwable -> L9
        d r101 = r100.f212521c;     // Catch: Throwable -> L9
        if (r101 == null) goto L12;
        List<HomeChartEntity> r102 = this.f212524b;     // Catch: Throwable -> L9
        e r103 = r101.e();     // Catch: Throwable -> L9
        if (r103 == null) goto L7;
        r103.b(r102);     // Catch: Throwable -> L9
    L7:
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new b(r100, r101));     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
