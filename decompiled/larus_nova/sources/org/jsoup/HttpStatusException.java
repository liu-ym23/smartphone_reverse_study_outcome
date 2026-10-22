package org.jsoup;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class HttpStatusException extends IOException {
    private final int statusCode;
    private final String url;

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getUrl() {
        return this.url;
    }

    public HttpStatusException(String r100, int r101, String r102) {
        super(r100 + ". Status=" + r101 + ", URL=[" + r102 + "]");
        this.statusCode = r101;
        this.url = r102;
    }
}
