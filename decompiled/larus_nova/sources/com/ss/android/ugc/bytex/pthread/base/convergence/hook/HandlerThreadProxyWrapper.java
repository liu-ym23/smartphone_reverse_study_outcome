package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import android.os.HandlerThread;
import com.bytedance.ai.event.MessageIndication;
import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadMonitor;
import com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityProvider;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\bH\u0016J\u0017\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0015J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u000bH\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0019H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/HandlerThreadProxyWrapper;", "Landroid/os/HandlerThread;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IThreadProxyProvider;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityProvider;", "name", "", "(Ljava/lang/String;)V", "priority", "", "(Ljava/lang/String;I)V", "isEnable", "", "isEnable$threadpool_plugin_base_release", "()Z", "setEnable$threadpool_plugin_base_release", "(Z)V", "priorityValue", "countStackFrames", "getStackTrace", "", "Ljava/lang/StackTraceElement;", "()[Ljava/lang/StackTraceElement;", "getState", "Ljava/lang/Thread$State;", MessageIndication.STATUS_INTERRUPT, "", "isInterrupted", "priorityAffinity", "setContextClassLoader", "cl", "Ljava/lang/ClassLoader;", "setEnable", "enable", "setPriorityAffinity", "setUncaughtExceptionHandler", "eh", "Ljava/lang/Thread$UncaughtExceptionHandler;", "start", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public abstract class HandlerThreadProxyWrapper extends HandlerThread implements IThreadProxyProvider, PriorityProvider {
    private boolean isEnable;
    private int priorityValue;

    public HandlerThreadProxyWrapper(String r100) {
        super(r100);
        this.priorityValue = 6;
    }

    public HandlerThreadProxyWrapper(String r100, int r101) {
        super(r100, r101);
        this.priorityValue = 6;
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

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityProvider
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
        r100.onThreadStart(this, 4);
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
}
