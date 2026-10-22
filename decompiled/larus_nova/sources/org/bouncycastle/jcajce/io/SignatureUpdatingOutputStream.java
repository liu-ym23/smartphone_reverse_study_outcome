package org.bouncycastle.jcajce.io;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Signature;
import java.security.SignatureException;

/* JADX INFO: loaded from: classes42.dex */
class SignatureUpdatingOutputStream extends OutputStream {
    private Signature sig;

    public SignatureUpdatingOutputStream(Signature r100) {
        this.sig = r100;
    }

    @Override // java.io.OutputStream
    public void write(int r100) throws IOException {
        this.sig.update((byte) r100);     // Catch: SignatureException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getMessage());
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100) throws IOException {
        this.sig.update(r100);     // Catch: SignatureException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getMessage());
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        this.sig.update(r100, r101, r102);     // Catch: SignatureException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getMessage());
    }
}
