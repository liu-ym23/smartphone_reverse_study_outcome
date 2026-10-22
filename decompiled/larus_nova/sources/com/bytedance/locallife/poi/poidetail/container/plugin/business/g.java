package com.bytedance.locallife.poi.poidetail.container.plugin.business;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiBusinessPopupPlugin f264070a;

    public g(PoiBusinessPopupPlugin r100) {
        this.f264070a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f264070a.f263959d.b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
