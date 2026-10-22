package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.engines.Salsa20Engine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SCrypt {
    private SCrypt() {
    }

    private static void BlockMix(int[] r100, int[] r101, int[] r102, int[] r103, int r110) {
        System.arraycopy(r100, r100.length - 16, r101, 0, 16);
        int r104 = r100.length >>> 1;
        int r111 = r110 * 2;
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r111 <= 0) goto L5;
        Xor(r101, r100, r105, r102);
        Salsa20Engine.salsaCore(8, r102, r101);
        System.arraycopy(r101, 0, r103, r106, 16);
        r106 = (r104 + r105) - r106;
        r105 = r105 + 16;
        r111 = r111 - 1;
        goto L3
    }

    private static void Clear(byte[] r100) {
        if (r100 == null) goto L5;
        Arrays.fill(r100, (byte) 0);
        return;
    }

    private static void Clear(int[] r100) {
        if (r100 == null) goto L5;
        Arrays.fill(r100, 0);
        return;
    }

    private static void ClearAll(int[][] r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        Clear(r100[r101]);
        r101 = r101 + 1;
        goto L4
    }

    private static byte[] MFcrypt(byte[] r100, byte[] r101, int r102, int r110, int r111, int r112) {
        int r103 = r110 * 128;
        byte[] r104 = SingleIterationPBKDF2(r100, r101, r111 * r103);
        int[] r113 = null;
        int r105 = r104.length >>> 2;     // Catch: Throwable -> L15
        r113 = new int[r105];     // Catch: Throwable -> L15
        Pack.littleEndianToInt(r104, 0, r113);     // Catch: Throwable -> L15
        int r106 = r102 * r110;     // Catch: Throwable -> L15
        int r107 = 0;
    L5:
        if ((r102 - r107) <= 2) goto L9;
        if (r106 <= 1024) goto L9;
        r107 = r107 + 1;     // Catch: Throwable -> L15
        r106 = r106 >>> 1;     // Catch: Throwable -> L15
    L9:
        int r108 = r103 >>> 2;     // Catch: Throwable -> L15
        int r109 = 0;
    L10:
        if (r109 >= r105) goto L12;
        SMix(r113, r109, r102, r107, r110);     // Catch: Throwable -> L15
        r109 = r109 + r108;     // Catch: Throwable -> L15
        goto L10
    L12:
        Pack.intToLittleEndian(r113, r104, 0);     // Catch: Throwable -> L15
        byte[] r114 = SingleIterationPBKDF2(r100, r104, r112);     // Catch: Throwable -> L15
        Clear(r104);
        Clear(r113);
        return r114;
    L15:
        th = move-exception;
        Clear(r104);
        Clear(r113);
        throw th;
    }

    private static void SMix(int[] r110, int r210, int r211, int r212, int r213) {
        int r100 = r211 >>> r212;
        int r101 = 1 << r212;
        int r102 = r100 - 1;
        int r103 = Integers.numberOfTrailingZeros(r211) - r212;
        int r104 = r213 * 32;
        int[] r111 = new int[16];
        int[] r112 = new int[16];
        int[] r113 = new int[r104];
        int[] r114 = new int[r104];
        int[][] r115 = new int[r101][];
        System.arraycopy(r110, r210, r114, 0, r104);     // Catch: Throwable -> L15
        int r116 = 0;
    L4:
        if (r116 >= r101) goto L9;
        int[] r105 = new int[r100 * r104];     // Catch: Throwable -> L15
        r115[r116] = r105;     // Catch: Throwable -> L15
        int r117 = r101;
        int r106 = 0;
        int r107 = 0;
    L6:
        if (r107 >= r100) goto L8;
        System.arraycopy(r114, 0, r105, r106, r104);     // Catch: Throwable -> L15
        int r108 = r106 + r104;     // Catch: Throwable -> L15
        BlockMix(r114, r111, r112, r113, r213);     // Catch: Throwable -> L15
        System.arraycopy(r113, 0, r105, r108, r104);     // Catch: Throwable -> L15
        r106 = r108 + r104;     // Catch: Throwable -> L15
        BlockMix(r113, r111, r112, r114, r213);     // Catch: Throwable -> L15
        r107 = r107 + 2;     // Catch: Throwable -> L15
        r100 = r100;
        goto L6
    L8:
        r116 = r116 + 1;     // Catch: Throwable -> L15
        r101 = r117;
        goto L4
    L9:
        int r109 = r211 - 1;     // Catch: Throwable -> L15
        int r118 = 0;
    L10:
        if (r118 >= r211) goto L12;
        int r119 = r114[r104 - 16] & r109;     // Catch: Throwable -> L15
        System.arraycopy(r115[r119 >>> r103], (r119 & r102) * r104, r113, 0, r104);     // Catch: Throwable -> L15
        Xor(r113, r114, 0, r113);     // Catch: Throwable -> L15
        BlockMix(r113, r111, r112, r114, r213);     // Catch: Throwable -> L15
        r118 = r118 + 1;     // Catch: Throwable -> L15
        goto L10
    L12:
        System.arraycopy(r114, 0, r110, r210, r104);     // Catch: Throwable -> L15
        ClearAll(r115);
        ClearAll(new int[][]{r114, r111, r112, r113});
        return;
    L15:
        th = move-exception;
        ClearAll(r115);
        ClearAll(new int[][]{r114, r111, r112, r113});
        throw th;
    }

    private static byte[] SingleIterationPBKDF2(byte[] r100, byte[] r101, int r102) {
        PKCS5S2ParametersGenerator r103 = new PKCS5S2ParametersGenerator(new SHA256Digest());
        r103.init(r100, r101, 1);
        return ((KeyParameter) r103.generateDerivedMacParameters(r102 * 8)).getKey();
    }

    private static void Xor(int[] r100, int[] r101, int r102, int[] r103) {
        int r104 = r103.length - 1;
    L3:
        if (r104 < 0) goto L5;
        r103[r104] = r100[r104] ^ r101[r102 + r104];
        r104 = r104 - 1;
        goto L3
    }

    public static byte[] generate(byte[] r100, byte[] r101, int r102, int r103, int r104, int r105) {
        if (r100 == null) goto L32;
        if (r101 == null) goto L30;
        if (r102 <= 1) goto L28;
        if (isPowerOf2(r102) == false) goto L28;
        if (r103 == 1) goto L10;
    L14:
        if (r103 < 1) goto L26;
        int r106 = Integer.MAX_VALUE / ((r103 * 128) * 8);
        if (r104 < 1) goto L24;
        if (r104 > r106) goto L24;
        if (r105 < 1) goto L22;
        return MFcrypt(r100, r101, r102, r103, r104, r105);
    L22:
        throw new IllegalArgumentException("Generated key length dkLen must be >= 1.");
    L24:
        throw new IllegalArgumentException("Parallelisation parameter p must be >= 1 and <= " + r106 + " (based on block size r of " + r103 + ")");
    L26:
        throw new IllegalArgumentException("Block size r must be >= 1.");
    L10:
        if (r102 < 65536) goto L14;
        throw new IllegalArgumentException("Cost parameter N must be > 1 and < 65536.");
    L28:
        throw new IllegalArgumentException("Cost parameter N must be > 1 and a power of 2");
    L30:
        throw new IllegalArgumentException("Salt S must be provided.");
    L32:
        throw new IllegalArgumentException("Passphrase P must be provided.");
    }

    private static boolean isPowerOf2(int r100) {
        if ((r100 & (r100 - 1)) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
