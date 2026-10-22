package org.bouncycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.SkippingCipher;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class CipherInputStream extends FilterInputStream {
    private static final int INPUT_BUF_SIZE = 2048;
    private AEADBlockCipher aeadBlockCipher;
    private byte[] buf;
    private int bufOff;
    private BufferedBlockCipher bufferedBlockCipher;
    private boolean finalized;
    private byte[] inBuf;
    private byte[] markBuf;
    private int markBufOff;
    private long markPosition;
    private int maxBuf;
    private SkippingCipher skippingCipher;
    private StreamCipher streamCipher;

    public CipherInputStream(InputStream r100, BufferedBlockCipher r101) {
        this(r100, r101, 2048);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CipherInputStream(InputStream r100, BufferedBlockCipher r101, int r102) {
        super(r100);
        this.bufferedBlockCipher = r101;
        this.inBuf = new byte[r102];
        if ((r101 instanceof SkippingCipher) == false) goto L5;
        SkippingCipher r103 = (SkippingCipher) r101;
    L6:
        this.skippingCipher = r103;
        return;
    L5:
        r103 = null;
        goto L6
    }

    public CipherInputStream(InputStream r100, StreamCipher r101) {
        this(r100, r101, 2048);
    }

    public CipherInputStream(InputStream r100, StreamCipher r101, int r102) {
        super(r100);
        this.streamCipher = r101;
        this.inBuf = new byte[r102];
        if ((r101 instanceof SkippingCipher) == false) goto L5;
        SkippingCipher r103 = (SkippingCipher) r101;
    L6:
        this.skippingCipher = r103;
        return;
    L5:
        r103 = null;
        goto L6
    }

    public CipherInputStream(InputStream r100, AEADBlockCipher r101) {
        this(r100, r101, 2048);
    }

    public CipherInputStream(InputStream r100, AEADBlockCipher r101, int r102) {
        super(r100);
        this.aeadBlockCipher = r101;
        this.inBuf = new byte[r102];
        if ((r101 instanceof SkippingCipher) == false) goto L5;
        SkippingCipher r103 = (SkippingCipher) r101;
    L6:
        this.skippingCipher = r103;
        return;
    L5:
        r103 = null;
        goto L6
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

    private void finaliseCipher() throws IOException {
        this.finalized = true;     // Catch: Exception -> L12 InvalidCipherTextException -> L15
        ensureCapacity(0, true);     // Catch: Exception -> L12 InvalidCipherTextException -> L15
        BufferedBlockCipher r100 = this.bufferedBlockCipher;     // Catch: Exception -> L12 InvalidCipherTextException -> L15
        if (r100 == null) goto L7;
        int r101 = r100.doFinal(this.buf, 0);     // Catch: Exception -> L12 InvalidCipherTextException -> L15
    L6:
        this.maxBuf = r101;     // Catch: Exception -> L12 InvalidCipherTextException -> L15
        return;
    L7:
        AEADBlockCipher r102 = this.aeadBlockCipher;     // Catch: Exception -> L12 InvalidCipherTextException -> L15
        if (r102 == null) goto L10;
        r101 = r102.doFinal(this.buf, 0);     // Catch: Exception -> L12 InvalidCipherTextException -> L15
        goto L6
    L10:
        this.maxBuf = 0;     // Catch: Exception -> L12 InvalidCipherTextException -> L15
        return;
    L15:
        e = move-exception;
        throw new InvalidCipherTextIOException("Error finalising cipher", e);
    L12:
        e = move-exception;
        throw new IOException("Error finalising cipher " + e);
    }

    private int nextChunk() throws IOException {
        if (this.finalized == false) goto L5;
        return -1;
    L5:
        this.bufOff = 0;
        this.maxBuf = 0;
    L6:
        int r100 = this.maxBuf;
        if (r100 != 0) goto L26;
        int r101 = ((FilterInputStream) this).in.read(this.inBuf);
        if (r101 == (-1)) goto L10;
        ensureCapacity(r101, false);     // Catch: Exception -> L23
        BufferedBlockCipher r102 = this.bufferedBlockCipher;     // Catch: Exception -> L23
        if (r102 == null) goto L18;
        r101 = r102.processBytes(this.inBuf, 0, r101, this.buf, 0);     // Catch: Exception -> L23
    L17:
        this.maxBuf = r101;     // Catch: Exception -> L23
        goto L6
    L18:
        AEADBlockCipher r103 = this.aeadBlockCipher;     // Catch: Exception -> L23
        if (r103 == null) goto L21;
        r101 = r103.processBytes(this.inBuf, 0, r101, this.buf, 0);     // Catch: Exception -> L23
        goto L17
    L21:
        this.streamCipher.processBytes(this.inBuf, 0, r101, this.buf, 0);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        throw new CipherIOException("Error processing stream ", e);
    L10:
        finaliseCipher();
        int r104 = this.maxBuf;
        if (r104 != 0) goto L13;
        return -1;
    L13:
        return r104;
    L26:
        return r100;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return this.maxBuf - this.bufOff;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterInputStream) this).in.close();     // Catch: Throwable -> L14
        if (this.finalized == true) goto L6;
        finaliseCipher();
    L6:
        this.bufOff = 0;
        this.maxBuf = 0;
        this.markBufOff = 0;
        this.markPosition = 0;
        byte[] r100 = this.markBuf;
        if (r100 == null) goto L9;
        Arrays.fill(r100, (byte) 0);
        this.markBuf = null;
    L9:
        byte[] r101 = this.buf;
        if (r101 == null) goto L12;
        Arrays.fill(r101, (byte) 0);
        this.buf = null;
    L12:
        Arrays.fill(this.inBuf, (byte) 0);
        return;
    L14:
        th = move-exception;
        if (this.finalized == true) goto L18;
        finaliseCipher();
    L18:
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int r100) {
        ((FilterInputStream) this).in.mark(r100);
        SkippingCipher r101 = this.skippingCipher;
        if (r101 == null) goto L5;
        this.markPosition = r101.getPosition();
    L5:
        byte[] r102 = this.buf;
        if (r102 == null) goto L8;
        byte[] r103 = new byte[r102.length];
        this.markBuf = r103;
        System.arraycopy(r102, 0, r103, 0, r102.length);
    L8:
        this.markBufOff = this.bufOff;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        if (this.skippingCipher != null) goto L5;
        return false;
    L5:
        return ((FilterInputStream) this).in.markSupported();
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
    public int read(byte[] r100) throws IOException {
        return read(r100, 0, r100.length);
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
        if (this.skippingCipher == null) goto L10;
        ((FilterInputStream) this).in.reset();
        this.skippingCipher.seekTo(this.markPosition);
        byte[] r100 = this.markBuf;
        if (r100 == null) goto L7;
        this.buf = r100;
    L7:
        this.bufOff = this.markBufOff;
        return;
    L10:
        throw new IOException("cipher must implement SkippingCipher to be used with reset()");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r100) throws IOException {
        if (r100 > 0) goto L6;
        return 0;
    L6:
        if (this.skippingCipher == null) goto L17;
        long r101 = available();
        if (r100 > r101) goto L11;
        this.bufOff = (int) (((long) this.bufOff) + r100);
        return r100;
    L11:
        this.bufOff = this.maxBuf;
        long r102 = ((FilterInputStream) this).in.skip(r100 - r101);
        if (r102 != this.skippingCipher.skip(r102)) goto L16;
        return r102 + r101;
    L16:
        throw new IOException("Unable to skip cipher " + r102 + " bytes.");
    L17:
        int r103 = (int) Math.min(r100, available());
        this.bufOff += r103;
        return r103;
    }
}
