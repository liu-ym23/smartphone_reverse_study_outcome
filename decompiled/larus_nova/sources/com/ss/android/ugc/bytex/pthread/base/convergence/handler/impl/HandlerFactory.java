package com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl;

import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerFactory;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IMessageHandler;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/HandlerFactory;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerFactory;", "()V", "create", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandler;", "executor", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerExecutor;", "messageHandler", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IMessageHandler;", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class HandlerFactory implements IHandlerFactory {
    public HandlerFactory() {
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerFactory
    public IHandler create(IHandlerExecutor r100) {
        return create(r100, null);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerFactory
    public IHandler create(IHandlerExecutor r100, IMessageHandler r101) {
        if ((r100 instanceof SysHandlerExecutorAdapter) == false) goto L7;
        return new HandlerImpl(new HandlerWrapper(((SysHandlerExecutorAdapter) r100).getHandlerThread().getLooper(), r101), null, r100);
    L7:
        return new ForwardHandler(UnifiedHandlerThread.INSTANCE.getLooper(), r100, r101).getHandler();
    }
}
