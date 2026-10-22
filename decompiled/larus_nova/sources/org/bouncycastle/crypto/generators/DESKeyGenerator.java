package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.DESParameters;

/* JADX INFO: loaded from: classes42.dex */
public class DESKeyGenerator extends CipherKeyGenerator {
    public DESKeyGenerator() {
    }

    @Override // org.bouncycastle.crypto.CipherKeyGenerator
    public byte[] generateKey() {
        byte[] r100 = new byte[8];
    L3:
        this.random.nextBytes(r100);
        DESParameters.setOddParity(r100);
        if (DESParameters.isWeakKey(r100, 0) == true) goto L3;
        return r100;
    }

    @Override // org.bouncycastle.crypto.CipherKeyGenerator
    public void init(KeyGenerationParameters r100) {
        super.init(r100);
        int r101 = this.strength;
        if (r101 != 0) goto L5;
    L11:
        this.strength = 8;
        return;
    L5:
        if (r101 == 7) goto L11;
        if (r101 != 8) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("DES key must be 64 bits long.");
    }
}
