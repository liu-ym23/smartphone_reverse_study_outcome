package com.bytedance.apm.battery;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final enum BatteryExceptionListener$IssueType extends Enum<BatteryExceptionListener$IssueType> {
    public static final BatteryExceptionListener$IssueType ALARM = null;
    public static final BatteryExceptionListener$IssueType LOCATION = null;
    public static final BatteryExceptionListener$IssueType WAKELOCK = null;
    public static final /* synthetic */ BatteryExceptionListener$IssueType[] a = null;

    static {
        BatteryExceptionListener$IssueType r0 = new BatteryExceptionListener$IssueType("ALARM", 0);
        ALARM = r0;
        BatteryExceptionListener$IssueType r1 = new BatteryExceptionListener$IssueType("WAKELOCK", 1);
        WAKELOCK = r1;
        BatteryExceptionListener$IssueType r3 = new BatteryExceptionListener$IssueType("LOCATION", 2);
        LOCATION = r3;
        a = new BatteryExceptionListener$IssueType[]{r0, r1, r3};
    }

    public static BatteryExceptionListener$IssueType[] values() {
        return (BatteryExceptionListener$IssueType[]) a.clone();
    }

    public static BatteryExceptionListener$IssueType valueOf(String r1) {
        return (BatteryExceptionListener$IssueType) a.a(BatteryExceptionListener$IssueType.class, r1);
    }

    public BatteryExceptionListener$IssueType(String r1, int r2) {
        super(r1, r2);
    }
}
