package com.ss.android.token;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f449766a;

    public m(String r100) {
        this.f449766a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SecTimeUpdater.a(SecTimeUpdater.f449642k, this.f449766a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
