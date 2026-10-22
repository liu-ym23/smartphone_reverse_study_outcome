package com.bytedance.librarian;

import android.content.Context;
import com.ss.android.lark.framework.assembly.librarian.InitLibrarianTask;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f254575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f254576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f254577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f254578d = null;

    static {
        f254578d = new Object();
    }

    public static UnsatisfiedLinkError[] a() {
        return LibrarianUnsatisfiedLinkError.getErrors();
    }

    public static void c(String r100) {
        e(r100, false, null);
    }

    public static void d(String r100, Context r101) {
        e(r100, true, r101);
    }

    public static void b(Context r100, String r101, InitLibrarianTask.b r102) {
        Object r103 = f254578d;
        monitor-enter(r103);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f254576b == null) goto L8;
        monitor-exit(r103);     // Catch: Throwable -> L15
        return;
    L8:
        monitor-exit(r103);     // Catch: Throwable -> L15
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
        f254575a = r100;
        f254576b = r101;
        f254577c = r102;
        return;
    L14:
        throw new IllegalStateException("context or version is null in init");
    }

    public static void e(String r100, boolean r101, Context r102) {
        if (r101 == true) goto L4;
    L6:
        b r103 = b.f254579n;
        if (r103 == null) goto L10;
        r103.h(r100);
        return;
    L10:
        if (f254577c == null) goto L12;
        System.loadLibrary(r100);
        return;
    L12:
        System.loadLibrary(r100);
        return;
    L4:
        if (f254575a != null) goto L6;
        f254575a = r102;
        goto L6
    }
}
