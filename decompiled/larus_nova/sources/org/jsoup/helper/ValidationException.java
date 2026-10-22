package org.jsoup.helper;

import ewc.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes42.dex */
public class ValidationException extends IllegalArgumentException {
    public static final String Validator = null;

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        monitor-enter(this);
        super.fillInStackTrace();     // Catch: Throwable -> L13
        StackTraceElement[] r100 = getStackTrace();     // Catch: Throwable -> L13
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L13
        int r102 = r100.length;     // Catch: Throwable -> L13
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L10;
        StackTraceElement r104 = r100[r103];     // Catch: Throwable -> L13
        if (r104.getClassName().equals(Validator) == true) goto L9;
        r101.add(r104);     // Catch: Throwable -> L13
    L9:
        r103 = r103 + 1;     // Catch: Throwable -> L13
        goto L4
    L10:
        setStackTrace((StackTraceElement[]) r101.toArray(new StackTraceElement[0]));     // Catch: Throwable -> L13
        monitor-exit(this);
        return this;
    L13:
        th = move-exception;
        throw th;
    }

    static {
        Validator = b.class.getName();
    }

    public ValidationException(String r100) {
        super(r100);
    }
}
