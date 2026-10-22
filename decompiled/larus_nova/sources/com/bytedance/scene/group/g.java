package com.bytedance.scene.group;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Throwable f268712a;

    @Override // java.lang.Runnable
    public final void run() {
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    L3:
        throw this.f268712a;     // Catch: Throwable -> L4
    }

    public g(Throwable r100) {
        this.f268712a = r100;
    }
}
