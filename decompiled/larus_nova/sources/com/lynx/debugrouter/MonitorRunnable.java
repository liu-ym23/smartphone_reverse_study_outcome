package com.lynx.debugrouter;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.debugrouter.log.LLog;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.ttm.player.C;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
class MonitorRunnable implements Runnable {
    private static final String CONNECT_RUNNABLE = "connect";
    private static final String TAG = "MonitorRunnable";
    private static final long TIME_THRESHOLD = 3000000000L;
    private static volatile MonitorRunnable sCurMonitorRunnable;
    private static volatile int sRunnableCount;
    private static ScheduledExecutorService sTimer;
    private Future mMonitorTask;
    private Runnable mRunnable;
    private String mRunnableTag;

    @Override // java.lang.Runnable
    public void run() {
        com_lynx_debugrouter_MonitorRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    static {
        sTimer = PThreadExecutorsUtils.newScheduledThreadPool(1, new DefaultThreadFactory(TAG));
        sCurMonitorRunnable = null;
        sRunnableCount = 0;
    }

    public void com_lynx_debugrouter_MonitorRunnable__run$___twin___() {
        sCurMonitorRunnable = this;
        long r100 = System.nanoTime();
        this.mRunnable.run();
        long r101 = System.nanoTime() - r100;
        sRunnableCount--;
        this.mMonitorTask.cancel(false);
        if (r101 < C.NANOS_PER_SECOND) goto L5;
        LLog.w(TAG, this.mRunnable.hashCode() + this.mRunnableTag + " exe time is too large:" + r101);
    L5:
        sCurMonitorRunnable = null;
    }

    public String toString() {
        return "MonitorRunnable_" + this.mRunnable.hashCode() + this.mRunnableTag;
    }

    public static /* synthetic */ MonitorRunnable access$100() {
        return sCurMonitorRunnable;
    }

    public static /* synthetic */ Runnable access$000(MonitorRunnable r100) {
        return r100.mRunnable;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_lynx_debugrouter_MonitorRunnable_com_larus_apm_impl_protector_RunnableLancet_run(MonitorRunnable r100) {
        r100.com_lynx_debugrouter_MonitorRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public MonitorRunnable(Runnable r100, final String r101) {
        this.mRunnable = r100;
        this.mRunnableTag = r101;
        sRunnableCount++;
        if (CONNECT_RUNNABLE.equals(r101) == false) goto L5;
        LLog.i(TAG, "MonitorRunnableCount: " + sRunnableCount);
    L5:
        this.mMonitorTask = sTimer.schedule(new AnonymousClass1(this, r101), TIME_THRESHOLD, TimeUnit.NANOSECONDS);
    }
}
