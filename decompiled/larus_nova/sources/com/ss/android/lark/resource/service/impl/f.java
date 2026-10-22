package com.ss.android.lark.resource.service.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes37.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f439551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f439552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f439553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f439554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ResourcePush f439555e;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f439555e.f439537c).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        ((qpc.b) r100.next()).onPushDownloadProgress(this.f439551a, this.f439552b, this.f439553c, this.f439554d);     // Catch: Throwable -> L7
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

    public f(ResourcePush r100, String r101, int r102, long r103, long r104) {
        this.f439555e = r100;
        this.f439551a = r101;
        this.f439552b = r102;
        this.f439553c = r103;
        this.f439554d = r104;
    }
}
