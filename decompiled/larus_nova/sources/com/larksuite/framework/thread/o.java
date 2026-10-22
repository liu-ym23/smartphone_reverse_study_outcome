package com.larksuite.framework.thread;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes24.dex */
public final class o extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f285790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f285791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f285792c;

    public final void a() {
        this.f285790a.run();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("CoreThreadPool", "task exception, task name: " + this.f285791b.getClass());
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

    public o(p r100, k r101, Runnable r102) {
        this.f285792c = r100;
        this.f285790a = r101;
        this.f285791b = r102;
    }
}
