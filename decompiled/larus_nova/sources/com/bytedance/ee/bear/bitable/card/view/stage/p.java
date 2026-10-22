package com.bytedance.ee.bear.bitable.card.view.stage;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f208762a;

    public p(o r100) {
        this.f208762a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r100 = this.f208762a.f208744c;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.Vd();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
