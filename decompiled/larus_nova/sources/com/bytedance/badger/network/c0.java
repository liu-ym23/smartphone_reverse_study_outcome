package com.bytedance.badger.network;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes47.dex */
public final class c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f199089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f199090b;

    public c0(Function0 r100, b r101) {
        this.f199089a = r100;
        this.f199090b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f199089a.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        z0 r100 = d0.f199093a;     // Catch: Throwable -> L7
        d0.e(this.f199090b, th, "uploadThread - execution failed");     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
