package com.ss.ugc.live.gift.resource.download;

import java.io.IOException;

/* JADX INFO: loaded from: classes36.dex */
class HttpUrlConnectionDownloader$HttpResponseException extends IOException {
    private int code;

    public int getCode() {
        return this.code;
    }

    public HttpUrlConnectionDownloader$HttpResponseException(String r100, int r101) {
        super(r100);
        this.code = r101;
    }
}
