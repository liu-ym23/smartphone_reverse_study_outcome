package com.ss.android.ugc.bytex.pthread.base.convergence.handler;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerExecutorFactory;", "", "create", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerExecutor;", "name", "", "priority", "", "client", "Ljava/lang/Thread;", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface IHandlerExecutorFactory {
    IHandlerExecutor create(String r100, int r101, Thread r102);
}
