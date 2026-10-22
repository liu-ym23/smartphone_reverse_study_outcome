package com.ss.android.ugc.aweme.search.common.base;

import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.search.common.result.sug.a;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes40.dex */
public class TaskManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile TaskManager f451483c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f451484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Executor f451485b;

    public static class AsyncRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Callable<?> f451486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Message f451487b;

        @Override // java.lang.Runnable
        public final void run() {
            e = this.f451486a.call();     // Catch: Throwable -> L4 Exception -> L6
        L7:
            Message r100 = this.f451487b;     // Catch: Throwable -> L4
            if (r100 == null) goto L11;
            r100.obj = e;     // Catch: Throwable -> L4
            r100.sendToTarget();     // Catch: Throwable -> L4
            return;
        L11:
            if ((e instanceof Exception) == false) goto L20;
            Exception r101 = (Exception) e;     // Catch: Throwable -> L4
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
            return "TaskManager[" + this.f451486a.toString() + "]";
        }

        public AsyncRunnable(a r100, Message r101) {
            this.f451486a = r100;
            this.f451487b = r101;
        }
    }

    public TaskManager() {
        this.f451484a = false;
    }

    public final void a(WeakHandler r100, a r101) {
        if (this.f451484a == true) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f451485b != null) goto L8;
        this.f451485b = ThreadPoolHelper.d();     // Catch: Throwable -> L10
        this.f451484a = true;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        if (this.f451485b == null) goto L23;
        Executor r102 = this.f451485b;
        if (r100 != null) goto L18;
        AsyncRunnable r103 = new AsyncRunnable(r101, null);
    L19:
        r102.execute(r103);
        return;
    L18:
        r103 = new AsyncRunnable(r101, r100.obtainMessage(0));
        goto L19
    }
}
