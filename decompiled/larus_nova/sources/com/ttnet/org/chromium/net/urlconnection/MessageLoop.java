package com.ttnet.org.chromium.net.urlconnection;

import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public class MessageLoop implements Executor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long INVALID_THREAD_ID = -1;
    private static final AtomicBoolean mDisableValidThreadAssert = null;
    private boolean mLoopFailed;
    private boolean mLoopRunning;
    private InterruptedIOException mPriorInterruptedIOException;
    private RuntimeException mPriorRuntimeException;
    private final BlockingQueue<Runnable> mQueue;
    private long mThreadId;

    public void loop() throws IOException {
        loop(0);
    }

    public void quit() {
        this.mLoopRunning = false;
    }

    public void reset() {
        this.mLoopFailed = false;
    }

    static {
        mDisableValidThreadAssert = new AtomicBoolean(false);
    }

    private boolean calledOnValidThread() {
        if (mDisableValidThreadAssert.get() == false) goto L5;
        return true;
    L5:
        long r100 = this.mThreadId;
        if (r100 != (-1)) goto L10;
        this.mThreadId = ThreadMethodProxy.currentThread().getId();
        return true;
    L10:
        if (r100 == ThreadMethodProxy.currentThread().getId()) goto L14;
        return false;
    L14:
        return true;
    }

    public boolean onValidThread() {
        long r100 = this.mThreadId;
        if (r100 != (-1)) goto L5;
    L8:
        return true;
    L5:
        if (r100 == ThreadMethodProxy.currentThread().getId()) goto L8;
        return false;
    }

    public MessageLoop() {
        this.mThreadId = -1;
        this.mQueue = new LinkedBlockingQueue();
    }

    public boolean hasLoopFailed() {
        return this.mLoopFailed;
    }

    public boolean isRunning() {
        return this.mLoopRunning;
    }

    public static void disableVaildThreadAssert(boolean r100) {
        mDisableValidThreadAssert.set(r100);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) throws RejectedExecutionException {
        if (r100 == null) goto L9;
        this.mQueue.put(r100);     // Catch: InterruptedException -> L5
        return;
    L5:
        e = move-exception;
        throw new RejectedExecutionException(e);
    L9:
        throw new IllegalArgumentException();
    }

    public void loop(int r100) throws IOException {
        long r101 = System.nanoTime();
        long r102 = TimeUnit.NANOSECONDS.convert(r100, TimeUnit.MILLISECONDS);
        if (this.mLoopFailed == false) goto L10;
        InterruptedIOException r103 = this.mPriorInterruptedIOException;
        if (r103 == null) goto L8;
        throw r103;
    L8:
        throw this.mPriorRuntimeException;
    L10:
        if (this.mLoopRunning == true) goto L31;
        this.mLoopRunning = true;
    L13:
        if (this.mLoopRunning == false) goto L29;
        if (r100 == 0) goto L32;
        take(true, (r102 - System.nanoTime()) + r101).run();     // Catch: RuntimeException -> L20 InterruptedIOException -> L23 SocketTimeoutException -> L26
        goto L13
    L32:
        take(false, 0).run();     // Catch: RuntimeException -> L20 InterruptedIOException -> L23 SocketTimeoutException -> L26
    L26:
        e = move-exception;
        this.mLoopRunning = false;
        this.mLoopFailed = true;
        throw e;
    L23:
        e = move-exception;
        this.mLoopRunning = false;
        this.mLoopFailed = true;
        this.mPriorInterruptedIOException = e;
        throw e;
    L20:
        e = move-exception;
        this.mLoopRunning = false;
        this.mLoopFailed = true;
        this.mPriorRuntimeException = e;
        throw e;
    L29:
        return;
    L31:
        throw new IllegalStateException("Cannot run loop when it is already running.");
    }

    private Runnable take(boolean r100, long r101) throws InterruptedIOException {
        if (r100 == true) goto L4;
        Runnable r102 = this.mQueue.take();     // Catch: InterruptedException -> L9
    L5:
        if (r102 == null) goto L8;
        return r102;
    L8:
        throw new SocketTimeoutException(TrafficMetrics.FRPM_TTNET);
    L4:
        r102 = this.mQueue.poll(r101, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L9
    L9:
        e = move-exception;
        InterruptedIOException r103 = new InterruptedIOException();
        r103.initCause(e);
        throw r103;
    }
}
