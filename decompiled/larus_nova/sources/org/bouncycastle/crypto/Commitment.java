package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public class Commitment {
    private final byte[] commitment;
    private final byte[] secret;

    public Commitment(byte[] r100, byte[] r101) {
        this.secret = r100;
        this.commitment = r101;
    }

    public byte[] getCommitment() {
        return this.commitment;
    }

    public byte[] getSecret() {
        return this.secret;
    }
}
