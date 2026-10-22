package com.ss.android.lark.download.service.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.download.service.DownloadProgress;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadProgress f420539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f420540b;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f420540b.f420542b).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        ((wbb.e) r100.next()).a(this.f420539a);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public d(e r100, DownloadProgress r101) {
        this.f420540b = r100;
        this.f420539a = r101;
    }
}
