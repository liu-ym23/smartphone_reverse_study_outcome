package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.DESParameters;
import org.bouncycastle.crypto.params.DESedeParameters;

/* JADX INFO: loaded from: classes42.dex */
public class DESedeKeyGenerator extends DESKeyGenerator {
    private static final int MAX_IT = 20;

    public DESedeKeyGenerator() {
    }

    @Override // org.bouncycastle.crypto.generators.DESKeyGenerator, org.bouncycastle.crypto.CipherKeyGenerator
    public byte[] generateKey() {
        int r100 = this.strength;
        byte[] r101 = new byte[r100];
        int r102 = 0;
    L3:
        this.random.nextBytes(r101);
        DESParameters.setOddParity(r101);
        r102 = r102 + 1;
        if (r102 >= 20) goto L10;
        if (DESedeParameters.isWeakKey(r101, 0, r100) == true) goto L3;
        if (DESedeParameters.isRealEDEKey(r101, 0) == false) goto L3;
    L10:
        if (DESedeParameters.isWeakKey(r101, 0, r100) == true) goto L15;
        if (DESedeParameters.isRealEDEKey(r101, 0) == false) goto L15;
        return r101;
    L15:
        throw new IllegalStateException("Unable to generate DES-EDE key");
    }

    @Override // org.bouncycastle.crypto.generators.DESKeyGenerator, org.bouncycastle.crypto.CipherKeyGenerator
    public void init(KeyGenerationParameters r100) {
        this.random = r100.getRandom();
        int r101 = (r100.getStrength() + 7) / 8;
        this.strength = r101;
        if (r101 != 0) goto L5;
    L15:
        this.strength = 24;
        return;
    L5:
        if (r101 == 21) goto L15;
        if (r101 != 14) goto L10;
        this.strength = 16;
        return;
    L10:
        if (r101 == 24) goto L18;
        if (r101 != 16) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("DESede key must be 192 or 128 bits long.");
    }
}
