package com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl;

import android.os.Message;
import com.bytedance.pia.core.metrics.ErrorType;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadExecutePolicy;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IMessageQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00060\u000eR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/HandlerExecutor;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerExecutor;", "messageQueue", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IMessageQueue;", "executor", "Ljava/util/concurrent/Executor;", "keepAliveTime", "", "threadPolicy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IThreadExecutePolicy;", "(Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IMessageQueue;Ljava/util/concurrent/Executor;JLcom/ss/android/ugc/bytex/pthread/base/convergence/external/IThreadExecutePolicy;)V", "currentThread", "Ljava/lang/Thread;", ErrorType.WORKER, "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/HandlerExecutor$Worker;", "working", "Ljava/util/concurrent/atomic/AtomicBoolean;", "addWorker", "", "dispatchMessage", "", "msg", "Landroid/os/Message;", "getQueue", "isCurrentThread", "releaseWorker", "Worker", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class HandlerExecutor implements IHandlerExecutor {
    private volatile Thread currentThread;
    private final Executor executor;
    private final long keepAliveTime;
    private final IMessageQueue messageQueue;
    private final IThreadExecutePolicy threadPolicy;
    private final Worker worker;
    private final AtomicBoolean working;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/HandlerExecutor$Worker;", "Ljava/lang/Runnable;", "messageQueue", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IMessageQueue;", "(Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/HandlerExecutor;Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IMessageQueue;)V", "run", "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public final class Worker implements Runnable {
        private final IMessageQueue messageQueue;
        final /* synthetic */ HandlerExecutor this$0;

        public Worker(HandlerExecutor r100, IMessageQueue r101) {
            this.this$0 = r100;
            this.messageQueue = r101;
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread r100 = Thread.currentThread();
            HandlerExecutor.access$setCurrentThread$p(this.this$0, r100);     // Catch: Throwable -> L15
            HandlerExecutor.access$getThreadPolicy$p(this.this$0).onThreadStartUp(r100);     // Catch: Throwable -> L15
        L4:
            Message r101 = this.messageQueue.pollMessage(HandlerExecutor.access$getKeepAliveTime$p(this.this$0));     // Catch: Throwable -> L15
            if (r101 != null) goto L6;
            if (HandlerExecutor.access$releaseWorker(this.this$0) == false) goto L4;
            HandlerExecutor.access$setCurrentThread$p(this.this$0, null);     // Catch: Throwable -> L12
            HandlerExecutor.access$getThreadPolicy$p(this.this$0).onThreadRelease(r100);     // Catch: Throwable -> L12
            HandlerExecutor.access$addWorker(this.this$0);
            return;
        L12:
            th = move-exception;
            HandlerExecutor.access$addWorker(this.this$0);
            throw th;
        L6:
            r101.getTarget().dispatchMessage(r101);     // Catch: Throwable -> L15
            r101.recycle();     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            HandlerExecutor.access$setCurrentThread$p(this.this$0, null);     // Catch: Throwable -> L19
            HandlerExecutor.access$getThreadPolicy$p(this.this$0).onThreadRelease(r100);     // Catch: Throwable -> L19
            HandlerExecutor.access$addWorker(this.this$0);
            throw th;
        L19:
            th = move-exception;
            HandlerExecutor.access$addWorker(this.this$0);
            throw th;
        }
    }

    public HandlerExecutor(IMessageQueue r100, Executor r101, long r102, IThreadExecutePolicy r103) {
        this.messageQueue = r100;
        this.executor = r101;
        this.keepAliveTime = r102;
        this.threadPolicy = r103;
        this.working = new AtomicBoolean(false);
        this.worker = new Worker(this, r100);
    }

    public /* synthetic */ HandlerExecutor(IMessageQueue r100, Executor r101, long r102, IThreadExecutePolicy r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 4) == 0) goto L5;
        r102 = 0;
    L5:
        this(r100, r101, r102, r110);
    }

    public static final /* synthetic */ boolean access$addWorker(HandlerExecutor r100) {
        return r100.addWorker();
    }

    public static final /* synthetic */ Thread access$getCurrentThread$p(HandlerExecutor r100) {
        return r100.currentThread;
    }

    public static final /* synthetic */ long access$getKeepAliveTime$p(HandlerExecutor r100) {
        return r100.keepAliveTime;
    }

    public static final /* synthetic */ IThreadExecutePolicy access$getThreadPolicy$p(HandlerExecutor r100) {
        return r100.threadPolicy;
    }

    public static final /* synthetic */ boolean access$releaseWorker(HandlerExecutor r100) {
        return r100.releaseWorker();
    }

    public static final /* synthetic */ void access$setCurrentThread$p(HandlerExecutor r100, Thread r101) {
        r100.currentThread = r101;
    }

    private final boolean addWorker() {
        boolean r100 = false;
        if (this.messageQueue.isEmpty() == false) goto L5;
    L7:
        if (r100 == false) goto L9;
        this.executor.execute(this.worker);
    L9:
        return r100;
    L5:
        if (this.working.compareAndSet(false, true) == false) goto L7;
        r100 = true;
        goto L7
    }

    private final boolean releaseWorker() {
        if (this.messageQueue.isEmpty() == true) goto L5;
        return false;
    L5:
        if (this.working.compareAndSet(true, false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerExecutor
    public void dispatchMessage(Message r100) {
        this.messageQueue.enqueueMessage(r100);
        addWorker();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerExecutor
    public IMessageQueue getQueue() {
        return this.messageQueue;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerExecutor
    public boolean isCurrentThread() {
        Thread r100 = this.currentThread;
        if (r100 != null) goto L5;
        return false;
    L5:
        return Intrinsics.areEqual(Thread.currentThread(), r100);
    }
}
