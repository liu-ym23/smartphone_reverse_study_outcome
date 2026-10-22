package org.bouncycastle.crypto.prng;

/* JADX INFO: loaded from: classes42.dex */
public class EntropyUtil {
    public EntropyUtil() {
    }

    public static byte[] generateSeed(EntropySource r100, int r101) {
        byte[] r102 = new byte[r101];
        if ((r101 * 8) > r100.entropySize()) goto L5;
        System.arraycopy(r100.getEntropy(), 0, r102, 0, r101);
    L12:
        return r102;
    L5:
        int r103 = r100.entropySize() / 8;
        int r104 = 0;
    L6:
        if (r104 >= r101) goto L12;
        byte[] r105 = r100.getEntropy();
        int r106 = r101 - r104;
        if (r105.length > r106) goto L10;
        System.arraycopy(r105, 0, r102, r104, r105.length);
    L11:
        r104 = r104 + r103;
        goto L6
    L10:
        System.arraycopy(r105, 0, r102, r104, r106);
        goto L11
    }
}
