package com.orhanobut.logger;

import com.bytedance.jedi.model.util.SyncLog$androidLogAdapter$1;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Printer f404334a = null;

    static {
        f404334a = new LoggerPrinter();
    }

    public static void a(SyncLog$androidLogAdapter$1 r100) {
        ((ArrayList) ((LoggerPrinter) f404334a).f404336b).add(r100);
    }

    public static void b(String r100, Object... r101) {
        LoggerPrinter r102 = (LoggerPrinter) f404334a;
        monitor-enter(r102);
        r100.getClass();
        String r103 = r102.f404335a.get();     // Catch: Throwable -> L16
        if (r103 == null) goto L8;
        r102.f404335a.remove();     // Catch: Throwable -> L16
    L10:
        if (r101.length == 0) goto L13;
        r100 = String.format(r100, r101);     // Catch: Throwable -> L16
    L13:
        r102.a(r103, r100);     // Catch: Throwable -> L16
        monitor-exit(r102);
        return;
    L8:
        r103 = null;
    L16:
        th = move-exception;
        throw th;
    }
}
