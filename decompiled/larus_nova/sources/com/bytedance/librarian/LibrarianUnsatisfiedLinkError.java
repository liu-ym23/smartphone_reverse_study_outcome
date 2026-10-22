package com.bytedance.librarian;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
class LibrarianUnsatisfiedLinkError extends UnsatisfiedLinkError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<LibrarianUnsatisfiedLinkError> f254574a = null;

    static {
        f254574a = new ArrayList();
    }

    public static UnsatisfiedLinkError[] getErrors() {
        ArrayList<LibrarianUnsatisfiedLinkError> r100 = f254574a;
        monitor-enter(r100);
        UnsatisfiedLinkError[] r101 = (UnsatisfiedLinkError[]) r100.toArray(new UnsatisfiedLinkError[0]);     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    public LibrarianUnsatisfiedLinkError(String r100) {
        super(r100);
        ArrayList<LibrarianUnsatisfiedLinkError> r101 = f254574a;
        monitor-enter(r101);
        r101.add(this);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public LibrarianUnsatisfiedLinkError(String r100, Throwable r101) {
        super(r100);
        initCause(r101);
        ArrayList<LibrarianUnsatisfiedLinkError> r102 = f254574a;
        monitor-enter(r102);
        r102.add(this);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
