package org.bouncycastle.jcajce.provider.digest;

import java.security.MessageDigest;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Xof;

/* JADX INFO: loaded from: classes42.dex */
public class BCMessageDigest extends MessageDigest {
    protected Digest digest;
    protected int digestSize;

    public BCMessageDigest(Digest r100) {
        super(r100.getAlgorithmName());
        this.digest = r100;
        this.digestSize = r100.getDigestSize();
    }

    public BCMessageDigest(Xof r100, int r101) {
        super(r100.getAlgorithmName());
        this.digest = r100;
        this.digestSize = r101 / 8;
    }

    @Override // java.security.MessageDigestSpi
    public byte[] engineDigest() {
        byte[] r100 = new byte[this.digestSize];
        this.digest.doFinal(r100, 0);
        return r100;
    }

    @Override // java.security.MessageDigestSpi
    public int engineGetDigestLength() {
        return this.digestSize;
    }

    @Override // java.security.MessageDigestSpi
    public void engineReset() {
        this.digest.reset();
    }

    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte r100) {
        this.digest.update(r100);
    }

    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte[] r100, int r101, int r102) {
        this.digest.update(r100, r101, r102);
    }
}
