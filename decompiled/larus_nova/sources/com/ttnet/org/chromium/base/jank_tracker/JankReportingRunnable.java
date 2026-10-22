package com.ttnet.org.chromium.base.jank_tracker;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
class JankReportingRunnable implements Runnable {
    private final boolean mIsStartingTracking;
    private final FrameMetricsStore mMetricsStore;
    private final int mScenario;

    @Override // java.lang.Runnable
    public void run() {
        com_ttnet_org_chromium_base_jank_tracker_JankReportingRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_ttnet_org_chromium_base_jank_tracker_JankReportingRunnable__run$___twin___() {
        if (this.mIsStartingTracking == false) goto L5;
        this.mMetricsStore.startTrackingScenario(this.mScenario);
        return;
    L5:
        FrameMetrics r100 = this.mMetricsStore.stopTrackingScenario(this.mScenario);
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.timestampsNs.length == 0) goto L14;
        JankMetricUMARecorderJni.get();
        JankMetricUMARecorder.recordJankMetricsToUMA(JankMetricCalculator.calculateJankMetrics(r100), this.mScenario);
        return;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ttnet_org_chromium_base_jank_tracker_JankReportingRunnable_com_larus_apm_impl_protector_RunnableLancet_run(JankReportingRunnable r100) {
        r100.com_ttnet_org_chromium_base_jank_tracker_JankReportingRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public JankReportingRunnable(FrameMetricsStore r100, int r101, boolean r102) {
        this.mMetricsStore = r100;
        this.mScenario = r101;
        this.mIsStartingTracking = r102;
    }
}
