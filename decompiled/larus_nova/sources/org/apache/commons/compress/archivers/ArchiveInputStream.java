package org.apache.commons.compress.archivers;

import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ArchiveInputStream extends InputStream {
    private long bytesRead;
    private final byte[] single;

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.single, 0, 1) != (-1)) goto L6;
        return -1;
    L6:
        return this.single[0] & UByte.MAX_VALUE;
    }

    public ArchiveInputStream() {
        this.single = new byte[1];
        this.bytesRead = 0;
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public void count(long r100) {
        if (r100 == (-1)) goto L6;
        this.bytesRead += r100;
        return;
    }

    public void pushedBackBytes(long r100) {
        this.bytesRead -= r100;
    }

    public void count(int r100) {
        count(r100);
    }
}
