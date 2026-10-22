package com.bytedance.ee.bear.document.loading;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Runnable {
    public final /* synthetic */ DocLoadingPlugin a;
    public final /* synthetic */ DocLoadingPlugin.c b;

    public b(DocLoadingPlugin r1, DocLoadingPlugin.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    L21:
        return;
    L3:
        if (DocLoadingPlugin.access$isEditionTokenInPath$p(this.a) == false) goto L16;
        DocLoadingPlugin.b r0 = (DocLoadingPlugin.b) this.a.getLoadingState().getValue();     // Catch: Throwable -> L13
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L20;
        this.b.b();     // Catch: Throwable -> L13
        return;
    L20:
        return;
    L7:
        if (r0.a != (-800002)) goto L9;
        r1 = true;
        goto L10
    }
}
