package com.ss.android.ugc.aweme.thread;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes40.dex */
class TaskMonitor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ExecutorService f454300c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f454301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<DelegateRunnable, Object> f454302b;

    public static class Holder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TaskMonitor f454303a = null;

        static {
            f454303a = new TaskMonitor(0);
        }
    }

    public class TaskBlockedMonitorWorker implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            ThreadPoolHelper.f454305b.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public TaskBlockedMonitorWorker(TaskMonitor r100) {
        }
    }

    private TaskMonitor() {
        this.f454301a = new Object();
        new ReentrantLock();
        this.f454302b = new WeakHashMap();
        ThreadPoolOptions.Builder r100 = new ThreadPoolOptions.Builder(ThreadPoolType.SCHEDULED);
        r100.f454333c = 1;
        r100.f454332b = "TaskMonitor";
        f454300c = ThreadPoolHelper.a(new ThreadPoolOptions(r100));
        ThreadPoolInitConfig r101 = ThreadPoolHelper.f454304a;
        String.format("taskBlockedTimeOut=%d", new Object[]{Long.valueOf(r101.f454318e)});
        ScheduledExecutorService r102 = (ScheduledExecutorService) f454300c;
        TaskBlockedMonitorWorker r103 = new TaskBlockedMonitorWorker(this);
        long r104 = r101.f454318e;
        r102.scheduleAtFixedRate(r103, r104, r104, TimeUnit.MILLISECONDS);
    }

    public /* synthetic */ TaskMonitor(int r100) {
        this();
    }
}
