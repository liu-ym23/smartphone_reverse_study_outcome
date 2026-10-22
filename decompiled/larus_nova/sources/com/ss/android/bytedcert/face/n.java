package com.ss.android.bytedcert.face;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.constants.ErrorConstant;

/* JADX INFO: loaded from: classes34.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SDKCallBack.CommonRequestCallback f407410a;

    @Override // java.lang.Runnable
    public final void run() {
        BDResponse r100 = new BDResponse(ErrorConstant.Client.ERROR_VIDEO_RECORD_UPLOAD_FAIL);     // Catch: Throwable -> L4
        this.f407410a.onRequestFinish(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public n(m r100) {
        this.f407410a = r100;
    }
}
