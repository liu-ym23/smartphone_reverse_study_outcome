package com.ss.android.ugc.bytex.pthread.base.convergence.executor;

import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IResourceExecutor;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/MigrateExecutor;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/PrestartableExecutor;", "Ljava/util/concurrent/Executor;", "getInstrumentation", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/Instrumentation;", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface IResourceExecutor extends MigrateExecutor, PrestartableExecutor, Executor {
    Instrumentation getInstrumentation();
}
