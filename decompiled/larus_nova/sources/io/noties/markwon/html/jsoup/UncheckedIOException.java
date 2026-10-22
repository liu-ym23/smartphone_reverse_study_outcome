package io.noties.markwon.html.jsoup;

import java.io.IOException;

/* JADX INFO: loaded from: classes41.dex */
public class UncheckedIOException extends RuntimeException {
    public IOException ioException() {
        return (IOException) getCause();
    }

    public UncheckedIOException(IOException r100) {
        super(r100);
    }
}
