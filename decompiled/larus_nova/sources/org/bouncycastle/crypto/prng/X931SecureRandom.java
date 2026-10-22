package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes42.dex */
public class X931SecureRandom extends SecureRandom {
    private final X931RNG drbg;
    private final boolean predictionResistant;
    private final SecureRandom randomSource;

    public X931SecureRandom(SecureRandom r100, X931RNG r101, boolean r102) {
        this.randomSource = r100;
        this.drbg = r101;
        this.predictionResistant = r102;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int r100) {
        return EntropyUtil.generateSeed(this.drbg.getEntropySource(), r100);
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] r100) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.drbg.generate(r100, this.predictionResistant) >= 0) goto L6;
        this.drbg.reseed();     // Catch: Throwable -> L8
        this.drbg.generate(r100, this.predictionResistant);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
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
