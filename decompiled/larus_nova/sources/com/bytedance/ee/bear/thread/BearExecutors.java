package com.bytedance.ee.bear.thread;

import com.larksuite.framework.thread.CoreThreadPool;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final class BearExecutors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorService f239438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ExecutorService f239439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Executor f239440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ScheduledExecutorService f239441d;

    public static final enum ExecutorType extends Enum<ExecutorType> {
        public static final ExecutorType CPU = null;
        public static final ExecutorType HIGH_PRIORITY = null;
        public static final ExecutorType IO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ExecutorType[] f239442a = null;

        static {
            ExecutorType r100 = new ExecutorType("CPU", 0);
            CPU = r100;
            ExecutorType r101 = new ExecutorType("IO", 1);
            IO = r101;
            ExecutorType r102 = new ExecutorType("HIGH_PRIORITY", 2);
            HIGH_PRIORITY = r102;
            f239442a = new ExecutorType[]{r100, r101, r102};
        }

        public static ExecutorType[] values() {
            return (ExecutorType[]) f239442a.clone();
        }

        public static ExecutorType valueOf(String r100) {
            return (ExecutorType) a.a(ExecutorType.class, r100);
        }

        public ExecutorType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static ExecutorService a() {
        if (f239438a != null) goto L6;
        f239438a = CoreThreadPool.getDefault().getFixedThreadPool();
    L6:
        return f239438a;
    }

    public static Executor b() {
        if (f239439b != null) goto L6;
        f239439b = CoreThreadPool.getDefault().getCachedThreadPool();
    L6:
        return f239439b;
    }

    public static ExecutorService c() {
        if (f239439b != null) goto L6;
        f239439b = CoreThreadPool.getDefault().getCachedThreadPool();
    L6:
        return f239439b;
    }

    public static ExecutorService d() {
        if (f239439b != null) goto L6;
        f239439b = CoreThreadPool.getDefault().getCachedThreadPool();
    L6:
        return f239439b;
    }

    public static ScheduledExecutorService e() {
        if (f239441d != null) goto L6;
        f239441d = CoreThreadPool.getDefault().getScheduleThreadPool();
    L6:
        return f239441d;
    }

    public static Executor f() {
        if (f239440c != null) goto L6;
        f239440c = CoreThreadPool.getDefault().getUIExecutor();
    L6:
        return f239440c;
    }
}
