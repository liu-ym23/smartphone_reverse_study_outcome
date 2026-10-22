package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.tts.TtsResult;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements Runnable {
    public final /* synthetic */ mo5.b a;
    public final /* synthetic */ TtsResult b;

    public j(po5.b.a.C0292a r1, TtsResult r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        mo5.b r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.a(this.b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
