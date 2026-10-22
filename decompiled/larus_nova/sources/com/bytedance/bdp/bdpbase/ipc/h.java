package com.bytedance.bdp.bdpbase.ipc;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f201174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f201175b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f201174a.b(this.f201175b.f201145j);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(e r100, v r101) {
        this.f201175b = r100;
        this.f201174a = r101;
    }
}
