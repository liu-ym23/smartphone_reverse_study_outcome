package com.bytedance.locallife.pdp.opt;

import android.os.Looper;
import android.os.MessageQueue;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageQueue.IdleHandler f261620a;

    public c(d r100) {
        this.f261620a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myQueue().addIdleHandler(this.f261620a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
