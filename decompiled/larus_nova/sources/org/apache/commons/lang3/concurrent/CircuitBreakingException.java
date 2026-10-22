package org.apache.commons.lang3.concurrent;

/* JADX INFO: loaded from: classes42.dex */
public class CircuitBreakingException extends RuntimeException {
    private static final long serialVersionUID = 1408176654686913340L;

    public CircuitBreakingException() {
    }

    public CircuitBreakingException(String r100) {
        super(r100);
    }

    public CircuitBreakingException(Throwable r100) {
        super(r100);
    }

    public CircuitBreakingException(String r100, Throwable r101) {
        super(r100, r101);
    }
}
