package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes6.dex */
public abstract class QuicException extends NetworkException {
    public abstract int getQuicDetailedErrorCode();

    public QuicException(String r100, Throwable r101) {
        super(r100, r101);
    }
}
