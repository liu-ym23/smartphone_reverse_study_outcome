package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class X931SecureRandomBuilder {
    private byte[] dateTimeVector;
    private EntropySourceProvider entropySourceProvider;
    private SecureRandom random;

    public X931SecureRandomBuilder() {
        this(CryptoServicesRegistrar.getSecureRandom(), false);
    }

    public X931SecureRandomBuilder(SecureRandom r100, boolean r101) {
        this.random = r100;
        this.entropySourceProvider = new BasicEntropySourceProvider(r100, r101);
    }

    public X931SecureRandomBuilder(EntropySourceProvider r100) {
        this.random = null;
        this.entropySourceProvider = r100;
    }

    public X931SecureRandom build(BlockCipher r100, KeyParameter r101, boolean r102) {
        if (this.dateTimeVector != null) goto L5;
        this.dateTimeVector = new byte[r100.getBlockSize()];
        Pack.longToBigEndian(System.currentTimeMillis(), this.dateTimeVector, 0);
    L5:
        r100.init(true, r101);
        return new X931SecureRandom(this.random, new X931RNG(r100, this.dateTimeVector, this.entropySourceProvider.get(r100.getBlockSize() * 8)), r102);
    }

    public X931SecureRandomBuilder setDateTimeVector(byte[] r100) {
        this.dateTimeVector = Arrays.clone(r100);
        return this;
    }
}
