package com.bytedance.hmp;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum ColorSpace extends Enum<ColorSpace> {
    private static final /* synthetic */ ColorSpace[] $VALUES = null;
    public static final ColorSpace CS_BT2020_CL = null;
    public static final ColorSpace CS_BT2020_NCL = null;
    public static final ColorSpace CS_BT470BG = null;
    public static final ColorSpace CS_BT709 = null;
    public static final ColorSpace CS_CHROMA_DERIVED_CL = null;
    public static final ColorSpace CS_CHROMA_DERIVED_NCL = null;
    public static final ColorSpace CS_FCC = null;
    public static final ColorSpace CS_ICTCP = null;
    public static final ColorSpace CS_NB = null;
    public static final ColorSpace CS_RESERVED = null;
    public static final ColorSpace CS_RGB = null;
    public static final ColorSpace CS_SMPTE170M = null;
    public static final ColorSpace CS_SMPTE2085 = null;
    public static final ColorSpace CS_SMPTE240M = null;
    public static final ColorSpace CS_UNSPECIFIED = null;
    public static final ColorSpace CS_YCGCO = null;
    public static final ColorSpace CS_YCOCG = null;
    private final int value;

    static {
        ColorSpace r100 = new ColorSpace("CS_RGB", 0, 0);
        CS_RGB = r100;
        ColorSpace r101 = new ColorSpace("CS_BT709", 1, 1);
        CS_BT709 = r101;
        ColorSpace r102 = new ColorSpace("CS_UNSPECIFIED", 2, 2);
        CS_UNSPECIFIED = r102;
        ColorSpace r103 = new ColorSpace("CS_RESERVED", 3, 3);
        CS_RESERVED = r103;
        ColorSpace r104 = new ColorSpace("CS_FCC", 4, 4);
        CS_FCC = r104;
        ColorSpace r105 = new ColorSpace("CS_BT470BG", 5, 5);
        CS_BT470BG = r105;
        ColorSpace r110 = new ColorSpace("CS_SMPTE170M", 6, 6);
        CS_SMPTE170M = r110;
        ColorSpace r111 = new ColorSpace("CS_SMPTE240M", 7, 7);
        CS_SMPTE240M = r111;
        ColorSpace r112 = new ColorSpace("CS_YCGCO", 8, 8);
        CS_YCGCO = r112;
        ColorSpace r113 = new ColorSpace("CS_YCOCG", 9, 8);
        CS_YCOCG = r113;
        ColorSpace r114 = new ColorSpace("CS_BT2020_NCL", 10, 9);
        CS_BT2020_NCL = r114;
        ColorSpace r115 = new ColorSpace("CS_BT2020_CL", 11, 10);
        CS_BT2020_CL = r115;
        ColorSpace r106 = new ColorSpace("CS_SMPTE2085", 12, 11);
        CS_SMPTE2085 = r106;
        ColorSpace r107 = new ColorSpace("CS_CHROMA_DERIVED_NCL", 13, 2);
        CS_CHROMA_DERIVED_NCL = r107;
        ColorSpace r108 = new ColorSpace("CS_CHROMA_DERIVED_CL", 14, 13);
        CS_CHROMA_DERIVED_CL = r108;
        ColorSpace r109 = new ColorSpace("CS_ICTCP", 15, 14);
        CS_ICTCP = r109;
        ColorSpace r116 = new ColorSpace("CS_NB", 16, 15);
        CS_NB = r116;
        $VALUES = new ColorSpace[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116};
    }

    public static ColorSpace[] values() {
        return (ColorSpace[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static ColorSpace valueOf(String r100) {
        return (ColorSpace) a.a(ColorSpace.class, r100);
    }

    private ColorSpace(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
