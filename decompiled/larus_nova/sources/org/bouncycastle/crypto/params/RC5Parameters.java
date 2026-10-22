package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class RC5Parameters implements CipherParameters {
    private byte[] key;
    private int rounds;

    public RC5Parameters(byte[] r100, int r101) {
        if (r100.length > 255) goto L7;
        byte[] r102 = new byte[r100.length];
        this.key = r102;
        this.rounds = r101;
        System.arraycopy(r100, 0, r102, 0, r100.length);
        return;
    L7:
        throw new IllegalArgumentException("RC5 key length can be no greater than 255");
    }

    public byte[] getKey() {
        return this.key;
    }

    public int getRounds() {
        return this.rounds;
    }
}
