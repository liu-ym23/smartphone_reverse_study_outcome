package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class AEADParameters implements CipherParameters {
    private byte[] associatedText;
    private KeyParameter key;
    private int macSize;
    private byte[] nonce;

    public AEADParameters(KeyParameter r100, int r101, byte[] r102) {
        this(r100, r101, r102, null);
    }

    public AEADParameters(KeyParameter r100, int r101, byte[] r102, byte[] r103) {
        this.key = r100;
        this.nonce = Arrays.clone(r102);
        this.macSize = r101;
        this.associatedText = Arrays.clone(r103);
    }

    public byte[] getAssociatedText() {
        return Arrays.clone(this.associatedText);
    }

    public KeyParameter getKey() {
        return this.key;
    }

    public int getMacSize() {
        return this.macSize;
    }

    public byte[] getNonce() {
        return Arrays.clone(this.nonce);
    }
}
