package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.digests.SkeinEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.SkeinParameters;

/* JADX INFO: loaded from: classes42.dex */
public class SkeinMac implements Mac {
    public static final int SKEIN_1024 = 1024;
    public static final int SKEIN_256 = 256;
    public static final int SKEIN_512 = 512;
    private SkeinEngine engine;

    public SkeinMac(int r100, int r101) {
        this.engine = new SkeinEngine(r100, r101);
    }

    public SkeinMac(SkeinMac r100) {
        this.engine = new SkeinEngine(r100.engine);
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] r100, int r101) {
        return this.engine.doFinal(r100, r101);
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "Skein-MAC-" + (this.engine.getBlockSize() * 8) + "-" + (this.engine.getOutputSize() * 8);
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return this.engine.getOutputSize();
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters r100) throws IllegalArgumentException {
        if ((r100 instanceof SkeinParameters) == false) goto L6;
        SkeinParameters r101 = (SkeinParameters) r100;
    L9:
        if (r101.getKey() == null) goto L13;
        this.engine.init(r101);
        return;
    L13:
        throw new IllegalArgumentException("Skein MAC requires a key parameter.");
    L6:
        if ((r100 instanceof KeyParameter) == false) goto L15;
        r101 = new SkeinParameters.Builder().setKey(((KeyParameter) r100).getKey()).build();
        goto L9
    L15:
        throw new IllegalArgumentException("Invalid parameter passed to Skein MAC init - ".concat(r100.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        this.engine.reset();
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte r100) {
        this.engine.update(r100);
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] r100, int r101, int r102) {
        this.engine.update(r100, r101, r102);
    }
}
