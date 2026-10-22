package com.ss.android.ugc.route_monitor.impl.route_out;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f454700a;

    public i(h r100) {
        this.f454700a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap<String, h> r100 = k.f454702a;     // Catch: Throwable -> L4
        h r101 = this.f454700a;     // Catch: Throwable -> L4
        r100.put(r101.f454699d, r101);     // Catch: Throwable -> L4
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
