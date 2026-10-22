package com.bytedance.ug.sdk.luckydog.task.newTimer.pendant;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f272136a;

    public f(d r100) {
        this.f272136a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f272136a.b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
