package com.google.crypto.tink.internal;

/* JADX INFO: loaded from: classes23.dex */
public final class TinkBugException extends RuntimeException {

    public interface a {
        void run() throws Exception;
    }

    public interface b<T> {
        T get() throws Exception;
    }

    public TinkBugException(String r100) {
        super(r100);
    }

    public static <T> T exceptionIsBug(b<T> r100) {
        return r100.get();
    L4:
        e = move-exception;
        throw new TinkBugException(e);
    }

    public TinkBugException(Throwable r100) {
        super(r100);
    }

    public static void exceptionIsBug(a r100) {
        r100.run();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        throw new TinkBugException(e);
    }

    public TinkBugException(String r100, Throwable r101) {
        super(r100, r101);
    }
}
