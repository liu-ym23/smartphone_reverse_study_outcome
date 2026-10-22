package com.bytedance.apm;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class c$a implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        ApmAgent.storeLogBypass("Apm#start", "Apm start");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c$a() {
    }
}
