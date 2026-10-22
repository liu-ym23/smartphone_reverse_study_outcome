package com.ss.android.account;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class j implements Runnable {
    public j() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        k.e(false);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }
}
