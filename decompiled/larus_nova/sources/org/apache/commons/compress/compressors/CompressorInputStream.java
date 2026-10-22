package org.apache.commons.compress.compressors;

import java.io.InputStream;

/* JADX INFO: loaded from: classes42.dex */
public abstract class CompressorInputStream extends InputStream {
    private long bytesRead;

    public CompressorInputStream() {
        this.bytesRead = 0;
    }

    public void count(long r100) {
        if (r100 == (-1)) goto L6;
        this.bytesRead += r100;
        return;
    }

    public void count(int r100) {
        count(r100);
    }
}
