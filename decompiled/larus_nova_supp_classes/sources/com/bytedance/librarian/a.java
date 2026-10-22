package com.bytedance.librarian;

import android.content.Context;
import com.ss.android.lark.framework.assembly.librarian.InitLibrarianTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static Context a;
    public static volatile String b;
    public static c c;
    public static final Object d = null;

    static {
        d = new Object();
    }

    public static UnsatisfiedLinkError[] a() {
        return LibrarianUnsatisfiedLinkError.getErrors();
    }

    public static void c(String r2) {
        e(r2, false, null);
    }

    public static void d(String r1, Context r2) {
        e(r1, true, r2);
    }

    public static void b(Context r2, String r3, InitLibrarianTask.b r4) {
        Object r0 = d;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (b == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L15
        if (r2 == null) goto L14;
        if (r3 == null) goto L14;
        a = r2;
        b = r3;
        c = r4;
        return;
    L14:
        throw new IllegalStateException("context or version is null in init");
    }

    public static void e(String r0, boolean r1, Context r2) {
        if (r1 == true) goto L4;
    L6:
        b r3 = b.n;
        if (r3 == null) goto L10;
        r3.h(r0);
        return;
    L10:
        if (c == null) goto L12;
        System.loadLibrary(r0);
        return;
    L12:
        System.loadLibrary(r0);
        return;
    L4:
        if (a != null) goto L6;
        a = r2;
        goto L6
    }
}
