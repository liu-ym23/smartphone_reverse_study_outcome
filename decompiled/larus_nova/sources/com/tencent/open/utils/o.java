package com.tencent.open.utils;

import kotlin.UByte;

/* JADX INFO: loaded from: classes35.dex */
public final class o implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f461876a;

    public byte[] a() {
        int r100 = this.f461876a;
        return new byte[]{(byte) (r100 & 255), (byte) ((r100 & 65280) >> 8)};
    }

    public int b() {
        return this.f461876a;
    }

    public int hashCode() {
        return this.f461876a;
    }

    public o(int r100) {
        this.f461876a = r100;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        if (this.f461876a != ((o) r100).b()) goto L12;
        return true;
    L12:
        return false;
    }

    public o(byte[] r100) {
        this(r100, 0);
    }

    public o(byte[] r100, int r101) {
        this.f461876a = ((r100[r101 + 1] << 8) & 65280) + (r100[r101] & UByte.MAX_VALUE);
    }
}
