package com.google.common.util.concurrent;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public class ExecutionError extends Error {
    private static final long serialVersionUID = 0;

    public ExecutionError() {
    }

    public ExecutionError(@CheckForNull Error r100) {
        super(r100);
    }

    public ExecutionError(@CheckForNull String r100) {
        super(r100);
    }

    public ExecutionError(@CheckForNull String r100, @CheckForNull Error r101) {
        super(r100, r101);
    }
}
