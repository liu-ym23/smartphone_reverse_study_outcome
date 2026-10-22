package com.larksuite.framework.thread;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes24.dex */
public final class f extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f285749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f285750b;

    public final void a() {
        this.f285749a.run();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("CoreScheduledThreadPoolExecutor", "schedule task exception, task name: " + this.f285750b.getClass());
        a.c().a(e);
        a.c().getClass();
        System.currentTimeMillis();
        throw e;
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

    public f(k r100, Runnable r101) {
        this.f285749a = r100;
        this.f285750b = r101;
    }
}
