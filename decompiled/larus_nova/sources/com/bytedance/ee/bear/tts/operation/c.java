package com.bytedance.ee.bear.tts.operation;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TtsOperationQueue f239745a;

    public c(TtsOperationQueue r100) {
        this.f239745a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TtsOperationQueue.a(this.f239745a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
