package com.bytedance.ee.bear.rn;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements Runnable {
    public static final q a = null;

    static {
        a = new q();
    }

    public q() {
    }

    public static void a() {
        MutableLiveData r0 = ((com.bytedance.ee.bear.contract.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.f.class, null, null, 6)).c();
        RnSyncManager$appVisibleObserve$1 r3 = RnSyncManager.z;
        r0.removeObserver(r3);
        ((com.bytedance.ee.bear.contract.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.f.class, null, null, 6)).c().observeForever(r3);
        MutableLiveData r1 = ((com.bytedance.ee.bear.contract.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.f.class, null, null, 6)).d();
        RnSyncManager.b r4 = RnSyncManager.A;
        r1.removeObserver(r4);
        ((com.bytedance.ee.bear.contract.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.f.class, null, null, 6)).d().observeForever(r4);
        com.bytedance.ee.bear.contract.j r2 = com.bytedance.ee.bear.contract.j.a.a;
        LiveData r5 = r2.a();
        RnSyncManager$connectStateObserve$1 r6 = RnSyncManager.B;
        r5.removeObserver(r6);
        r2.a().observeForever(r6);
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
