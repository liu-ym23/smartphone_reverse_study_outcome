package com.google.common.util.concurrent;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public class UncheckedTimeoutException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedTimeoutException() {
    }

    public UncheckedTimeoutException(@CheckForNull String r100) {
        super(r100);
    }

    public UncheckedTimeoutException(@CheckForNull Throwable r100) {
        super(r100);
    }

    public UncheckedTimeoutException(@CheckForNull String r100, @CheckForNull Throwable r101) {
        super(r100, r101);
    }
}
