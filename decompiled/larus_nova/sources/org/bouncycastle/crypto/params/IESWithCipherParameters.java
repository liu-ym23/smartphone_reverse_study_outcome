package org.bouncycastle.crypto.params;

/* JADX INFO: loaded from: classes42.dex */
public class IESWithCipherParameters extends IESParameters {
    private int cipherKeySize;

    public IESWithCipherParameters(byte[] r100, byte[] r101, int r102, int r103) {
        super(r100, r101, r102);
        this.cipherKeySize = r103;
    }

    public int getCipherKeySize() {
        return this.cipherKeySize;
    }
}
