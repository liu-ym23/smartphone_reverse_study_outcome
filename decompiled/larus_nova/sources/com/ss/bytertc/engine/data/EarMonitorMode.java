package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum EarMonitorMode extends Enum<EarMonitorMode> {
    private static final /* synthetic */ EarMonitorMode[] $VALUES = null;
    public static final EarMonitorMode EAR_MONITOR_MODE_OFF = null;
    public static final EarMonitorMode EAR_MONITOR_MODE_ON = null;
    private int value;

    static {
        EarMonitorMode r100 = new EarMonitorMode("EAR_MONITOR_MODE_OFF", 0, 0);
        EAR_MONITOR_MODE_OFF = r100;
        EarMonitorMode r101 = new EarMonitorMode("EAR_MONITOR_MODE_ON", 1, 1);
        EAR_MONITOR_MODE_ON = r101;
        $VALUES = new EarMonitorMode[]{r100, r101};
    }

    public static EarMonitorMode[] values() {
        return (EarMonitorMode[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != EAR_MONITOR_MODE_ON) goto L5;
        return "kEarMonitorModeOn";
    L5:
        return "kEarMonitorModeOff";
    }

    public int value() {
        return this.value;
    }

    public static EarMonitorMode fromId(int r100) {
        EarMonitorMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        EarMonitorMode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static EarMonitorMode valueOf(String r100) {
        return (EarMonitorMode) a.a(EarMonitorMode.class, r100);
    }

    private EarMonitorMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
