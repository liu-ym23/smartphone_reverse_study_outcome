package f96;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f475972a = null;

    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f475973a = null;

        static {
            f475973a = new a();
        }

        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, "InteractiveThreadUtil$threadFactory$1");
            ThreadMethodProxy.setPriority(r101, 10);
            return r101;
        }
    }

    static {
        f475972a = PThreadExecutorsUtils.newSingleThreadExecutor(a.f475973a);
        new Handler(Looper.getMainLooper());
    }
}
