package org.bouncycastle.crypto.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.modes.AEADBlockCipher;

/* JADX INFO: loaded from: classes42.dex */
public class CipherOutputStream extends FilterOutputStream {
    private AEADBlockCipher aeadBlockCipher;
    private byte[] buf;
    private BufferedBlockCipher bufferedBlockCipher;
    private final byte[] oneByte;
    private StreamCipher streamCipher;

    public CipherOutputStream(OutputStream r100, BufferedBlockCipher r101) {
        super(r100);
        this.oneByte = new byte[1];
        this.bufferedBlockCipher = r101;
    }

    public CipherOutputStream(OutputStream r100, StreamCipher r101) {
        super(r100);
        this.oneByte = new byte[1];
        this.streamCipher = r101;
    }

    public CipherOutputStream(OutputStream r100, AEADBlockCipher r101) {
        super(r100);
        this.oneByte = new byte[1];
        this.aeadBlockCipher = r101;
    }

    private void ensureCapacity(int r100, boolean r101) {
        if (r101 == false) goto L9;
        BufferedBlockCipher r102 = this.bufferedBlockCipher;
        if (r102 == null) goto L6;
        r100 = r102.getOutputSize(r100);
    L15:
        byte[] r103 = this.buf;
        if (r103 != null) goto L18;
    L19:
        this.buf = new byte[r100];
        return;
    L18:
        if (r103.length < r100) goto L19;
        return;
    L6:
        AEADBlockCipher r104 = this.aeadBlockCipher;
        if (r104 == null) goto L15;
        r100 = r104.getOutputSize(r100);
        goto L15
    L9:
        BufferedBlockCipher r105 = this.bufferedBlockCipher;
        if (r105 == null) goto L12;
        r100 = r105.getUpdateOutputSize(r100);
        goto L15
    L12:
        AEADBlockCipher r106 = this.aeadBlockCipher;
        if (r106 == null) goto L15;
        r100 = r106.getUpdateOutputSize(r100);
        goto L15
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ensureCapacity(0, true);
        BufferedBlockCipher r100 = this.bufferedBlockCipher;     // Catch: Exception -> L17 InvalidCipherTextException -> L19
        if (r100 == null) goto L8;
        int r101 = r100.doFinal(this.buf, 0);     // Catch: Exception -> L17 InvalidCipherTextException -> L19
        if (r101 == 0) goto L16;
        ((FilterOutputStream) this).out.write(this.buf, 0, r101);     // Catch: Exception -> L17 InvalidCipherTextException -> L19
    L16:
        IOException r102 = null;
    L30:
        flush();     // Catch: IOException -> L24
        ((FilterOutputStream) this).out.close();     // Catch: IOException -> L24
    L27:
        if (r102 != null) goto L29;
        return;
    L29:
        throw r102;
    L24:
        e = move-exception;
        if (r102 != null) goto L27;
        r102 = e;
        goto L27
    L8:
        AEADBlockCipher r103 = this.aeadBlockCipher;     // Catch: Exception -> L17 InvalidCipherTextException -> L19
        if (r103 == null) goto L13;
        int r104 = r103.doFinal(this.buf, 0);     // Catch: Exception -> L17 InvalidCipherTextException -> L19
        if (r104 == 0) goto L16;
        ((FilterOutputStream) this).out.write(this.buf, 0, r104);     // Catch: Exception -> L17 InvalidCipherTextException -> L19
        goto L16
    L13:
        StreamCipher r105 = this.streamCipher;     // Catch: Exception -> L17 InvalidCipherTextException -> L19
        if (r105 == null) goto L16;
        r105.reset();     // Catch: Exception -> L17 InvalidCipherTextException -> L19
    L19:
        e = move-exception;
        IOException r106 = new InvalidCipherTextIOException("Error finalising cipher data", e);
    L21:
        r102 = r106;
    L17:
        e = move-exception;
        r106 = new CipherIOException("Error closing stream: ", e);
        goto L21
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r100) throws IOException {
        byte[] r101 = this.oneByte;
        byte r102 = (byte) r100;
        r101[0] = r102;
        StreamCipher r103 = this.streamCipher;
        if (r103 == null) goto L5;
        ((FilterOutputStream) this).out.write(r103.returnByte(r102));
        return;
    L5:
        write(r101, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r100) throws IOException {
        write(r100, 0, r100.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r100, int r101, int r110) throws IOException {
        ensureCapacity(r110, false);
        BufferedBlockCipher r102 = this.bufferedBlockCipher;
        if (r102 == null) goto L7;
        int r103 = r102.processBytes(r100, r101, r110, this.buf, 0);
        if (r103 == 0) goto L14;
        ((FilterOutputStream) this).out.write(this.buf, 0, r103);
        return;
    L14:
        return;
    L7:
        AEADBlockCipher r104 = this.aeadBlockCipher;
        if (r104 == null) goto L12;
        int r105 = r104.processBytes(r100, r101, r110, this.buf, 0);
        if (r105 == 0) goto L16;
        ((FilterOutputStream) this).out.write(this.buf, 0, r105);
        return;
    L16:
        return;
    L12:
        this.streamCipher.processBytes(r100, r101, r110, this.buf, 0);
        ((FilterOutputStream) this).out.write(this.buf, 0, r110);
    }
}
