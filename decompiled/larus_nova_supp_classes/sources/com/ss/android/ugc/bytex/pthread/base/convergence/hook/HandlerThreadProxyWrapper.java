package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import android.os.HandlerThread;
import android.util.EventsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadMonitor;
import com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityProvider;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\bH\u0016J\u0017\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0015J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u000bH\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0019H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/HandlerThreadProxyWrapper;", "Landroid/os/HandlerThread;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IThreadProxyProvider;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityProvider;", "name", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/String;)V", "priority", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/String;I)V", "isEnable", XmlPullParser.NO_NAMESPACE, "isEnable$threadpool_plugin_base_release", "()Z", "setEnable$threadpool_plugin_base_release", "(Z)V", "priorityValue", "countStackFrames", "getStackTrace", XmlPullParser.NO_NAMESPACE, "Ljava/lang/StackTraceElement;", "()[Ljava/lang/StackTraceElement;", "getState", "Ljava/lang/Thread$State;", "interrupt", XmlPullParser.NO_NAMESPACE, "isInterrupted", "priorityAffinity", "setContextClassLoader", "cl", "Ljava/lang/ClassLoader;", "setEnable", "enable", "setPriorityAffinity", "setUncaughtExceptionHandler", "eh", "Ljava/lang/Thread$UncaughtExceptionHandler;", "start", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
public abstract class HandlerThreadProxyWrapper extends HandlerThread implements IThreadProxyProvider, PriorityProvider {
    private boolean isEnable;
    private int priorityValue;

    public HandlerThreadProxyWrapper(String r1) {
        super(r1);
        this.priorityValue = 6;
    }

    public HandlerThreadProxyWrapper(String r1, int r2) {
        super(r1, r2);
        this.priorityValue = 6;
    }

    @Override // java.lang.Thread
    public int countStackFrames() {
        IThreadProxy r0 = getProxy();
        if (r0 == null) goto L8;
        Thread r1 = r0.getAttachThread();
        if (r1 == null) goto L8;
        return r1.countStackFrames();
    L8:
        return super.countStackFrames();
    }

    @Override // java.lang.Thread
    public StackTraceElement[] getStackTrace() {
        IThreadProxy r0 = getProxy();
        if (r0 == null) goto L10;
        Thread r1 = r0.getAttachThread();
        if (r1 == null) goto L10;
        StackTraceElement[] r2 = r1.getStackTrace();
        if (r2 == null) goto L10;
        return r2;
    L10:
        return super.getStackTrace();
    }

    @Override // java.lang.Thread
    public Thread.State getState() {
        IThreadProxy r0 = getProxy();
        if (r0 == null) goto L8;
        Thread.State r1 = r0.getState();
        if (r1 == null) goto L8;
        return r1;
    L8:
        return super.getState();
    }

    @Override // java.lang.Thread
    public void interrupt() {
        IThreadProxy r0 = getProxy();
        if (r0 == null) goto L7;
        Thread r1 = r0.getAttachThread();
        if (r1 == null) goto L7;
        r1.interrupt();
        return;
    L7:
        super.interrupt();
    }

    public final boolean isEnable$threadpool_plugin_base_release() {
        return this.isEnable;
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        IThreadProxy r0 = getProxy();
        if (r0 == null) goto L8;
        Thread r1 = r0.getAttachThread();
        if (r1 == null) goto L8;
        return r1.isInterrupted();
    L8:
        return super.isInterrupted();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityProvider
    public int priorityAffinity() {
        return this.priorityValue;
    }

    @Override // java.lang.Thread
    public void setContextClassLoader(ClassLoader r2) {
        super.setContextClassLoader(r2);
        IThreadProxy r0 = getProxy();
        if (r0 == null) goto L6;
        r0.setContextClassLoader(r2);
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxyProvider
    public void setEnable(boolean r1) {
        this.isEnable = r1;
    }

    public final void setEnable$threadpool_plugin_base_release(boolean r1) {
        this.isEnable = r1;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxyProvider
    public void setPriorityAffinity(int r1) {
        this.priorityValue = r1;
    }

    @Override // java.lang.Thread
    public void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler r2) {
        super.setUncaughtExceptionHandler(r2);
        IThreadProxy r0 = getProxy();
        if (r0 == null) goto L6;
        r0.setUncaughtExceptionHandler(r2);
        return;
    }

    @Override // java.lang.Thread
    public void start() {
        IThreadMonitor r0 = SuperThreadPool.INSTANCE.getThreadMonitor();
        if (r0 == null) goto L6;
        r0.onThreadStart(this, 4);
    L6:
        if (this.isEnable == true) goto L9;
        super.start();
        return;
    L9:
        IThreadProxy r1 = getProxy();
        if (r1 == null) goto L12;
        r1.start();
        return;
    L12:
        super.start();
    }
}
