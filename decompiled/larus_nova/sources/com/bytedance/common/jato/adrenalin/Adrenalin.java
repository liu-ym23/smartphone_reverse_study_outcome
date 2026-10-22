package com.bytedance.common.jato.adrenalin;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.common.jato.JatoListener;
import com.bytedance.common.jato.JatoXL;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes15.dex */
public class Adrenalin {
    private Application application;
    private long deadThreshold;
    private long maxThreshold;
    private long minThreshold;
    private Handler sAdrenalinHandler;
    private HandlerThread sAdrenalinHandlerThread;
    private boolean sInitReady;
    private JatoListener sJatoListener;
    private long sLastStartTimeStamp;
    private AdrenalinStatus sStatus;

    public static class AdrenalinConfig {
        public static long sDeadThreshold = -1;
        public static long sMaxThreshold = -1;
        public static long sMinThreshold = -1;
    }

    public static class Builder {
        private Application sApplication;
        private long sDeadThreshold;
        private long sMaxThreshold;
        private long sMinThreshold;

        public Adrenalin build() {
            if (this.sDeadThreshold >= 0) goto L6;
            this.sDeadThreshold = this.sMaxThreshold * 2;
        L6:
            return new Adrenalin(this.sApplication, this.sMinThreshold, this.sMaxThreshold, this.sDeadThreshold, null);
        }

        public Builder() {
            this.sMinThreshold = 2000;
            this.sMaxThreshold = 5000;
            this.sDeadThreshold = -1;
        }

        public Builder setApplication(Application r100) {
            this.sApplication = r100;
            return this;
        }

        public Builder setDeadThreshold(long r100) {
            if (r100 <= 0) goto L5;
            this.sDeadThreshold = r100;
        L5:
            return this;
        }

        public Builder setMaxThreshold(long r100) {
            if (r100 <= 0) goto L5;
            this.sMaxThreshold = r100;
        L5:
            return this;
        }

        public Builder setMinThreshold(long r100) {
            if (r100 <= 0) goto L5;
            this.sMinThreshold = r100;
        L5:
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private void startReal() {
        this.sJatoListener.onDebugInfo("real start with status = " + this.sStatus.name());
        this.sAdrenalinHandler.removeMessages(AdrenalinMessage.FORCE_STOP.value);
        this.sAdrenalinHandler.removeMessages(AdrenalinMessage.STOP.value);
        if (this.sStatus != AdrenalinStatus.STOPPED) goto L11;
        this.sLastStartTimeStamp = SystemClock.elapsedRealtime();     // Catch: Throwable -> L6
        JatoXL.tryCpuBoost(this.maxThreshold);     // Catch: Throwable -> L6
        JatoXL.tryGpuBoost(this.maxThreshold);     // Catch: Throwable -> L6
        JatoXL.startBlockGc(Adrenalin.class.getCanonicalName());     // Catch: Throwable -> L6
        JatoXL.boostRenderThread(this.application, -20);     // Catch: Throwable -> L6
        this.sStatus = AdrenalinStatus.RUNNNING;     // Catch: Throwable -> L6
        this.sJatoListener.onDebugInfo("real start success");     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        this.sJatoListener.onErrorInfo("startReal failed", th);
        return;
    }

    private void stopReal() {
        this.sJatoListener.onDebugInfo("real stop with status = " + this.sStatus.name());
        if (this.sStatus != AdrenalinStatus.RUNNNING) goto L11;
        JatoXL.releaseBoost();     // Catch: Throwable -> L6
        JatoXL.stopBlockGc(Adrenalin.class.getCanonicalName());     // Catch: Throwable -> L6
        JatoXL.boostRenderThread(this.application, 19);     // Catch: Throwable -> L6
        this.sJatoListener.onDebugInfo("real stop success");     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        this.sJatoListener.onErrorInfo("stopReal failed", th);
        return;
    }

    public synchronized void init() {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (JatoXL.isInited() == true) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (this.sInitReady == false) goto L14;
        this.sJatoListener.onDebugInfo("Adrenalin has already inited");     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L14:
        if (JatoXL.getConfig().isDebug() == false) goto L16;
        this.sJatoListener = new AnonymousClass2(this);     // Catch: Throwable -> L19
    L16:
        this.sJatoListener.onDebugInfo("init with isDebug = " + JatoXL.getConfig().isDebug());     // Catch: Throwable -> L19
        this.sInitReady = false;     // Catch: Throwable -> L19
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("adrenalin");     // Catch: Throwable -> L19
        this.sAdrenalinHandlerThread = r100;     // Catch: Throwable -> L19
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L19
        final Looper r101 = this.sAdrenalinHandlerThread.getLooper();     // Catch: Throwable -> L19
        this.sAdrenalinHandler = new AnonymousClass3(this, r101);     // Catch: Throwable -> L19
        this.sInitReady = true;     // Catch: Throwable -> L19
        this.sJatoListener.onDebugInfo("Adrenalin init end");     // Catch: Throwable -> L19
        monitor-exit(this);
    }

    public static /* synthetic */ JatoListener access$000(Adrenalin r100) {
        return r100.sJatoListener;
    }

    public static /* synthetic */ void access$100(Adrenalin r100) {
        r100.startReal();
    }

    public static /* synthetic */ void access$200(Adrenalin r100) {
        r100.stopReal();
    }

    private Adrenalin(Application r100, long r101, long r102, long r103) {
        this.sStatus = AdrenalinStatus.STOPPED;
        this.sLastStartTimeStamp = -1;
        this.sInitReady = false;
        this.sJatoListener = new AnonymousClass1(this);
        this.application = r100;
        this.minThreshold = r101;
        this.maxThreshold = r102;
        this.deadThreshold = r103;
    }

    public /* synthetic */ Adrenalin(Application r100, long r101, long r102, long r103, AnonymousClass1 r104) {
        this(r100, r101, r102, r103);
    }
}
