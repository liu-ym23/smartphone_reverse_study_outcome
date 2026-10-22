package io.reactivex.exceptions;

/* JADX INFO: loaded from: classes41.dex */
public final class OnErrorNotImplementedException extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public OnErrorNotImplementedException(Throwable r100) {
        this("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | " + r100, r100);
    }

    public OnErrorNotImplementedException(String r100, Throwable r101) {
        if (r101 != null) goto L5;
        r101 = new NullPointerException();
    L5:
        super(r100, r101);
    }
}
