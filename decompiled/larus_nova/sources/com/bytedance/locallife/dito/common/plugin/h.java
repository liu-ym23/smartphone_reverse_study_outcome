package com.bytedance.locallife.dito.common.plugin;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DitoImagePrefetchPlugin f257583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.locallife.dito.common.data.c f257584b;

    public h(DitoImagePrefetchPlugin r100, com.bytedance.locallife.dito.common.data.c r101) {
        this.f257583a = r100;
        this.f257584b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DitoImagePrefetchPlugin r100 = this.f257583a;     // Catch: Throwable -> L4
        r100.f257464e = null;     // Catch: Throwable -> L4
        DitoImagePrefetchPlugin.s(r100, this.f257584b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
