package com.ss.android.ugc.bytex.pthread.base.convergence.handler;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerFactory;", "", "create", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandler;", "executor", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerExecutor;", "messageHandler", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IMessageHandler;", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface IHandlerFactory {
    IHandler create(IHandlerExecutor r100);

    IHandler create(IHandlerExecutor r100, IMessageHandler r101);
}
