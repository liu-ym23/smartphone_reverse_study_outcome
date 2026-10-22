package com.ss.android.ugc.bytex.pthread.base.convergence.executor;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxyProvider;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ThreadExecutor;", "Ljava/util/concurrent/Executor;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(Ljava/util/concurrent/ThreadFactory;)V", "execute", "", "command", "Ljava/lang/Runnable;", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class ThreadExecutor implements Executor {
    private final ThreadFactory threadFactory;

    public ThreadExecutor(ThreadFactory r100) {
        this.threadFactory = r100;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        Thread r101 = this.threadFactory.newThread(r100);
        if ((r101 instanceof IThreadProxyProvider) == true) goto L5;
        Object r102 = null;
    L6:
        IThreadProxyProvider r103 = (IThreadProxyProvider) r102;
        if (r103 == null) goto L9;
        r103.setEnable(false);
    L9:
        r101.start();
        return;
    L5:
        r102 = r101;
        goto L6
    }
}
