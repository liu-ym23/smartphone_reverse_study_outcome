package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.QuicException;

/* JADX INFO: loaded from: classes6.dex */
public class QuicExceptionImpl extends QuicException {
    private final NetworkExceptionImpl mNetworkException;
    private final int mQuicDetailedErrorCode;

    @Override // com.ttnet.org.chromium.net.NetworkException
    public int getCronetInternalErrorCode() {
        return this.mNetworkException.getCronetInternalErrorCode();
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public int getErrorCode() {
        return this.mNetworkException.getErrorCode();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.mNetworkException.getMessage() + ", QuicDetailedErrorCode=" + this.mQuicDetailedErrorCode;
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public boolean immediatelyRetryable() {
        return this.mNetworkException.immediatelyRetryable();
    }

    @Override // com.ttnet.org.chromium.net.QuicException
    public int getQuicDetailedErrorCode() {
        return this.mQuicDetailedErrorCode;
    }

    public QuicExceptionImpl(String r100, int r101, int r102, int r103) {
        super(r100, null);
        this.mNetworkException = new NetworkExceptionImpl(r100, r101, r102);
        this.mQuicDetailedErrorCode = r103;
    }
}
