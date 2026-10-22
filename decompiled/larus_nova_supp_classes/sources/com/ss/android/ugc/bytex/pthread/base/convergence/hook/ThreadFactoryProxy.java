package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import android.util.EventsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadMonitor;
import com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityProvider;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0007\u001a\u00020\u0001J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ThreadFactoryProxy;", "Ljava/util/concurrent/ThreadFactory;", "mDelegate", "mEnableType", XmlPullParser.NO_NAMESPACE, "(Ljava/util/concurrent/ThreadFactory;I)V", "priorityAffinity", "getDelegate", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "obtainPriority", "thread", "Companion", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
public final class ThreadFactoryProxy implements ThreadFactory {
    public static final Companion Companion = null;
    private final ThreadFactory mDelegate;
    private final int mEnableType;
    private volatile int priorityAffinity;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ThreadFactoryProxy$Companion;", XmlPullParser.NO_NAMESPACE, "()V", "proxy", "Ljava/util/concurrent/ThreadFactory;", "delegate", "enableType", XmlPullParser.NO_NAMESPACE, "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final ThreadFactory proxy(ThreadFactory r2, int r3) {
            if (r2 != null) goto L4;
        L8:
            return r2;
        L4:
            if ((r2 instanceof ThreadFactoryProxy) == true) goto L8;
            return new ThreadFactoryProxy(r2, r3);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ThreadFactoryProxy(ThreadFactory r1, int r2) {
        this.mDelegate = r1;
        this.mEnableType = r2;
        this.priorityAffinity = -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int obtainPriority(Thread r3) {
        int r0 = this.priorityAffinity;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        ThreadFactory r1 = this.mDelegate;
        if ((r1 instanceof PriorityProvider) == false) goto L9;
        int r4 = ((PriorityProvider) r1).priorityAffinity();
    L12:
        boolean r2 = true;
        if (r4 >= 1) goto L15;
    L17:
        r2 = false;
    L18:
        if (r2 == false) goto L22;
        this.priorityAffinity = r4;
        return r4;
    L22:
        throw new IllegalArgumentException("priorityAffinity must be in [1, 15]".toString());
    L15:
        if (r4 >= 16) goto L17;
    L9:
        if ((r3 instanceof PriorityProvider) == false) goto L11;
        r4 = ((PriorityProvider) r3).priorityAffinity();
        goto L12
    L11:
        r4 = 6;
        goto L12
    }

    public final ThreadFactory getDelegate() {
        return this.mDelegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r4) {
        Thread r5 = this.mDelegate.newThread(r4);
        SuperThreadPool r0 = SuperThreadPool.INSTANCE;
        if (r0.isEnable(this.mEnableType) == true) goto L8;
        IThreadMonitor r1 = r0.getThreadMonitor();
        if (r1 == null) goto L7;
        r1.onThreadStart(r5, this.mEnableType);
    L7:
        return r5;
    L8:
        int r2 = obtainPriority(r5);
        if (r0.isEnable(1) == false) goto L21;
        if ((r5 instanceof IThreadProxyProvider) == false) goto L21;
        IThreadProxyProvider r3 = (IThreadProxyProvider) r5;
        r3.setEnable(true);
        r3.setPriorityAffinity(r2);
        if ((r5 instanceof ThreadProxyWrapper) == true) goto L15;
        Object r6 = null;
    L16:
        ThreadProxyWrapper r7 = (ThreadProxyWrapper) r6;
        if (r7 == null) goto L19;
        r7.setThreadType(this.mEnableType);
    L19:
        return r5;
    L15:
        r6 = r5;
    L21:
        return new DirectThreadWrapper(r5, this.mEnableType, r2);
    }
}
