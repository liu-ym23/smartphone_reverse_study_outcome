package com.bytedance.ee.bear.document.plugin.loading;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeLoadingPlugin f220854a;

    public e(OfficeLoadingPlugin r100) {
        this.f220854a = r100;
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
        if (OfficeLoadingPlugin.access$isEditionTokenInPath$p(this.f220854a) == false) goto L16;
        b r100 = this.f220854a.getLoadingState().getValue();     // Catch: Throwable -> L13
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L20;
        OfficeLoadingPlugin.access$showEditionDocNotFound(this.f220854a);     // Catch: Throwable -> L13
        return;
    L20:
        return;
    L7:
        if (r100.f220849a != (-800002)) goto L9;
        r101 = true;
        goto L10
    }
}
