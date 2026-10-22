package com.bytedance.ee.bear.bitable.homepage.chart.datasource;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, rs4.d> f212469a;

    @Override // com.bytedance.ee.bear.bitable.homepage.chart.datasource.d
    public final void clear() {
        this.f212469a.clear();
    }

    public g() {
        this.f212469a = new ConcurrentHashMap();
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.chart.datasource.d
    public final rs4.d get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chartToken");
        return this.f212469a.get(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.chart.datasource.d
    public final void a(String r100, rs4.d r101) {
        Intrinsics.checkNotNullParameter(r100, "chartToken");
        Intrinsics.checkNotNullParameter(r101, "chartData");
        this.f212469a.put(r100, r101);
    }
}
