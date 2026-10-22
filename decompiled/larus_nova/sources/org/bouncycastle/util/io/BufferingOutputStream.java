package org.bouncycastle.util.io;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class BufferingOutputStream extends OutputStream {
    private final byte[] buf;
    private int bufOff;
    private final OutputStream other;

    public BufferingOutputStream(OutputStream r100) {
        this.other = r100;
        this.buf = new byte[4096];
    }

    public BufferingOutputStream(OutputStream r100, int r101) {
        this.other = r100;
        this.buf = new byte[r101];
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        this.other.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.other.write(this.buf, 0, this.bufOff);
        this.bufOff = 0;
        Arrays.fill(this.buf, (byte) 0);
    }

    @Override // java.io.OutputStream
    public void write(int r100) throws IOException {
        byte[] r101 = this.buf;
        int r102 = this.bufOff;
        int r103 = r102 + 1;
        this.bufOff = r103;
        r101[r102] = (byte) r100;
        if (r103 != r101.length) goto L6;
        flush();
        return;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        byte[] r103 = this.buf;
        int r104 = r103.length;
        int r105 = this.bufOff;
        if (r102 >= (r104 - r105)) goto L6;
        System.arraycopy(r100, r101, r103, r105, r102);
    L5:
        this.bufOff += r102;
        return;
    L6:
        int r106 = r103.length - r105;
        System.arraycopy(r100, r101, r103, r105, r106);
        this.bufOff += r106;
        flush();
        int r107 = r101 + r106;
        r102 = r102 - r106;
    L7:
        byte[] r108 = this.buf;
        if (r102 < r108.length) goto L10;
        this.other.write(r100, r107, r108.length);
        byte[] r109 = this.buf;
        r107 = r107 + r109.length;
        r102 = r102 - r109.length;
        goto L7
    L10:
        if (r102 <= 0) goto L14;
        System.arraycopy(r100, r107, r108, this.bufOff, r102);
        goto L5
    }
}
