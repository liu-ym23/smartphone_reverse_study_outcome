package org.bouncycastle.jcajce.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.bouncycastle.crypto.io.InvalidCipherTextIOException;

/* JADX INFO: loaded from: classes42.dex */
public class CipherOutputStream extends FilterOutputStream {
    private final Cipher cipher;
    private final byte[] oneByte;

    public CipherOutputStream(OutputStream r100, Cipher r101) {
        super(r100);
        this.oneByte = new byte[1];
        this.cipher = r101;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        byte[] r100 = this.cipher.doFinal();     // Catch: Exception -> L6 GeneralSecurityException -> L8
        if (r100 == null) goto L5;
        ((FilterOutputStream) this).out.write(r100);     // Catch: Exception -> L6 GeneralSecurityException -> L8
    L5:
        IOException r101 = null;
    L19:
        flush();     // Catch: IOException -> L13
        ((FilterOutputStream) this).out.close();     // Catch: IOException -> L13
    L16:
        if (r101 != null) goto L18;
        return;
    L18:
        throw r101;
    L13:
        e = move-exception;
        if (r101 != null) goto L16;
        r101 = e;
    L8:
        e = move-exception;
        IOException r102 = new InvalidCipherTextIOException("Error during cipher finalisation", e);
    L10:
        r101 = r102;
    L6:
        e = move-exception;
        r102 = new IOException("Error closing stream: " + e);
        goto L10
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r100) throws IOException {
        byte[] r101 = this.oneByte;
        r101[0] = (byte) r100;
        write(r101, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        byte[] r103 = this.cipher.update(r100, r101, r102);
        if (r103 == null) goto L6;
        ((FilterOutputStream) this).out.write(r103);
        return;
    }
}
