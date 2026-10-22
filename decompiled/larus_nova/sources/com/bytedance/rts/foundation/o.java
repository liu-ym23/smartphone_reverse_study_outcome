package com.bytedance.rts.foundation;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f267586a;

    public o(s r100) {
        this.f267586a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n.a(this.f267586a.f267592e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
