package com.ss.bytertc.engine.video;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum FrameRate extends Enum<FrameRate> {
    private static final /* synthetic */ FrameRate[] $VALUES = null;
    public static final FrameRate FRAME_RATE_FPS_1 = null;
    public static final FrameRate FRAME_RATE_FPS_10 = null;
    public static final FrameRate FRAME_RATE_FPS_15 = null;
    public static final FrameRate FRAME_RATE_FPS_24 = null;
    public static final FrameRate FRAME_RATE_FPS_30 = null;
    public static final FrameRate FRAME_RATE_FPS_7 = null;
    private final int value;

    static {
        FrameRate r100 = new FrameRate("FRAME_RATE_FPS_1", 0, 1);
        FRAME_RATE_FPS_1 = r100;
        FrameRate r101 = new FrameRate("FRAME_RATE_FPS_7", 1, 7);
        FRAME_RATE_FPS_7 = r101;
        FrameRate r102 = new FrameRate("FRAME_RATE_FPS_10", 2, 10);
        FRAME_RATE_FPS_10 = r102;
        FrameRate r103 = new FrameRate("FRAME_RATE_FPS_15", 3, 15);
        FRAME_RATE_FPS_15 = r103;
        FrameRate r104 = new FrameRate("FRAME_RATE_FPS_24", 4, 24);
        FRAME_RATE_FPS_24 = r104;
        FrameRate r105 = new FrameRate("FRAME_RATE_FPS_30", 5, 30);
        FRAME_RATE_FPS_30 = r105;
        $VALUES = new FrameRate[]{r100, r101, r102, r103, r104, r105};
    }

    public static FrameRate[] values() {
        return (FrameRate[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static FrameRate valueOf(String r100) {
        return (FrameRate) a.a(FrameRate.class, r100);
    }

    private FrameRate(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
