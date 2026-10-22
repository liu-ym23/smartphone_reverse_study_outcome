package com.bytedance.hmp;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum ColorRange extends Enum<ColorRange> {
    private static final /* synthetic */ ColorRange[] $VALUES = null;
    public static final ColorRange CR_JPEG = null;
    public static final ColorRange CR_MPEG = null;
    public static final ColorRange CR_NB = null;
    public static final ColorRange CR_UNSPECIFIED = null;
    private final int value;

    static {
        ColorRange r100 = new ColorRange("CR_UNSPECIFIED", 0, 0);
        CR_UNSPECIFIED = r100;
        ColorRange r101 = new ColorRange("CR_MPEG", 1, 1);
        CR_MPEG = r101;
        ColorRange r102 = new ColorRange("CR_JPEG", 2, 2);
        CR_JPEG = r102;
        ColorRange r103 = new ColorRange("CR_NB", 3, 3);
        CR_NB = r103;
        $VALUES = new ColorRange[]{r100, r101, r102, r103};
    }

    public static ColorRange[] values() {
        return (ColorRange[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static ColorRange valueOf(String r100) {
        return (ColorRange) a.a(ColorRange.class, r100);
    }

    private ColorRange(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
