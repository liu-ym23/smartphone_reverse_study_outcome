package com.ss.android.ugc.route_monitor.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f454762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f454763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f454764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Throwable f454765d;

    public e(i r100, String r101, JSONObject r102, Throwable r103) {
        this.f454762a = r100;
        this.f454763b = r101;
        this.f454764c = r102;
        this.f454765d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i r100 = this.f454762a;     // Catch: Throwable -> L10
        monitor-enter(r100);     // Catch: Throwable -> L10
        this.f454762a.f454774a.put(this.f454763b, this.f454764c);     // Catch: Throwable -> L7
        this.f454762a.e(this.f454765d);     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
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
