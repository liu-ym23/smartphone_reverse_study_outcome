package com.ss.bytertc.engine.type;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum PerformanceAlarmMode extends Enum<PerformanceAlarmMode> {
    private static final /* synthetic */ PerformanceAlarmMode[] $VALUES = null;
    public static final PerformanceAlarmMode NORMAL = null;
    public static final PerformanceAlarmMode SIMULCAST = null;
    private int value;

    static {
        PerformanceAlarmMode r100 = new PerformanceAlarmMode(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        PerformanceAlarmMode r101 = new PerformanceAlarmMode("SIMULCAST", 1, 1);
        SIMULCAST = r101;
        $VALUES = new PerformanceAlarmMode[]{r100, r101};
    }

    public static PerformanceAlarmMode[] values() {
        return (PerformanceAlarmMode[]) $VALUES.clone();
    }

    public static PerformanceAlarmMode valueOf(String r100) {
        return (PerformanceAlarmMode) a.a(PerformanceAlarmMode.class, r100);
    }

    private PerformanceAlarmMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
