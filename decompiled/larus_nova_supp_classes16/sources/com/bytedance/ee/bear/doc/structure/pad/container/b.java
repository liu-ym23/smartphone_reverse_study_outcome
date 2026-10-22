package com.bytedance.ee.bear.doc.structure.pad.container;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Runnable {
    public final /* synthetic */ PadCatalogController a;

    public b(PadCatalogController r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d.loadPreviousPreferenceOnce();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
