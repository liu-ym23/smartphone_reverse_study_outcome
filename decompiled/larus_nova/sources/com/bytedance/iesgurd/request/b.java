package com.bytedance.iesgurd.request;

import com.bytedance.iesgurd.j;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f250815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f250816b;

    public b(List r100, j r101) {
        this.f250815a = r100;
        this.f250816b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicInteger r100 = b96.i.f18315a;     // Catch: Throwable -> L4
        b96.i.a(this.f250815a, this.f250816b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
