package com.vivo.push.g;

import android.content.Context;
import com.vivo.push.util.ContextDelegate;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f462329c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f462330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f462331b;

    public static synchronized b a() {
        monitor-enter(b.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f462329c != null) goto L7;
        f462329c = new b();     // Catch: Throwable -> L10
    L7:
        b r100 = f462329c;     // Catch: Throwable -> L10
        monitor-exit(b.class);
        return r100;
    }

    private b() {
    }

    public final synchronized a a(Context r100) {
        monitor-enter(this);
        a r101 = this.f462330a;     // Catch: Throwable -> L16
        if (r101 == null) goto L7;
        monitor-exit(this);
        return r101;
    L7:
        if (r100 != null) goto L11;
        monitor-exit(this);
        return null;
    L11:
        if (r101 != null) goto L13;
        Context r102 = ContextDelegate.getContext(r100.getApplicationContext());     // Catch: Throwable -> L16
        this.f462331b = r102;     // Catch: Throwable -> L16
        this.f462330a = new c(r102);     // Catch: Throwable -> L16
    L13:
        a r103 = this.f462330a;     // Catch: Throwable -> L16
        monitor-exit(this);
        return r103;
    L16:
        th = move-exception;
        throw th;
    }
}
