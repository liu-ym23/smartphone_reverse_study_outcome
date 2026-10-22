package com.bytedance.lego.init.config;

import android.content.Context;
import com.bytedance.lego.init.IdleTaskConfig;
import com.bytedance.lego.init.util.c;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001:\u00012Bw\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0002\u0010\u0018J\b\u0010/\u001a\u00020\tH\u0002J\b\u00100\u001a\u00020\u000bH\u0002J\b\u00101\u001a\u00020\u000bH\u0002R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/bytedance/lego/init/config/TaskConfig;", "", "isDebug", "", "base", "Landroid/content/Context;", "mode", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "coreThreadNum", "", "isMainProcess", "processName", "", "timeout", "catchException", "applicationStartTime", "", "idleTaskConfig", "Lcom/bytedance/lego/init/IdleTaskConfig;", "agreePrivacyPopupWindow", "(ZLandroid/content/Context;Lcom/bytedance/lego/init/config/ProcessMatchMode;Ljava/util/concurrent/ThreadPoolExecutor;Ljava/util/concurrent/ThreadFactory;IZLjava/lang/String;IZJLcom/bytedance/lego/init/IdleTaskConfig;Z)V", "getAgreePrivacyPopupWindow", "()Z", "setAgreePrivacyPopupWindow", "(Z)V", "getApplicationStartTime", "()J", "getBase", "()Landroid/content/Context;", "getCatchException", "getIdleTaskConfig", "()Lcom/bytedance/lego/init/IdleTaskConfig;", "getMode", "()Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getProcessName", "()Ljava/lang/String;", "taskExecutor", "getTaskExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "setTaskExecutor", "(Ljava/util/concurrent/ThreadPoolExecutor;)V", "getTimeout", "()I", "getDefaultExecutor", "getDefaultThreadFactory", "getThreadFactory", "Builder", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class TaskConfig {
    private boolean agreePrivacyPopupWindow;
    private final long applicationStartTime;
    private final Context base;
    private final boolean catchException;
    private final int coreThreadNum;
    private final ThreadPoolExecutor executor;
    private final IdleTaskConfig idleTaskConfig;
    private final boolean isDebug;
    private final boolean isMainProcess;
    private final ProcessMatchMode mode;
    private final String processName;
    private ThreadPoolExecutor taskExecutor;
    private final ThreadFactory threadFactory;
    private final int timeout;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0015J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/lego/init/config/TaskConfig$Builder;", "", "base", "Landroid/content/Context;", "isMainProcess", "", "processName", "", "(Landroid/content/Context;ZLjava/lang/String;)V", "agreePrivacyPopupWindow", "applicationStartTime", "", "catchException", "coreThreadNum", "", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "idleTaskConfig", "Lcom/bytedance/lego/init/IdleTaskConfig;", "isDebug", "processMatchMode", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "timeout", "build", "Lcom/bytedance/lego/init/config/TaskConfig;", "enableCatchException", "enable", "setApplicationStartTime", "setCoreThreadNum", "setExecutorService", "setIdleTaskConfig", "setProcessMatchMode", "mode", "setThreadFactory", "setTimeOut", "millis", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
    public static final class Builder {
        private boolean agreePrivacyPopupWindow;
        private long applicationStartTime;
        private final Context base;
        private boolean catchException;
        private int coreThreadNum;
        private ThreadPoolExecutor executor;
        private IdleTaskConfig idleTaskConfig;
        private boolean isDebug;
        private final boolean isMainProcess;
        private ProcessMatchMode processMatchMode;
        private final String processName;
        private ThreadFactory threadFactory;
        private int timeout;

        public final TaskConfig build() {
            boolean r100 = this.isDebug;
            Context r101 = this.base;
            ThreadPoolExecutor r102 = this.executor;
            ProcessMatchMode r103 = this.processMatchMode;
            int r104 = this.coreThreadNum;
            return new TaskConfig(r100, r101, r103, r102, this.threadFactory, r104, this.isMainProcess, this.processName, this.timeout, this.catchException, this.applicationStartTime, this.idleTaskConfig, this.agreePrivacyPopupWindow, null);
        }

        public final Builder agreePrivacyPopupWindow(boolean r100) {
            this.agreePrivacyPopupWindow = r100;
            return this;
        }

        public final Builder enableCatchException(boolean r100) {
            this.catchException = r100;
            return this;
        }

        public final Builder isDebug(boolean r100) {
            this.isDebug = r100;
            return this;
        }

        public final Builder setApplicationStartTime(long r100) {
            this.applicationStartTime = r100;
            return this;
        }

        public final Builder setCoreThreadNum(int r100) {
            this.coreThreadNum = r100;
            return this;
        }

        public final Builder setExecutorService(ThreadPoolExecutor r100) {
            this.executor = r100;
            return this;
        }

        public final Builder setIdleTaskConfig(IdleTaskConfig r100) {
            this.idleTaskConfig = r100;
            return this;
        }

        public final Builder setProcessMatchMode(ProcessMatchMode r100) {
            this.processMatchMode = r100;
            return this;
        }

        public final Builder setThreadFactory(ThreadFactory r100) {
            this.threadFactory = r100;
            return this;
        }

        public final Builder setTimeOut(int r100) {
            if (r100 >= 3000) goto L5;
            int r101 = c.f254571a;
            this.timeout = 3000;
        L6:
            return this;
        L5:
            this.timeout = r100;
            goto L6
        }

        public Builder(Context r100, boolean r101, String r102) {
            this.base = r100;
            this.isMainProcess = r101;
            this.processName = r102;
            this.processMatchMode = ProcessMatchMode.CONTAIN;
            this.coreThreadNum = Runtime.getRuntime().availableProcessors();
            this.timeout = 8000;
            IdleTaskConfig.Companion.getClass();
            this.idleTaskConfig = IdleTaskConfig.access$getDEFAULT_IDLETASK_CONFIG$cp();
            this.applicationStartTime = System.currentTimeMillis();
            this.agreePrivacyPopupWindow = true;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f254520a;

        public a() {
            this.f254520a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            return new PthreadThreadV2(r100, "AA InitThread#" + this.f254520a.getAndIncrement());
        }
    }

    private final ThreadPoolExecutor getDefaultExecutor() {
        int r100 = this.coreThreadNum;
        return new PThreadPoolExecutor(r100, r100, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), getThreadFactory());
    }

    private final ThreadFactory getDefaultThreadFactory() {
        return new a();
    }

    private final ThreadFactory getThreadFactory() {
        ThreadFactory r100 = this.threadFactory;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return getDefaultThreadFactory();
    }

    public final ThreadPoolExecutor getTaskExecutor() {
        ThreadPoolExecutor r100 = this.taskExecutor;
        if (r100 != null) goto L6;
        r100 = this.executor;
    L6:
        if (r100 == null) goto L9;
        return r100;
    L9:
        return getDefaultExecutor();
    }

    public final boolean getAgreePrivacyPopupWindow() {
        return this.agreePrivacyPopupWindow;
    }

    public final long getApplicationStartTime() {
        return this.applicationStartTime;
    }

    public final Context getBase() {
        return this.base;
    }

    public final boolean getCatchException() {
        return this.catchException;
    }

    public final IdleTaskConfig getIdleTaskConfig() {
        return this.idleTaskConfig;
    }

    public final ProcessMatchMode getMode() {
        return this.mode;
    }

    public final String getProcessName() {
        return this.processName;
    }

    public final int getTimeout() {
        return this.timeout;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    public final boolean isMainProcess() {
        return this.isMainProcess;
    }

    public final void setAgreePrivacyPopupWindow(boolean r100) {
        this.agreePrivacyPopupWindow = r100;
    }

    public final void setTaskExecutor(ThreadPoolExecutor r100) {
        this.taskExecutor = r100;
    }

    private TaskConfig(boolean r100, Context r101, ProcessMatchMode r102, ThreadPoolExecutor r103, ThreadFactory r104, int r105, boolean r106, String r107, int r108, boolean r110, long r111, IdleTaskConfig r112, boolean r113) {
        this.isDebug = r100;
        this.base = r101;
        this.mode = r102;
        this.executor = r103;
        this.threadFactory = r104;
        this.coreThreadNum = r105;
        this.isMainProcess = r106;
        this.processName = r107;
        this.timeout = r108;
        this.catchException = r110;
        this.applicationStartTime = r111;
        this.idleTaskConfig = r112;
        this.agreePrivacyPopupWindow = r113;
    }

    public /* synthetic */ TaskConfig(boolean r100, Context r101, ProcessMatchMode r102, ThreadPoolExecutor r103, ThreadFactory r104, int r105, boolean r106, String r107, int r108, boolean r110, long r111, IdleTaskConfig r112, boolean r113, DefaultConstructorMarker r114) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113);
    }

    public /* synthetic */ TaskConfig(boolean r110, Context r111, ProcessMatchMode r210, ThreadPoolExecutor r211, ThreadFactory r212, int r213, boolean r214, String r215, int r216, boolean r217, long r218, IdleTaskConfig r310, boolean r311, int r312, DefaultConstructorMarker r313) {
        if ((r312 & 8) == 0) goto L5;
        ThreadPoolExecutor r100 = null;
    L7:
        if ((r312 & 16) == 0) goto L9;
        ThreadFactory r101 = null;
    L10:
        this(r110, r111, r210, r100, r101, r213, r214, r215, r216, r217, r218, r310, r311);
        return;
    L9:
        r101 = r212;
        goto L10
    L5:
        r100 = r211;
        goto L7
    }
}
