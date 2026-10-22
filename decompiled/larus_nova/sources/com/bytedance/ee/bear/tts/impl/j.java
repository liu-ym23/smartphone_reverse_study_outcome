package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.tts.TtsResult;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mo5.b f239567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TtsResult f239568b;

    public j(po5.b.a.C7219a r100, TtsResult r101) {
        this.f239567a = r100;
        this.f239568b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        mo5.b r100 = this.f239567a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.a(this.f239568b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
