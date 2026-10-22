package org.bouncycastle.pqc.crypto.newhope;

/* JADX INFO: loaded from: classes42.dex */
class Reduce {
    static final int QInv = 12287;
    static final int RLog = 18;
    static final int RMask = 262143;

    public Reduce() {
    }

    public static short barrett(short r100) {
        int r101 = r100 & 65535;
        return (short) (r101 - (((r101 * 5) >>> 16) * 12289));
    }

    public static short montgomery(int r100) {
        return (short) (((((r100 * 12287) & RMask) * 12289) + r100) >>> 18);
    }
}
