package com.ss.android.ugc.bytex.pthread.base.convergence.core;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.helper.ThreadCleaner;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u00110\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/core/CoreThread;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/core/ICoreThread;", "group", "Ljava/lang/ThreadGroup;", PickerReporterConstants.KEY.TARGET, "Ljava/lang/Runnable;", "name", "", "stackSize", "", "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;Ljava/lang/String;J)V", "delegate", "Ljava/lang/Thread;", "originClassLoader", "Ljava/lang/ClassLoader;", "kotlin.jvm.PlatformType", "originUncaughtExceptionHandler", "Ljava/lang/Thread$UncaughtExceptionHandler;", "associateDelegateThread", "", "getDelegateThread", "resetThread", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class CoreThread extends ICoreThread {
    private volatile Thread delegate;
    private ClassLoader originClassLoader;
    private Thread.UncaughtExceptionHandler originUncaughtExceptionHandler;

    public CoreThread(ThreadGroup r100, Runnable r101, String r102, long r103) {
        super(r100, r101, r102, r103);
        this.originClassLoader = getContextClassLoader();
        this.originUncaughtExceptionHandler = getUncaughtExceptionHandler();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.core.ICoreThread
    public void associateDelegateThread(Thread r100) {
        this.delegate = r100;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.core.ICoreThread
    public Thread getDelegateThread() {
        return this.delegate;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.core.ICoreThread
    public void resetThread() {
        this.delegate = null;
        setContextClassLoader(this.originClassLoader);
        setUncaughtExceptionHandler(this.originUncaughtExceptionHandler);
        ThreadCleaner.INSTANCE.clearTls();
        if (isInterrupted() == false) goto L6;
        Thread.interrupted();
        return;
    }
}
