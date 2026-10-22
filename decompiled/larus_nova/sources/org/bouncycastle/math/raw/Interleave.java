package org.bouncycastle.math.raw;

/* JADX INFO: loaded from: classes42.dex */
public class Interleave {
    private static final long M32 = 1431655765;
    private static final long M64 = 6148914691236517205L;
    private static final long M64R = -6148914691236517206L;

    public Interleave() {
    }

    public static int expand16to32(int r100) {
        int r101 = r100 & 65535;
        int r102 = (r101 | (r101 << 8)) & 16711935;
        int r103 = (r102 | (r102 << 4)) & 252645135;
        int r104 = (r103 | (r103 << 2)) & 858993459;
        return (r104 | (r104 << 1)) & 1431655765;
    }

    public static long expand32to64(int r100) {
        int r101 = Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(r100, 65280, 8), 15728880, 4), 202116108, 2), 572662306, 1);
        return ((((long) (r101 >>> 1)) & M32) << 32) | (M32 & ((long) r101));
    }

    public static void expand64To128(long r100, long[] r101, int r102) {
        long r103 = Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(r100, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
        r101[r102] = r103 & M64;
        r101[r102 + 1] = (r103 >>> 1) & M64;
    }

    public static void expand64To128(long[] r100, int r101, int r102, long[] r103, int r104) {
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L5;
        expand64To128(r100[r101 + r105], r103, r104);
        r104 = r104 + 2;
        r105 = r105 + 1;
        goto L3
    }

    public static void expand64To128Rev(long r100, long[] r101, int r102) {
        long r103 = Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(r100, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
        r101[r102] = r103 & M64R;
        r101[r102 + 1] = (r103 << 1) & M64R;
    }

    public static int expand8to16(int r100) {
        int r101 = r100 & 255;
        int r102 = (r101 | (r101 << 4)) & 3855;
        int r103 = (r102 | (r102 << 2)) & 13107;
        return (r103 | (r103 << 1)) & 21845;
    }

    public static int shuffle(int r100) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(r100, 65280, 8), 15728880, 4), 202116108, 2), 572662306, 1);
    }

    public static long shuffle(long r100) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(r100, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
    }

    public static int shuffle2(int r100) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(r100, 11141290, 7), 52428, 14), 15728880, 4), 65280, 8);
    }

    public static long shuffle2(long r100) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(r100, 4278255360L, 24), 57421771435671756L, 6), 264913582878960L, 12), 723401728380766730L, 3);
    }

    public static long shuffle3(long r100) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(r100, 47851476196393130L, 7), 225176545447116L, 14), 4042322160L, 28);
    }

    public static int unshuffle(int r100) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(r100, 572662306, 1), 202116108, 2), 15728880, 4), 65280, 8);
    }

    public static long unshuffle(long r100) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(r100, 2459565876494606882L, 1), 868082074056920076L, 2), 67555025218437360L, 4), 280375465148160L, 8), 4294901760L, 16);
    }

    public static int unshuffle2(int r100) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(r100, 65280, 8), 15728880, 4), 52428, 14), 11141290, 7);
    }

    public static long unshuffle2(long r100) {
        return Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(Bits.bitPermuteStep(r100, 723401728380766730L, 3), 264913582878960L, 12), 57421771435671756L, 6), 4278255360L, 24);
    }

    public static long unshuffle3(long r100) {
        return shuffle3(r100);
    }
}
