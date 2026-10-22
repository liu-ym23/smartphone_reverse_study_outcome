package com.bytedance.ee.bear.drive.core.fragment;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f224215a;

    public h(d r100) {
        this.f224215a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.b(this.f224215a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
