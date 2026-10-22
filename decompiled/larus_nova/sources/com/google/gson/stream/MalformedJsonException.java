package com.google.gson.stream;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class MalformedJsonException extends IOException {
    private static final long serialVersionUID = 1;

    public MalformedJsonException(String r100) {
        super(r100);
    }

    public MalformedJsonException(Throwable r100) {
        super(r100);
    }

    public MalformedJsonException(String r100, Throwable r101) {
        super(r100, r101);
    }
}
