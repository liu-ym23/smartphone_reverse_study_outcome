package com.bytedance.ee.bear.bitable.homepage.chart.home.datasource;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChartListDataCache f212525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f212526b;

    public b(ChartListDataCache r100, d r101) {
        this.f212525a = r100;
        this.f212526b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ay4.b.d(DocumentType.BITABLE_NAME, 6).putString("bitable_homepage_chart_list_datav1", this.f212525a.f212519a.toJson(this.f212526b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        tt5.a.e("ChartListDataCache", "update cache failed", th, false);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
