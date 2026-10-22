package com.github.alexzhirkevich.customqrgenerator.encoder;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class c {
    public static final QrCodeMatrix a(com.google.zxing.qrcode.encoder.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.f275997b;
        if (r101 != r100.f275998c) goto L16;
        QrCodeMatrix r102 = new QrCodeMatrix(r101);
        int r103 = r100.f275997b;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L14;
        int r105 = r100.f275997b;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L13;
        if (r100.a(r104, r106) != 1) goto L11;
        QrCodeMatrix.PixelType r107 = QrCodeMatrix.PixelType.DarkPixel;
    L12:
        r102.b(r104, r106, r107);
        r106 = r106 + 1;
        goto L7
    L11:
        r107 = QrCodeMatrix.PixelType.LightPixel;
        goto L12
    L13:
        r104 = r104 + 1;
        goto L5
    L14:
        return r102;
    L16:
        throw new IllegalStateException("Non-square qr byte matrix");
    }
}
