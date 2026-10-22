package org.apache.commons.net.io;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class CopyStreamException extends IOException {
    private static final long serialVersionUID = -2602899129433221532L;
    private final long totalBytesTransferred;

    public IOException getIOException() {
        return (IOException) getCause();
    }

    public long getTotalBytesTransferred() {
        return this.totalBytesTransferred;
    }

    public CopyStreamException(String r100, long r101, IOException r102) {
        super(r100);
        initCause(r102);
        this.totalBytesTransferred = r101;
    }
}
