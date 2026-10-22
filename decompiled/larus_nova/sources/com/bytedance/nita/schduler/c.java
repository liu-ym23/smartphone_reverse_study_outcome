package com.bytedance.nita.schduler;

import android.os.Looper;
import android.os.MessageQueue;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.nita.schduler.a f266012a;

    public static final class a implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f266013a;

        public a(c r100) {
            this.f266013a = r100;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            com.bytedance.nita.schduler.a r100 = this.f266013a.f266012a;
            int r101 = com.bytedance.nita.schduler.a.f266005f;
            r100.e();
            return true;
        }
    }

    public c(com.bytedance.nita.schduler.a r100) {
        this.f266012a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myQueue().addIdleHandler(new a(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
