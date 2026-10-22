package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes42.dex */
public final class ZipShort implements Cloneable, Serializable {
    public static final ZipShort ZERO = null;
    private static final long serialVersionUID = 1;
    private final int value;

    public byte[] getBytes() {
        byte[] r100 = new byte[2];
        ByteUtils.toLittleEndian(r100, this.value, 0, 2);
        return r100;
    }

    static {
        ZERO = new ZipShort(0);
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

    public static byte[] getBytes(int r100) {
        byte[] r101 = new byte[2];
        putShort(r100, r101, 0);
        return r101;
    }

    public static int getValue(byte[] r100) {
        return getValue(r100, 0);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof ZipShort) == true) goto L8;
        return false;
    L8:
        if (this.value != ((ZipShort) r100).getValue()) goto L12;
        return true;
    L12:
        return false;
    }

    public ZipShort(byte[] r100) {
        this(r100, 0);
    }

    public ZipShort(byte[] r100, int r101) {
        this.value = getValue(r100, r101);
    }

    public static int getValue(byte[] r100, int r101) {
        return (int) ByteUtils.fromLittleEndian(r100, r101, 2);
    }

    public static void putShort(int r100, byte[] r101, int r102) {
        ByteUtils.toLittleEndian(r101, r100, r102, 2);
    }
}
