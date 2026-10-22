package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Nat576 {
    public Nat576() {
    }

    public static void copy64(long[] r100, int r101, long[] r102, int r103) {
        r102[r103 + 0] = r100[r101 + 0];
        r102[r103 + 1] = r100[r101 + 1];
        r102[r103 + 2] = r100[r101 + 2];
        r102[r103 + 3] = r100[r101 + 3];
        r102[r103 + 4] = r100[r101 + 4];
        r102[r103 + 5] = r100[r101 + 5];
        r102[r103 + 6] = r100[r101 + 6];
        r102[r103 + 7] = r100[r101 + 7];
        r102[r103 + 8] = r100[r101 + 8];
    }

    public static void copy64(long[] r100, long[] r101) {
        r101[0] = r100[0];
        r101[1] = r100[1];
        r101[2] = r100[2];
        r101[3] = r100[3];
        r101[4] = r100[4];
        r101[5] = r100[5];
        r101[6] = r100[6];
        r101[7] = r100[7];
        r101[8] = r100[8];
    }

    public static long[] create64() {
        return new long[9];
    }

    public static long[] createExt64() {
        return new long[18];
    }

    public static boolean eq64(long[] r100, long[] r101) {
        int r102 = 8;
    L3:
        if (r102 < 0) goto L9;
        if (r100[r102] != r101[r102]) goto L6;
        r102 = r102 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    public static long[] fromBigInteger64(BigInteger r100) {
        if (r100.signum() < 0) goto L12;
        if (r100.bitLength() > 576) goto L12;
        long[] r101 = create64();
        int r102 = 0;
    L8:
        if (r102 >= 9) goto L10;
        r101[r102] = r100.longValue();
        r100 = r100.shiftRight(64);
        r102 = r102 + 1;
        goto L8
    L10:
        return r101;
    L12:
        throw new IllegalArgumentException();
    }

    public static boolean isOne64(long[] r100) {
        if (r100[0] == 1) goto L5;
        return false;
    L5:
        int r101 = 1;
    L7:
        if (r101 >= 9) goto L12;
        if (r100[r101] != 0) goto L10;
        r101 = r101 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static boolean isZero64(long[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= 9) goto L9;
        if (r100[r101] != 0) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static BigInteger toBigInteger64(long[] r100) {
        byte[] r101 = new byte[72];
        int r102 = 0;
    L4:
        if (r102 >= 9) goto L10;
        long r103 = r100[r102];
        if (r103 == 0) goto L8;
        Pack.longToBigEndian(r103, r101, (8 - r102) << 3);
    L8:
        r102 = r102 + 1;
        goto L4
    L10:
        return new BigInteger(1, r101);
    }
}
