package org.bouncycastle.crypto.modes.gcm;

/* JADX INFO: loaded from: classes42.dex */
public class BasicGCMMultiplier implements GCMMultiplier {
    private long[] H;

    public BasicGCMMultiplier() {
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void init(byte[] r100) {
        this.H = GCMUtil.asLongs(r100);
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void multiplyH(byte[] r100) {
        long[] r101 = GCMUtil.asLongs(r100);
        GCMUtil.multiply(r101, this.H);
        GCMUtil.asBytes(r101, r100);
    }
}
