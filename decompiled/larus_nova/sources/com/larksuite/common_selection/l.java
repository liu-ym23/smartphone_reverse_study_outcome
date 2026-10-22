package com.larksuite.common_selection;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes24.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f282903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f282904b;

    public l(i r100, boolean r101) {
        this.f282903a = r100;
        this.f282904b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f282903a.m();     // Catch: Throwable -> L6
        if (this.f282904b == false) goto L9;
        this.f282903a.k();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
