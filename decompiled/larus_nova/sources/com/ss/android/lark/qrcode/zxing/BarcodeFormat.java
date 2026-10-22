package com.ss.android.lark.qrcode.zxing;

import com.huawei.hms.support.api.entity.common.CommonConstant;

/* JADX INFO: loaded from: classes37.dex */
public final enum BarcodeFormat extends Enum<BarcodeFormat> {
    public static final BarcodeFormat CODABAR = null;
    public static final BarcodeFormat CODE_128 = null;
    public static final BarcodeFormat CODE_39 = null;
    public static final BarcodeFormat CODE_93 = null;
    public static final BarcodeFormat EAN_13 = null;
    public static final BarcodeFormat EAN_8 = null;
    public static final BarcodeFormat QR_CODE = null;
    public static final BarcodeFormat UPC_EAN_EXTENSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BarcodeFormat[] f439104a = null;

    static {
        BarcodeFormat r100 = new BarcodeFormat("CODABAR", 0);
        CODABAR = r100;
        BarcodeFormat r101 = new BarcodeFormat("CODE_39", 1);
        CODE_39 = r101;
        BarcodeFormat r102 = new BarcodeFormat("CODE_93", 2);
        CODE_93 = r102;
        BarcodeFormat r103 = new BarcodeFormat("CODE_128", 3);
        CODE_128 = r103;
        BarcodeFormat r104 = new BarcodeFormat("EAN_8", 4);
        EAN_8 = r104;
        BarcodeFormat r105 = new BarcodeFormat("EAN_13", 5);
        EAN_13 = r105;
        BarcodeFormat r110 = new BarcodeFormat(CommonConstant.RETKEY.QR_CODE, 6);
        QR_CODE = r110;
        BarcodeFormat r111 = new BarcodeFormat("UPC_EAN_EXTENSION", 7);
        UPC_EAN_EXTENSION = r111;
        f439104a = new BarcodeFormat[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static BarcodeFormat[] values() {
        return (BarcodeFormat[]) f439104a.clone();
    }

    public static BarcodeFormat valueOf(String r100) {
        return (BarcodeFormat) r27.a.a(BarcodeFormat.class, r100);
    }

    public BarcodeFormat(String r100, int r101) {
        super(r100, r101);
    }
}
