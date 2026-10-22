package com.google.zxing;

import com.huawei.hms.support.api.entity.common.CommonConstant;

/* JADX INFO: loaded from: classes23.dex */
public final enum BarcodeFormat extends Enum<BarcodeFormat> {
    public static final BarcodeFormat AZTEC = null;
    public static final BarcodeFormat CODABAR = null;
    public static final BarcodeFormat CODE_128 = null;
    public static final BarcodeFormat CODE_39 = null;
    public static final BarcodeFormat CODE_93 = null;
    public static final BarcodeFormat DATA_MATRIX = null;
    public static final BarcodeFormat EAN_13 = null;
    public static final BarcodeFormat EAN_8 = null;
    public static final BarcodeFormat ITF = null;
    public static final BarcodeFormat MAXICODE = null;
    public static final BarcodeFormat PDF_417 = null;
    public static final BarcodeFormat QR_CODE = null;
    public static final BarcodeFormat RSS_14 = null;
    public static final BarcodeFormat RSS_EXPANDED = null;
    public static final BarcodeFormat UPC_A = null;
    public static final BarcodeFormat UPC_E = null;
    public static final BarcodeFormat UPC_EAN_EXTENSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BarcodeFormat[] f275930a = null;

    static {
        BarcodeFormat r100 = new BarcodeFormat("AZTEC", 0);
        AZTEC = r100;
        BarcodeFormat r101 = new BarcodeFormat("CODABAR", 1);
        CODABAR = r101;
        BarcodeFormat r102 = new BarcodeFormat("CODE_39", 2);
        CODE_39 = r102;
        BarcodeFormat r103 = new BarcodeFormat("CODE_93", 3);
        CODE_93 = r103;
        BarcodeFormat r104 = new BarcodeFormat("CODE_128", 4);
        CODE_128 = r104;
        BarcodeFormat r105 = new BarcodeFormat("DATA_MATRIX", 5);
        DATA_MATRIX = r105;
        BarcodeFormat r110 = new BarcodeFormat("EAN_8", 6);
        EAN_8 = r110;
        BarcodeFormat r111 = new BarcodeFormat("EAN_13", 7);
        EAN_13 = r111;
        BarcodeFormat r112 = new BarcodeFormat("ITF", 8);
        ITF = r112;
        BarcodeFormat r113 = new BarcodeFormat("MAXICODE", 9);
        MAXICODE = r113;
        BarcodeFormat r114 = new BarcodeFormat("PDF_417", 10);
        PDF_417 = r114;
        BarcodeFormat r115 = new BarcodeFormat(CommonConstant.RETKEY.QR_CODE, 11);
        QR_CODE = r115;
        BarcodeFormat r106 = new BarcodeFormat("RSS_14", 12);
        RSS_14 = r106;
        BarcodeFormat r107 = new BarcodeFormat("RSS_EXPANDED", 13);
        RSS_EXPANDED = r107;
        BarcodeFormat r108 = new BarcodeFormat("UPC_A", 14);
        UPC_A = r108;
        BarcodeFormat r109 = new BarcodeFormat("UPC_E", 15);
        UPC_E = r109;
        BarcodeFormat r116 = new BarcodeFormat("UPC_EAN_EXTENSION", 16);
        UPC_EAN_EXTENSION = r116;
        f275930a = new BarcodeFormat[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116};
    }

    public static BarcodeFormat[] values() {
        return (BarcodeFormat[]) f275930a.clone();
    }

    public static BarcodeFormat valueOf(String r100) {
        return (BarcodeFormat) r27.a.a(BarcodeFormat.class, r100);
    }

    public BarcodeFormat(String r100, int r101) {
        super(r100, r101);
    }
}
