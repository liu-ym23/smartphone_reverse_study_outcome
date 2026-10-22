package com.ss.android.ugc.route_monitor.impl.route_out;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f454701a;

    public j(h r100) {
        this.f454701a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h r100 = this.f454701a;     // Catch: Throwable -> L4
        r100.f454698c = 1;     // Catch: Throwable -> L4
        r100.b();     // Catch: Throwable -> L4
        com.ss.android.ugc.route_monitor.c.a().i();     // Catch: Throwable -> L4
        HashMap<String, h> r101 = k.f454702a;     // Catch: Throwable -> L4
        h r102 = this.f454701a;     // Catch: Throwable -> L4
        k.f454702a.remove(r102.f454699d);     // Catch: Throwable -> L4
        k.i();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
