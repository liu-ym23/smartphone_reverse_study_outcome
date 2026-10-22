package com.bytedance.locallife.hybrid.bridge.network.exception;

/* JADX INFO: loaded from: classes21.dex */
public class HttpResponseException extends ClientProtocolException {
    private static final long serialVersionUID = -7186627969477257933L;
    private final int statusCode;

    public int getStatusCode() {
        return this.statusCode;
    }

    public HttpResponseException(int r100, String r101) {
        super(r101);
        this.statusCode = r100;
    }
}
