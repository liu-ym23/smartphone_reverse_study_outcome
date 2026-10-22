package io.opentelemetry.sdk.metrics.data;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum MetricDataType extends Enum<MetricDataType> {
    public static final MetricDataType DOUBLE_GAUGE = null;
    public static final MetricDataType DOUBLE_SUM = null;
    public static final MetricDataType EXPONENTIAL_HISTOGRAM = null;
    public static final MetricDataType HISTOGRAM = null;
    public static final MetricDataType LONG_GAUGE = null;
    public static final MetricDataType LONG_SUM = null;
    public static final MetricDataType SUMMARY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MetricDataType[] f492723a = null;

    static {
        MetricDataType r100 = new MetricDataType("LONG_GAUGE", 0);
        LONG_GAUGE = r100;
        MetricDataType r101 = new MetricDataType("DOUBLE_GAUGE", 1);
        DOUBLE_GAUGE = r101;
        MetricDataType r102 = new MetricDataType("LONG_SUM", 2);
        LONG_SUM = r102;
        MetricDataType r103 = new MetricDataType("DOUBLE_SUM", 3);
        DOUBLE_SUM = r103;
        MetricDataType r104 = new MetricDataType("SUMMARY", 4);
        SUMMARY = r104;
        MetricDataType r105 = new MetricDataType("HISTOGRAM", 5);
        HISTOGRAM = r105;
        MetricDataType r110 = new MetricDataType("EXPONENTIAL_HISTOGRAM", 6);
        EXPONENTIAL_HISTOGRAM = r110;
        f492723a = new MetricDataType[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static MetricDataType[] values() {
        return (MetricDataType[]) f492723a.clone();
    }

    public static MetricDataType valueOf(String r100) {
        return (MetricDataType) a.a(MetricDataType.class, r100);
    }

    public MetricDataType(String r100, int r101) {
        super(r100, r101);
    }
}
