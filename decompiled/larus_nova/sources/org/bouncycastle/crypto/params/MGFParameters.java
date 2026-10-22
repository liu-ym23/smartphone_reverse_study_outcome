package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class MGFParameters implements DerivationParameters {
    byte[] seed;

    public MGFParameters(byte[] r100) {
        this(r100, 0, r100.length);
    }

    public MGFParameters(byte[] r100, int r101, int r102) {
        byte[] r103 = new byte[r102];
        this.seed = r103;
        System.arraycopy(r100, r101, r103, 0, r102);
    }

    public byte[] getSeed() {
        return this.seed;
    }
}
