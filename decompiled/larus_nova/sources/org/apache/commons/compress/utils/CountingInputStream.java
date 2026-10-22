package org.apache.commons.compress.utils;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes42.dex */
public class CountingInputStream extends FilterInputStream {
    private long bytesRead;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int r100 = ((FilterInputStream) this).in.read();
        if (r100 < 0) goto L5;
        count(1);
    L5:
        return r100;
    }

    public CountingInputStream(InputStream r100) {
        super(r100);
    }

    public final void count(long r100) {
        if (r100 == (-1)) goto L6;
        this.bytesRead += r100;
        return;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r100) throws IOException {
        return read(r100, 0, r100.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = ((FilterInputStream) this).in.read(r100, r101, r102);
        if (r103 < 0) goto L5;
        count(r103);
    L5:
        return r103;
    }
}
