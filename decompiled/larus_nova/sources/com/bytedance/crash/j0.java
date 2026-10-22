package com.bytedance.crash;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final class j0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f203230a;

    @Override // java.lang.Runnable
    public final void run() {
        i0.a(this.f203230a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public j0(Map r100) {
        this.f203230a = r100;
    }
}
