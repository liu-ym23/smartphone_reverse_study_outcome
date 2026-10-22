package com.ss.android.ugc.route_monitor.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f454761a;

    public d(com.ss.android.ugc.route_monitor.impl.route_out.b r100) {
        this.f454761a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i r100 = this.f454761a;     // Catch: Throwable -> L10
        monitor-enter(r100);     // Catch: Throwable -> L10
        i r101 = this.f454761a;     // Catch: Throwable -> L7
        r101.f454774a = new JSONObject();     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }
}
