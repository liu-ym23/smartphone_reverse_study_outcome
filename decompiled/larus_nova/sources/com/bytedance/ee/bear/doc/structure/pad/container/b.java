package com.bytedance.ee.bear.doc.structure.pad.container;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PadCatalogController f218243a;

    public b(PadCatalogController r100) {
        this.f218243a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f218243a.f218232d.loadPreviousPreferenceOnce();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
