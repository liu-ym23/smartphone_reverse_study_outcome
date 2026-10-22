package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class CdnCacheVerifyException extends IOException {
    public CdnCacheVerifyException() {
    }

    public CdnCacheVerifyException(Throwable r100) {
        initCause(r100);
    }

    public CdnCacheVerifyException(String r100) {
        super(r100);
    }

    public CdnCacheVerifyException(String r100, Throwable r101) {
        super(r100);
        initCause(r101);
    }
}
