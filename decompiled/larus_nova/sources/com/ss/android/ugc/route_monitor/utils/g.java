package com.ss.android.ugc.route_monitor.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes40.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f454769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f454770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Throwable f454771c;

    public g(i r100, String r101, Throwable r102) {
        this.f454769a = r100;
        this.f454770b = r101;
        this.f454771c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i r100 = this.f454769a;     // Catch: Throwable -> L13
        monitor-enter(r100);     // Catch: Throwable -> L13
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L5:
        if (this.f454769a.f454774a.remove(this.f454770b) == null) goto L7;
        this.f454769a.e(this.f454771c);     // Catch: Throwable -> L10
    L7:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    }
}
