package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import android.util.EventsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.core.IThreadExitListener;
import com.ss.android.ugc.bytex.pthread.base.convergence.core.ThreadWorker;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u0012\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ThreadProxy;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IThreadProxy;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/core/IThreadExitListener;", "mDelegate", "Ljava/lang/Thread;", "mSkipSetPriority", XmlPullParser.NO_NAMESPACE, "mThreadType", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/Thread;ZI)V", "hasJoinWaiter", "lock", "Ljava/lang/Object;", "mAttachThread", "mRunState", "Ljava/util/concurrent/atomic/AtomicInteger;", "checkAttachThread", XmlPullParser.NO_NAMESPACE, "thread", "getAttachThread", "getState", "Ljava/lang/Thread$State;", "isRealAlive", "join", "millis", XmlPullParser.NO_NAMESPACE, "nanos", "onThreadExit", "setContextClassLoader", "cl", "Ljava/lang/ClassLoader;", "setUncaughtExceptionHandler", "eh", "Ljava/lang/Thread$UncaughtExceptionHandler;", "start", "Companion", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
public final class ThreadProxy implements IThreadExitListener, IThreadProxy {
    public static final Companion Companion = null;
    private static final int STATE_IDLE = 0;
    private static final int STATE_READY = 1;
    private static final int STATE_RUNNING = 2;
    private static final int STATE_TERMINATION = -1;
    private static final int THREAD_POOL_MASK = 10;
    private volatile boolean hasJoinWaiter;
    private final Object lock;
    private volatile Thread mAttachThread;
    private final Thread mDelegate;
    private final AtomicInteger mRunState;
    private final boolean mSkipSetPriority;
    private final int mThreadType;

    static {
        Companion = new Companion(null);
    }

    public ThreadProxy(Thread r1, boolean r2, int r3) {
        this.mDelegate = r1;
        this.mSkipSetPriority = r2;
        this.mThreadType = r3;
        this.mRunState = new AtomicInteger(0);
        this.lock = new Object();
    }

    public /* synthetic */ ThreadProxy(Thread r1, boolean r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ void access$checkAttachThread(ThreadProxy r0, Thread r1) {
        r0.checkAttachThread(r1);
    }

    public static final /* synthetic */ Thread access$getMAttachThread$p(ThreadProxy r0) {
        return r0.mAttachThread;
    }

    public static final /* synthetic */ Thread access$getMDelegate$p(ThreadProxy r0) {
        return r0.mDelegate;
    }

    public static final /* synthetic */ AtomicInteger access$getMRunState$p(ThreadProxy r0) {
        return r0.mRunState;
    }

    public static final /* synthetic */ int access$getMThreadType$p(ThreadProxy r0) {
        return r0.mThreadType;
    }

    public static final /* synthetic */ void access$setMAttachThread$p(ThreadProxy r0, Thread r1) {
        r0.mAttachThread = r1;
    }

    private final void checkAttachThread(Thread r2) {
        if ((r2 instanceof IThreadProxyProvider) == true) goto L6;
        return;
    L6:
        throw new RuntimeException("the attach thread must not be IThreadProxyProvider");
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxy
    public Thread getAttachThread() {
        return this.mAttachThread;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxy
    public Thread.State getState() {
        Thread r0 = this.mAttachThread;
        if (r0 == null) goto L8;
        Thread.State r1 = r0.getState();
        if (r1 == null) goto L8;
        return r1;
    L8:
        if (this.mRunState.get() != 0) goto L11;
        return Thread.State.NEW;
    L11:
        return Thread.State.TERMINATED;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxy
    public boolean isRealAlive() {
        if (this.mRunState.get() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxy
    public void join() {
        join(0);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxy
    public void join(long r9) {
        if (isRealAlive() == true) goto L5;
        return;
    L5:
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r1 = true;
        this.hasJoinWaiter = true;     // Catch: Throwable -> L29
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L29
        if (r9 >= 0) goto L12;
        r1 = false;
    L12:
        if (r1 == false) goto L28;
        if (r9 == 0) goto L15;
        long r6 = 0;
    L19:
        if (isRealAlive() == false) goto L24;
        long r7 = r9 - r6;     // Catch: Throwable -> L29
        if (r7 <= 0) goto L24;
        this.lock.wait(r7);     // Catch: Throwable -> L29
        r6 = System.currentTimeMillis() - r2;     // Catch: Throwable -> L29
    L24:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L29
        monitor-exit(r0);
        return;
    L15:
        if (isRealAlive() == false) goto L24;
        this.lock.wait(0);     // Catch: Throwable -> L29
        goto L15
    L28:
        throw new IllegalArgumentException("timeout value is negative".toString());     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxy
    public void join(long r7, int r9) {
        if (isRealAlive() == true) goto L5;
        return;
    L5:
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r3 = true;
        if (r7 < 0) goto L10;
        boolean r1 = true;
    L33:
        if (r1 == false) goto L29;
        if (r9 >= 0) goto L14;
    L16:
        r3 = false;
    L17:
        if (r3 == false) goto L27;
        if (r9 >= 500000) goto L22;
        if (r9 == 0) goto L23;
        if (r7 == 0) goto L22;
    L23:
        join(r7);     // Catch: Throwable -> L30
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(r0);
        return;
    L22:
        r7 = r7 + 1;
        goto L23
    L27:
        throw new IllegalArgumentException("nanosecond timeout value out of range".toString());     // Catch: Throwable -> L30
    L14:
        if (r9 > 999999) goto L16;
    L29:
        throw new IllegalArgumentException("timeout value is negative".toString());     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    L10:
        r1 = false;
        goto L33
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.core.IThreadExitListener
    public void onThreadExit() {
        Object r0 = this.lock;
        monitor-enter(r0);
        this.mAttachThread = null;     // Catch: Throwable -> L11
        this.mRunState.set(-1);     // Catch: Throwable -> L11
        if (this.hasJoinWaiter == false) goto L8;
        this.lock.notifyAll();     // Catch: Throwable -> L11
    L8:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxy
    public void setContextClassLoader(ClassLoader r3) {
        if (this.mAttachThread == null) goto L15;
        Object r0 = this.lock;
        monitor-enter(r0);
        Thread r1 = this.mAttachThread;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        r1.setContextClassLoader(r3);     // Catch: Throwable -> L12
    L9:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxy
    public void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler r3) {
        if (this.mAttachThread == null) goto L15;
        Object r0 = this.lock;
        monitor-enter(r0);
        Thread r1 = this.mAttachThread;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        r1.setUncaughtExceptionHandler(r3);     // Catch: Throwable -> L12
    L9:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxy
    public void start() {
        if (this.mRunState.compareAndSet(0, 1) == true) goto L10;
        return;
    L10:
        SuperThreadPool.INSTANCE.execute(new ThreadWorker(this.mDelegate, this.mSkipSetPriority, this, this.mThreadType, new start.1(this)), this.mThreadType);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        onThreadExit();
        throw th;
    }
}
