package com.bytedance.frameworks.baselib.network.connectionclass;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceBandwidthSampler {
    private static long sPreviousBytes = -1;
    private final jx5.b mConnectionClassManager;
    private b mHandler;
    private boolean mInvalid;
    private long mLastTimeReading;
    private AtomicInteger mSamplingCounter;
    private HandlerThread mThread;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DeviceBandwidthSampler f244650a = null;

        static {
            f244650a = new DeviceBandwidthSampler(jx5.b.a.f500873a);
        }
    }

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeviceBandwidthSampler f244651a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
        L7:
            th = move-exception;
            th.printStackTrace();
            return;
        L3:
            if (r100.what != 1) goto L12;
            this.f244651a.addSample();     // Catch: Throwable -> L7
            sendEmptyMessageDelayed(1, 1000);     // Catch: Throwable -> L7
            return;
        }

        public b(DeviceBandwidthSampler r100, Looper r101) {
            this.f244651a = r100;
            super(r101);
        }
    }

    public boolean isSampling() {
        if (this.mSamplingCounter.get() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void startSampling() {
        if (this.mInvalid == false) goto L6;
        return;
    L6:
        if (this.mSamplingCounter.getAndIncrement() == 0) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("ConnectionClassManager", "startSampling");     // Catch: Throwable -> L12
    L10:
        this.mHandler.sendEmptyMessage(1);     // Catch: Throwable -> L12
        this.mLastTimeReading = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        return;
    }

    public void stopSampling() {
        if (this.mInvalid == false) goto L6;
        return;
    L6:
        if (this.mSamplingCounter.decrementAndGet() == 0) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("ConnectionClassManager", "stopSampling");     // Catch: Throwable -> L12
    L10:
        this.mHandler.removeMessages(1);     // Catch: Throwable -> L12
        addFinalSample();     // Catch: Throwable -> L12
        return;
    }

    public void addFinalSample() {
        addSample();
        sPreviousBytes = -1;
    }

    public void addSample() {
        long r100 = TrafficStats.getTotalRxBytes();     // Catch: Throwable -> L13
        long r101 = sPreviousBytes;     // Catch: Throwable -> L13
        long r102 = r100 - r101;     // Catch: Throwable -> L13
        if (r101 < 0) goto L11;
        monitor-enter(this);     // Catch: Throwable -> L13
        long r103 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        this.mConnectionClassManager.a(r102, r103 - this.mLastTimeReading);     // Catch: Throwable -> L8
        this.mLastTimeReading = r103;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L11:
        sPreviousBytes = r100;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
    }

    public static DeviceBandwidthSampler getInstance() {
        return a.f244650a;
    }

    public DeviceBandwidthSampler(jx5.b r100) {
        this.mInvalid = false;
        this.mConnectionClassManager = r100;
        this.mSamplingCounter = new AtomicInteger();     // Catch: Throwable -> L5
        HandlerThread r101 = xx5.a.a();     // Catch: Throwable -> L5
        this.mThread = r101;     // Catch: Throwable -> L5
        ThreadMethodProxy.start(r101);     // Catch: Throwable -> L5
        this.mHandler = new b(this, this.mThread.getLooper());     // Catch: Throwable -> L5
        return;
    L5:
        this.mInvalid = true;
    }
}
