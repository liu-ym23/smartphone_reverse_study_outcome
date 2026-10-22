package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u0014\u001a\u00020\tH&¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IThreadProxy;", "", "getAttachThread", "Ljava/lang/Thread;", "getState", "Ljava/lang/Thread$State;", "isRealAlive", "", "join", "", "millis", "", "nanos", "", "setContextClassLoader", "cl", "Ljava/lang/ClassLoader;", "setUncaughtExceptionHandler", "eh", "Ljava/lang/Thread$UncaughtExceptionHandler;", "start", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface IThreadProxy {
    Thread getAttachThread();

    Thread.State getState();

    boolean isRealAlive();

    void join();

    void join(long r100);

    void join(long r100, int r101);

    void setContextClassLoader(ClassLoader r100);

    void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler r100);

    void start();
}
