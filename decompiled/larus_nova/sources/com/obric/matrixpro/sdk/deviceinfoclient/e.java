package com.obric.matrixpro.sdk.deviceinfoclient;

import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes33.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC4654a f397046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Exception f397047b;

    public e(a.InterfaceC4654a r100, Exception r101) {
        this.f397046a = r100;
        this.f397047b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.InterfaceC4654a r100 = this.f397046a;     // Catch: Throwable -> L7
        String r101 = this.f397047b.getMessage();     // Catch: Throwable -> L7
        if (r101 != null) goto L5;
        r101 = DyVerifyReqConstants.BioFailMsg.UNKNOWN_ERROR;
    L5:
        r100.onError("获取失败：".concat(r101));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
