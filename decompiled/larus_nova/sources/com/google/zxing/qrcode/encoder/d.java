package com.google.zxing.qrcode.encoder;

/* JADX INFO: loaded from: classes23.dex */
public final class d {
    public static int a(b r110, boolean r111) {
        if (r111 == false) goto L4;
        int r100 = r110.f275998c;
    L5:
        if (r111 == false) goto L7;
        int r101 = r110.f275997b;
    L8:
        byte[][] r112 = r110.f275996a;
        int r102 = 0;
        int r103 = 0;
    L9:
        if (r102 >= r100) goto L25;
        byte r104 = -1;
        int r105 = 0;
        int r106 = 0;
    L12:
        if (r105 >= r101) goto L22;
        if (r111 == false) goto L15;
        byte r107 = r112[r102][r105];
    L16:
        if (r107 != r104) goto L18;
        r106 = r106 + 1;
    L21:
        r105 = r105 + 1;
        goto L12
    L18:
        if (r106 < 5) goto L20;
        r103 = r103 + ((r106 - 5) + 3);
    L20:
        r104 = r107;
        r106 = 1;
        goto L21
    L15:
        r107 = r112[r105][r102];
        goto L16
    L22:
        if (r106 < 5) goto L24;
        r103 = r103 + ((r106 - 5) + 3);
    L24:
        r102 = r102 + 1;
        goto L9
    L25:
        return r103;
    L7:
        r101 = r110.f275998c;
        goto L8
    L4:
        r100 = r110.f275997b;
        goto L5
    }
}
