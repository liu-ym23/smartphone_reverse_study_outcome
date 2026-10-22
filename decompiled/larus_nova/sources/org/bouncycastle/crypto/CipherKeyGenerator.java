package org.bouncycastle.crypto;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes42.dex */
public class CipherKeyGenerator {
    protected SecureRandom random;
    protected int strength;

    public CipherKeyGenerator() {
    }

    public byte[] generateKey() {
        byte[] r100 = new byte[this.strength];
        this.random.nextBytes(r100);
        return r100;
    }

    public void init(KeyGenerationParameters r100) {
        this.random = r100.getRandom();
        this.strength = (r100.getStrength() + 7) / 8;
    }
}
