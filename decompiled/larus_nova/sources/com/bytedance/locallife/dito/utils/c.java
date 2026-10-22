package com.bytedance.locallife.dito.utils;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f258690a;

    public c(Runnable r100) {
        this.f258690a = r100;
    }

    public final void a() {
        rq6.a r100 = rq6.a.f538927a;
        r100.c("DitoChunkFrontExp", "插入开始执行 hash:" + this.f258690a.hashCode());
        this.f258690a.run();
        r100.c("DitoChunkFrontExp", "【Done】插入执行 hash:" + this.f258690a.hashCode());
        a.f258684a.getClass();
        a.b(false);
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
