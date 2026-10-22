package com.ss.vcbkit;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class VCBaseKitLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f458543a;

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("vcbasekit", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> vcbasekit");
        com.bytedance.librarian.a.c("vcbasekit");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> vcbasekit");
    }

    public static synchronized boolean loadLibrary() {
        monitor-enter(VCBaseKitLoader.class);
    L25:
        th = move-exception;
        throw th;
    L6:
        if (f458543a == false) goto L10;
        monitor-exit(VCBaseKitLoader.class);
        return true;
    L10:
        if (UnExpected.f458542a == true) goto L32;
        UnExpected.f458542a = true;     // Catch: Throwable -> L14
    L15:
        UnExpected.f458542a = false;     // Catch: Throwable -> L25
    L32:
        a();     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L20
        f458543a = true;     // Catch: Throwable -> L18 UnsatisfiedLinkError -> L20
    L22:
        boolean r100 = f458543a;     // Catch: Throwable -> L25
        monitor-exit(VCBaseKitLoader.class);
        return r100;
    L20:
        e = move-exception;
        e.getMessage();     // Catch: Throwable -> L25
    L18:
        th = move-exception;
        th.getMessage();     // Catch: Throwable -> L25
        goto L22
    }

    public VCBaseKitLoader() {
    }
}
