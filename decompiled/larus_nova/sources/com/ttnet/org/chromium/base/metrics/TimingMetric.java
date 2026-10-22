package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.TimeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes41.dex */
public class TimingMetric implements AutoCloseable {
    private final String mMetricName;
    private long mStartTime;
    private final int mTimerType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TimerType {
        public static final int MEDIUM_UPTIME = 1;
        public static final int SHORT_THREAD_TIME = 2;
        public static final int SHORT_UPTIME = 0;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        String r100 = this.mMetricName;
        long r101 = this.mStartTime;
        if (r101 != 0) goto L5;
        return;
    L5:
        this.mStartTime = 0;
        int r102 = this.mTimerType;
        if (r102 != 0) goto L8;
        RecordHistogram.recordTimesHistogram(r100, TimeUtils.uptimeMillis() - r101);
        return;
    L8:
        if (r102 != 1) goto L10;
        RecordHistogram.recordMediumTimesHistogram(r100, TimeUtils.uptimeMillis() - r101);
        return;
    L10:
        if (r102 != 2) goto L18;
        RecordHistogram.recordTimesHistogram(r100, TimeUtils.currentThreadTimeMillis() - r101);
        return;
    }

    public static TimingMetric mediumUptime(String r100) {
        TimingMetric r101 = new TimingMetric(r100, 1);
        r101.mStartTime = TimeUtils.uptimeMillis();
        return r101;
    }

    public static TimingMetric shortThreadTime(String r100) {
        TimingMetric r101 = new TimingMetric(r100, 2);
        r101.mStartTime = TimeUtils.currentThreadTimeMillis();
        return r101;
    }

    public static TimingMetric shortUptime(String r100) {
        TimingMetric r101 = new TimingMetric(r100, 0);
        r101.mStartTime = TimeUtils.uptimeMillis();
        return r101;
    }

    private TimingMetric(String r100, int r101) {
        this.mMetricName = r100;
        this.mTimerType = r101;
    }
}
