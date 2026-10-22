package com.bytedance.pia.core.metrics;

import com.bytedance.android.ec.core.event.a;

/* JADX INFO: loaded from: classes21.dex */
public final enum MetricsType extends Enum<MetricsType> {
    public static final MetricsType EXCEPTION = null;
    public static final MetricsType NSR_PERFORMANCE = null;
    public static final MetricsType PV = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MetricsType[] f266233a = null;
    private final String value;

    static {
        MetricsType r100 = new MetricsType("EXCEPTION", 0, a.KEY_EXCEPTION);
        EXCEPTION = r100;
        MetricsType r101 = new MetricsType("PV", 1, "pv");
        PV = r101;
        MetricsType r102 = new MetricsType("NSR_PERFORMANCE", 2, "nsr_worker_performance");
        NSR_PERFORMANCE = r102;
        f266233a = new MetricsType[]{r100, r101, r102};
    }

    public static MetricsType[] values() {
        return (MetricsType[]) f266233a.clone();
    }

    public String getValue() {
        return this.value;
    }

    public static MetricsType valueOf(String r100) {
        return (MetricsType) r27.a.a(MetricsType.class, r100);
    }

    public MetricsType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
