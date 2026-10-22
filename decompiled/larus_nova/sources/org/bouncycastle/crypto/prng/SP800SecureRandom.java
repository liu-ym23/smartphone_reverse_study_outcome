package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;
import org.bouncycastle.crypto.prng.drbg.SP80090DRBG;

/* JADX INFO: loaded from: classes42.dex */
public class SP800SecureRandom extends SecureRandom {
    private SP80090DRBG drbg;
    private final DRBGProvider drbgProvider;
    private final EntropySource entropySource;
    private final boolean predictionResistant;
    private final SecureRandom randomSource;

    public SP800SecureRandom(SecureRandom r100, EntropySource r101, DRBGProvider r102, boolean r103) {
        this.randomSource = r100;
        this.entropySource = r101;
        this.drbgProvider = r102;
        this.predictionResistant = r103;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int r100) {
        return EntropyUtil.generateSeed(this.entropySource, r100);
    }

    @Override // java.security.SecureRandom
    public String getAlgorithm() {
        return this.drbgProvider.getAlgorithm();
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.drbg != null) goto L7;
        this.drbg = this.drbgProvider.get(this.entropySource);     // Catch: Throwable -> L11
    L7:
        if (this.drbg.generate(r100, null, this.predictionResistant) >= 0) goto L9;
        this.drbg.reseed(null);     // Catch: Throwable -> L11
        this.drbg.generate(r100, null, this.predictionResistant);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    public void reseed(byte[] r100) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.drbg != null) goto L6;
        this.drbg = this.drbgProvider.get(this.entropySource);     // Catch: Throwable -> L9
    L6:
        this.drbg.reseed(r100);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void setSeed(long r100) {
        monitor-enter(this);
        SecureRandom r101 = this.randomSource;     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        r101.setSeed(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // java.security.SecureRandom
    public void setSeed(byte[] r100) {
        monitor-enter(this);
        SecureRandom r101 = this.randomSource;     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        r101.setSeed(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
