package com.bytedance.applog.monitor.v3;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final enum Features$ReportInterval extends Enum<Features$ReportInterval> {
    public static final Features$ReportInterval BIG_THAN_60 = null;
    public static final Features$ReportInterval DEFAULT_60 = null;
    public static final Features$ReportInterval LESS_THAN_60 = null;
    public static final /* synthetic */ Features$ReportInterval[] a = null;
    private int value;

    static {
        Features$ReportInterval r0 = new Features$ReportInterval("DEFAULT_60", 0, 0);
        DEFAULT_60 = r0;
        Features$ReportInterval r1 = new Features$ReportInterval("LESS_THAN_60", 1, 1);
        LESS_THAN_60 = r1;
        Features$ReportInterval r3 = new Features$ReportInterval("BIG_THAN_60", 2, 2);
        BIG_THAN_60 = r3;
        a = new Features$ReportInterval[]{r0, r1, r3};
    }

    public static Features$ReportInterval[] values() {
        return (Features$ReportInterval[]) a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static Features$ReportInterval valueOf(String r1) {
        return (Features$ReportInterval) a.a(Features$ReportInterval.class, r1);
    }

    public Features$ReportInterval(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
