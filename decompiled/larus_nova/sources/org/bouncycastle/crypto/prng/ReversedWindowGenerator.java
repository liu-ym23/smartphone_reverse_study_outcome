package org.bouncycastle.crypto.prng;

/* JADX INFO: loaded from: classes42.dex */
public class ReversedWindowGenerator implements RandomGenerator {
    private final RandomGenerator generator;
    private byte[] window;
    private int windowCount;

    public ReversedWindowGenerator(RandomGenerator r100, int r101) {
        if (r100 == null) goto L11;
        if (r101 < 2) goto L9;
        this.generator = r100;
        this.window = new byte[r101];
        return;
    L9:
        throw new IllegalArgumentException("windowSize must be at least 2");
    L11:
        throw new IllegalArgumentException("generator cannot be null");
    }

    private void doNextBytes(byte[] r100, int r101, int r102) {
        monitor-enter(this);
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L9;
    L11:
        th = move-exception;
        throw th;
    L6:
        if (this.windowCount >= 1) goto L8;
        RandomGenerator r104 = this.generator;     // Catch: Throwable -> L11
        byte[] r105 = this.window;     // Catch: Throwable -> L11
        r104.nextBytes(r105, 0, r105.length);     // Catch: Throwable -> L11
        this.windowCount = this.window.length;     // Catch: Throwable -> L11
    L8:
        int r106 = r103 + 1;     // Catch: Throwable -> L11
        byte[] r107 = this.window;     // Catch: Throwable -> L11
        int r108 = this.windowCount - 1;     // Catch: Throwable -> L11
        this.windowCount = r108;     // Catch: Throwable -> L11
        r100[r103 + r101] = r107[r108];     // Catch: Throwable -> L11
        r103 = r106;
        goto L4
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void addSeedMaterial(long r100) {
        monitor-enter(this);
        this.windowCount = 0;     // Catch: Throwable -> L7
        this.generator.addSeedMaterial(r100);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void addSeedMaterial(byte[] r100) {
        monitor-enter(this);
        this.windowCount = 0;     // Catch: Throwable -> L7
        this.generator.addSeedMaterial(r100);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void nextBytes(byte[] r100) {
        doNextBytes(r100, 0, r100.length);
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void nextBytes(byte[] r100, int r101, int r102) {
        doNextBytes(r100, r101, r102);
    }
}
