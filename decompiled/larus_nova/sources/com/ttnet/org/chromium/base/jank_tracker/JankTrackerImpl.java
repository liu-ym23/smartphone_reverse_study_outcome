package com.ttnet.org.chromium.base.jank_tracker;

import android.app.Activity;
import android.os.Build;

/* JADX INFO: loaded from: classes41.dex */
public class JankTrackerImpl implements JankTracker {
    private static final boolean IS_TRACKING_ENABLED = false;
    private final JankActivityTracker mActivityTracker;
    private final JankReportingScheduler mReportingScheduler;

    static {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        boolean r100 = true;
    L6:
        IS_TRACKING_ENABLED = r100;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public void destroy() {
        if (IS_TRACKING_ENABLED == true) goto L5;
        return;
    L5:
        this.mActivityTracker.destroy();
    }

    public JankTrackerImpl(Activity r100) {
        if (IS_TRACKING_ENABLED == true) goto L6;
        this.mActivityTracker = null;
        this.mReportingScheduler = null;
        return;
    L6:
        FrameMetricsStore r101 = new FrameMetricsStore();
        FrameMetricsListener r102 = new FrameMetricsListener(r101);
        this.mReportingScheduler = new JankReportingScheduler(r101);
        JankActivityTracker r103 = new JankActivityTracker(r100, r102, this.mReportingScheduler);
        this.mActivityTracker = r103;
        r103.initialize();
    }

    @Override // com.ttnet.org.chromium.base.jank_tracker.JankTracker
    public void finishTrackingScenario(int r100) {
        if (IS_TRACKING_ENABLED == true) goto L5;
        return;
    L5:
        this.mReportingScheduler.finishTrackingScenario(r100);
    }

    @Override // com.ttnet.org.chromium.base.jank_tracker.JankTracker
    public void startTrackingScenario(int r100) {
        if (IS_TRACKING_ENABLED == true) goto L5;
        return;
    L5:
        this.mReportingScheduler.startTrackingScenario(r100);
    }
}
