package com.lynx.tasm.icu;

import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.service.ILynxI18nService;
import i8a.n;

/* JADX INFO: loaded from: classes32.dex */
public class ICURegister {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f383451a;

    public ICURegister() {
    }

    public static synchronized void a(INativeLibraryLoader r100) {
        monitor-enter(ICURegister.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f383451a == false) goto L8;
        monitor-exit(ICURegister.class);
        return;
    L8:
        ILynxI18nService r101 = (ILynxI18nService) n.c().a(ILynxI18nService.class);     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        f383451a = r101.loadLibrary(r100);     // Catch: Throwable -> L13
    L11:
        monitor-exit(ICURegister.class);
    }

    private static synchronized boolean register(long r100) {
        monitor-enter(ICURegister.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (f383451a == false) goto L11;
        ILynxI18nService r101 = (ILynxI18nService) n.c().a(ILynxI18nService.class);     // Catch: Throwable -> L14
        if (r101 == null) goto L11;
        boolean r102 = r101.registerNapiEnv(r100);     // Catch: Throwable -> L14
        monitor-exit(ICURegister.class);
        return r102;
    L11:
        monitor-exit(ICURegister.class);
        return false;
    }
}
