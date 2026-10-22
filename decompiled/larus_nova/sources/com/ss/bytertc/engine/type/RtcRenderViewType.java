package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RtcRenderViewType extends Enum<RtcRenderViewType> {
    private static final /* synthetic */ RtcRenderViewType[] $VALUES = null;
    public static final RtcRenderViewType RTC_SURFACEVIEW = null;
    public static final RtcRenderViewType RTC_TEXTUREVIEW = null;

    static {
        RtcRenderViewType r100 = new RtcRenderViewType("RTC_SURFACEVIEW", 0);
        RTC_SURFACEVIEW = r100;
        RtcRenderViewType r101 = new RtcRenderViewType("RTC_TEXTUREVIEW", 1);
        RTC_TEXTUREVIEW = r101;
        $VALUES = new RtcRenderViewType[]{r100, r101};
    }

    public static RtcRenderViewType[] values() {
        return (RtcRenderViewType[]) $VALUES.clone();
    }

    public static RtcRenderViewType valueOf(String r100) {
        return (RtcRenderViewType) a.a(RtcRenderViewType.class, r100);
    }

    private RtcRenderViewType(String r100, int r101) {
        super(r100, r101);
    }
}
