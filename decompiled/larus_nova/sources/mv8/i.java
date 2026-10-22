package mv8;

import com.bytedance.common.utility.concurrent.TTExecutors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements zc.e {
    public i() {
    }

    @Override // zc.e
    public final ScheduledExecutorService a() {
        return TTExecutors.getScheduledThreadPool();
    }

    @Override // zc.e
    public final ExecutorService b() {
        return TTExecutors.getSerialThreadPool();
    }

    @Override // zc.e
    public final ExecutorService c() {
        return TTExecutors.getCPUThreadPool();
    }

    @Override // zc.e
    public final ExecutorService getIOExecutor() {
        return TTExecutors.getIOThreadPool();
    }
}
