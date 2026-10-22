package com.ss.android.socialbase.appdownloader.util.parser.zip;

import kotlin.UByte;

/* JADX INFO: loaded from: classes38.dex */
public final class ZipShort implements Cloneable {
    private static final int BYTE_1_MASK = 65280;
    private static final int BYTE_1_SHIFT = 8;
    private final int value;

    public static byte[] getBytes(int r100) {
        return new byte[]{(byte) (r100 & 255), (byte) ((r100 & 65280) >> 8)};
    }

    public byte[] getBytes() {
        byte[] r100 = new byte[2];
        putShort(this.value, r100, 0);
        return r100;
    }

    public String toString() {
        return "ZipShort value: " + this.value;
    }

    public Object clone() {
        return super.clone();
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }

    public ZipShort(int r100) {
        this.value = r100;
    }

    public static int getValue(byte[] r100) {
        return getValue(r100, 0);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ZipShort) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.value != ((ZipShort) r100).getValue()) goto L7;
        return true;
    }

    public ZipShort(byte[] r100) {
        this(r100, 0);
    }

    public ZipShort(byte[] r100, int r101) {
        this.value = getValue(r100, r101);
    }

    public static int getValue(byte[] r100, int r101) {
        return ((r100[r101 + 1] << 8) & 65280) + (r100[r101] & UByte.MAX_VALUE);
    }

    public static void putShort(int r100, byte[] r101, int r102) {
        r101[r102] = (byte) (r100 & 255);
        r101[r102 + 1] = (byte) ((r100 & 65280) >> 8);
    }
}
