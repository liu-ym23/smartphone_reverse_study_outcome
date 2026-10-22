package org.bouncycastle.jcajce.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import kotlin.UByte;
import org.bouncycastle.crypto.io.InvalidCipherTextIOException;

/* JADX INFO: loaded from: classes42.dex */
public class CipherInputStream extends FilterInputStream {
    private byte[] buf;
    private int bufOff;
    private final Cipher cipher;
    private boolean finalized;
    private final byte[] inputBuffer;
    private int maxBuf;

    public CipherInputStream(InputStream r100, Cipher r101) {
        super(r100);
        this.inputBuffer = new byte[512];
        this.finalized = false;
        this.cipher = r101;
    }

    private byte[] finaliseCipher() throws InvalidCipherTextIOException {
    L8:
        e = move-exception;
        throw new InvalidCipherTextIOException("Error finalising cipher", e);
    L3:
        if (this.finalized == true) goto L6;
        this.finalized = true;     // Catch: GeneralSecurityException -> L8
        return this.cipher.doFinal();
    L6:
        return null;
    }

    private int nextChunk() throws IOException {
        if (this.finalized == false) goto L5;
        return -1;
    L5:
        this.bufOff = 0;
        this.maxBuf = 0;
    L6:
        int r100 = this.maxBuf;
        if (r100 != 0) goto L21;
        int r101 = ((FilterInputStream) this).in.read(this.inputBuffer);
        if (r101 == (-1)) goto L10;
        byte[] r102 = this.cipher.update(this.inputBuffer, 0, r101);
        this.buf = r102;
        if (r102 == null) goto L6;
        this.maxBuf = r102.length;
        goto L6
    L10:
        byte[] r103 = finaliseCipher();
        this.buf = r103;
        if (r103 != null) goto L13;
    L17:
        return -1;
    L13:
        if (r103.length == 0) goto L17;
        int r104 = r103.length;
        this.maxBuf = r104;
        return r104;
    L21:
        return r100;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return this.maxBuf - this.bufOff;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterInputStream) this).in.close();     // Catch: Throwable -> L8
        if (this.finalized == true) goto L6;
        finaliseCipher();
    L6:
        this.bufOff = 0;
        this.maxBuf = 0;
        return;
    L8:
        th = move-exception;
        if (this.finalized == true) goto L12;
        finaliseCipher();
    L12:
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int r100) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.bufOff >= this.maxBuf) goto L5;
    L8:
        byte[] r100 = this.buf;
        int r101 = this.bufOff;
        this.bufOff = r101 + 1;
        return r100[r101] & UByte.MAX_VALUE;
    L5:
        if (nextChunk() >= 0) goto L8;
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        if (this.bufOff >= this.maxBuf) goto L5;
    L8:
        int r103 = Math.min(r102, available());
        System.arraycopy(this.buf, this.bufOff, r100, r101, r103);
        this.bufOff += r103;
        return r103;
    L5:
        if (nextChunk() >= 0) goto L8;
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r100) throws IOException {
        if (r100 > 0) goto L5;
        return 0;
    L5:
        int r101 = (int) Math.min(r100, available());
        this.bufOff += r101;
        return r101;
    }
}
