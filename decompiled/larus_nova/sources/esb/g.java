package esb;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.MemoryCallbackManager;
import com.ss.android.lark.monitor.memory.MemoryMetrics;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f473823a;

    public final void a() {
        MemoryMetrics r100 = new MemoryMetrics();
        this.f473823a.getClass();
        b.c(r100);
        Log.i("MemoryPerfMonitor", "before reachTop notify, reach_top_mem_info，" + r100);
        MemoryCallbackManager.getInstance().notifyMemoryReachTop();
        CoreThreadPool.getDefault().getScheduleThreadPool().schedule(new f(this), 500, TimeUnit.MILLISECONDS);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public g(b r100) {
        this.f473823a = r100;
    }
}
