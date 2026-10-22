package com.ss.android.lark.resource.service.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes37.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f439548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f439549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ResourcePush f439550c;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f439550c.f439536b).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        ((qpc.d) r100.next()).onPushUploadProgress(this.f439548a, this.f439549b);     // Catch: Throwable -> L7
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

    public e(ResourcePush r100, String r101, int r102, long r103, long r104) {
        this.f439550c = r100;
        this.f439548a = r101;
        this.f439549b = r102;
    }
}
