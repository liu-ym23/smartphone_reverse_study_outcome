package com.ss.cast.discovery.nsd;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes40.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NsdClient f456382a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f456382a.startBrowse();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(NsdClient r100) {
        this.f456382a = r100;
    }
}
