package com.ss.android.lark.biz.core.api;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum BarcodeFormat extends Enum<BarcodeFormat> {
    public static final BarcodeFormat CODABAR = null;
    public static final BarcodeFormat CODE_128 = null;
    public static final BarcodeFormat CODE_39 = null;
    public static final BarcodeFormat CODE_93 = null;
    public static final BarcodeFormat CODE_ITF = null;
    public static final BarcodeFormat DATA_MATRIX = null;
    public static final BarcodeFormat EAN_13 = null;
    public static final BarcodeFormat EAN_8 = null;
    public static final BarcodeFormat PDF_417 = null;
    public static final BarcodeFormat QR_CODE = null;
    public static final BarcodeFormat UPC_A = null;
    public static final BarcodeFormat UPC_E = null;
    public static final BarcodeFormat UPC_EAN_EXTENSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BarcodeFormat[] f409789a = null;

    static {
        BarcodeFormat r100 = new BarcodeFormat("CODABAR", 0);
        CODABAR = r100;
        BarcodeFormat r101 = new BarcodeFormat("CODE_39", 1);
        CODE_39 = r101;
        BarcodeFormat r102 = new BarcodeFormat("CODE_93", 2);
        CODE_93 = r102;
        BarcodeFormat r103 = new BarcodeFormat("CODE_128", 3);
        CODE_128 = r103;
        BarcodeFormat r104 = new BarcodeFormat("DATA_MATRIX", 4);
        DATA_MATRIX = r104;
        BarcodeFormat r105 = new BarcodeFormat("EAN_8", 5);
        EAN_8 = r105;
        BarcodeFormat r110 = new BarcodeFormat("EAN_13", 6);
        EAN_13 = r110;
        BarcodeFormat r111 = new BarcodeFormat("PDF_417", 7);
        PDF_417 = r111;
        BarcodeFormat r112 = new BarcodeFormat(CommonConstant.RETKEY.QR_CODE, 8);
        QR_CODE = r112;
        BarcodeFormat r113 = new BarcodeFormat("UPC_A", 9);
        UPC_A = r113;
        BarcodeFormat r114 = new BarcodeFormat("UPC_E", 10);
        UPC_E = r114;
        BarcodeFormat r115 = new BarcodeFormat("UPC_EAN_EXTENSION", 11);
        UPC_EAN_EXTENSION = r115;
        BarcodeFormat r106 = new BarcodeFormat("CODE_ITF", 12);
        CODE_ITF = r106;
        f409789a = new BarcodeFormat[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
    }

    public static BarcodeFormat[] values() {
        return (BarcodeFormat[]) f409789a.clone();
    }

    public static BarcodeFormat valueOf(String r100) {
        return (BarcodeFormat) a.a(BarcodeFormat.class, r100);
    }

    public BarcodeFormat(String r100, int r101) {
        super(r100, r101);
    }
}
