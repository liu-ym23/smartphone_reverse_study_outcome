package io.reactivex.internal.schedulers;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes41.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    public static final class a extends PthreadThreadV2 implements h {
        public a(Runnable r100, String r101) {
            super(r100, r101);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.prefix + "]";
    }

    public RxThreadFactory(String r100) {
        this(r100, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r100) {
        String r101 = this.prefix + '-' + incrementAndGet();
        if (this.nonBlocking == false) goto L5;
        Thread r102 = new a(r100, r101);
    L6:
        ThreadMethodProxy.setPriority(r102, this.priority);
        r102.setDaemon(true);
        return r102;
    L5:
        r102 = new PthreadThreadV2(r100, r101);
        goto L6
    }

    public RxThreadFactory(String r100, int r101) {
        this(r100, r101, false);
    }

    public RxThreadFactory(String r100, int r101, boolean r102) {
        this.prefix = r100;
        this.priority = r101;
        this.nonBlocking = r102;
    }
}
