package com.ss.android.lark.resource.service.impl;

import com.bytedance.lark.pb.media.v1.PushResourceResponse;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f439543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PushResourceResponse.Status f439544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ResourcePush f439545c;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f439545c.f439535a).iterator();     // Catch: Throwable -> L11
    L4:
        if (r100.hasNext() == false) goto L22;
        qpc.c r101 = (qpc.c) r100.next();     // Catch: Throwable -> L11
        String r102 = this.f439543a;     // Catch: Throwable -> L11
        if (this.f439544b != PushResourceResponse.Status.SUCCESS) goto L8;
        boolean r103 = true;
    L9:
        r101.onPushDownloadStatus(r102, r103);     // Catch: Throwable -> L11
        goto L4
    L8:
        r103 = false;
        goto L9
    L22:
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L15;
        return;
    L15:
        throw th;
    }

    public c(ResourcePush r100, String r101, PushResourceResponse.Status r102) {
        this.f439545c = r100;
        this.f439543a = r101;
        this.f439544b = r102;
    }
}
