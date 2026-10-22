package com.bytedance.ee.bear.document.loading;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocLoadingPlugin f220214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DocLoadingPlugin.c f220215b;

    public b(DocLoadingPlugin r100, DocLoadingPlugin.c r101) {
        this.f220214a = r100;
        this.f220215b = r101;
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
        if (DocLoadingPlugin.access$isEditionTokenInPath$p(this.f220214a) == false) goto L16;
        DocLoadingPlugin.b r100 = this.f220214a.getLoadingState().getValue();     // Catch: Throwable -> L13
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L20;
        this.f220215b.b();     // Catch: Throwable -> L13
        return;
    L20:
        return;
    L7:
        if (r100.f220180a != (-800002)) goto L9;
        r101 = true;
        goto L10
    }
}
