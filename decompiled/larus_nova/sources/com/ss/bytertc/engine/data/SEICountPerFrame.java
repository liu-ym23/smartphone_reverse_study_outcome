package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum SEICountPerFrame extends Enum<SEICountPerFrame> {
    private static final /* synthetic */ SEICountPerFrame[] $VALUES = null;
    public static final SEICountPerFrame SEI_COUNT_PER_FRAME_MULTI = null;
    public static final SEICountPerFrame SEI_COUNT_PER_FRAME_SINGLE = null;
    private int value;

    static {
        SEICountPerFrame r100 = new SEICountPerFrame("SEI_COUNT_PER_FRAME_SINGLE", 0, 0);
        SEI_COUNT_PER_FRAME_SINGLE = r100;
        SEICountPerFrame r101 = new SEICountPerFrame("SEI_COUNT_PER_FRAME_MULTI", 1, 1);
        SEI_COUNT_PER_FRAME_MULTI = r101;
        $VALUES = new SEICountPerFrame[]{r100, r101};
    }

    public static SEICountPerFrame[] values() {
        return (SEICountPerFrame[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static SEICountPerFrame fromId(int r100) {
        SEICountPerFrame[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        SEICountPerFrame r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static SEICountPerFrame valueOf(String r100) {
        return (SEICountPerFrame) a.a(SEICountPerFrame.class, r100);
    }

    private SEICountPerFrame(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
