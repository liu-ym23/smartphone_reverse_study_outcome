package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.tts.TtsResult;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mo5.b f239569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TtsResult f239570b;

    public k(mo5.b r100, TtsResult r101) {
        this.f239569a = r100;
        this.f239570b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        mo5.b r100 = this.f239569a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.a(this.f239570b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
