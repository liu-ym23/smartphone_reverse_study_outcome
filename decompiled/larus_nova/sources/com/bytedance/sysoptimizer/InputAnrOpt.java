package com.bytedance.sysoptimizer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.anr.AnrListener;
import com.bytedance.sysoptimizer.anr.AnrManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class InputAnrOpt {
    private static LaunchActivityLifecycleCallback LaunchActivityLifecycleCallback = null;
    private static final String TAG = "InputAnrOpt";
    private static volatile boolean isRunning;
    static AnrListener mAnrListener;
    private static Timer mFdCheckTimer;
    private static int sAnrLevel;
    private static boolean sAnrOptInited;
    private static Config sConfig;
    static ScheduledExecutorService sExecutor;
    private static int sFd;
    static ScheduledFuture<?> sFuture;
    private static boolean sGetFdRetry;
    public static volatile boolean sGetInputFdSuccess;
    private static HighFrequencyMessageDetector sHighFrequencyMessageDetector;
    private static final Object sMutex = null;
    private static boolean sShadowHookInited;
    private static AtomicInteger safeIntFdCheck;

    /* JADX INFO: renamed from: com.bytedance.sysoptimizer.InputAnrOpt$1, reason: invalid class name */
    public static class AnonymousClass1 implements AnrListener {
        public AnonymousClass1() {
        }

        public static /* synthetic */ void a() {
            lambda$onAnrChange$0();
        }

        private static /* synthetic */ void lambda$onAnrChange$0() {
            InputAnrOpt.access$1600(false);
        }

        @Override // com.bytedance.sysoptimizer.anr.AnrListener
        public void onAnrChange(boolean r100, int r101, AnrManager.AnrReason r102) {
            if (r100 == true) goto L4;
            return;
        L4:
            if (r102.getNewAnrLevel() < InputAnrOpt.access$1500()) goto L16;
            ScheduledFuture<?> r103 = InputAnrOpt.sFuture;
            if (r103 == null) goto L8;
            r103.cancel(false);
        L8:
            InputAnrOpt.access$1600(true);
            if (InputAnrOpt.access$1700() == true) goto L11;
        L13:
            InputAnrOpt.sFuture = InputAnrOpt.sExecutor.schedule(new d(), 500, TimeUnit.MILLISECONDS);
            return;
        L11:
            if (InputAnrOpt.access$1800() == true) goto L13;
            InputAnrOpt.access$1900();
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sysoptimizer.InputAnrOpt$2, reason: invalid class name */
    public static class AnonymousClass2 extends TimerTask {
        public static /* synthetic */ void a() {
            lambda$run$0();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            com_bytedance_sysoptimizer_InputAnrOpt$2_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_bytedance_sysoptimizer_InputAnrOpt$2__run$___twin___() {
            InputAnrOpt.sExecutor.submit(new e());
        }

        private static /* synthetic */ void lambda$run$0() {
            if (InputAnrOpt.access$3500().get() > 0) goto L6;
            InputAnrOpt.access$3100();
            return;
        L6:
            int r100 = InputAnrOpt.access$3300();
            if (r100 != InputAnrOpt.access$3200()) goto L9;
            InputAnrOpt.access$3500().decrementAndGet();
            InputAnrOpt.access$1900();
            return;
        L9:
            InputAnrOpt.access$3200();
            InputAnrOpt.access$3202(r100);
            InputAnrOpt.access$3100();
        }

        public AnonymousClass2() {
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_sysoptimizer_InputAnrOpt$2_com_larus_apm_impl_protector_RunnableLancet_run(AnonymousClass2 r100) {
            r100.com_bytedance_sysoptimizer_InputAnrOpt$2__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class Config {
        private final long mCheckIntervalMs;
        private final boolean mEnableHighFrequentMessageOpt;
        private final boolean mEnableInputStuckOpt;
        private final boolean mEnableJavaStuckOpt;
        private final boolean mEnableTimeoutResend;
        private final boolean mGetFdRetry;
        private final boolean mIsDebug;
        private final int mMessageCountThreshold;
        private final int mPriority;
        private final int mTimeout;

        public static class Builder {
            private long mCheckIntervalMs;
            private boolean mEnableHighFrequentMessageOpt;
            private boolean mEnableInputStuckOpt;
            private boolean mEnableJavaStuckOpt;
            private boolean mEnableTimeoutResend;
            private boolean mGetFdRetry;
            private boolean mIsDebug;
            private int mMessageCountThreshold;
            private int mPriority;
            private int mTimeout;

            public Config build() {
                return new Config(this, null);
            }

            public Builder() {
                this.mTimeout = 3000;
                this.mIsDebug = false;
                this.mPriority = -10;
                this.mGetFdRetry = false;
                this.mEnableInputStuckOpt = false;
                this.mEnableHighFrequentMessageOpt = false;
                this.mMessageCountThreshold = 50;
                this.mCheckIntervalMs = 3000;
                this.mEnableTimeoutResend = false;
                this.mEnableJavaStuckOpt = true;
            }

            public static /* synthetic */ boolean access$1000(Builder r100) {
                return r100.mEnableTimeoutResend;
            }

            public static /* synthetic */ boolean access$1100(Builder r100) {
                return r100.mEnableJavaStuckOpt;
            }

            public static /* synthetic */ int access$200(Builder r100) {
                return r100.mTimeout;
            }

            public static /* synthetic */ boolean access$300(Builder r100) {
                return r100.mIsDebug;
            }

            public static /* synthetic */ int access$400(Builder r100) {
                return r100.mPriority;
            }

            public static /* synthetic */ boolean access$500(Builder r100) {
                return r100.mGetFdRetry;
            }

            public static /* synthetic */ boolean access$600(Builder r100) {
                return r100.mEnableInputStuckOpt;
            }

            public static /* synthetic */ boolean access$700(Builder r100) {
                return r100.mEnableHighFrequentMessageOpt;
            }

            public static /* synthetic */ int access$800(Builder r100) {
                return r100.mMessageCountThreshold;
            }

            public static /* synthetic */ long access$900(Builder r100) {
                return r100.mCheckIntervalMs;
            }

            public Builder setCheckIntervalMs(long r100) {
                this.mCheckIntervalMs = r100;
                return this;
            }

            public Builder setDebug(boolean r100) {
                this.mIsDebug = r100;
                return this;
            }

            public Builder setEnableHighFrequentMessageOpt(boolean r100) {
                this.mEnableHighFrequentMessageOpt = r100;
                return this;
            }

            public Builder setEnableInputStuckOpt(boolean r100) {
                this.mEnableInputStuckOpt = r100;
                return this;
            }

            public Builder setEnableJavaStuckOpt(boolean r100) {
                this.mEnableJavaStuckOpt = r100;
                return this;
            }

            public Builder setEnableTimeoutResend(boolean r100) {
                this.mEnableTimeoutResend = r100;
                return this;
            }

            public Builder setGetFdRetry(boolean r100) {
                this.mGetFdRetry = r100;
                return this;
            }

            public Builder setMessageCountThreshold(int r100) {
                this.mMessageCountThreshold = r100;
                return this;
            }

            public Builder setPriority(int r100) {
                this.mPriority = r100;
                return this;
            }

            public Builder setTimeout(int r100) {
                if (r100 <= 0) goto L8;
                if (r100 >= 5000) goto L8;
                this.mTimeout = r100;
                return this;
            L8:
                throw new IllegalArgumentException("timeout must be in (0, 5000)ms");
            }
        }

        private Config(Builder r100) {
            this.mTimeout = Builder.access$200(r100);
            this.mIsDebug = Builder.access$300(r100);
            this.mPriority = Builder.access$400(r100);
            this.mGetFdRetry = Builder.access$500(r100);
            this.mEnableInputStuckOpt = Builder.access$600(r100);
            this.mEnableHighFrequentMessageOpt = Builder.access$700(r100);
            this.mMessageCountThreshold = Builder.access$800(r100);
            this.mCheckIntervalMs = Builder.access$900(r100);
            this.mEnableTimeoutResend = Builder.access$1000(r100);
            this.mEnableJavaStuckOpt = Builder.access$1100(r100);
        }

        public static /* synthetic */ int access$1300(Config r100) {
            return r100.mTimeout;
        }

        public static /* synthetic */ boolean access$1400(Config r100) {
            return r100.mGetFdRetry;
        }

        public static /* synthetic */ boolean access$2000(Config r100) {
            return r100.mIsDebug;
        }

        public static /* synthetic */ int access$2100(Config r100) {
            return r100.mPriority;
        }

        public static /* synthetic */ boolean access$2200(Config r100) {
            return r100.mEnableInputStuckOpt;
        }

        public static /* synthetic */ boolean access$2300(Config r100) {
            return r100.mEnableHighFrequentMessageOpt;
        }

        public static /* synthetic */ boolean access$2400(Config r100) {
            return r100.mEnableTimeoutResend;
        }

        public static /* synthetic */ boolean access$2500(Config r100) {
            return r100.mEnableJavaStuckOpt;
        }

        public static /* synthetic */ int access$2600(Config r100) {
            return r100.mMessageCountThreshold;
        }

        public static /* synthetic */ long access$2700(Config r100) {
            return r100.mCheckIntervalMs;
        }

        public /* synthetic */ Config(Builder r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public static class HighFrequencyMessageDetector {
        private boolean mFieldResolved;
        private ScheduledFuture<?> mFuture;
        private boolean mIsHigh;
        private Field mMessagesField;
        private Field mNextField;
        private ScheduledExecutorService mScheduler;

        public static /* synthetic */ void a(HighFrequencyMessageDetector r100, int r101) {
            r100.lambda$start$0(r101);
        }

        public void stop() {
            ScheduledFuture<?> r100 = this.mFuture;
            if (r100 == null) goto L5;
            r100.cancel(false);
            this.mFuture = null;
        L5:
            ScheduledExecutorService r101 = this.mScheduler;
            if (r101 == null) goto L11;
            if (r101.isShutdown() == true) goto L11;
            this.mScheduler.shutdown();
            this.mScheduler = null;
        L11:
            if (this.mIsHigh == false) goto L14;
            InputAnrOpt.access$000(false);
            this.mIsHigh = false;
            return;
        }

        private HighFrequencyMessageDetector() {
            this.mFieldResolved = false;
            this.mIsHigh = false;
        }

        public /* synthetic */ HighFrequencyMessageDetector(AnonymousClass1 r100) {
            this();
        }

        private boolean isHighFrequentMessage(int r100) {
            if (this.mFieldResolved == true) goto L11;
            Field r101 = MessageQueue.class.getDeclaredField("mMessages");     // Catch: Throwable -> L6 NoSuchFieldException -> L22
            this.mMessagesField = r101;     // Catch: Throwable -> L6 NoSuchFieldException -> L22
            r101.setAccessible(true);     // Catch: Throwable -> L6 NoSuchFieldException -> L22
            Field r102 = Message.class.getDeclaredField(TeaEventTrack.ACTION_DRAMA_NEXT);     // Catch: Throwable -> L6 NoSuchFieldException -> L22
            this.mNextField = r102;     // Catch: Throwable -> L6 NoSuchFieldException -> L22
            r102.setAccessible(true);     // Catch: Throwable -> L6 NoSuchFieldException -> L22
        L6:
            th = move-exception;
            this.mFieldResolved = true;
            throw th;
        L9:
            this.mFieldResolved = true;
        L11:
            if (this.mMessagesField != null) goto L13;
        L20:
            return false;
        L13:
            if (this.mNextField == null) goto L20;
            MessageQueue r103 = Looper.getMainLooper().getQueue();     // Catch: Exception -> L21
            Message r104 = (Message) this.mMessagesField.get(r103);     // Catch: Exception -> L21
            int r105 = 0;
        L16:
            if (r104 == null) goto L20;
            r105 = r105 + 1;     // Catch: Exception -> L21
            r104 = (Message) this.mNextField.get(r104);     // Catch: Exception -> L21
            if (r105 < r100) goto L16;
            return true;
        }

        private /* synthetic */ void lambda$start$0(int r100) {
            if (isHighFrequentMessage(r100) == false) goto L8;
            if (this.mIsHigh == true) goto L11;
            this.mIsHigh = true;
            InputAnrOpt.access$000(true);
            return;
        L11:
            return;
        L8:
            if (this.mIsHigh == false) goto L13;
            this.mIsHigh = false;
            InputAnrOpt.access$000(false);
            return;
        }

        public void start(final int r100, long r110) {
            ScheduledExecutorService r101 = this.mScheduler;
            if (r101 != null) goto L5;
        L6:
            this.mScheduler = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("InputAnrOpt$HighFrequencyMessageDetector"));
        L7:
            ScheduledFuture<?> r102 = this.mFuture;
            if (r102 != null) goto L10;
        L11:
            this.mFuture = this.mScheduler.scheduleAtFixedRate(new f(this, r100), 0, r110, TimeUnit.MILLISECONDS);
            return;
        L10:
            if (r102.isDone() == true) goto L11;
            return;
        L5:
            if (r101.isShutdown() == false) goto L7;
            goto L6
        }
    }

    public static class LaunchActivityLifecycleCallback implements Application.ActivityLifecycleCallbacks {
        public LaunchActivityLifecycleCallback() {
        }

        public static /* synthetic */ void a() {
            lambda$onActivityPaused$1();
        }

        public static /* synthetic */ void b() {
            lambda$onActivityResumed$0();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r100) {
        }

        private static /* synthetic */ void lambda$onActivityPaused$1() {
            if (InputAnrOpt.access$2900() != null) goto L5;
        L7:
            InputAnrOpt.access$3100();
            return;
        L5:
            if (Config.access$2300(InputAnrOpt.access$2900()) == false) goto L7;
            InputAnrOpt.access$3000().stop();
            goto L7
        }

        private static /* synthetic */ void lambda$onActivityResumed$0() {
            InputAnrOpt.access$3202(InputAnrOpt.access$3300());
            InputAnrOpt.access$1900();
            if (InputAnrOpt.access$1700() == false) goto L23;
            int r100 = 5;
        L5:
            if (r100 <= 0) goto L15;
            r100 = r100 - 1;
            int r101 = InputAnrOpt.access$3300();
            if (r101 != InputAnrOpt.access$3200()) goto L14;
            Thread.sleep(1000);     // Catch: InterruptedException -> L11
            InputAnrOpt.access$1900();
        L11:
            e = move-exception;
            throw new RuntimeException(e);
        L14:
            InputAnrOpt.access$3200();
            InputAnrOpt.access$3202(r101);
            boolean r102 = true;
        L16:
            if (r102 == true) goto L24;
            InputAnrOpt.access$3400();
            return;
        L24:
            return;
        L15:
            r102 = false;
            goto L16
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r100) {
            InputAnrOpt.access$2800(true);
            InputAnrOpt.sExecutor.submit(new g());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r100) {
            InputAnrOpt.access$2800(false);
            if (InputAnrOpt.access$2900() != null) goto L5;
        L7:
            InputAnrOpt.sExecutor.submit(new h());
            return;
        L5:
            if (Config.access$2300(InputAnrOpt.access$2900()) == false) goto L7;
            InputAnrOpt.access$3000().start(Config.access$2600(InputAnrOpt.access$2900()), Config.access$2700(InputAnrOpt.access$2900()));
            goto L7
        }
    }

    public InputAnrOpt() {
    }

    public static /* synthetic */ void a() {
        lambda$startAnrOpt$0();
    }

    public static native boolean corruptInputFdOnce();

    private static native int getFDValue();

    private static native boolean getSocketFd();

    private static native boolean init(int r100, int r101, boolean r102, int r103, boolean r104, boolean r105, boolean r106, boolean r107);

    private static native boolean isInputFdGetSucess();

    private static native void setActivityPaused(boolean r100);

    private static native boolean setEnableInputStuckOpt(boolean r100);

    private static native void setHighFrequentMessageFlag(boolean r100);

    private static native void setStuckFlag(boolean r100);

    private static native void setTimeOut(int r100);

    private static native boolean stopOpt();

    static {
        sHighFrequencyMessageDetector = new HighFrequencyMessageDetector(null);
        sShadowHookInited = false;
        sAnrOptInited = false;
        sAnrLevel = 2;
        sMutex = new Object();
        sGetInputFdSuccess = false;
        safeIntFdCheck = new AtomicInteger(0);
        sFd = -1;
        isRunning = false;
        sExecutor = PThreadExecutorsUtils.newScheduledThreadPool(1, new DefaultThreadFactory("r/InputAnrOpt"));
        LaunchActivityLifecycleCallback = new LaunchActivityLifecycleCallback();
        sFuture = null;
        sGetFdRetry = false;
        sConfig = null;
        mAnrListener = new AnonymousClass1();
    }

    private static boolean isTargetOSVersion() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 24) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 35) goto L7;
        return true;
    }

    private static /* synthetic */ void lambda$startAnrOpt$0() {
        Object r100 = sMutex;
        monitor-enter(r100);
        getSocketFd();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void startAnrOpt() {
        sExecutor.submit(new c());
    }

    private static synchronized void startFdChecking() {
        monitor-enter(InputAnrOpt.class);
        stopFdChecking();     // Catch: Throwable -> L7
        safeIntFdCheck.set(5);     // Catch: Throwable -> L7
        PthreadTimer r100 = new PthreadTimer("FdCheckTimer");     // Catch: Throwable -> L7
        mFdCheckTimer = r100;     // Catch: Throwable -> L7
        r100.schedule(new AnonymousClass2(), 0, 2000);     // Catch: Throwable -> L7
        monitor-exit(InputAnrOpt.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static synchronized void stopFdChecking() {
        monitor-enter(InputAnrOpt.class);
        Timer r100 = mFdCheckTimer;     // Catch: Throwable -> L8 Exception -> L10
        if (r100 == null) goto L12;
        r100.cancel();     // Catch: Throwable -> L8 Exception -> L10
        mFdCheckTimer.purge();     // Catch: Throwable -> L8 Exception -> L10
        mFdCheckTimer = null;     // Catch: Throwable -> L8 Exception -> L10
    L12:
        monitor-exit(InputAnrOpt.class);
        return;
    L8:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        e.getMessage();     // Catch: Throwable -> L8
        goto L12
    }

    public static /* synthetic */ boolean access$1800() {
        return isInputFdGetSucess();
    }

    public static /* synthetic */ boolean access$1900() {
        return getSocketFd();
    }

    public static /* synthetic */ int access$3300() {
        return getFDValue();
    }

    public static /* synthetic */ int access$1500() {
        return sAnrLevel;
    }

    public static /* synthetic */ boolean access$1700() {
        return sGetFdRetry;
    }

    public static /* synthetic */ Config access$2900() {
        return sConfig;
    }

    public static /* synthetic */ HighFrequencyMessageDetector access$3000() {
        return sHighFrequencyMessageDetector;
    }

    public static /* synthetic */ void access$3100() {
        stopFdChecking();
    }

    public static /* synthetic */ int access$3200() {
        return sFd;
    }

    public static /* synthetic */ void access$3400() {
        startFdChecking();
    }

    public static /* synthetic */ AtomicInteger access$3500() {
        return safeIntFdCheck;
    }

    public static /* synthetic */ void access$000(boolean r100) {
        setHighFrequentMessageFlag(r100);
    }

    public static /* synthetic */ void access$1600(boolean r100) {
        setStuckFlag(r100);
    }

    public static /* synthetic */ void access$2800(boolean r100) {
        setActivityPaused(r100);
    }

    public static /* synthetic */ int access$3202(int r100) {
        sFd = r100;
        return r100;
    }

    public static void setAnrLevel(int r100) {
        if (r100 < 2000) goto L6;
        sAnrLevel = r100 / 1000;
        setTimeOut(r100);
        return;
    }

    public static boolean inputAnrInit(Context r110, Config r111) {
        sConfig = r111;
        Object r100 = sMutex;
        monitor-enter(r100);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (sShadowHookInited == false) goto L10;
        boolean r112 = sAnrOptInited;     // Catch: Throwable -> L30
        monitor-exit(r100);     // Catch: Throwable -> L30
        return r112;
    L10:
        if (isTargetOSVersion() == true) goto L34;
        boolean r113 = sAnrOptInited;     // Catch: Throwable -> L30
        monitor-exit(r100);     // Catch: Throwable -> L30
        return r113;
    L34:
    L25:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L30
        sAnrOptInited = false;     // Catch: Throwable -> L30
    L27:
        monitor-exit(r100);     // Catch: Throwable -> L30
        return sAnrOptInited;
    L16:
        if (SysOptimizer.loadOptimizerLibrary(r110) == false) goto L18;
        ShadowHook.access$000();     // Catch: Throwable -> L25
        ShadowHook.access$100();     // Catch: Throwable -> L25
        int r101 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L25
        ShadowHook.b r102 = new ShadowHook.b();     // Catch: Throwable -> L25
        r102.f270294a = r101;     // Catch: Throwable -> L25
        r102.f270295b = true;     // Catch: Throwable -> L25
        r102.f270296c = false;     // Catch: Throwable -> L25
        r102.f270297d = false;     // Catch: Throwable -> L25
        ShadowHook.init(r102);     // Catch: Throwable -> L25
        sShadowHookInited = true;     // Catch: Throwable -> L25
    L18:
        sAnrOptInited = init(Build.VERSION.SDK_INT, Config.access$1300(r111), Config.access$2000(r111), Config.access$2100(r111), Config.access$2200(r111), Config.access$2300(r111), Config.access$2400(r111), Config.access$2500(r111));     // Catch: Throwable -> L25
        Config.access$2000(r111);     // Catch: Throwable -> L25
        Config.access$2100(r111);     // Catch: Throwable -> L25
        ((Application) r110.getApplicationContext()).registerActivityLifecycleCallbacks(LaunchActivityLifecycleCallback);     // Catch: Throwable -> L25
        AnrManager.getInstance().registerListener(mAnrListener);     // Catch: Throwable -> L25
        if (r111 != null) goto L21;
    L23:
        startAnrOpt();     // Catch: Throwable -> L25
    L21:
        if (Config.access$2300(r111) == false) goto L23;
        sHighFrequencyMessageDetector.start(Config.access$2600(r111), Config.access$2700(r111));     // Catch: Throwable -> L25
        goto L23
    }

    public static boolean inputAnrOptStart(Context r100, Config r101) {
        if (Config.access$1300(r101) < 2000) goto L5;
        sAnrLevel = Config.access$1300(r101) / 1000;
    L5:
        sGetFdRetry = Config.access$1400(r101);
        return inputAnrInit(r100, r101);
    }
}
