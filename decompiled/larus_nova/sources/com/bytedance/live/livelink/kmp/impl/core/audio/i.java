package com.bytedance.live.livelink.kmp.impl.core.audio;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f255380a;

    public i(f r100) {
        this.f255380a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f255380a.getClass();     // Catch: Throwable -> L7
        this.f255380a.getClass();     // Catch: Throwable -> L7
        PthreadHandlerThreadV2 r100 = this.f255380a.f255376f;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.quit();     // Catch: Throwable -> L7
    L5:
        this.f255380a.f255377g = null;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
