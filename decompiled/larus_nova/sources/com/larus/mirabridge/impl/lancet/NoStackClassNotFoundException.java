package com.larus.mirabridge.impl.lancet;

/* JADX INFO: loaded from: classes30.dex */
public class NoStackClassNotFoundException extends ClassNotFoundException {
    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        monitor-enter(this);
        monitor-exit(this);
        return this;
    }

    public NoStackClassNotFoundException() {
    }

    public NoStackClassNotFoundException(String r100) {
        super(r100);
    }

    public NoStackClassNotFoundException(String r100, Throwable r101) {
        super(r100, r101);
    }
}
