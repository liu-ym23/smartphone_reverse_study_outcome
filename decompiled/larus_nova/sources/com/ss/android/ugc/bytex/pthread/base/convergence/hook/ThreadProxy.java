package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.core.IThreadExitListener;
import com.ss.android.ugc.bytex.pthread.base.convergence.core.ThreadWorker;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u0012\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ThreadProxy;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IThreadProxy;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/core/IThreadExitListener;", "mDelegate", "Ljava/lang/Thread;", "mSkipSetPriority", "", "mThreadType", "", "(Ljava/lang/Thread;ZI)V", "hasJoinWaiter", "lock", "Ljava/lang/Object;", "mAttachThread", "mRunState", "Ljava/util/concurrent/atomic/AtomicInteger;", "checkAttachThread", "", "thread", "getAttachThread", "getState", "Ljava/lang/Thread$State;", "isRealAlive", "join", "millis", "", "nanos", "onThreadExit", "setContextClassLoader", "cl", "Ljava/lang/ClassLoader;", "setUncaughtExceptionHandler", "eh", "Ljava/lang/Thread$UncaughtExceptionHandler;", "start", "Companion", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
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

    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ThreadProxy$Companion;", "", "()V", "STATE_IDLE", "", "STATE_READY", "STATE_RUNNING", "STATE_TERMINATION", "THREAD_POOL_MASK", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ThreadProxy(Thread r100, boolean r101, int r102) {
        this.mDelegate = r100;
        this.mSkipSetPriority = r101;
        this.mThreadType = r102;
        this.mRunState = new AtomicInteger(0);
        this.lock = new Object();
    }

    public /* synthetic */ ThreadProxy(Thread r100, boolean r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L5;
        r101 = false;
    L5:
        this(r100, r101, r102);
    }

    public static final /* synthetic */ void access$checkAttachThread(ThreadProxy r100, Thread r101) {
        r100.checkAttachThread(r101);
    }

    public static final /* synthetic */ Thread access$getMAttachThread$p(ThreadProxy r100) {
        return r100.mAttachThread;
    }

    public static final /* synthetic */ Thread access$getMDelegate$p(ThreadProxy r100) {
        return r100.mDelegate;
    }

    public static final /* synthetic */ AtomicInteger access$getMRunState$p(ThreadProxy r100) {
        return r100.mRunState;
    }

    public static final /* synthetic */ int access$getMThreadType$p(ThreadProxy r100) {
        return r100.mThreadType;
    }

    public static final /* synthetic */ void access$setMAttachThread$p(ThreadProxy r100, Thread r101) {
        r100.mAttachThread = r101;
    }

    private final void checkAttachThread(Thread r100) {
        if ((r100 instanceof IThreadProxyProvider) == true) goto L6;
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
        Thread r100 = this.mAttachThread;
        if (r100 == null) goto L8;
        Thread.State r101 = r100.getState();
        if (r101 == null) goto L8;
        return r101;
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
    public void join(long r100) {
        if (isRealAlive() == true) goto L5;
        return;
    L5:
        Object r101 = this.lock;
        monitor-enter(r101);
        boolean r102 = true;
        this.hasJoinWaiter = true;     // Catch: Throwable -> L29
        long r103 = System.currentTimeMillis();     // Catch: Throwable -> L29
        if (r100 >= 0) goto L12;
        r102 = false;
    L12:
        if (r102 == false) goto L28;
        if (r100 == 0) goto L15;
        long r104 = 0;
    L19:
        if (isRealAlive() == false) goto L24;
        long r105 = r100 - r104;     // Catch: Throwable -> L29
        if (r105 <= 0) goto L24;
        this.lock.wait(r105);     // Catch: Throwable -> L29
        r104 = System.currentTimeMillis() - r103;     // Catch: Throwable -> L29
    L24:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L29
        monitor-exit(r101);
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
    public void join(long r100, int r101) {
        if (isRealAlive() == true) goto L5;
        return;
    L5:
        Object r102 = this.lock;
        monitor-enter(r102);
        boolean r103 = true;
        if (r100 < 0) goto L10;
        boolean r104 = true;
    L33:
        if (r104 == false) goto L29;
        if (r101 >= 0) goto L14;
    L16:
        r103 = false;
    L17:
        if (r103 == false) goto L27;
        if (r101 >= 500000) goto L22;
        if (r101 == 0) goto L23;
        if (r100 == 0) goto L22;
    L23:
        join(r100);     // Catch: Throwable -> L30
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(r102);
        return;
    L22:
        r100 = r100 + 1;
        goto L23
    L27:
        throw new IllegalArgumentException("nanosecond timeout value out of range".toString());     // Catch: Throwable -> L30
    L14:
        if (r101 > 999999) goto L16;
    L29:
        throw new IllegalArgumentException("timeout value is negative".toString());     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    L10:
        r104 = false;
        goto L33
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.core.IThreadExitListener
    public void onThreadExit() {
        Object r100 = this.lock;
        monitor-enter(r100);
        this.mAttachThread = null;     // Catch: Throwable -> L11
        this.mRunState.set(-1);     // Catch: Throwable -> L11
        if (this.hasJoinWaiter == false) goto L8;
        this.lock.notifyAll();     // Catch: Throwable -> L11
    L8:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r100);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxy
    public void setContextClassLoader(ClassLoader r100) {
        if (this.mAttachThread == null) goto L15;
        Object r101 = this.lock;
        monitor-enter(r101);
        Thread r102 = this.mAttachThread;     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        r102.setContextClassLoader(r100);     // Catch: Throwable -> L12
    L9:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r101);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxy
    public void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler r100) {
        if (this.mAttachThread == null) goto L15;
        Object r101 = this.lock;
        monitor-enter(r101);
        Thread r102 = this.mAttachThread;     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        r102.setUncaughtExceptionHandler(r100);     // Catch: Throwable -> L12
    L9:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r101);
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
        SuperThreadPool.INSTANCE.execute(new ThreadWorker(this.mDelegate, this.mSkipSetPriority, this, this.mThreadType, new AnonymousClass1(this)), this.mThreadType);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        onThreadExit();
        throw th;
    }
}
