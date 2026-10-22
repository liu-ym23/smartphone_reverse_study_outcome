package com.ttnet.org.chromium.base.jank_tracker;

import android.app.Activity;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.ttnet.org.chromium.base.lifetime.DestroyChecker;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes41.dex */
class JankActivityTracker implements ApplicationStatus.ActivityStateListener {
    private WeakReference<Activity> mActivityReference;
    private final DestroyChecker mDestroyChecker;
    private final FrameMetricsListener mFrameMetricsListener;
    private final JankReportingScheduler mReportingScheduler;
    private final ThreadUtils.ThreadChecker mThreadChecker;

    private void assertValidState() {
        this.mThreadChecker.assertOnValidThread();
        this.mDestroyChecker.checkNotDestroyed();
    }

    public void destroy() {
        this.mThreadChecker.assertOnValidThread();
        ApplicationStatus.unregisterActivityStateListener(this);
        stopMetricRecording();
        stopReportingTimer();
        Activity r100 = this.mActivityReference.get();
        if (r100 == null) goto L5;
        r100.getWindow().removeOnFrameMetricsAvailableListener(this.mFrameMetricsListener);
    L5:
        this.mDestroyChecker.destroy();
    }

    private void startMetricRecording() {
        assertValidState();
        this.mFrameMetricsListener.setIsListenerRecording(true);
    }

    private void startReportingTimer() {
        assertValidState();
        this.mReportingScheduler.startReportingPeriodicMetrics();
    }

    private void stopMetricRecording() {
        assertValidState();
        this.mFrameMetricsListener.setIsListenerRecording(false);
    }

    private void stopReportingTimer() {
        assertValidState();
        this.mReportingScheduler.stopReportingPeriodicMetrics();
    }

    public void initialize() {
        assertValidState();
        Activity r100 = this.mActivityReference.get();
        if (r100 == null) goto L6;
        ApplicationStatus.registerStateListenerForActivity(this, r100);
        onActivityStateChange(r100, ApplicationStatus.getStateForActivity(r100));
        r100.getWindow().addOnFrameMetricsAvailableListener(this.mFrameMetricsListener, this.mReportingScheduler.getOrCreateHandler());
        return;
    }

    @Override // com.ttnet.org.chromium.base.ApplicationStatus.ActivityStateListener
    public void onActivityStateChange(Activity r100, int r101) {
        assertValidState();
        if (r101 != 2) goto L5;
    L13:
        startReportingTimer();
        startMetricRecording();
        return;
    L5:
        if (r101 == 3) goto L13;
        if (r101 != 4) goto L9;
        startReportingTimer();
        stopMetricRecording();
        return;
    L9:
        if (r101 != 5) goto L17;
        stopMetricRecording();
        stopReportingTimer();
        return;
    }

    public JankActivityTracker(Activity r100, FrameMetricsListener r101, JankReportingScheduler r102) {
        this.mThreadChecker = new ThreadUtils.ThreadChecker();
        this.mDestroyChecker = new DestroyChecker();
        this.mActivityReference = new WeakReference(r100);
        this.mFrameMetricsListener = r101;
        this.mReportingScheduler = r102;
    }
}
