package com.bytedance.lego.init.config;

import android.content.Context;
import android.util.EventsUtils;
import com.bytedance.lego.init.IdleTaskConfig;
import com.bytedance.lego.init.util.c;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001:\u00012Bw\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0002\u0010\u0018J\b\u0010/\u001a\u00020\tH\u0002J\b\u00100\u001a\u00020\u000bH\u0002J\b\u00101\u001a\u00020\u000bH\u0002R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/bytedance/lego/init/config/TaskConfig;", XmlPullParser.NO_NAMESPACE, "isDebug", XmlPullParser.NO_NAMESPACE, "base", "Landroid/content/Context;", "mode", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "coreThreadNum", XmlPullParser.NO_NAMESPACE, "isMainProcess", "processName", XmlPullParser.NO_NAMESPACE, "timeout", "catchException", "applicationStartTime", XmlPullParser.NO_NAMESPACE, "idleTaskConfig", "Lcom/bytedance/lego/init/IdleTaskConfig;", "agreePrivacyPopupWindow", "(ZLandroid/content/Context;Lcom/bytedance/lego/init/config/ProcessMatchMode;Ljava/util/concurrent/ThreadPoolExecutor;Ljava/util/concurrent/ThreadFactory;IZLjava/lang/String;IZJLcom/bytedance/lego/init/IdleTaskConfig;Z)V", "getAgreePrivacyPopupWindow", "()Z", "setAgreePrivacyPopupWindow", "(Z)V", "getApplicationStartTime", "()J", "getBase", "()Landroid/content/Context;", "getCatchException", "getIdleTaskConfig", "()Lcom/bytedance/lego/init/IdleTaskConfig;", "getMode", "()Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getProcessName", "()Ljava/lang/String;", "taskExecutor", "getTaskExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "setTaskExecutor", "(Ljava/util/concurrent/ThreadPoolExecutor;)V", "getTimeout", "()I", "getDefaultExecutor", "getDefaultThreadFactory", "getThreadFactory", "Builder", "initscheduler_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0015J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/lego/init/config/TaskConfig$Builder;", XmlPullParser.NO_NAMESPACE, "base", "Landroid/content/Context;", "isMainProcess", XmlPullParser.NO_NAMESPACE, "processName", XmlPullParser.NO_NAMESPACE, "(Landroid/content/Context;ZLjava/lang/String;)V", "agreePrivacyPopupWindow", "applicationStartTime", XmlPullParser.NO_NAMESPACE, "catchException", "coreThreadNum", XmlPullParser.NO_NAMESPACE, "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "idleTaskConfig", "Lcom/bytedance/lego/init/IdleTaskConfig;", "isDebug", "processMatchMode", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "timeout", "build", "Lcom/bytedance/lego/init/config/TaskConfig;", "enableCatchException", "enable", "setApplicationStartTime", "setCoreThreadNum", "setExecutorService", "setIdleTaskConfig", "setProcessMatchMode", "mode", "setThreadFactory", "setTimeOut", "millis", "initscheduler_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
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
            boolean r2 = this.isDebug;
            Context r3 = this.base;
            ThreadPoolExecutor r5 = this.executor;
            ProcessMatchMode r4 = this.processMatchMode;
            int r7 = this.coreThreadNum;
            return new TaskConfig(r2, r3, r4, r5, this.threadFactory, r7, this.isMainProcess, this.processName, this.timeout, this.catchException, this.applicationStartTime, this.idleTaskConfig, this.agreePrivacyPopupWindow, null);
        }

        public final Builder agreePrivacyPopupWindow(boolean r1) {
            this.agreePrivacyPopupWindow = r1;
            return this;
        }

        public final Builder enableCatchException(boolean r1) {
            this.catchException = r1;
            return this;
        }

        public final Builder isDebug(boolean r1) {
            this.isDebug = r1;
            return this;
        }

        public final Builder setApplicationStartTime(long r1) {
            this.applicationStartTime = r1;
            return this;
        }

        public final Builder setCoreThreadNum(int r1) {
            this.coreThreadNum = r1;
            return this;
        }

        public final Builder setExecutorService(ThreadPoolExecutor r1) {
            this.executor = r1;
            return this;
        }

        public final Builder setIdleTaskConfig(IdleTaskConfig r1) {
            this.idleTaskConfig = r1;
            return this;
        }

        public final Builder setProcessMatchMode(ProcessMatchMode r1) {
            this.processMatchMode = r1;
            return this;
        }

        public final Builder setThreadFactory(ThreadFactory r1) {
            this.threadFactory = r1;
            return this;
        }

        public final Builder setTimeOut(int r2) {
            if (r2 >= 3000) goto L5;
            int r3 = c.a;
            this.timeout = 3000;
        L6:
            return this;
        L5:
            this.timeout = r2;
            goto L6
        }

        public Builder(Context r1, boolean r2, String r3) {
            this.base = r1;
            this.isMainProcess = r2;
            this.processName = r3;
            this.processMatchMode = ProcessMatchMode.CONTAIN;
            this.coreThreadNum = Runtime.getRuntime().availableProcessors();
            this.timeout = 8000;
            IdleTaskConfig.Companion.getClass();
            this.idleTaskConfig = IdleTaskConfig.access$getDEFAULT_IDLETASK_CONFIG$cp();
            this.applicationStartTime = System.currentTimeMillis();
            this.agreePrivacyPopupWindow = true;
        }
    }

    private final ThreadPoolExecutor getDefaultExecutor() {
        int r2 = this.coreThreadNum;
        return new PThreadPoolExecutor(r2, r2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), getThreadFactory());
    }

    private final ThreadFactory getDefaultThreadFactory() {
        return new a();
    }

    private final ThreadFactory getThreadFactory() {
        ThreadFactory r0 = this.threadFactory;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getDefaultThreadFactory();
    }

    public final ThreadPoolExecutor getTaskExecutor() {
        ThreadPoolExecutor r0 = this.taskExecutor;
        if (r0 != null) goto L6;
        r0 = this.executor;
    L6:
        if (r0 == null) goto L9;
        return r0;
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

    public final void setAgreePrivacyPopupWindow(boolean r1) {
        this.agreePrivacyPopupWindow = r1;
    }

    public final void setTaskExecutor(ThreadPoolExecutor r1) {
        this.taskExecutor = r1;
    }

    private TaskConfig(boolean r1, Context r2, ProcessMatchMode r3, ThreadPoolExecutor r4, ThreadFactory r5, int r6, boolean r7, String r8, int r9, boolean r10, long r11, IdleTaskConfig r13, boolean r14) {
        this.isDebug = r1;
        this.base = r2;
        this.mode = r3;
        this.executor = r4;
        this.threadFactory = r5;
        this.coreThreadNum = r6;
        this.isMainProcess = r7;
        this.processName = r8;
        this.timeout = r9;
        this.catchException = r10;
        this.applicationStartTime = r11;
        this.idleTaskConfig = r13;
        this.agreePrivacyPopupWindow = r14;
    }

    public /* synthetic */ TaskConfig(boolean r1, Context r2, ProcessMatchMode r3, ThreadPoolExecutor r4, ThreadFactory r5, int r6, boolean r7, String r8, int r9, boolean r10, long r11, IdleTaskConfig r13, boolean r14, DefaultConstructorMarker r15) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14);
    }

    public /* synthetic */ TaskConfig(boolean r18, Context r19, ProcessMatchMode r20, ThreadPoolExecutor r21, ThreadFactory r22, int r23, boolean r24, String r25, int r26, boolean r28, long r29, IdleTaskConfig r30, boolean r31, int r32, DefaultConstructorMarker r33) {
        if ((r32 & 8) == 0) goto L5;
        ThreadPoolExecutor r6 = null;
    L7:
        if ((r32 & 16) == 0) goto L9;
        ThreadFactory r7 = null;
    L10:
        this(r18, r19, r20, r6, r7, r23, r24, r25, r26, r28, r29, r30, r31);
        return;
    L9:
        r7 = r22;
        goto L10
    L5:
        r6 = r21;
        goto L7
    }
}
