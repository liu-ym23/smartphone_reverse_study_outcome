package com.bytedance.ee.bear.drive.core.fragment;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f224271a;

    public s(r r100) {
        this.f224271a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r r100 = this.f224271a;     // Catch: Throwable -> L6
        if (r100.f224270k == true) goto L9;
        r100.a();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
