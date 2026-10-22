package com.bytedance.reparo.secondary;

import android.app.Application;
import com.bytedance.reparo.IReparoConfig;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Application f267488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IReparoConfig f267489b;

    @Override // java.lang.Runnable
    public final void run() {
        Application r100 = this.f267488a;     // Catch: Throwable -> L4
        MonitorService.f267468d = this.f267489b;     // Catch: Throwable -> L4
        MonitorService.f267469e = r100;     // Catch: Throwable -> L4
        MonitorService.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public k(Application r100, b r101) {
        this.f267488a = r100;
        this.f267489b = r101;
    }
}
