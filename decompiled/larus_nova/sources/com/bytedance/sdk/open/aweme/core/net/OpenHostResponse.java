package com.bytedance.sdk.open.aweme.core.net;

/* JADX INFO: loaded from: classes22.dex */
public class OpenHostResponse {
    public OpenResponseBody body;
    public int code;
    public OpenNetHeaders headers;
    public String message;
    public Throwable throwable;
    public String url;

    public OpenHostResponse(int r100, String r101, String r102, OpenNetHeaders r103, OpenResponseBody r104, Throwable r105) {
        this.code = r100;
        this.message = r101;
        this.url = r102;
        this.headers = r103;
        this.body = r104;
        this.throwable = r105;
    }

    public boolean isSuccessful() {
        int r100 = this.code;
        if (r100 <= 299) goto L5;
    L7:
        return false;
    L5:
        if (r100 < 200) goto L7;
        return true;
    }

    public String toString() {
        return "OpenHostResponse{code=" + this.code + ", message='" + this.message + "', url='" + this.url + "', headers=" + this.headers + ", body=" + this.body + ", throwable=" + this.throwable + '}';
    }
}
