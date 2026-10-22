package com.ss.ugc.effectplatform.cache.disklrucache;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f457320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.c f457321b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f457320a.j(this.f457321b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(a r100, a.c r101) {
        this.f457320a = r100;
        this.f457321b = r101;
    }
}
