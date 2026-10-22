package com.bytedance.ee.bear.bitable.homepage.chart;

import com.bytedance.ee.bear.bitable.homepage.chart.entity.ChartEntity;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChartEntity f212470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f212471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f212472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f212473d;

    public e(ChartEntity r100, String r101, String r102, Map<String, ? extends Object> r103) {
        this.f212470a = r100;
        this.f212471b = r101;
        this.f212472c = r102;
        this.f212473d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a().i("ccm_bitable_homepage_dashboard_component_full_screen_view", c.b(this.f212470a, this.f212471b, this.f212472c, this.f212473d));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
