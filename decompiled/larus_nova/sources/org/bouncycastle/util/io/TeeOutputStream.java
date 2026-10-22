package org.bouncycastle.util.io;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes42.dex */
public class TeeOutputStream extends OutputStream {
    private OutputStream output1;
    private OutputStream output2;

    public TeeOutputStream(OutputStream r100, OutputStream r101) {
        this.output1 = r100;
        this.output2 = r101;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.output1.close();
        this.output2.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.output1.flush();
        this.output2.flush();
    }

    @Override // java.io.OutputStream
    public void write(int r100) throws IOException {
        this.output1.write(r100);
        this.output2.write(r100);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100) throws IOException {
        this.output1.write(r100);
        this.output2.write(r100);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        this.output1.write(r100, r101, r102);
        this.output2.write(r100, r101, r102);
    }
}
