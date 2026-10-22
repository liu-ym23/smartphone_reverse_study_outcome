package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.NetworkException;

/* JADX INFO: loaded from: classes5.dex */
public class NetworkExceptionImpl extends NetworkException {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected final int mCronetInternalErrorCode;
    protected final int mErrorCode;

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder r100 = new StringBuilder(super.getMessage());
        r100.append(", ErrorCode=");
        r100.append(this.mErrorCode);
        if (this.mCronetInternalErrorCode == 0) goto L5;
        r100.append(", InternalErrorCode=");
        r100.append(this.mCronetInternalErrorCode);
    L5:
        r100.append(", Retryable=");
        r100.append(immediatelyRetryable());
        return r100.toString();
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public boolean immediatelyRetryable() {
        int r100 = this.mErrorCode;
        if (r100 != 3) goto L5;
        return true;
    L5:
        if (r100 != 4) goto L7;
        return true;
    L7:
        if (r100 != 5) goto L9;
        return true;
    L9:
        if (r100 != 6) goto L11;
        return true;
    L11:
        if (r100 == 8) goto L19;
        return false;
    L19:
        return true;
    }

    static {
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public int getCronetInternalErrorCode() {
        return this.mCronetInternalErrorCode;
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public int getErrorCode() {
        return this.mErrorCode;
    }

    public NetworkExceptionImpl(String r100, int r101, int r102) {
        super(r100, null);
        this.mErrorCode = r101;
        this.mCronetInternalErrorCode = r102;
    }
}
