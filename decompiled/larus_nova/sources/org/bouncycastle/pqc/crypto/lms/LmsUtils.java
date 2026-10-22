package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes42.dex */
class LmsUtils {
    public LmsUtils() {
    }

    public static void byteArray(byte[] r100, int r101, int r102, Digest r103) {
        r103.update(r100, r101, r102);
    }

    public static void byteArray(byte[] r100, Digest r101) {
        r101.update(r100, 0, r100.length);
    }

    public static int calculateStrength(LMSParameters r100) {
        if (r100 == null) goto L6;
        LMSigParameters r101 = r100.getLMSigParam();
        return (1 << r101.getH()) * r101.getM();
    L6:
        throw new NullPointerException("lmsParameters cannot be null");
    }

    public static void u16str(short r100, Digest r101) {
        r101.update((byte) (r100 >>> 8));
        r101.update((byte) r100);
    }

    public static void u32str(int r100, Digest r101) {
        r101.update((byte) (r100 >>> 24));
        r101.update((byte) (r100 >>> 16));
        r101.update((byte) (r100 >>> 8));
        r101.update((byte) r100);
    }
}
