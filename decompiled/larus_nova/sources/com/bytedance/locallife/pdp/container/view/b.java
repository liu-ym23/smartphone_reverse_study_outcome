package com.bytedance.locallife.pdp.container.view;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DefaultViewVisibilityDirector f261254a;

    public b(DefaultViewVisibilityDirector r100) {
        this.f261254a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f261254a.e();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
