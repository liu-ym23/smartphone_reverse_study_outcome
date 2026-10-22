package com.larksuite.framework.http.request;

import java.io.Serializable;

/* JADX INFO: loaded from: classes24.dex */
public class RequestBody implements Serializable {
    private byte[] mBytesContent;
    private String mContent;
    private String mMediaType;

    public RequestBody() {
    }

    public byte[] getBytesContent() {
        return this.mBytesContent;
    }

    public String getContent() {
        return this.mContent;
    }

    public String getMediaType() {
        return this.mMediaType;
    }

    public RequestBody(String r100, String r101) {
        this.mMediaType = r100;
        this.mContent = r101;
    }

    public static RequestBody create(String r100, String r101) {
        return new RequestBody(r100, r101);
    }

    public RequestBody(String r100, byte[] r101) {
        this.mMediaType = r100;
        this.mBytesContent = r101;
    }

    public static RequestBody create(String r100, byte[] r101) {
        return new RequestBody(r100, r101);
    }
}
