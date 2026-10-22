package com.bytedance.ee.bear.bitable.homepage.chart.datasource;

import com.bytedance.ee.bear.bitable.homepage.chart.ChartConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruChartDataCache$cache$1 f212468a;

    @Override // com.bytedance.ee.bear.bitable.homepage.chart.datasource.d
    public final void clear() {
        evictAll();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.ee.bear.bitable.homepage.chart.datasource.LruChartDataCache$cache$1] */
    public f() {
        ChartConfig r100 = (ChartConfig) SettingManager.getInstance().get(ChartConfig.class);
        if (r100 != null) goto L5;
        r100 = new ChartConfig();
    L5:
        final int r101 = r100.e().a();
        this.f212468a = new LruChartDataCache$cache$1(r101);
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.chart.datasource.d
    public final rs4.d get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chartToken");
        return get(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.chart.datasource.d
    public final void a(String r100, rs4.d r101) {
        Intrinsics.checkNotNullParameter(r100, "chartToken");
        Intrinsics.checkNotNullParameter(r101, "chartData");
        put(r100, r101);
    }
}
