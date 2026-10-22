package com.ss.android.lark.http.model.http;

import java.io.Serializable;

/* JADX INFO: loaded from: classes36.dex */
public class HttpRequestBody implements Serializable {
    private String mContent;
    private String mMediaType;

    public HttpRequestBody() {
    }

    public String getContent() {
        return this.mContent;
    }

    public String getMediaType() {
        return this.mMediaType;
    }

    public HttpRequestBody(String r100, String r101) {
        this.mMediaType = r100;
        this.mContent = r101;
    }
}
