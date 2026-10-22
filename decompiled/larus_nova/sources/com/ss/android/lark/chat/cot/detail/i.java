package com.ss.android.lark.chat.cot.detail;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f414979a;

    public i(c r100) {
        this.f414979a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CotStepExposureTracker r100 = this.f414979a.f414960n;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.a();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
