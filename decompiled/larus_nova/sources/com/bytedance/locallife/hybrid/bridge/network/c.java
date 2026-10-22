package com.bytedance.locallife.hybrid.bridge.network;

import android.os.Handler;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f259038c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f259039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Executor f259040b;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Callable<?> f259041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Message f259042b;

        @Override // java.lang.Runnable
        public final void run() {
            e = this.f259041a.call();     // Catch: Throwable -> L4 Exception -> L6
        L7:
            Message r100 = this.f259042b;     // Catch: Throwable -> L4
            if (r100 == null) goto L11;
            r100.obj = e;     // Catch: Throwable -> L4
            r100.sendToTarget();     // Catch: Throwable -> L4
            return;
        L11:
            if ((e instanceof Exception) == false) goto L20;
            com.bytedance.locallife.biz.common.utils.c.c("TaskManager", "catch", (Exception) e);     // Catch: Throwable -> L4
            return;
        L20:
            return;
        L6:
            e = e;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }

        public final String toString() {
            return "TaskManager[" + this.f259041a.toString() + "]";
        }

        public a(Callable r100, Message r101) {
            this.f259041a = r100;
            this.f259042b = r101;
        }
    }

    public static c b() {
        if (f259038c != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f259038c != null) goto L9;
        f259038c = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f259038c;
    }

    public c() {
        this.f259039a = false;
    }

    public final void a(Handler r100, Callable<?> r101, int r102) {
        if (this.f259039a == true) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f259040b != null) goto L8;
        this.f259040b = ThreadPoolHelper.d();     // Catch: Throwable -> L10
        this.f259039a = true;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        if (this.f259040b == null) goto L23;
        Executor r103 = this.f259040b;
        if (r100 != null) goto L18;
        a r104 = new a(r101, null);
    L19:
        r103.execute(r104);
        return;
    L18:
        r104 = new a(r101, r100.obtainMessage(r102));
        goto L19
    }
}
