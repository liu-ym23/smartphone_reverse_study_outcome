package com.google.common.base;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public class VerifyException extends RuntimeException {
    public VerifyException() {
    }

    public VerifyException(@CheckForNull String r100) {
        super(r100);
    }

    public VerifyException(@CheckForNull Throwable r100) {
        super(r100);
    }

    public VerifyException(@CheckForNull String r100, @CheckForNull Throwable r101) {
        super(r100, r101);
    }
}
