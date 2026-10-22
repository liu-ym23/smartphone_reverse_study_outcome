package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import com.bytedance.ai.event.MessageIndication;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadMonitor;
import com.ss.android.ugc.bytex.pthread.base.convergence.helper.ThreadUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityProvider;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u0011\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u001b\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eB\u0019\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u000fB\u0019\b\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0010B#\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0011B+\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\b\u0010\"\u001a\u00020\u001cH\u0016J\u0017\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$H\u0016¢\u0006\u0002\u0010&J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0016H\u0016J\b\u0010,\u001a\u00020\u001cH\u0016J\u0012\u0010-\u001a\u00020*2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\u0016H\u0016J\u0010\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020\u001cH\u0016J\u0012\u00104\u001a\u00020*2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020*H\u0016J\b\u00108\u001a\u00020\tH\u0016R\u001a\u0010\u0015\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00069"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ThreadProxyWrapper;", "Ljava/lang/Thread;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IThreadProxyProvider;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityProvider;", "()V", "runnable", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "name", "", "(Ljava/lang/String;)V", "group", "Ljava/lang/ThreadGroup;", PickerReporterConstants.KEY.TARGET, "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;)V", "(Ljava/lang/ThreadGroup;Ljava/lang/String;)V", "(Ljava/lang/Runnable;Ljava/lang/String;)V", "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;Ljava/lang/String;)V", "stackSize", "", "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;Ljava/lang/String;J)V", "isEnable", "", "isEnable$threadpool_plugin_base_release", "()Z", "setEnable$threadpool_plugin_base_release", "(Z)V", "priorityValue", "", "threadType", "getThreadType", "()I", "setThreadType", "(I)V", "countStackFrames", "getStackTrace", "", "Ljava/lang/StackTraceElement;", "()[Ljava/lang/StackTraceElement;", "getState", "Ljava/lang/Thread$State;", MessageIndication.STATUS_INTERRUPT, "", "isInterrupted", "priorityAffinity", "setContextClassLoader", "cl", "Ljava/lang/ClassLoader;", "setEnable", "enable", "setPriorityAffinity", "priority", "setUncaughtExceptionHandler", "eh", "Ljava/lang/Thread$UncaughtExceptionHandler;", "start", "toString", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public abstract class ThreadProxyWrapper extends Thread implements IThreadProxyProvider, PriorityProvider {
    private boolean isEnable;
    private int priorityValue;
    private int threadType;

    public ThreadProxyWrapper() {
        this(null, null);
    }

    public ThreadProxyWrapper(Runnable r100) {
        this(null, r100);
    }

    public ThreadProxyWrapper(Runnable r100, String r101) {
        this(null, r100, r101);
    }

    public ThreadProxyWrapper(String r100) {
        this(null, null, r100);
    }

    public ThreadProxyWrapper(ThreadGroup r100, Runnable r101) {
        super(ThreadUtils.getThreadInitGroup(r100), r101);
        this.priorityValue = 6;
        this.threadType = 1;
    }

    public ThreadProxyWrapper(ThreadGroup r100, Runnable r101, String r102) {
        this(r100, r101, r102, 0);
    }

    public ThreadProxyWrapper(ThreadGroup r100, Runnable r101, String r102, long r110) {
        super(ThreadUtils.getThreadInitGroup(r100), r101, r102, r110);
        this.priorityValue = 6;
        this.threadType = 1;
    }

    public ThreadProxyWrapper(ThreadGroup r100, String r101) {
        this(r100, null, r101);
    }

    @Override // java.lang.Thread
    public int countStackFrames() {
        IThreadProxy r100 = getProxy();
        if (r100 == null) goto L8;
        Thread r101 = r100.getAttachThread();
        if (r101 == null) goto L8;
        return r101.countStackFrames();
    L8:
        return super.countStackFrames();
    }

    @Override // java.lang.Thread
    public StackTraceElement[] getStackTrace() {
        IThreadProxy r100 = getProxy();
        if (r100 == null) goto L10;
        Thread r101 = r100.getAttachThread();
        if (r101 == null) goto L10;
        StackTraceElement[] r102 = r101.getStackTrace();
        if (r102 == null) goto L10;
        return r102;
    L10:
        return super.getStackTrace();
    }

    @Override // java.lang.Thread
    public Thread.State getState() {
        IThreadProxy r100 = getProxy();
        if (r100 == null) goto L8;
        Thread.State r101 = r100.getState();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getState();
    }

    public final int getThreadType() {
        return this.threadType;
    }

    @Override // java.lang.Thread
    public void interrupt() {
        IThreadProxy r100 = getProxy();
        if (r100 == null) goto L7;
        Thread r101 = r100.getAttachThread();
        if (r101 == null) goto L7;
        r101.interrupt();
        return;
    L7:
        super.interrupt();
    }

    public final boolean isEnable$threadpool_plugin_base_release() {
        return this.isEnable;
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        IThreadProxy r100 = getProxy();
        if (r100 == null) goto L8;
        Thread r101 = r100.getAttachThread();
        if (r101 == null) goto L8;
        return r101.isInterrupted();
    L8:
        return super.isInterrupted();
    }

    public int priorityAffinity() {
        return this.priorityValue;
    }

    @Override // java.lang.Thread
    public void setContextClassLoader(ClassLoader r100) {
        super.setContextClassLoader(r100);
        IThreadProxy r101 = getProxy();
        if (r101 == null) goto L6;
        r101.setContextClassLoader(r100);
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxyProvider
    public void setEnable(boolean r100) {
        this.isEnable = r100;
    }

    public final void setEnable$threadpool_plugin_base_release(boolean r100) {
        this.isEnable = r100;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxyProvider
    public void setPriorityAffinity(int r100) {
        this.priorityValue = r100;
    }

    public final void setThreadType(int r100) {
        this.threadType = r100;
    }

    @Override // java.lang.Thread
    public void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler r100) {
        super.setUncaughtExceptionHandler(r100);
        IThreadProxy r101 = getProxy();
        if (r101 == null) goto L6;
        r101.setUncaughtExceptionHandler(r100);
        return;
    }

    @Override // java.lang.Thread
    public void start() {
        IThreadMonitor r100 = SuperThreadPool.INSTANCE.getThreadMonitor();
        if (r100 == null) goto L6;
        r100.onThreadStart(this, this.threadType);
    L6:
        if (this.isEnable == true) goto L9;
        super.start();
        return;
    L9:
        IThreadProxy r101 = getProxy();
        if (r101 == null) goto L12;
        r101.start();
        return;
    L12:
        super.start();
    }

    @Override // java.lang.Thread
    public String toString() {
        if (SuperThreadPool.INSTANCE.getEnableThreadToStringOpt() == false) goto L7;
        return "Thread[" + getName() + ',' + getPriority() + ']';
    L7:
        return super.toString();
    }
}
