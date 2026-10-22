package com.bytedance.iesgurd.request;

import com.bytedance.iesgurd.utils.GeckoExecutors;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f250826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f250827b;

    public f(e r100, long r101) {
        this.f250826a = r100;
        this.f250827b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (e.f250821e.contains(Long.valueOf(this.f250827b)) == false) goto L9;
        UpdateRequest r100 = this.f250826a.f250825d;     // Catch: Throwable -> L6
        r100.getClass();     // Catch: Throwable -> L6
        ((ThreadPoolExecutor) GeckoExecutors.f250868a.getValue()).execute(new i(r100));     // Catch: Throwable -> L6
        return;
    }
}
