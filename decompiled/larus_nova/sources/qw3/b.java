package qw3;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends PThreadPoolExecutor {
    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final void shutdown() {
    }

    static {
        new ThreadPoolExecutor.AbortPolicy();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return new ArrayList();
    }

    public b(int r100, int r101, long r102, TimeUnit r103, BlockingQueue r104, a.d r105, a.RejectedExecutionHandlerC7401a r106) {
        super(r100, r101, r102, r103, r104, r105, r106);
    }
}
