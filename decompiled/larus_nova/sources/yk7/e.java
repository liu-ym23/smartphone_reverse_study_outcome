package yk7;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f568241a = null;

    static {
        f568241a = new e();
    }

    public e() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, "ThreadPoolUtils$init$1$1");
        ThreadMethodProxy.setName(r101, "ThreadPoolUtils");
        return r101;
    }
}
