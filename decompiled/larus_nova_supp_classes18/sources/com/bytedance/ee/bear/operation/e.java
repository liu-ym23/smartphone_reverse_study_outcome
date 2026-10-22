package com.bytedance.ee.bear.operation;

import android.os.Handler;
import com.bytedance.ee.bear.contract.AccountService;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import gl5.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements com.bytedance.ee.bear.contract.b {
    public e() {
    }

    public final void a(AccountService.Account r4) {
        tt5.a.h("OperationManager", "account changed, clear all uploading tasks： " + ThreadMethodProxy.currentThread().getName());
        gl5.b r5 = gl5.b.a();
        monitor-enter(r5);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (r5.a == true) goto L9;
        tt5.a.k("OperationUploadManager", "clearAllTasks cancel by mUploadEnable = false");     // Catch: Throwable -> L16
        monitor-exit(r5);
    L14:
        gl5.b.a().b(new h(), 5000);
        return;
    L9:
        Handler r0 = r5.b;     // Catch: Throwable -> L16
        if (r0 == null) goto L12;
        r0.removeCallbacksAndMessages(null);     // Catch: Throwable -> L16
    L12:
        r5.c.clear();     // Catch: Throwable -> L16
        monitor-exit(r5);
        goto L14
    }
}
