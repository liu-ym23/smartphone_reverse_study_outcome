package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class Poly1305KeyGenerator extends CipherKeyGenerator {
    private static final byte R_MASK_HIGH_4 = 15;
    private static final byte R_MASK_LOW_2 = -4;

    public Poly1305KeyGenerator() {
    }

    public static void checkKey(byte[] r100) {
        if (r100.length != 32) goto L7;
        checkMask(r100[3], (byte) 15);
        checkMask(r100[7], (byte) 15);
        checkMask(r100[11], (byte) 15);
        checkMask(r100[15], (byte) 15);
        checkMask(r100[4], R_MASK_LOW_2);
        checkMask(r100[8], R_MASK_LOW_2);
        checkMask(r100[12], R_MASK_LOW_2);
        return;
    L7:
        throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
    }

    private static void checkMask(byte r100, byte r101) {
        if ((r100 & (~r101)) != 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Invalid format for r portion of Poly1305 key.");
    }

    public static void clamp(byte[] r100) {
        if (r100.length != 32) goto L7;
        r100[3] = (byte) (r100[3] & 15);
        r100[7] = (byte) (r100[7] & 15);
        r100[11] = (byte) (r100[11] & 15);
        r100[15] = (byte) (r100[15] & 15);
        r100[4] = (byte) (r100[4] & R_MASK_LOW_2);
        r100[8] = (byte) (r100[8] & R_MASK_LOW_2);
        r100[12] = (byte) (r100[12] & R_MASK_LOW_2);
        return;
    L7:
        throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
    }

    @Override // org.bouncycastle.crypto.CipherKeyGenerator
    public byte[] generateKey() {
        byte[] r100 = super.generateKey();
        clamp(r100);
        return r100;
    }

    @Override // org.bouncycastle.crypto.CipherKeyGenerator
    public void init(KeyGenerationParameters r100) {
        super.init(new KeyGenerationParameters(r100.getRandom(), 256));
    }
}
