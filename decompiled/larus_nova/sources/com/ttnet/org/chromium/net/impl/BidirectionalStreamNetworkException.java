package com.ttnet.org.chromium.net.impl;

/* JADX INFO: loaded from: classes41.dex */
public class BidirectionalStreamNetworkException extends NetworkExceptionImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Override // com.ttnet.org.chromium.net.impl.NetworkExceptionImpl, com.ttnet.org.chromium.net.NetworkException
    public boolean immediatelyRetryable() {
        int r100 = this.mCronetInternalErrorCode;
        if (r100 != (-358)) goto L5;
        return true;
    L5:
        if (r100 != (-352)) goto L7;
        return true;
    L7:
        return super.immediatelyRetryable();
    }

    static {
    }

    public BidirectionalStreamNetworkException(String r100, int r101, int r102) {
        super(r100, r101, r102);
    }
}
