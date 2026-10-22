package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import org.apache.commons.compress.utils.ByteUtils;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes42.dex */
public final class ZipLong implements Cloneable, Serializable {
    public static final ZipLong AED_SIG = null;
    public static final ZipLong CFH_SIG = null;
    public static final ZipLong DD_SIG = null;
    public static final ZipLong LFH_SIG = null;
    public static final ZipLong SINGLE_SEGMENT_SPLIT_MARKER = null;
    static final ZipLong ZIP64_MAGIC = null;
    private static final long serialVersionUID = 1;
    private final long value;

    static {
        CFH_SIG = new ZipLong(33639248);
        LFH_SIG = new ZipLong(67324752);
        DD_SIG = new ZipLong(134695760);
        ZIP64_MAGIC = new ZipLong(BodyPartID.bodyIdMax);
        SINGLE_SEGMENT_SPLIT_MARKER = new ZipLong(808471376);
        AED_SIG = new ZipLong(134630224);
    }

    public byte[] getBytes() {
        return getBytes(this.value);
    }

    public int getIntValue() {
        return (int) this.value;
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

    public ZipLong(int r100) {
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
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof ZipLong) == true) goto L8;
        return false;
    L8:
        if (this.value != ((ZipLong) r100).getValue()) goto L12;
        return true;
    L12:
        return false;
    }

    public ZipLong(long r100) {
        this.value = r100;
    }

    public ZipLong(byte[] r100) {
        this(r100, 0);
    }

    public ZipLong(byte[] r100, int r101) {
        this.value = getValue(r100, r101);
    }

    public static long getValue(byte[] r100, int r101) {
        return ByteUtils.fromLittleEndian(r100, r101, 4);
    }

    public void putLong(byte[] r100, int r101) {
        putLong(this.value, r100, r101);
    }

    public static void putLong(long r100, byte[] r101, int r102) {
        ByteUtils.toLittleEndian(r101, r100, r102, 4);
    }
}
