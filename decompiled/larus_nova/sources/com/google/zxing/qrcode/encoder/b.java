package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[][] f275996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f275997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f275998c;

    public final String toString() {
        StringBuilder r100 = new StringBuilder(((this.f275997b * 2) * this.f275998c) + 2);
        int r101 = 0;
    L4:
        if (r101 >= this.f275998c) goto L18;
        byte[] r102 = this.f275996a[r101];
        int r103 = 0;
    L7:
        if (r103 >= this.f275997b) goto L16;
        byte r104 = r102[r103];
        if (r104 != 0) goto L11;
        r100.append(" 0");
    L15:
        r103 = r103 + 1;
        goto L7
    L11:
        if (r104 == 1) goto L13;
        r100.append(tb2.c.DEFAULT_TEXT);
        goto L15
    L13:
        r100.append(" 1");
        goto L15
    L16:
        r100.append('\n');
        r101 = r101 + 1;
        goto L4
    L18:
        return r100.toString();
    }

    public b(int r100, int r101) {
        this.f275996a = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{r101, r100});
        this.f275997b = r100;
        this.f275998c = r101;
    }

    public final byte a(int r100, int r101) {
        return this.f275996a[r101][r100];
    }

    public final void b(int r100, int r101, int r102) {
        this.f275996a[r101][r100] = (byte) r102;
    }
}
