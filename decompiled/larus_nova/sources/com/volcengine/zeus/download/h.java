package com.volcengine.zeus.download;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorCompletionService;

/* JADX INFO: loaded from: classes41.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f462686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExecutorCompletionService f462687b;

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList r100 = new ArrayList();     // Catch: Throwable -> L12
        int r101 = this.f462686a.size();     // Catch: Throwable -> L12
    L3:
        int r102 = r101 - 1;
        if (r101 <= 0) goto L11;
        r100.add(this.f462687b.take().get());     // Catch: Throwable -> L7
    L9:
        r101 = r102;
    L7:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L12
        goto L9
    L11:
        throw null;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L16;
        return;
    L16:
        throw th;
    }

    public h(List r100, ExecutorCompletionService r101) {
        this.f462686a = r100;
        this.f462687b = r101;
    }
}
