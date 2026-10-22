package com.google.zxing;

/* JADX INFO: loaded from: classes23.dex */
public final enum EncodeHintType extends Enum<EncodeHintType> {
    public static final EncodeHintType AZTEC_LAYERS = null;
    public static final EncodeHintType CHARACTER_SET = null;
    public static final EncodeHintType CODE128_COMPACT = null;
    public static final EncodeHintType DATA_MATRIX_COMPACT = null;
    public static final EncodeHintType DATA_MATRIX_SHAPE = null;
    public static final EncodeHintType ERROR_CORRECTION = null;
    public static final EncodeHintType FORCE_C40 = null;
    public static final EncodeHintType FORCE_CODE_SET = null;
    public static final EncodeHintType GS1_FORMAT = null;
    public static final EncodeHintType MARGIN = null;
    public static final EncodeHintType MAX_SIZE = null;
    public static final EncodeHintType MIN_SIZE = null;
    public static final EncodeHintType PDF417_AUTO_ECI = null;
    public static final EncodeHintType PDF417_COMPACT = null;
    public static final EncodeHintType PDF417_COMPACTION = null;
    public static final EncodeHintType PDF417_DIMENSIONS = null;
    public static final EncodeHintType QR_COMPACT = null;
    public static final EncodeHintType QR_MASK_PATTERN = null;
    public static final EncodeHintType QR_VERSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EncodeHintType[] f275933a = null;

    static {
        EncodeHintType r100 = new EncodeHintType("ERROR_CORRECTION", 0);
        ERROR_CORRECTION = r100;
        EncodeHintType r101 = new EncodeHintType("CHARACTER_SET", 1);
        CHARACTER_SET = r101;
        EncodeHintType r102 = new EncodeHintType("DATA_MATRIX_SHAPE", 2);
        DATA_MATRIX_SHAPE = r102;
        EncodeHintType r103 = new EncodeHintType("DATA_MATRIX_COMPACT", 3);
        DATA_MATRIX_COMPACT = r103;
        EncodeHintType r104 = new EncodeHintType("MIN_SIZE", 4);
        MIN_SIZE = r104;
        EncodeHintType r105 = new EncodeHintType("MAX_SIZE", 5);
        MAX_SIZE = r105;
        EncodeHintType r110 = new EncodeHintType("MARGIN", 6);
        MARGIN = r110;
        EncodeHintType r111 = new EncodeHintType("PDF417_COMPACT", 7);
        PDF417_COMPACT = r111;
        EncodeHintType r112 = new EncodeHintType("PDF417_COMPACTION", 8);
        PDF417_COMPACTION = r112;
        EncodeHintType r113 = new EncodeHintType("PDF417_DIMENSIONS", 9);
        PDF417_DIMENSIONS = r113;
        EncodeHintType r114 = new EncodeHintType("PDF417_AUTO_ECI", 10);
        PDF417_AUTO_ECI = r114;
        EncodeHintType r115 = new EncodeHintType("AZTEC_LAYERS", 11);
        AZTEC_LAYERS = r115;
        EncodeHintType r106 = new EncodeHintType("QR_VERSION", 12);
        QR_VERSION = r106;
        EncodeHintType r107 = new EncodeHintType("QR_MASK_PATTERN", 13);
        QR_MASK_PATTERN = r107;
        EncodeHintType r108 = new EncodeHintType("QR_COMPACT", 14);
        QR_COMPACT = r108;
        EncodeHintType r109 = new EncodeHintType("GS1_FORMAT", 15);
        GS1_FORMAT = r109;
        EncodeHintType r116 = new EncodeHintType("FORCE_CODE_SET", 16);
        FORCE_CODE_SET = r116;
        EncodeHintType r117 = new EncodeHintType("FORCE_C40", 17);
        FORCE_C40 = r117;
        EncodeHintType r118 = new EncodeHintType("CODE128_COMPACT", 18);
        CODE128_COMPACT = r118;
        f275933a = new EncodeHintType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118};
    }

    public static EncodeHintType[] values() {
        return (EncodeHintType[]) f275933a.clone();
    }

    public static EncodeHintType valueOf(String r100) {
        return (EncodeHintType) r27.a.a(EncodeHintType.class, r100);
    }

    public EncodeHintType(String r100, int r101) {
        super(r100, r101);
    }
}
