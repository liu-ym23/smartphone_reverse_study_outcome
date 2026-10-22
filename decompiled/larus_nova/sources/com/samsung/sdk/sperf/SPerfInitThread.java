package com.samsung.sdk.sperf;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
class SPerfInitThread implements Runnable {
    SPerfManager sPerfManager;

    public SPerfInitThread() {
        this.sPerfManager = null;
    }

    public void com_samsung_sdk_sperf_SPerfInitThread__run$___twin___() {
        this.sPerfManager = SPerfManager.initSPerfManager();     // Catch: IllegalThreadStateException -> L4
        return;
    L4:
        e = move-exception;
        this.sPerfManager = null;
        e.printStackTrace();
    }

    public SPerfManager getSPerfManager() {
        return this.sPerfManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        com_samsung_sdk_sperf_SPerfInitThread_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_samsung_sdk_sperf_SPerfInitThread_com_larus_apm_impl_protector_RunnableLancet_run(SPerfInitThread r100) {
        r100.com_samsung_sdk_sperf_SPerfInitThread__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
