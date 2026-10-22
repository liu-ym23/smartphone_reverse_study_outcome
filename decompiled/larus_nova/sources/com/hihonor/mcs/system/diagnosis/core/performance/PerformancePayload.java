package com.hihonor.mcs.system.diagnosis.core.performance;

import com.hihonor.mcs.system.diagnosis.core.BasePayload;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class PerformancePayload extends BasePayload {
    private static final long serialVersionUID = 8704899546781516578L;
    private List<ActivityStartTimeoutMetric> activityStartTimeoutMetrics;
    private List<AnimationJankFrameMetric> animationJankFrameMetrics;
    private List<AppSkipFrameMetric> appSkipFrameMetrics;
    private List<AppStartupSlowMetric> appStartupSlowMetrics;
    private List<FlingJankFrameMetric> flingJankFrameMetrics;

    public PerformancePayload() {
        this.appStartupSlowMetrics = new ArrayList();
        this.appSkipFrameMetrics = new ArrayList();
        this.animationJankFrameMetrics = new ArrayList();
        this.flingJankFrameMetrics = new ArrayList();
        this.activityStartTimeoutMetrics = new ArrayList();
    }

    public List<ActivityStartTimeoutMetric> getActivityStartTimeoutMetrics() {
        return this.activityStartTimeoutMetrics;
    }

    public List<AnimationJankFrameMetric> getAnimationJankFrameMetrics() {
        return this.animationJankFrameMetrics;
    }

    public List<AppSkipFrameMetric> getAppSkipFrameMetrics() {
        return this.appSkipFrameMetrics;
    }

    public List<AppStartupSlowMetric> getAppStartupSlowMetrics() {
        return this.appStartupSlowMetrics;
    }

    public List<FlingJankFrameMetric> getFlingJankFrameMetrics() {
        return this.flingJankFrameMetrics;
    }

    public void setActivityStartTimeoutMetrics(ArrayList<ActivityStartTimeoutMetric> r100) {
        this.activityStartTimeoutMetrics = r100;
    }

    public void setAnimationJankFrameMetrics(ArrayList<AnimationJankFrameMetric> r100) {
        this.animationJankFrameMetrics = r100;
    }

    public void setAppSkipFrameMetrics(ArrayList<AppSkipFrameMetric> r100) {
        this.appSkipFrameMetrics = r100;
    }

    public void setAppStartupSlowMetrics(ArrayList<AppStartupSlowMetric> r100) {
        this.appStartupSlowMetrics = r100;
    }

    public void setFlingJankFrameMetrics(ArrayList<FlingJankFrameMetric> r100) {
        this.flingJankFrameMetrics = r100;
    }
}
