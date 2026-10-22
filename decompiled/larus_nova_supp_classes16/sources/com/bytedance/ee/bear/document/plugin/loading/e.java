package com.bytedance.ee.bear.document.plugin.loading;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements Runnable {
    public final /* synthetic */ OfficeLoadingPlugin a;

    public e(OfficeLoadingPlugin r1) {
        this.a = r1;
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
        if (OfficeLoadingPlugin.access$isEditionTokenInPath$p(this.a) == false) goto L16;
        b r0 = (b) this.a.getLoadingState().getValue();     // Catch: Throwable -> L13
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L20;
        OfficeLoadingPlugin.access$showEditionDocNotFound(this.a);     // Catch: Throwable -> L13
        return;
    L20:
        return;
    L7:
        if (r0.a != (-800002)) goto L9;
        r1 = true;
        goto L10
    }
}
