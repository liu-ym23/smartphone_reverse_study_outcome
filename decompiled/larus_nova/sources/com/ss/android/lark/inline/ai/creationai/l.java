package com.ss.android.lark.inline.ai.creationai;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationAIDragView f427141a;

    public l(CreationAIDragView r100) {
        this.f427141a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CreationAIDragView r100 = this.f427141a;     // Catch: Throwable -> L4
        r100.f426922d.b(r100.Z);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
