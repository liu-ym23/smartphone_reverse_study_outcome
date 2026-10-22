package com.bytedance.ug.sdk.luckydog.api.ab;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum ABServiceEffectTime extends Enum<ABServiceEffectTime> {
    private static final /* synthetic */ ABServiceEffectTime[] $VALUES = null;
    public static final ABServiceEffectTime ColdLaunch = null;
    public static final ABServiceEffectTime RealTime = null;

    static {
        ABServiceEffectTime r100 = new ABServiceEffectTime("ColdLaunch", 0);
        ColdLaunch = r100;
        ABServiceEffectTime r101 = new ABServiceEffectTime("RealTime", 1);
        RealTime = r101;
        $VALUES = new ABServiceEffectTime[]{r100, r101};
    }

    public static ABServiceEffectTime[] values() {
        return (ABServiceEffectTime[]) $VALUES.clone();
    }

    public static ABServiceEffectTime valueOf(String r100) {
        return (ABServiceEffectTime) a.a(ABServiceEffectTime.class, r100);
    }

    private ABServiceEffectTime(String r100, int r101) {
        super(r100, r101);
    }
}
