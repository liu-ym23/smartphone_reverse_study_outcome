package com.ttnet.org.chromium.base.jank_tracker;

import android.view.Window;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes41.dex */
class FrameMetricsListener implements Window.OnFrameMetricsAvailableListener {
    private final FrameMetricsStore mFrameMetricsStore;
    private final AtomicBoolean mIsRecording;

    public FrameMetricsListener(FrameMetricsStore r100) {
        this.mFrameMetricsStore = r100;
        this.mIsRecording = new AtomicBoolean(false);
    }

    public void setIsListenerRecording(boolean r100) {
        this.mIsRecording.set(r100);
    }

    @Override // android.view.Window.OnFrameMetricsAvailableListener
    public void onFrameMetricsAvailable(Window r100, android.view.FrameMetrics r101, int r102) {
        if (this.mIsRecording.get() == true) goto L5;
        return;
    L5:
        long r103 = r101.getMetric(8);
        long r104 = r101.getMetric(10);
        this.mFrameMetricsStore.addFrameMeasurement(r104, r103, r102);
    }
}
