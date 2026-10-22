package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat128;

/* JADX INFO: loaded from: classes42.dex */
public class SecT113Field {
    private static final long M49 = 562949953421311L;
    private static final long M57 = 144115188075855871L;

    public SecT113Field() {
    }

    public static void add(long[] r100, long[] r101, long[] r102) {
        r102[0] = r100[0] ^ r101[0];
        long r103 = r100[1];
        r102[1] = r101[1] ^ r103;
    }

    public static void addExt(long[] r100, long[] r101, long[] r102) {
        r102[0] = r100[0] ^ r101[0];
        r102[1] = r100[1] ^ r101[1];
        r102[2] = r100[2] ^ r101[2];
        long r103 = r100[3];
        r102[3] = r101[3] ^ r103;
    }

    public static void addOne(long[] r100, long[] r101) {
        r101[0] = r100[0] ^ 1;
        r101[1] = r100[1];
    }

    private static void addTo(long[] r100, long[] r101) {
        r101[0] = r101[0] ^ r100[0];
        r101[1] = r101[1] ^ r100[1];
    }

    public static long[] fromBigInteger(BigInteger r100) {
        return Nat.fromBigInteger64(113, r100);
    }

    public static void halfTrace(long[] r100, long[] r101) {
        long[] r102 = Nat128.createExt64();
        Nat128.copy64(r100, r101);
        int r103 = 1;
    L4:
        if (r103 >= 113) goto L6;
        implSquare(r101, r102);
        reduce(r102, r101);
        implSquare(r101, r102);
        reduce(r102, r101);
        addTo(r100, r101);
        r103 = r103 + 2;
        goto L4
    }

    public static void implMultiply(long[] r210, long[] r211, long[] r212) {
        long r100 = r210[0];
        long r101 = r210[1] << 7;
        long r110 = (r101 ^ (r100 >>> 57)) & M57;
        long r111 = r100 & M57;
        long r102 = r211[0];
        long r103 = r211[1] << 7;
        long r112 = (r103 ^ (r102 >>> 57)) & M57;
        long r113 = r102 & M57;
        long[] r104 = new long[6];
        implMulw(r212, r111, r113, r104, 0);
        implMulw(r212, r110, r112, r104, 2);
        implMulw(r212, r111 ^ r110, r113 ^ r112, r104, 4);
        long r105 = r104[1] ^ r104[2];
        long r106 = r104[0];
        long r114 = r104[3];
        long r115 = (r104[4] ^ r106) ^ r105;
        long r107 = r105 ^ (r104[5] ^ r114);
        r212[0] = r106 ^ (r115 << 57);
        r212[1] = (r115 >>> 7) ^ (r107 << 50);
        r212[2] = (r107 >>> 14) ^ (r114 << 43);
        r212[3] = r114 >>> 21;
    }

    public static void implMulw(long[] r110, long r111, long r210, long[] r211, int r212) {
        r110[1] = r210;
        long r100 = r210 << 1;
        r110[2] = r100;
        long r101 = r100 ^ r210;
        r110[3] = r101;
        long r102 = r100 << 1;
        r110[4] = r102;
        r110[5] = r102 ^ r210;
        long r103 = r101 << 1;
        r110[6] = r103;
        r110[7] = r103 ^ r210;
        long r104 = r110[((int) r111) & 7];
        long r105 = 0;
        int r112 = 48;
    L3:
        int r113 = (int) (r111 >>> r112);
        long r114 = (r110[(r113 >>> 6) & 7] << 6) ^ (r110[r113 & 7] ^ (r110[(r113 >>> 3) & 7] << 3));
        r104 = r104 ^ (r114 << r112);
        r105 = r105 ^ (r114 >>> (-r112));
        r112 = r112 - 9;
        if (r112 > 0) goto L3;
        r211[r212] = M57 & r104;
        r211[r212 + 1] = (((((r111 & 72198606942111744L) & ((r210 << 7) >> 63)) >>> 8) ^ r105) << 7) ^ (r104 >>> 57);
    }

    public static void implSquare(long[] r100, long[] r101) {
        Interleave.expand64To128(r100, 0, 2, r101, 0);
    }

    public static void invert(long[] r100, long[] r101) {
        if (Nat128.isZero64(r100) == true) goto L7;
        long[] r102 = Nat128.create64();
        long[] r103 = Nat128.create64();
        square(r100, r102);
        multiply(r102, r100, r102);
        square(r102, r102);
        multiply(r102, r100, r102);
        squareN(r102, 3, r103);
        multiply(r103, r102, r103);
        square(r103, r103);
        multiply(r103, r100, r103);
        squareN(r103, 7, r102);
        multiply(r102, r103, r102);
        squareN(r102, 14, r103);
        multiply(r103, r102, r103);
        squareN(r103, 28, r102);
        multiply(r102, r103, r102);
        squareN(r102, 56, r103);
        multiply(r103, r102, r103);
        square(r103, r101);
        return;
    L7:
        throw new IllegalStateException();
    }

    public static void multiply(long[] r100, long[] r101, long[] r102) {
        long[] r103 = new long[8];
        implMultiply(r100, r101, r103);
        reduce(r103, r102);
    }

    public static void multiplyAddToExt(long[] r100, long[] r101, long[] r102) {
        long[] r103 = new long[8];
        implMultiply(r100, r101, r103);
        addExt(r102, r103, r102);
    }

    public static void reduce(long[] r110, long[] r111) {
        long r100 = r110[0];
        long r101 = r110[1];
        long r102 = r110[2];
        long r103 = r110[3];
        long r104 = r101 ^ ((r103 << 15) ^ (r103 << 24));
        long r112 = r103 >>> 49;
        long r105 = r102 ^ ((r103 >>> 40) ^ r112);
        long r106 = r100 ^ ((r105 << 15) ^ (r105 << 24));
        long r107 = r105 >>> 49;
        long r108 = r104 ^ ((r105 >>> 40) ^ r107);
        long r109 = r108 >>> 49;
        r111[0] = (r106 ^ r109) ^ (r109 << 9);
        r111[1] = M49 & r108;
    }

    public static void reduce15(long[] r100, int r110) {
        int r101 = r110 + 1;
        long r102 = r100[r101];
        long r103 = r102 >>> 49;
        long r104 = r103 ^ (r103 << 9);
        r100[r110] = r104 ^ r100[r110];
        r100[r101] = r102 & M49;
    }

    public static void sqrt(long[] r110, long[] r111) {
        long r100 = Interleave.unshuffle(r110[0]);
        long r101 = Interleave.unshuffle(r110[1]);
        long r102 = (BodyPartID.bodyIdMax & r100) | (r101 << 32);
        long r103 = (r100 >>> 32) | (r101 & (-4294967296L));
        r111[0] = ((r103 << 57) ^ r102) ^ (r103 << 5);
        long r104 = r103 >>> 59;
        r111[1] = r104 ^ (r103 >>> 7);
    }

    public static void square(long[] r100, long[] r101) {
        long[] r102 = Nat128.createExt64();
        implSquare(r100, r102);
        reduce(r102, r101);
    }

    public static void squareAddToExt(long[] r100, long[] r101) {
        long[] r102 = Nat128.createExt64();
        implSquare(r100, r102);
        addExt(r101, r102, r101);
    }

    public static void squareN(long[] r100, int r101, long[] r102) {
        long[] r103 = Nat128.createExt64();
        implSquare(r100, r103);
    L3:
        reduce(r103, r102);
        r101 = r101 - 1;
        if (r101 <= 0) goto L6;
        implSquare(r102, r103);
        goto L3
    }

    public static int trace(long[] r100) {
        return ((int) r100[0]) & 1;
    }
}
