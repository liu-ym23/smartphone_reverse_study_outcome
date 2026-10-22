package org.bouncycastle.crypto.io;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes42.dex */
public class DigestOutputStream extends OutputStream {
    protected Digest digest;

    public DigestOutputStream(Digest r100) {
        this.digest = r100;
    }

    public byte[] getDigest() {
        byte[] r100 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(r100, 0);
        return r100;
    }

    @Override // java.io.OutputStream
    public void write(int r100) throws IOException {
        this.digest.update((byte) r100);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        this.digest.update(r100, r101, r102);
    }
}
