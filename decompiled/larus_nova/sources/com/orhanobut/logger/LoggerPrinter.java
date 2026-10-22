package com.orhanobut.logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
class LoggerPrinter implements Printer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal<String> f404335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<LogAdapter> f404336b;

    public LoggerPrinter() {
        this.f404335a = new ThreadLocal();
        this.f404336b = new ArrayList();
    }

    public final synchronized void a(String r100, String r101) {
        monitor-enter(this);
        if (r101 == null) goto L11;
    L8:
        th = move-exception;
        throw th;
    L5:
        if (r101.length() == 0) goto L11;
    L11:
        Iterator r102 = ((ArrayList) this.f404336b).iterator();     // Catch: Throwable -> L8
    L12:
        if (r102.hasNext() == false) goto L16;
        ((LogAdapter) r102.next()).a();     // Catch: Throwable -> L8
        goto L12
    L16:
        monitor-exit(this);
    }
}
