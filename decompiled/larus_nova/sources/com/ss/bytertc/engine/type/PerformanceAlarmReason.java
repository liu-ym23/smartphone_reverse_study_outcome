package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum PerformanceAlarmReason extends Enum<PerformanceAlarmReason> {
    private static final /* synthetic */ PerformanceAlarmReason[] $VALUES = null;
    public static final PerformanceAlarmReason BANDWIDTH_FALLBACKED = null;
    public static final PerformanceAlarmReason BANDWIDTH_RESUMED = null;
    public static final PerformanceAlarmReason PERFORMANCE_FALLBACKED = null;
    public static final PerformanceAlarmReason PERFORMANCE_RESUMED = null;
    private int value;

    static {
        PerformanceAlarmReason r100 = new PerformanceAlarmReason("BANDWIDTH_FALLBACKED", 0, 0);
        BANDWIDTH_FALLBACKED = r100;
        PerformanceAlarmReason r101 = new PerformanceAlarmReason("BANDWIDTH_RESUMED", 1, 1);
        BANDWIDTH_RESUMED = r101;
        PerformanceAlarmReason r102 = new PerformanceAlarmReason("PERFORMANCE_FALLBACKED", 2, 2);
        PERFORMANCE_FALLBACKED = r102;
        PerformanceAlarmReason r103 = new PerformanceAlarmReason("PERFORMANCE_RESUMED", 3, 3);
        PERFORMANCE_RESUMED = r103;
        $VALUES = new PerformanceAlarmReason[]{r100, r101, r102, r103};
    }

    public static PerformanceAlarmReason[] values() {
        return (PerformanceAlarmReason[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static PerformanceAlarmReason valueOf(String r100) {
        return (PerformanceAlarmReason) a.a(PerformanceAlarmReason.class, r100);
    }

    private PerformanceAlarmReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
