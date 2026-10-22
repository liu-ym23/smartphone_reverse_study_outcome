package org.bouncycastle.crypto.modes.kgcm;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes42.dex */
public class Tables16kKGCMMultiplier_512 implements KGCMMultiplier {
    private long[][] T;

    public Tables16kKGCMMultiplier_512() {
    }

    @Override // org.bouncycastle.crypto.modes.kgcm.KGCMMultiplier
    public void init(long[] r100) {
        long[][] r101 = this.T;
        int r102 = 2;
        if (r101 != null) goto L6;
        Class r103 = Long.TYPE;
        this.T = (long[][]) Array.newInstance(r103, new int[]{256, 8});
    L8:
        KGCMUtil_512.copy(r100, this.T[1]);
    L10:
        if (r102 >= 256) goto L12;
        long[][] r104 = this.T;
        KGCMUtil_512.multiplyX(r104[r102 >> 1], r104[r102]);
        long[][] r105 = this.T;
        KGCMUtil_512.add(r105[r102], r105[1], r105[r102 + 1]);
        r102 = r102 + 2;
        goto L10
    L12:
        return;
    L6:
        if (KGCMUtil_512.equal(r100, r101[1]) == false) goto L8;
    }

    @Override // org.bouncycastle.crypto.modes.kgcm.KGCMMultiplier
    public void multiplyH(long[] r100) {
        long[] r101 = new long[8];
        KGCMUtil_512.copy(this.T[((int) (r100[7] >>> 56)) & 255], r101);
        int r102 = 62;
    L3:
        if (r102 < 0) goto L5;
        KGCMUtil_512.multiplyX8(r101, r101);
        KGCMUtil_512.add(this.T[((int) (r100[r102 >>> 3] >>> ((r102 & 7) << 3))) & 255], r101, r101);
        r102 = r102 - 1;
        goto L3
    L5:
        KGCMUtil_512.copy(r101, r100);
    }
}
