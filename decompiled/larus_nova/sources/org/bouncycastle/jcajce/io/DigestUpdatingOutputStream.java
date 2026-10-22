package org.bouncycastle.jcajce.io;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes42.dex */
class DigestUpdatingOutputStream extends OutputStream {
    private MessageDigest digest;

    public DigestUpdatingOutputStream(MessageDigest r100) {
        this.digest = r100;
    }

    @Override // java.io.OutputStream
    public void write(int r100) throws IOException {
        this.digest.update((byte) r100);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100) throws IOException {
        this.digest.update(r100);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        this.digest.update(r100, r101, r102);
    }
}
