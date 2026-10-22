package com.ss.android.lark.jsruntime.vmsdk;

import com.bytedance.vmsdk.worker.JsWorker;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f428185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f428186b;

    public k(j r100, String r101) {
        this.f428185a = r100;
        this.f428186b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j r100 = this.f428185a;     // Catch: Throwable -> L6
        JsWorker r101 = r100.f428176c;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.evaluateJavaScript(this.f428186b, r100.f428175b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
