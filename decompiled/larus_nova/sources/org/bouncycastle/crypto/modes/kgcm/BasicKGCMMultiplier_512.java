package org.bouncycastle.crypto.modes.kgcm;

/* JADX INFO: loaded from: classes42.dex */
public class BasicKGCMMultiplier_512 implements KGCMMultiplier {
    private final long[] H;

    public BasicKGCMMultiplier_512() {
        this.H = new long[8];
    }

    @Override // org.bouncycastle.crypto.modes.kgcm.KGCMMultiplier
    public void init(long[] r100) {
        KGCMUtil_512.copy(r100, this.H);
    }

    @Override // org.bouncycastle.crypto.modes.kgcm.KGCMMultiplier
    public void multiplyH(long[] r100) {
        KGCMUtil_512.multiply(r100, this.H, r100);
    }
}
