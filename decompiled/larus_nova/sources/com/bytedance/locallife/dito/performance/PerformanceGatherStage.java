package com.bytedance.locallife.dito.performance;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/dito/performance/PerformanceGatherStage;", "", "FMP", "ENTIRE", "dito-performance-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum PerformanceGatherStage extends Enum<PerformanceGatherStage> {
    public static final PerformanceGatherStage ENTIRE = null;
    public static final PerformanceGatherStage FMP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PerformanceGatherStage[] f258546a = null;

    public static PerformanceGatherStage valueOf(String r100) {
        return (PerformanceGatherStage) r27.a.a(PerformanceGatherStage.class, r100);
    }

    public static PerformanceGatherStage[] values() {
        return (PerformanceGatherStage[]) f258546a.clone();
    }

    static {
        PerformanceGatherStage r100 = new PerformanceGatherStage("FMP", 0);
        FMP = r100;
        PerformanceGatherStage r101 = new PerformanceGatherStage("ENTIRE", 1);
        ENTIRE = r101;
        f258546a = new PerformanceGatherStage[]{r100, r101};
    }

    public PerformanceGatherStage(String r100, int r101) {
        super(r100, r101);
    }
}
