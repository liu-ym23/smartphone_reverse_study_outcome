package com.ss.android.lark.qrcode.zxing;

/* JADX INFO: loaded from: classes37.dex */
public final enum EncodeHintType extends Enum<EncodeHintType> {
    public static final EncodeHintType AZTEC_LAYERS = null;
    public static final EncodeHintType CHARACTER_SET = null;
    public static final EncodeHintType DATA_MATRIX_SHAPE = null;
    public static final EncodeHintType ERROR_CORRECTION = null;
    public static final EncodeHintType GS1_FORMAT = null;
    public static final EncodeHintType MARGIN = null;
    public static final EncodeHintType MAX_SIZE = null;
    public static final EncodeHintType MIN_SIZE = null;
    public static final EncodeHintType PDF417_COMPACT = null;
    public static final EncodeHintType PDF417_COMPACTION = null;
    public static final EncodeHintType PDF417_DIMENSIONS = null;
    public static final EncodeHintType QR_VERSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EncodeHintType[] f439107a = null;

    static {
        EncodeHintType r100 = new EncodeHintType("ERROR_CORRECTION", 0);
        ERROR_CORRECTION = r100;
        EncodeHintType r101 = new EncodeHintType("CHARACTER_SET", 1);
        CHARACTER_SET = r101;
        EncodeHintType r102 = new EncodeHintType("DATA_MATRIX_SHAPE", 2);
        DATA_MATRIX_SHAPE = r102;
        EncodeHintType r103 = new EncodeHintType("MIN_SIZE", 3);
        MIN_SIZE = r103;
        EncodeHintType r104 = new EncodeHintType("MAX_SIZE", 4);
        MAX_SIZE = r104;
        EncodeHintType r105 = new EncodeHintType("MARGIN", 5);
        MARGIN = r105;
        EncodeHintType r110 = new EncodeHintType("PDF417_COMPACT", 6);
        PDF417_COMPACT = r110;
        EncodeHintType r111 = new EncodeHintType("PDF417_COMPACTION", 7);
        PDF417_COMPACTION = r111;
        EncodeHintType r112 = new EncodeHintType("PDF417_DIMENSIONS", 8);
        PDF417_DIMENSIONS = r112;
        EncodeHintType r113 = new EncodeHintType("AZTEC_LAYERS", 9);
        AZTEC_LAYERS = r113;
        EncodeHintType r114 = new EncodeHintType("QR_VERSION", 10);
        QR_VERSION = r114;
        EncodeHintType r115 = new EncodeHintType("GS1_FORMAT", 11);
        GS1_FORMAT = r115;
        f439107a = new EncodeHintType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
    }

    public static EncodeHintType[] values() {
        return (EncodeHintType[]) f439107a.clone();
    }

    public static EncodeHintType valueOf(String r100) {
        return (EncodeHintType) r27.a.a(EncodeHintType.class, r100);
    }

    public EncodeHintType(String r100, int r101) {
        super(r100, r101);
    }
}
