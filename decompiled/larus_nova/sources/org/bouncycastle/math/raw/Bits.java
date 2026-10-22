package org.bouncycastle.math.raw;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Bits {
    public Bits() {
    }

    public static int bitPermuteStep(int r100, int r101, int r102) {
        int r103 = r101 & ((r100 >>> r102) ^ r100);
        return r100 ^ (r103 ^ (r103 << r102));
    }

    public static long bitPermuteStep(long r100, long r101, int r102) {
        long r103 = r101 & ((r100 >>> r102) ^ r100);
        return r100 ^ (r103 ^ (r103 << r102));
    }

    public static int bitPermuteStepSimple(int r100, int r101, int r102) {
        int r103 = (r100 & r101) << r102;
        return ((r100 >>> r102) & r101) | r103;
    }

    public static long bitPermuteStepSimple(long r100, long r101, int r102) {
        long r103 = (r100 & r101) << r102;
        return ((r100 >>> r102) & r101) | r103;
    }
}
