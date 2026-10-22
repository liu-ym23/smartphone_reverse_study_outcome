package org.aspectj.lang;

/* JADX INFO: loaded from: classes42.dex */
public class NoAspectBoundException extends RuntimeException {
    Throwable cause;

    public NoAspectBoundException() {
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public NoAspectBoundException(String r100, Throwable r101) {
        if (r101 == null) goto L5;
        StringBuffer r102 = new StringBuffer("Exception while initializing ");
        r102.append(r100);
        r102.append(": ");
        r102.append(r101);
        r100 = r102.toString();
    L5:
        super(r100);
        this.cause = r101;
    }
}
