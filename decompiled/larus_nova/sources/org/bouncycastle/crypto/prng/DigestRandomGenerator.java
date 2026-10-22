package org.bouncycastle.crypto.prng;

import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes42.dex */
public class DigestRandomGenerator implements RandomGenerator {
    private static long CYCLE_COUNT = 10;
    private Digest digest;
    private byte[] seed;
    private long seedCounter;
    private byte[] state;
    private long stateCounter;

    public DigestRandomGenerator(Digest r100) {
        this.digest = r100;
        this.seed = new byte[r100.getDigestSize()];
        this.seedCounter = 1;
        this.state = new byte[r100.getDigestSize()];
        this.stateCounter = 1;
    }

    private void cycleSeed() {
        digestUpdate(this.seed);
        long r100 = this.seedCounter;
        this.seedCounter = 1 + r100;
        digestAddCounter(r100);
        digestDoFinal(this.seed);
    }

    private void digestAddCounter(long r100) {
        int r101 = 0;
    L4:
        if (r101 == 8) goto L6;
        this.digest.update((byte) r100);
        r100 = r100 >>> 8;
        r101 = r101 + 1;
        goto L4
    }

    private void digestDoFinal(byte[] r100) {
        this.digest.doFinal(r100, 0);
    }

    private void digestUpdate(byte[] r100) {
        this.digest.update(r100, 0, r100.length);
    }

    private void generateState() {
        long r100 = this.stateCounter;
        this.stateCounter = 1 + r100;
        digestAddCounter(r100);
        digestUpdate(this.state);
        digestUpdate(this.seed);
        digestDoFinal(this.state);
        if ((this.stateCounter % CYCLE_COUNT) != 0) goto L6;
        cycleSeed();
        return;
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void addSeedMaterial(long r100) {
        monitor-enter(this);
        digestAddCounter(r100);     // Catch: Throwable -> L6
        digestUpdate(this.seed);     // Catch: Throwable -> L6
        digestDoFinal(this.seed);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void addSeedMaterial(byte[] r100) {
        monitor-enter(this);
        digestUpdate(r100);     // Catch: Throwable -> L6
        digestUpdate(this.seed);     // Catch: Throwable -> L6
        digestDoFinal(this.seed);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void nextBytes(byte[] r100) {
        nextBytes(r100, 0, r100.length);
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void nextBytes(byte[] r100, int r101, int r102) {
        monitor-enter(this);
        generateState();     // Catch: Throwable -> L11
        int r103 = r102 + r101;     // Catch: Throwable -> L11
        int r104 = 0;
    L4:
        if (r101 == r103) goto L9;
        if (r104 != this.state.length) goto L8;
        generateState();     // Catch: Throwable -> L11
        r104 = 0;
    L8:
        int r105 = r104 + 1;     // Catch: Throwable -> L11
        r100[r101] = this.state[r104];     // Catch: Throwable -> L11
        r101 = r101 + 1;     // Catch: Throwable -> L11
        r104 = r105;
        goto L4
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
