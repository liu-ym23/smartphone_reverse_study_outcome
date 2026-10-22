package com.facebook.common.util;

/* JADX INFO: loaded from: classes22.dex */
public class ExceptionWithNoStacktrace extends Exception {
    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        monitor-enter(this);
        monitor-exit(this);
        return this;
    }

    public ExceptionWithNoStacktrace(String r100) {
        super(r100);
    }
}
