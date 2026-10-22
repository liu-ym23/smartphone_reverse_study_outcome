package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\nH&J.\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\f\u0018\u00010\u000b\"\u0004\b\u0000\u0010\f2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\f\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IRunnableWrapperCreator;", "", "findWrapper", "Ljava/lang/Runnable;", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "r", "wrap", "command", "type", "", "Ljava/util/concurrent/Callable;", "V", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface IRunnableWrapperCreator {
    Runnable findWrapper(ThreadPoolExecutor r100, Runnable r101);

    Runnable wrap(Runnable r100, int r101);

    <V> Callable<V> wrap(Callable<V> r100, int r101);
}
