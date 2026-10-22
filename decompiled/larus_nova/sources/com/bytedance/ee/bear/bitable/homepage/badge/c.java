package com.bytedance.ee.bear.bitable.homepage.badge;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.a f212326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f212327b;

    public c(b.a r100, int r101, int r102) {
        this.f212326a = r100;
        this.f212327b = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f212326a.a(this.f212327b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
