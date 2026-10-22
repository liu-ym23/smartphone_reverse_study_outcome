package org.bouncycastle.crypto.params;

/* JADX INFO: loaded from: classes42.dex */
public class RC2Parameters extends KeyParameter {
    private int bits;

    public RC2Parameters(byte[] r100) {
        if (r100.length <= 128) goto L5;
        int r101 = 1024;
    L6:
        this(r100, r101);
        return;
    L5:
        r101 = r100.length * 8;
        goto L6
    }

    public RC2Parameters(byte[] r100, int r101) {
        super(r100);
        this.bits = r101;
    }

    public int getEffectiveKeyBits() {
        return this.bits;
    }
}
