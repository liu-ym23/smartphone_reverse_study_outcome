package com.relax;

import com.larus.apm.impl.protector.RunnableProtector;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f404635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BackendWorker f404636b;

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f404636b.f404534a == null) goto L9;
        boolean r100 = ipa.c.f495326a;     // Catch: Throwable -> L6
        ByteBuffer r101 = ipa.c.b(this.f404635a);     // Catch: Throwable -> L6
        this.f404636b.f404534a.setGlobalProps(r101);     // Catch: Throwable -> L6
        return;
    }

    public f(BackendWorker r100, Map r101) {
        this.f404636b = r100;
        this.f404635a = r101;
    }
}
