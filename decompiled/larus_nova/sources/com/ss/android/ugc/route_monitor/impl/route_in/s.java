package com.ss.android.ugc.route_monitor.impl.route_in;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.route_monitor.api.RouteResult;
import com.ss.android.ugc.route_monitor.utils.Logger;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes40.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f454557a;

    public s(String r100) {
        this.f454557a = r100;
    }

    public final void a() {
        ConcurrentHashMap<String, u> r100 = t.f454558a;     // Catch: Throwable -> L10
        u r101 = t.b(this.f454557a);     // Catch: Throwable -> L10
        if (r101 == null) goto L15;
        RouteResult r102 = r101.f454567g;     // Catch: Throwable -> L10
        Logger r103 = Logger.f454747c;     // Catch: Throwable -> L10
        Objects.toString(r102);     // Catch: Throwable -> L10
        r103.b();     // Catch: Throwable -> L10
        if (r102 != RouteResult.UNDEFINED) goto L7;
    L8:
        r101.o();     // Catch: Throwable -> L10
        return;
    L7:
        if (r102.isTimeout() == true) goto L8;
        return;
    L15:
        return;
    L10:
        th = move-exception;
        Logger r104 = Logger.f454747c;
        th.getMessage();
        r104.a();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
