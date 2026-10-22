package com.bytedance.hmp;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum ColorPrimaries extends Enum<ColorPrimaries> {
    private static final /* synthetic */ ColorPrimaries[] $VALUES = null;
    public static final ColorPrimaries CP_BT2020 = null;
    public static final ColorPrimaries CP_BT470BG = null;
    public static final ColorPrimaries CP_BT470M = null;
    public static final ColorPrimaries CP_BT709 = null;
    public static final ColorPrimaries CP_EBU3213 = null;
    public static final ColorPrimaries CP_FILM = null;
    public static final ColorPrimaries CP_JEDEC_P22 = null;
    public static final ColorPrimaries CP_NB = null;
    public static final ColorPrimaries CP_RESERVED = null;
    public static final ColorPrimaries CP_RESERVED0 = null;
    public static final ColorPrimaries CP_SMPTE170M = null;
    public static final ColorPrimaries CP_SMPTE240M = null;
    public static final ColorPrimaries CP_SMPTE428 = null;
    public static final ColorPrimaries CP_SMPTE431 = null;
    public static final ColorPrimaries CP_SMPTE432 = null;
    public static final ColorPrimaries CP_SMPTEST428_1 = null;
    public static final ColorPrimaries CP_UNSPECIFIED = null;
    private final int value;

    static {
        ColorPrimaries r100 = new ColorPrimaries("CP_RESERVED0", 0, 0);
        CP_RESERVED0 = r100;
        ColorPrimaries r101 = new ColorPrimaries("CP_BT709", 1, 1);
        CP_BT709 = r101;
        ColorPrimaries r102 = new ColorPrimaries("CP_UNSPECIFIED", 2, 2);
        CP_UNSPECIFIED = r102;
        ColorPrimaries r103 = new ColorPrimaries("CP_RESERVED", 3, 3);
        CP_RESERVED = r103;
        ColorPrimaries r104 = new ColorPrimaries("CP_BT470M", 4, 4);
        CP_BT470M = r104;
        ColorPrimaries r105 = new ColorPrimaries("CP_BT470BG", 5, 5);
        CP_BT470BG = r105;
        ColorPrimaries r110 = new ColorPrimaries("CP_SMPTE170M", 6, 6);
        CP_SMPTE170M = r110;
        ColorPrimaries r111 = new ColorPrimaries("CP_SMPTE240M", 7, 7);
        CP_SMPTE240M = r111;
        ColorPrimaries r112 = new ColorPrimaries("CP_FILM", 8, 8);
        CP_FILM = r112;
        ColorPrimaries r113 = new ColorPrimaries("CP_BT2020", 9, 9);
        CP_BT2020 = r113;
        ColorPrimaries r114 = new ColorPrimaries("CP_SMPTE428", 10, 10);
        CP_SMPTE428 = r114;
        ColorPrimaries r115 = new ColorPrimaries("CP_SMPTEST428_1", 11, 10);
        CP_SMPTEST428_1 = r115;
        ColorPrimaries r106 = new ColorPrimaries("CP_SMPTE431", 12, 11);
        CP_SMPTE431 = r106;
        ColorPrimaries r107 = new ColorPrimaries("CP_SMPTE432", 13, 12);
        CP_SMPTE432 = r107;
        ColorPrimaries r108 = new ColorPrimaries("CP_EBU3213", 14, 22);
        CP_EBU3213 = r108;
        ColorPrimaries r109 = new ColorPrimaries("CP_JEDEC_P22", 15, 22);
        CP_JEDEC_P22 = r109;
        ColorPrimaries r116 = new ColorPrimaries("CP_NB", 16, 23);
        CP_NB = r116;
        $VALUES = new ColorPrimaries[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116};
    }

    public static ColorPrimaries[] values() {
        return (ColorPrimaries[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static ColorPrimaries valueOf(String r100) {
        return (ColorPrimaries) a.a(ColorPrimaries.class, r100);
    }

    private ColorPrimaries(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
