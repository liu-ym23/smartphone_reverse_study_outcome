package com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl;

import android.os.HandlerThread;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IMessageQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/SysHandlerExecutorAdapter;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerExecutor;", "handlerThread", "Landroid/os/HandlerThread;", "(Landroid/os/HandlerThread;)V", "getHandlerThread", "()Landroid/os/HandlerThread;", "dispatchMessage", "", "msg", "Landroid/os/Message;", "getQueue", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IMessageQueue;", "isCurrentThread", "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class SysHandlerExecutorAdapter implements IHandlerExecutor {
    private final HandlerThread handlerThread;

    public SysHandlerExecutorAdapter(HandlerThread r100) {
        this.handlerThread = r100;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerExecutor
    public void dispatchMessage(Message r100) {
        throw new UnsupportedOperationException();
    }

    public final HandlerThread getHandlerThread() {
        return this.handlerThread;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerExecutor
    public IMessageQueue getQueue() {
        throw new UnsupportedOperationException();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerExecutor
    public boolean isCurrentThread() {
        return Intrinsics.areEqual(Thread.currentThread(), this.handlerThread);
    }
}
