package e97;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements ThreadFactory {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f471524d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadGroup f471525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f471526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f471527c;

    static {
        f471524d = new AtomicInteger(1);
    }

    public h() {
        this.f471526b = new AtomicInteger(1);
        SecurityManager r100 = System.getSecurityManager();
        if (r100 == null) goto L5;
        ThreadGroup r101 = r100.getThreadGroup();
    L6:
        this.f471525a = r101;
        this.f471527c = "reparo-" + f471524d.getAndIncrement() + '-';
        return;
    L5:
        r101 = ThreadMethodProxy.currentThread().getThreadGroup();
        goto L6
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(this.f471525a, r100, this.f471527c + this.f471526b.getAndIncrement(), 0);
        if (r101.isDaemon() == false) goto L6;
        r101.setDaemon(false);
    L6:
        if (r101.getPriority() == 5) goto L8;
        ThreadMethodProxy.setPriority(r101, 5);
    L8:
        return r101;
    }
}
