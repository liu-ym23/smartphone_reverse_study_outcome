package com.bytedance.ee.bear.operation;

import android.os.Handler;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import gl5.h;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements com.bytedance.ee.bear.contract.b {
    public e() {
    }

    @Override // com.bytedance.ee.bear.contract.b
    public final void a(AccountService$Account r100) {
        tt5.a.h("OperationManager", "account changed, clear all uploading tasks： " + ThreadMethodProxy.currentThread().getName());
        gl5.b r101 = gl5.b.a();
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (r101.f481588a == true) goto L9;
        tt5.a.k("OperationUploadManager", "clearAllTasks cancel by mUploadEnable = false");     // Catch: Throwable -> L16
        monitor-exit(r101);
    L14:
        gl5.b.a().b(new h(), 5000);
        return;
    L9:
        Handler r102 = r101.f481589b;     // Catch: Throwable -> L16
        if (r102 == null) goto L12;
        r102.removeCallbacksAndMessages(null);     // Catch: Throwable -> L16
    L12:
        r101.f481590c.clear();     // Catch: Throwable -> L16
        monitor-exit(r101);
        goto L14
    }
}
