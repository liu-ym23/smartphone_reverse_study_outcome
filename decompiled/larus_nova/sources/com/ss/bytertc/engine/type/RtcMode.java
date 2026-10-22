package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RtcMode extends Enum<RtcMode> {
    private static final /* synthetic */ RtcMode[] $VALUES = null;
    public static final RtcMode RTC_MODE_GENERAL = null;
    public static final RtcMode RTC_MODE_LOCAL_AUDIO = null;
    private int value;

    static {
        RtcMode r100 = new RtcMode("RTC_MODE_GENERAL", 0, 0);
        RTC_MODE_GENERAL = r100;
        RtcMode r101 = new RtcMode("RTC_MODE_LOCAL_AUDIO", 1, 1);
        RTC_MODE_LOCAL_AUDIO = r101;
        $VALUES = new RtcMode[]{r100, r101};
    }

    public static RtcMode[] values() {
        return (RtcMode[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RtcMode valueOf(String r100) {
        return (RtcMode) a.a(RtcMode.class, r100);
    }

    private RtcMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
