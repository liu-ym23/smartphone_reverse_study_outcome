package mra;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f515033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f515034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f515035c;

    public b(String r100) {
        this.f515033a = r100;
        this.f515034b = new AtomicInteger();
        this.f515035c = false;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, this.f515033a + '-' + this.f515034b.incrementAndGet());
        if (this.f515035c == false) goto L5;
    L10:
        return r101;
    L5:
        if (r101.isDaemon() == false) goto L8;
        r101.setDaemon(false);
    L8:
        if (r101.getPriority() == 5) goto L10;
        ThreadMethodProxy.setPriority(r101, 5);
        goto L10
    }
}
