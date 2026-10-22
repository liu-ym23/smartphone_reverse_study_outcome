package com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl;

import android.os.HandlerThread;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.NotQuitThread;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/ReuseHandlerThread;", "Landroid/os/HandlerThread;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/NotQuitThread;", "name", "", "maxReuseCount", "", "(Ljava/lang/String;I)V", "reuseCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "quit", "", "quitSafely", "reuse", "start", "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class ReuseHandlerThread extends HandlerThread implements NotQuitThread {
    private final int maxReuseCount;
    private final AtomicInteger reuseCount;

    public ReuseHandlerThread(String r100, int r101) {
        super(r100);
        this.maxReuseCount = r101;
        this.reuseCount = new AtomicInteger(1);
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        return false;
    }

    @Override // android.os.HandlerThread
    public boolean quitSafely() {
        return false;
    }

    public final boolean reuse(String r100) {
    L2:
        int r101 = this.reuseCount.get();
        if (r101 >= this.maxReuseCount) goto L8;
        if (this.reuseCount.compareAndSet(r101, r101 + 1) == false) goto L2;
        return true;
    L8:
        return false;
    }

    @Override // java.lang.Thread
    public void start() {
        if (isAlive() == false) goto L5;
        return;
    L5:
        super.start();
    }
}
