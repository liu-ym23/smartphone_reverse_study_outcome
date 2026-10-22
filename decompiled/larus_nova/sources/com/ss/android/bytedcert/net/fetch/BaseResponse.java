package com.ss.android.bytedcert.net.fetch;

/* JADX INFO: loaded from: classes34.dex */
public class BaseResponse {
    protected String mBody;
    protected int mStatusCode;
    protected boolean mSuccess;

    public BaseResponse() {
    }

    public String getBody() {
        return this.mBody;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public boolean isSuccess() {
        return this.mSuccess;
    }
}
