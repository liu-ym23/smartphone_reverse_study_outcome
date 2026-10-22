package com.google.common.hash;

import com.google.common.base.m;
import com.google.common.primitives.UnsignedInts;
import java.io.Serializable;
import javax.annotation.CheckForNull;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class HashCode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f275565a = null;

    public static final class BytesHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final byte[] bytes;

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            return (byte[]) this.bytes.clone();
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            byte[] r100 = this.bytes;
            if (r100.length < 4) goto L5;
            boolean r101 = true;
        L6:
            m.q(r101, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", r100.length);
            byte[] r102 = this.bytes;
            int r103 = ((r102[0] & UByte.MAX_VALUE) | ((r102[1] & UByte.MAX_VALUE) << 8)) | ((r102[2] & UByte.MAX_VALUE) << 16);
            return ((r102[3] & UByte.MAX_VALUE) << 24) | r103;
        L5:
            r101 = false;
            goto L6
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            byte[] r100 = this.bytes;
            if (r100.length < 8) goto L5;
            boolean r101 = true;
        L6:
            m.q(r101, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", r100.length);
            return padToLong();
        L5:
            r101 = false;
            goto L6
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return this.bytes.length * 8;
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            long r100 = this.bytes[0] & UByte.MAX_VALUE;
            int r101 = 1;
        L4:
            if (r101 >= Math.min(this.bytes.length, 8)) goto L6;
            r100 = r100 | ((((long) this.bytes[r101]) & 255) << (r101 * 8));
            r101 = r101 + 1;
            goto L4
        L6:
            return r100;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] getBytesInternal() {
            return this.bytes;
        }

        public BytesHashCode(byte[] r100) {
            r100.getClass();
            this.bytes = r100;
        }

        @Override // com.google.common.hash.HashCode
        public boolean equalsSameBits(HashCode r100) {
            if (this.bytes.length == r100.getBytesInternal().length) goto L5;
            return false;
        L5:
            int r101 = 0;
            boolean r102 = true;
        L6:
            byte[] r103 = this.bytes;
            if (r101 >= r103.length) goto L13;
            if (r103[r101] != r100.getBytesInternal()[r101]) goto L11;
            boolean r104 = true;
        L12:
            r102 = r102 & r104;
            r101 = r101 + 1;
            goto L6
        L11:
            r104 = false;
            goto L12
        L13:
            return r102;
        }

        @Override // com.google.common.hash.HashCode
        public void writeBytesToImpl(byte[] r100, int r101, int r102) {
            System.arraycopy(this.bytes, 0, r100, r101, r102);
        }
    }

    public static final class IntHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final int hash;

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            int r100 = this.hash;
            return new byte[]{(byte) r100, (byte) (r100 >> 8), (byte) (r100 >> 16), (byte) (r100 >> 24)};
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 32;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return UnsignedInts.a(this.hash);
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return this.hash;
        }

        public IntHashCode(int r100) {
            this.hash = r100;
        }

        @Override // com.google.common.hash.HashCode
        public boolean equalsSameBits(HashCode r100) {
            if (this.hash != r100.asInt()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.hash.HashCode
        public void writeBytesToImpl(byte[] r100, int r101, int r102) {
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L5;
            r100[r101 + r103] = (byte) (this.hash >> (r103 * 8));
            r103 = r103 + 1;
            goto L3
        }
    }

    public static final class LongHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final long hash;

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 64;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            long r100 = this.hash;
            return new byte[]{(byte) r100, (byte) (r100 >> 8), (byte) (r100 >> 16), (byte) (r100 >> 24), (byte) (r100 >> 32), (byte) (r100 >> 40), (byte) (r100 >> 48), (byte) (r100 >> 56)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return (int) this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return this.hash;
        }

        public LongHashCode(long r100) {
            this.hash = r100;
        }

        @Override // com.google.common.hash.HashCode
        public boolean equalsSameBits(HashCode r100) {
            if (this.hash != r100.asLong()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.hash.HashCode
        public void writeBytesToImpl(byte[] r100, int r101, int r102) {
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L5;
            r100[r101 + r103] = (byte) (this.hash >> (r103 * 8));
            r103 = r103 + 1;
            goto L3
        }
    }

    public HashCode() {
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    public abstract int bits();

    public abstract boolean equalsSameBits(HashCode r100);

    public abstract long padToLong();

    public abstract void writeBytesToImpl(byte[] r100, int r101, int r102);

    static {
        f275565a = "0123456789abcdef".toCharArray();
    }

    public byte[] getBytesInternal() {
        return asBytes();
    }

    public final int hashCode() {
        if (bits() >= 32) goto L5;
        byte[] r100 = getBytesInternal();
        int r101 = r100[0] & UByte.MAX_VALUE;
        int r102 = 1;
    L8:
        if (r102 >= r100.length) goto L10;
        r101 = r101 | ((r100[r102] & UByte.MAX_VALUE) << (r102 * 8));
        r102 = r102 + 1;
        goto L8
    L10:
        return r101;
    L5:
        return asInt();
    }

    public final String toString() {
        byte[] r100 = getBytesInternal();
        StringBuilder r101 = new StringBuilder(r100.length * 2);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        byte r104 = r100[r103];
        char[] r105 = f275565a;
        r101.append(r105[(r104 >> 4) & 15]);
        r101.append(r105[r104 & 15]);
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toString();
    }

    public static int a(char r100) {
        if (r100 < '0') goto L9;
        if (r100 > '9') goto L9;
        return r100 - '0';
    L9:
        if (r100 < 'a') goto L15;
        if (r100 > 'f') goto L15;
        return (r100 - 'a') + 10;
    L15:
        throw new IllegalArgumentException("Illegal hexadecimal character: " + r100);
    }

    public static HashCode fromBytes(byte[] r100) {
        boolean r101 = true;
        if (r100.length >= 1) goto L6;
        r101 = false;
    L6:
        m.c(r101, "A HashCode must contain at least 1 byte.");
        return fromBytesNoCopy((byte[]) r100.clone());
    }

    public static HashCode fromBytesNoCopy(byte[] r100) {
        return new BytesHashCode(r100);
    }

    public static HashCode fromInt(int r100) {
        return new IntHashCode(r100);
    }

    public static HashCode fromLong(long r100) {
        return new LongHashCode(r100);
    }

    public static HashCode fromString(String r100) {
        boolean r101 = true;
        int r102 = 0;
        if (r100.length() < 2) goto L5;
        boolean r103 = true;
    L6:
        m.h(r103, "input string (%s) must have at least 2 characters", r100);
        if ((r100.length() % 2) == 0) goto L10;
        r101 = false;
    L10:
        m.h(r101, "input string (%s) must have an even number of characters", r100);
        byte[] r104 = new byte[r100.length() / 2];
    L12:
        if (r102 >= r100.length()) goto L15;
        r104[r102 / 2] = (byte) ((a(r100.charAt(r102)) << 4) + a(r100.charAt(r102 + 1)));
        r102 = r102 + 2;
        goto L12
    L15:
        return fromBytesNoCopy(r104);
    L5:
        r103 = false;
        goto L6
    }

    public final boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof HashCode) == false) goto L10;
        HashCode r101 = (HashCode) r100;
        if (bits() == r101.bits()) goto L7;
        return false;
    L7:
        if (equalsSameBits(r101) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int writeBytesTo(byte[] r100, int r101, int r102) {
        int[] r103 = {r102, bits() / 8};
        int r104 = r103[0];
        int r105 = r103[1];
        if (r105 >= r104) goto L5;
        r104 = r105;
    L5:
        m.n(r101, r101 + r104, r100.length);
        writeBytesToImpl(r100, r101, r104);
        return r104;
    }
}
