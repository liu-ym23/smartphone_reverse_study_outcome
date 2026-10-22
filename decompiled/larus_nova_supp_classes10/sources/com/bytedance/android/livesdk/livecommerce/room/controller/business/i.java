package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements Runnable {
    public final /* synthetic */ EntryController a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.W();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(EntryController r1) {
        this.a = r1;
    }
}
