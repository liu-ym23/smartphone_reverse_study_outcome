package com.bytedance.jedi.arch.internal;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/jedi/arch/internal/JediThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "()V", "group", "Ljava/lang/ThreadGroup;", "namePrefix", "", "threadNumber", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "Companion", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JediThreadFactory implements ThreadFactory {
    public static final Companion Companion = null;
    private static final AtomicInteger POOL_NUMBER = null;
    private final ThreadGroup group;
    private final String namePrefix;
    private final AtomicInteger threadNumber;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/jedi/arch/internal/JediThreadFactory$Companion;", "", "()V", "POOL_NUMBER", "Ljava/util/concurrent/atomic/AtomicInteger;", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        POOL_NUMBER = new AtomicInteger(1);
    }

    public JediThreadFactory() {
        this.threadNumber = new AtomicInteger(1);
        SecurityManager r100 = System.getSecurityManager();
        if (r100 == null) goto L5;
        ThreadGroup r101 = r100.getThreadGroup();
    L6:
        this.group = r101;
        this.namePrefix = "pool-jedi-core-" + POOL_NUMBER.getAndIncrement() + "-thread-";
        return;
    L5:
        r101 = ThreadMethodProxy.currentThread().getThreadGroup();
        goto L6
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "r");
        PthreadThreadV2 r101 = new PthreadThreadV2(this.group, r100, this.namePrefix + this.threadNumber.getAndIncrement(), 0);
        if (r101.isDaemon() == false) goto L6;
        r101.setDaemon(false);
    L6:
        if (r101.getPriority() == 5) goto L8;
        ThreadMethodProxy.setPriority(r101, 5);
    L8:
        return r101;
    }
}
