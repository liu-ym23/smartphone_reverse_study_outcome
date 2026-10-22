package com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl;

import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerExecutorFactory;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/SysHandlerExecutorFactory;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerExecutorFactory;", "()V", "create", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerExecutor;", "name", "", "priority", "", "client", "Ljava/lang/Thread;", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class SysHandlerExecutorFactory implements IHandlerExecutorFactory {
    public SysHandlerExecutorFactory() {
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerExecutorFactory
    public IHandlerExecutor create(String r100, int r101, Thread r102) {
        PthreadHandlerThreadV2 r103 = new PthreadHandlerThreadV2(r100, r101);
        r103.start();
        if (r102 == null) goto L6;
        r103.setUncaughtExceptionHandler(r102.getUncaughtExceptionHandler());
    L6:
        return new SysHandlerExecutorAdapter(r103);
    }
}
