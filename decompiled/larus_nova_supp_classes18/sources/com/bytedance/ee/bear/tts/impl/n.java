package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.tts.TtsResult;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n implements Runnable {
    public final /* synthetic */ mo5.b a;

    public n(po5.b.a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        mo5.b r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.a(new TtsResult(TtsResult.ModelCode.TONE_NOT_SUPPORTED));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
