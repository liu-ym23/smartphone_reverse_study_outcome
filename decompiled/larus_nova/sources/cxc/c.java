package cxc;

import android.content.Context;

/* JADX INFO: loaded from: classes41.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f465754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f465755b = null;

    static {
        f465755b = new Object();
    }

    public c(Context r100) {
        r100.getPackageManager();
    }

    public static c a(Context r100) {
        Object r101 = f465755b;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f465754a == null) goto L7;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return f465754a;
    L7:
        if (r100.getApplicationContext() == null) goto L9;
        f465754a = new c(r100.getApplicationContext());     // Catch: Throwable -> L13
        goto L10
    L9:
        f465754a = new c(r100);     // Catch: Throwable -> L13
        goto L10
    }
}
