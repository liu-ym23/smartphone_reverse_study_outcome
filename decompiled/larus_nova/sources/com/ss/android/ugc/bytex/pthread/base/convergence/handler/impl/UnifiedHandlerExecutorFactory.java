package com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl;

import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerExecutorFactory;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/UnifiedHandlerExecutorFactory;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerExecutorFactory;", "resourceThreadPool", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "create", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerExecutor;", "name", "", "priority", "", "client", "Ljava/lang/Thread;", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class UnifiedHandlerExecutorFactory implements IHandlerExecutorFactory {
    private final Executor resourceThreadPool;

    public UnifiedHandlerExecutorFactory(Executor r100) {
        this.resourceThreadPool = r100;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerExecutorFactory
    public IHandlerExecutor create(final String r110, final int r111, final Thread r112) {
        return new HandlerExecutor(new MessageQueue(), this.resourceThreadPool, 0, new AnonymousClass1(r110, r111, r112), 4, null);
    }
}
