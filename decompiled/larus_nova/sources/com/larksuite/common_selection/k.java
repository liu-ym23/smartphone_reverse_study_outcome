package com.larksuite.common_selection;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes24.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f282902a;

    public k(i r100) {
        this.f282902a = r100;
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
        if (this.f282902a.f282883p.getAndSet(false) == false) goto L9;
        this.f282902a.m();     // Catch: Throwable -> L6
        return;
    }
}
