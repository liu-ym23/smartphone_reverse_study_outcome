package com.bytedance.ee.bear.thread;

import com.larksuite.framework.thread.CoreThreadPool;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BearExecutors {
    public static ExecutorService a;
    public static ExecutorService b;
    public static Executor c;
    public static ScheduledExecutorService d;

    public static final enum ExecutorType extends Enum<ExecutorType> {
        public static final ExecutorType CPU = null;
        public static final ExecutorType HIGH_PRIORITY = null;
        public static final ExecutorType IO = null;
        public static final /* synthetic */ ExecutorType[] a = null;

        static {
            ExecutorType r0 = new ExecutorType("CPU", 0);
            CPU = r0;
            ExecutorType r1 = new ExecutorType("IO", 1);
            IO = r1;
            ExecutorType r3 = new ExecutorType("HIGH_PRIORITY", 2);
            HIGH_PRIORITY = r3;
            a = new ExecutorType[]{r0, r1, r3};
        }

        public static ExecutorType[] values() {
            return (ExecutorType[]) a.clone();
        }

        public static ExecutorType valueOf(String r1) {
            return (ExecutorType) a.a(ExecutorType.class, r1);
        }

        public ExecutorType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static ExecutorService a() {
        if (a != null) goto L6;
        a = CoreThreadPool.getDefault().getFixedThreadPool();
    L6:
        return a;
    }

    public static Executor b() {
        if (b != null) goto L6;
        b = CoreThreadPool.getDefault().getCachedThreadPool();
    L6:
        return b;
    }

    public static ExecutorService c() {
        if (b != null) goto L6;
        b = CoreThreadPool.getDefault().getCachedThreadPool();
    L6:
        return b;
    }

    public static ExecutorService d() {
        if (b != null) goto L6;
        b = CoreThreadPool.getDefault().getCachedThreadPool();
    L6:
        return b;
    }

    public static ScheduledExecutorService e() {
        if (d != null) goto L6;
        d = CoreThreadPool.getDefault().getScheduleThreadPool();
    L6:
        return d;
    }

    public static Executor f() {
        if (c != null) goto L6;
        c = CoreThreadPool.getDefault().getUIExecutor();
    L6:
        return c;
    }
}
