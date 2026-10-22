package com.bytedance.hmp;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum ColorTransferCharacteristic extends Enum<ColorTransferCharacteristic> {
    private static final /* synthetic */ ColorTransferCharacteristic[] $VALUES = null;
    public static final ColorTransferCharacteristic CTC_ARIB_STD_B67 = null;
    public static final ColorTransferCharacteristic CTC_BT1361_ECG = null;
    public static final ColorTransferCharacteristic CTC_BT2020_10 = null;
    public static final ColorTransferCharacteristic CTC_BT2020_12 = null;
    public static final ColorTransferCharacteristic CTC_BT709 = null;
    public static final ColorTransferCharacteristic CTC_GAMMA22 = null;
    public static final ColorTransferCharacteristic CTC_GAMMA28 = null;
    public static final ColorTransferCharacteristic CTC_IEC61966_2_1 = null;
    public static final ColorTransferCharacteristic CTC_IEC61966_2_4 = null;
    public static final ColorTransferCharacteristic CTC_LINEAR = null;
    public static final ColorTransferCharacteristic CTC_LOG = null;
    public static final ColorTransferCharacteristic CTC_LOG_SQRT = null;
    public static final ColorTransferCharacteristic CTC_NB = null;
    public static final ColorTransferCharacteristic CTC_RESERVED = null;
    public static final ColorTransferCharacteristic CTC_RESERVED0 = null;
    public static final ColorTransferCharacteristic CTC_SMPTE170M = null;
    public static final ColorTransferCharacteristic CTC_SMPTE2084 = null;
    public static final ColorTransferCharacteristic CTC_SMPTE240M = null;
    public static final ColorTransferCharacteristic CTC_SMPTE428 = null;
    public static final ColorTransferCharacteristic CTC_SMPTEST2084 = null;
    public static final ColorTransferCharacteristic CTC_SMPTEST428_1 = null;
    public static final ColorTransferCharacteristic CTC_UNSPECIFIED = null;
    private final int value;

    static {
        ColorTransferCharacteristic r100 = new ColorTransferCharacteristic("CTC_RESERVED0", 0, 0);
        CTC_RESERVED0 = r100;
        ColorTransferCharacteristic r101 = new ColorTransferCharacteristic("CTC_BT709", 1, 1);
        CTC_BT709 = r101;
        ColorTransferCharacteristic r102 = new ColorTransferCharacteristic("CTC_UNSPECIFIED", 2, 2);
        CTC_UNSPECIFIED = r102;
        ColorTransferCharacteristic r103 = new ColorTransferCharacteristic("CTC_RESERVED", 3, 3);
        CTC_RESERVED = r103;
        ColorTransferCharacteristic r104 = new ColorTransferCharacteristic("CTC_GAMMA22", 4, 4);
        CTC_GAMMA22 = r104;
        ColorTransferCharacteristic r105 = new ColorTransferCharacteristic("CTC_GAMMA28", 5, 5);
        CTC_GAMMA28 = r105;
        ColorTransferCharacteristic r110 = new ColorTransferCharacteristic("CTC_SMPTE170M", 6, 6);
        CTC_SMPTE170M = r110;
        ColorTransferCharacteristic r111 = new ColorTransferCharacteristic("CTC_SMPTE240M", 7, 7);
        CTC_SMPTE240M = r111;
        ColorTransferCharacteristic r112 = new ColorTransferCharacteristic("CTC_LINEAR", 8, 8);
        CTC_LINEAR = r112;
        ColorTransferCharacteristic r113 = new ColorTransferCharacteristic("CTC_LOG", 9, 9);
        CTC_LOG = r113;
        ColorTransferCharacteristic r114 = new ColorTransferCharacteristic("CTC_LOG_SQRT", 10, 10);
        CTC_LOG_SQRT = r114;
        ColorTransferCharacteristic r115 = new ColorTransferCharacteristic("CTC_IEC61966_2_4", 11, 11);
        CTC_IEC61966_2_4 = r115;
        ColorTransferCharacteristic r106 = new ColorTransferCharacteristic("CTC_BT1361_ECG", 12, 12);
        CTC_BT1361_ECG = r106;
        ColorTransferCharacteristic r107 = new ColorTransferCharacteristic("CTC_IEC61966_2_1", 13, 13);
        CTC_IEC61966_2_1 = r107;
        ColorTransferCharacteristic r108 = new ColorTransferCharacteristic("CTC_BT2020_10", 14, 14);
        CTC_BT2020_10 = r108;
        ColorTransferCharacteristic r109 = new ColorTransferCharacteristic("CTC_BT2020_12", 15, 15);
        CTC_BT2020_12 = r109;
        ColorTransferCharacteristic r116 = new ColorTransferCharacteristic("CTC_SMPTE2084", 16, 16);
        CTC_SMPTE2084 = r116;
        ColorTransferCharacteristic r117 = new ColorTransferCharacteristic("CTC_SMPTEST2084", 17, 16);
        CTC_SMPTEST2084 = r117;
        ColorTransferCharacteristic r118 = new ColorTransferCharacteristic("CTC_SMPTE428", 18, 17);
        CTC_SMPTE428 = r118;
        ColorTransferCharacteristic r119 = new ColorTransferCharacteristic("CTC_SMPTEST428_1", 19, 17);
        CTC_SMPTEST428_1 = r119;
        ColorTransferCharacteristic r120 = new ColorTransferCharacteristic("CTC_ARIB_STD_B67", 20, 18);
        CTC_ARIB_STD_B67 = r120;
        ColorTransferCharacteristic r121 = new ColorTransferCharacteristic("CTC_NB", 21, 19);
        CTC_NB = r121;
        $VALUES = new ColorTransferCharacteristic[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121};
    }

    public static ColorTransferCharacteristic[] values() {
        return (ColorTransferCharacteristic[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static ColorTransferCharacteristic valueOf(String r100) {
        return (ColorTransferCharacteristic) a.a(ColorTransferCharacteristic.class, r100);
    }

    private ColorTransferCharacteristic(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
