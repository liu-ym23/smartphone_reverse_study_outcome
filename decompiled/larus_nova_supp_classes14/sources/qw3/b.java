package qw3;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends PThreadPoolExecutor {
    public final void shutdown() {
    }

    static {
        new ThreadPoolExecutor.AbortPolicy();
    }

    public final List<Runnable> shutdownNow() {
        return new ArrayList();
    }

    public b(int r1, int r2, long r3, TimeUnit r5, BlockingQueue r6, a.d r7, a.RejectedExecutionHandlerC0160a r8) {
        super(r1, r2, r3, r5, r6, r7, r8);
    }
}
