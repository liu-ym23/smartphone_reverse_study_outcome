package org.bouncycastle.math.ec.custom.sec;

import com.ss.ttm.player.MediaPlayer;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SecP256K1Field {
    static final int[] P = null;
    private static final int P7 = -1;
    private static final int[] PExt = null;
    private static final int PExt15 = -1;
    private static final int[] PExtInv = null;
    private static final int PInv33 = 977;

    static {
        P = new int[]{-977, -2, -1, -1, -1, -1, -1, -1};
        PExt = new int[]{954529, 1954, 1, 0, 0, 0, 0, 0, -1954, -3, -1, -1, -1, -1, -1, -1};
        PExtInv = new int[]{-954529, -1955, -2, -1, -1, -1, -1, -1, MediaPlayer.MEDIA_PLAYER_OPTION_TO_DECODE_FIRST_AUDIO_FRAME_TIME, 2};
    }

    public SecP256K1Field() {
    }

    public static void add(int[] r100, int[] r101, int[] r102) {
        if (Nat256.add(r100, r101, r102) == 0) goto L5;
    L8:
        Nat.add33To(8, 977, r102);
        return;
    L5:
        if (r102[7] == (-1)) goto L7;
        return;
    L7:
        if (Nat256.gte(r102, P) == true) goto L8;
    }

    public static void addExt(int[] r100, int[] r101, int[] r102) {
        if (Nat.add(16, r100, r101, r102) == 0) goto L5;
    L8:
        int[] r103 = PExtInv;
        if (Nat.addTo(r103.length, r103, r102) == 0) goto L14;
        Nat.incAt(16, r102, r103.length);
        return;
    L14:
        return;
    L5:
        if (r102[15] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(16, r102, PExt) == true) goto L8;
    }

    public static void addOne(int[] r100, int[] r101) {
        if (Nat.inc(8, r100, r101) == 0) goto L5;
    L8:
        Nat.add33To(8, 977, r101);
        return;
    L5:
        if (r101[7] == (-1)) goto L7;
        return;
    L7:
        if (Nat256.gte(r101, P) == true) goto L8;
    }

    public static int[] fromBigInteger(BigInteger r100) {
        int[] r101 = Nat256.fromBigInteger(r100);
        if (r101[7] != (-1)) goto L7;
        int[] r102 = P;
        if (Nat256.gte(r101, r102) == false) goto L7;
        Nat256.subFrom(r102, r101);
    L7:
        return r101;
    }

    public static void half(int[] r100, int[] r101) {
        if ((r100[0] & 1) != 0) goto L5;
        Nat.shiftDownBit(8, r100, 0, r101);
        return;
    L5:
        Nat.shiftDownBit(8, r101, Nat256.add(r100, P, r101));
    }

    public static void inv(int[] r100, int[] r101) {
        Mod.checkedModOddInverse(P, r100, r101);
    }

    public static int isZero(int[] r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= 8) goto L7;
        r102 = r102 | r100[r101];
        r101 = r101 + 1;
        goto L4
    L7:
        return (((r102 >>> 1) | (r102 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] r100, int[] r101, int[] r102) {
        int[] r103 = Nat256.createExt();
        Nat256.mul(r100, r101, r103);
        reduce(r103, r102);
    }

    public static void multiplyAddToExt(int[] r100, int[] r101, int[] r102) {
        if (Nat256.mulAddTo(r100, r101, r102) == 0) goto L5;
    L8:
        int[] r103 = PExtInv;
        if (Nat.addTo(r103.length, r103, r102) == 0) goto L14;
        Nat.incAt(16, r102, r103.length);
        return;
    L14:
        return;
    L5:
        if (r102[15] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(16, r102, PExt) == true) goto L8;
    }

    public static void negate(int[] r100, int[] r101) {
        if (isZero(r100) == 0) goto L5;
        int[] r102 = P;
        Nat256.sub(r102, r102, r101);
        return;
    L5:
        Nat256.sub(P, r100, r101);
    }

    public static void random(SecureRandom r100, int[] r101) {
        byte[] r102 = new byte[32];
    L3:
        r100.nextBytes(r102);
        Pack.littleEndianToInt(r102, 0, r101, 0, 8);
        if (Nat.lessThan(8, r101, P) == 0) goto L3;
    }

    public static void randomMult(SecureRandom r100, int[] r101) {
    L2:
        random(r100, r101);
        if (isZero(r101) != 0) goto L2;
    }

    public static void reduce(int[] r100, int[] r101) {
        if (Nat256.mul33DWordAdd(977, Nat256.mul33Add(977, r100, 8, r100, 0, r101, 0), r101, 0) == 0) goto L5;
    L8:
        Nat.add33To(8, 977, r101);
        return;
    L5:
        if (r101[7] == (-1)) goto L7;
        return;
    L7:
        if (Nat256.gte(r101, P) == true) goto L8;
    }

    public static void reduce32(int r100, int[] r101) {
        if (r100 == 0) goto L7;
        if (Nat256.mul33WordAdd(977, r100, r101, 0) == 0) goto L7;
    L10:
        Nat.add33To(8, 977, r101);
        return;
    L7:
        if (r101[7] == (-1)) goto L9;
        return;
    L9:
        if (Nat256.gte(r101, P) == true) goto L10;
    }

    public static void square(int[] r100, int[] r101) {
        int[] r102 = Nat256.createExt();
        Nat256.square(r100, r102);
        reduce(r102, r101);
    }

    public static void squareN(int[] r100, int r101, int[] r102) {
        int[] r103 = Nat256.createExt();
        Nat256.square(r100, r103);
    L3:
        reduce(r103, r102);
        r101 = r101 - 1;
        if (r101 <= 0) goto L6;
        Nat256.square(r102, r103);
        goto L3
    }

    public static void subtract(int[] r100, int[] r101, int[] r102) {
        if (Nat256.sub(r100, r101, r102) == 0) goto L6;
        Nat.sub33From(8, 977, r102);
        return;
    }

    public static void subtractExt(int[] r100, int[] r101, int[] r102) {
        if (Nat.sub(16, r100, r101, r102) == 0) goto L8;
        int[] r103 = PExtInv;
        if (Nat.subFrom(r103.length, r103, r102) == 0) goto L9;
        Nat.decAt(16, r102, r103.length);
        return;
    L9:
        return;
    }

    public static void twice(int[] r100, int[] r101) {
        if (Nat.shiftUpBit(8, r100, 0, r101) == 0) goto L5;
    L8:
        Nat.add33To(8, 977, r101);
        return;
    L5:
        if (r101[7] == (-1)) goto L7;
        return;
    L7:
        if (Nat256.gte(r101, P) == true) goto L8;
    }
}
