package com.ss.android.socialbase.appdownloader.util.parser.zip;

import kotlin.UByte;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes38.dex */
public final class ZipLong implements Cloneable {
    private static final int BYTE_1 = 1;
    private static final int BYTE_1_MASK = 65280;
    private static final int BYTE_1_SHIFT = 8;
    private static final int BYTE_2 = 2;
    private static final int BYTE_2_MASK = 16711680;
    private static final int BYTE_2_SHIFT = 16;
    private static final int BYTE_3 = 3;
    private static final long BYTE_3_MASK = 4278190080L;
    private static final int BYTE_3_SHIFT = 24;
    public static final ZipLong CFH_SIG = null;
    public static final ZipLong DD_SIG = null;
    public static final ZipLong LFH_SIG = null;
    static final ZipLong ZIP64_MAGIC = null;
    private final long value;

    static {
        CFH_SIG = new ZipLong(33639248);
        LFH_SIG = new ZipLong(67324752);
        DD_SIG = new ZipLong(134695760);
        ZIP64_MAGIC = new ZipLong(BodyPartID.bodyIdMax);
    }

    public byte[] getBytes() {
        return getBytes(this.value);
    }

    public int hashCode() {
        return (int) this.value;
    }

    public String toString() {
        return "ZipLong value: " + this.value;
    }

    public Object clone() {
        return super.clone();
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public long getValue() {
        return this.value;
    }

    public ZipLong(long r100) {
        this.value = r100;
    }

    public static byte[] getBytes(long r100) {
        byte[] r101 = new byte[4];
        putLong(r100, r101, 0);
        return r101;
    }

    public static long getValue(byte[] r100) {
        return getValue(r100, 0);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ZipLong) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.value != ((ZipLong) r100).getValue()) goto L7;
        return true;
    }

    public ZipLong(byte[] r100) {
        this(r100, 0);
    }

    public ZipLong(byte[] r100, int r101) {
        this.value = getValue(r100, r101);
    }

    public static long getValue(byte[] r100, int r101) {
        return (((((long) (r100[r101 + 3] << 24)) & BYTE_3_MASK) + ((long) ((r100[r101 + 2] << 16) & BYTE_2_MASK))) + ((long) ((r100[r101 + 1] << 8) & 65280))) + ((long) (r100[r101] & UByte.MAX_VALUE));
    }

    public void putLong(byte[] r100, int r101) {
        putLong(this.value, r100, r101);
    }

    public static void putLong(long r100, byte[] r101, int r102) {
        int r103 = r102 + 1;
        r101[r102] = (byte) (255 & r100);
        int r104 = r103 + 1;
        r101[r103] = (byte) ((65280 & r100) >> 8);
        r101[r104] = (byte) ((16711680 & r100) >> 16);
        r101[r104 + 1] = (byte) ((r100 & BYTE_3_MASK) >> 24);
    }
}
