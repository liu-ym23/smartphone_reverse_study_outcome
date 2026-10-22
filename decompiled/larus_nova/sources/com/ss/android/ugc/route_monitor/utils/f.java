package com.ss.android.ugc.route_monitor.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f454766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f454767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f454768c;

    public f(com.ss.android.ugc.route_monitor.impl.route_out.b r100, String r101, JSONObject r102) {
        this.f454766a = r100;
        this.f454767b = r101;
        this.f454768c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i r100 = this.f454766a;     // Catch: Throwable -> L10
        monitor-enter(r100);     // Catch: Throwable -> L10
        this.f454766a.f454774a.put(this.f454767b, this.f454768c);     // Catch: Throwable -> L7
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
