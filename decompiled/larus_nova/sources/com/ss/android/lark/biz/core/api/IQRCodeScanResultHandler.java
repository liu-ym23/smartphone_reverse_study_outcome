package com.ss.android.lark.biz.core.api;

import dxa.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes34.dex */
public interface IQRCodeScanResultHandler {

    @Retention(RetentionPolicy.SOURCE)
    public @interface QrCodeSource {
        public static final int PARSE_CODE = 2;
        public static final int PHOTO_CAMERA = 3;
        public static final int SCAN = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScanFormat {
        public static final int BARCODE = 1;
        public static final int QRCODE = 0;
    }

    boolean c(String r100, b r101);
}
