package org.jsoup;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class UncheckedIOException extends RuntimeException {
    public IOException ioException() {
        return (IOException) getCause();
    }

    public UncheckedIOException(String r100) {
        super(new IOException(r100));
    }

    public UncheckedIOException(IOException r100) {
        super(r100);
    }
}
