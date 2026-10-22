package com.bytedance.iesgurd.request;

import com.bytedance.geckox.logger.GeckoLogger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UpdateRequest f250832a;

    public i(UpdateRequest r100) {
        this.f250832a = r100;
    }

    public final void a() {
        GeckoLogger.d("update request retry start");
        UpdateRequest r100 = this.f250832a;
        UpdateRequest r101 = new UpdateRequest(r100.f250804l, r100.f250805m);
        r101.f250794b = true;
        UpdateRequest r102 = this.f250832a;
        r101.f250795c = r102.f250795c;
        r102.f250804l.getReqInfo().setRetry(true);
        String r103 = this.f250832a.f250793a;
        if (r103 == null) goto L5;
        r101.f250793a = r103;
    L5:
        UpdateRequest.a(r101);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
