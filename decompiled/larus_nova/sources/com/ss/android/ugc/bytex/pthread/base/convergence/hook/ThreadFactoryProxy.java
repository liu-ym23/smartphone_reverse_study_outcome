package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadMonitor;
import com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityProvider;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0007\u001a\u00020\u0001J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ThreadFactoryProxy;", "Ljava/util/concurrent/ThreadFactory;", "mDelegate", "mEnableType", "", "(Ljava/util/concurrent/ThreadFactory;I)V", "priorityAffinity", "getDelegate", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "obtainPriority", "thread", "Companion", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class ThreadFactoryProxy implements ThreadFactory {
    public static final Companion Companion = null;
    private final ThreadFactory mDelegate;
    private final int mEnableType;
    private volatile int priorityAffinity;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ThreadFactoryProxy$Companion;", "", "()V", "proxy", "Ljava/util/concurrent/ThreadFactory;", "delegate", "enableType", "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ThreadFactory proxy(ThreadFactory r100, int r101) {
            if (r100 != null) goto L4;
        L8:
            return r100;
        L4:
            if ((r100 instanceof ThreadFactoryProxy) == true) goto L8;
            return new ThreadFactoryProxy(r100, r101);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ThreadFactoryProxy(ThreadFactory r100, int r101) {
        this.mDelegate = r100;
        this.mEnableType = r101;
        this.priorityAffinity = -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int obtainPriority(Thread r100) {
        int r101 = this.priorityAffinity;
        if (r101 <= 0) goto L5;
        return r101;
    L5:
        ThreadFactory r102 = this.mDelegate;
        if ((r102 instanceof PriorityProvider) == false) goto L9;
        int r103 = ((PriorityProvider) r102).priorityAffinity();
    L12:
        boolean r104 = true;
        if (r103 >= 1) goto L15;
    L17:
        r104 = false;
    L18:
        if (r104 == false) goto L22;
        this.priorityAffinity = r103;
        return r103;
    L22:
        throw new IllegalArgumentException("priorityAffinity must be in [1, 15]".toString());
    L15:
        if (r103 >= 16) goto L17;
    L9:
        if ((r100 instanceof PriorityProvider) == false) goto L11;
        r103 = ((PriorityProvider) r100).priorityAffinity();
        goto L12
    L11:
        r103 = 6;
        goto L12
    }

    public final ThreadFactory getDelegate() {
        return this.mDelegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r100) {
        Thread r101 = this.mDelegate.newThread(r100);
        SuperThreadPool r102 = SuperThreadPool.INSTANCE;
        if (r102.isEnable(this.mEnableType) == true) goto L8;
        IThreadMonitor r103 = r102.getThreadMonitor();
        if (r103 == null) goto L7;
        r103.onThreadStart(r101, this.mEnableType);
    L7:
        return r101;
    L8:
        int r104 = obtainPriority(r101);
        if (r102.isEnable(1) == false) goto L21;
        if ((r101 instanceof IThreadProxyProvider) == false) goto L21;
        IThreadProxyProvider r105 = (IThreadProxyProvider) r101;
        r105.setEnable(true);
        r105.setPriorityAffinity(r104);
        if ((r101 instanceof ThreadProxyWrapper) == true) goto L15;
        Object r106 = null;
    L16:
        ThreadProxyWrapper r107 = (ThreadProxyWrapper) r106;
        if (r107 == null) goto L19;
        r107.setThreadType(this.mEnableType);
    L19:
        return r101;
    L15:
        r106 = r101;
    L21:
        return new DirectThreadWrapper(r101, this.mEnableType, r104);
    }
}
