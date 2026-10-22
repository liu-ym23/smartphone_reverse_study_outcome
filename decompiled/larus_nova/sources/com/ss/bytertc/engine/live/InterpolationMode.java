package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum InterpolationMode extends Enum<InterpolationMode> {
    private static final /* synthetic */ InterpolationMode[] $VALUES = null;
    public static final InterpolationMode BACKGROUND_IMAGE_FILL = null;
    public static final InterpolationMode LAST_FRAME_FILL = null;
    private int mode;

    static {
        InterpolationMode r100 = new InterpolationMode("LAST_FRAME_FILL", 0, 0);
        LAST_FRAME_FILL = r100;
        InterpolationMode r101 = new InterpolationMode("BACKGROUND_IMAGE_FILL", 1, 1);
        BACKGROUND_IMAGE_FILL = r101;
        $VALUES = new InterpolationMode[]{r100, r101};
    }

    public static InterpolationMode[] values() {
        return (InterpolationMode[]) $VALUES.clone();
    }

    public int value() {
        return this.mode;
    }

    public static InterpolationMode valueOf(String r100) {
        return (InterpolationMode) a.a(InterpolationMode.class, r100);
    }

    private InterpolationMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mode = r102;
    }
}
