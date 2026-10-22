package org.jsoup;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class UnsupportedMimeTypeException extends IOException {
    private final String mimeType;
    private final String url;

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + ". Mimetype=" + this.mimeType + ", URL=" + this.url;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getUrl() {
        return this.url;
    }

    public UnsupportedMimeTypeException(String r100, String r101, String r102) {
        super(r100);
        this.mimeType = r101;
        this.url = r102;
    }
}
