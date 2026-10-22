package io.opentelemetry.sdk.metrics.data;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum AggregationTemporality extends Enum<AggregationTemporality> {
    public static final AggregationTemporality CUMULATIVE = null;
    public static final AggregationTemporality DELTA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AggregationTemporality[] f492722a = null;

    static {
        AggregationTemporality r100 = new AggregationTemporality("DELTA", 0);
        DELTA = r100;
        AggregationTemporality r101 = new AggregationTemporality("CUMULATIVE", 1);
        CUMULATIVE = r101;
        f492722a = new AggregationTemporality[]{r100, r101};
    }

    public static AggregationTemporality[] values() {
        return (AggregationTemporality[]) f492722a.clone();
    }

    public static AggregationTemporality valueOf(String r100) {
        return (AggregationTemporality) a.a(AggregationTemporality.class, r100);
    }

    public AggregationTemporality(String r100, int r101) {
        super(r100, r101);
    }
}
