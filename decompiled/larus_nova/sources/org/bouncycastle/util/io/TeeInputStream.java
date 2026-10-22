package org.bouncycastle.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes42.dex */
public class TeeInputStream extends InputStream {
    private final InputStream input;
    private final OutputStream output;

    public TeeInputStream(InputStream r100, OutputStream r101) {
        this.input = r100;
        this.output = r101;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.input.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.input.close();
        this.output.close();
    }

    public OutputStream getOutputStream() {
        return this.output;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int r100 = this.input.read();
        if (r100 < 0) goto L5;
        this.output.write(r100);
    L5:
        return r100;
    }

    @Override // java.io.InputStream
    public int read(byte[] r100) throws IOException {
        return read(r100, 0, r100.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = this.input.read(r100, r101, r102);
        if (r103 <= 0) goto L5;
        this.output.write(r100, r101, r103);
    L5:
        return r103;
    }
}
