package com.ss.android.vesdk.model;

/* JADX INFO: loaded from: classes40.dex */
public class VERecPerformanceData {
    public float avgCostOfRecFirstNFrameInMS;
    public int countOfLastFragFrames;
    public float recordAvgRenderFps;
    public int recordLagCount;
    public int recordLagTotalDuration;
    public float recordRenderFps;
    public int recordSeriousLagCount;
    public float recordWriteFps;

    public String toString() {
        return "VERecPerformanceData{recordLagCount=" + this.recordLagCount + ", recordSeriousLagCount=" + this.recordSeriousLagCount + ", recordLagTotalDuration=" + this.recordLagTotalDuration + ", countOfLastFragFrames=" + this.countOfLastFragFrames + ", avgCostOfRecFirstNFrameInMS=" + this.avgCostOfRecFirstNFrameInMS + ", recordRenderFps=" + this.recordRenderFps + ", recordWriteFps=" + this.recordWriteFps + ", recordAvgRenderFps=" + this.recordAvgRenderFps + '}';
    }

    public VERecPerformanceData() {
        this.recordLagCount = 0;
        this.recordSeriousLagCount = 0;
        this.recordLagTotalDuration = 0;
        this.countOfLastFragFrames = 0;
        this.avgCostOfRecFirstNFrameInMS = -1.0f;
        this.recordRenderFps = 0.0f;
        this.recordWriteFps = 0.0f;
        this.recordAvgRenderFps = 0.0f;
    }
}
