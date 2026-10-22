package yo7;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends PThreadPoolExecutor {
    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final void shutdown() {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return new ArrayList();
    }

    public b(int r110, int r111, TimeUnit r112, BlockingQueue r113, a.b r114, a.RejectedExecutionHandlerC8367a r115) {
        super(r110, r111, 30, r112, r113, r114, r115);
    }
}
