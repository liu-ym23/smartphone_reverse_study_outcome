package com.ttnet.org.chromium.base.jank_tracker;

import android.os.Handler;
import android.os.HandlerThread;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ttnet.org.chromium.base.TraceEvent;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes41.dex */
class JankReportingScheduler {
    private static final long PERIODIC_METRIC_DELAY_MS = 30000;
    private static final long TRACE_EVENT_TRACK_ID = 84186319646187624L;
    private final FrameMetricsStore mFrameMetricsStore;
    private Handler mHandler;
    protected HandlerThread mHandlerThread;
    private final AtomicBoolean mIsPeriodicReporterLooping;
    private final Runnable mPeriodicMetricReporter;

    public Handler getOrCreateHandler() {
        if (this.mHandler != null) goto L6;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("Jank-Tracker");
        this.mHandlerThread = r100;
        ThreadMethodProxy.start(r100);
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    L6:
        return this.mHandler;
    }

    public void startReportingPeriodicMetrics() {
        if (this.mIsPeriodicReporterLooping.getAndSet(true) == false) goto L5;
        return;
    L5:
        startTrackingScenario(1);
        getOrCreateHandler().postDelayed(this.mPeriodicMetricReporter, 30000);
    }

    public void stopReportingPeriodicMetrics() {
        if (this.mIsPeriodicReporterLooping.getAndSet(false) == true) goto L5;
        return;
    L5:
        getOrCreateHandler().removeCallbacks(this.mPeriodicMetricReporter);
        getOrCreateHandler().post(this.mPeriodicMetricReporter);
    }

    public JankReportingScheduler(FrameMetricsStore r100) {
        this.mPeriodicMetricReporter = new AnonymousClass1(this);
        this.mIsPeriodicReporterLooping = new AtomicBoolean(false);
        this.mFrameMetricsStore = r100;
    }

    public static /* synthetic */ AtomicBoolean access$000(JankReportingScheduler r100) {
        return r100.mIsPeriodicReporterLooping;
    }

    public static /* synthetic */ Runnable access$100(JankReportingScheduler r100) {
        return r100.mPeriodicMetricReporter;
    }

    public void finishTrackingScenario(int r100) {
        TraceEvent.finishAsync("JankCUJ:" + JankMetricUMARecorder.scenarioToString(r100), ((long) r100) + TRACE_EVENT_TRACK_ID);
        getOrCreateHandler().post(new JankReportingRunnable(this.mFrameMetricsStore, r100, false));
    }

    public void startTrackingScenario(int r100) {
        TraceEvent.startAsync("JankCUJ:" + JankMetricUMARecorder.scenarioToString(r100), ((long) r100) + TRACE_EVENT_TRACK_ID);
        getOrCreateHandler().post(new JankReportingRunnable(this.mFrameMetricsStore, r100, true));
    }
}
