package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class KeyParameter implements CipherParameters {
    private byte[] key;

    public KeyParameter(byte[] r100) {
        this(r100, 0, r100.length);
    }

    public KeyParameter(byte[] r100, int r101, int r102) {
        byte[] r103 = new byte[r102];
        this.key = r103;
        System.arraycopy(r100, r101, r103, 0, r102);
    }

    public byte[] getKey() {
        return this.key;
    }
}
