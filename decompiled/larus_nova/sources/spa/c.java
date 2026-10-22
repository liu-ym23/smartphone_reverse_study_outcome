package spa;

import com.relax.embedding.LLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f542916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f542917b;

    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread r100, Throwable r101) {
            LLog.e("ThreadUtils executor uncaughtException:" + r101.toString());
        }
    }

    public c() {
        this.f542916a = "resource-loader";
        this.f542917b = 3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, this.f542916a);
        if (r101.isDaemon() == false) goto L5;
        r101.setDaemon(false);
    L5:
        ThreadMethodProxy.setPriority(r101, this.f542917b);
        r101.setUncaughtExceptionHandler(new a());
        return r101;
    }
}
