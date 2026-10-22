package com.facebook.battery.metrics.core;

import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.core.SystemMetricsCollector;

/* JADX INFO: loaded from: classes22.dex */
public class StatefulSystemMetricsCollector<R extends SystemMetrics<R>, S extends SystemMetricsCollector<R>> {
    private final S mCollector;
    private R mCurr;
    private final R mDiff;
    private boolean mIsValid;
    private R mPrev;

    public R getLatestDiff() {
        boolean r100 = this.mIsValid & this.mCollector.getSnapshot(this.mCurr);
        this.mIsValid = r100;
        if (r100 == true) goto L6;
        return null;
    L6:
        this.mCurr.diff(this.mPrev, this.mDiff);
        return this.mDiff;
    }

    public R getLatestDiffAndReset() {
        if (getLatestDiff() != null) goto L6;
        return null;
    L6:
        R r100 = this.mPrev;
        this.mPrev = this.mCurr;
        this.mCurr = r100;
        return this.mDiff;
    }

    public S getCollector() {
        return this.mCollector;
    }

    public StatefulSystemMetricsCollector(S r100) {
        this(r100, r100.createMetrics(), r100.createMetrics(), r100.createMetrics());
        boolean r101 = this.mIsValid;
        this.mIsValid = r100.getSnapshot(this.mPrev) & r101;
    }

    public StatefulSystemMetricsCollector(S r100, R r101, R r102, R r103) {
        this.mIsValid = true;
        this.mCollector = r100;
        this.mCurr = r101;
        this.mPrev = r102;
        this.mDiff = r103;
    }
}
