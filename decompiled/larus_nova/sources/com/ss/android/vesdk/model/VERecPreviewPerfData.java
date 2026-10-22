package com.ss.android.vesdk.model;

/* JADX INFO: loaded from: classes40.dex */
public class VERecPreviewPerfData {
    public float avgCostOfCamPreviewFirstNFrameInMS;
    public float avgCostOfPreviewFirstNFrameInMS;
    public float previewAvgRenderFps;
    public int previewLagCount;
    public int previewLagTotalDuration;
    public float previewRenderFps;
    public int previewSeriousLagCount;
    public int previewSubLagCount;
    public float previewSubRenderFps;

    public String toString() {
        return "VERecPreviewPerfData{previewLagCount=" + this.previewLagCount + ", previewSeriousLagCount=" + this.previewSeriousLagCount + ", previewSubLagCount=" + this.previewSubLagCount + ", previewLagTotalDuration=" + this.previewLagTotalDuration + ", previewRenderFps=" + this.previewRenderFps + ", previewAvgRenderFps=" + this.previewAvgRenderFps + ", previewSubRenderFps=" + this.previewSubRenderFps + ", avgCostOfCamPreviewFirstNFrameInMS=" + this.avgCostOfCamPreviewFirstNFrameInMS + ", avgCostOfPreviewFirstNFrameInMS=" + this.avgCostOfPreviewFirstNFrameInMS + '}';
    }

    public VERecPreviewPerfData() {
        this.previewLagCount = 0;
        this.previewSeriousLagCount = 0;
        this.previewSubLagCount = 0;
        this.previewLagTotalDuration = 0;
        this.previewRenderFps = 0.0f;
        this.previewAvgRenderFps = 0.0f;
        this.previewSubRenderFps = 0.0f;
        this.avgCostOfCamPreviewFirstNFrameInMS = -1.0f;
        this.avgCostOfPreviewFirstNFrameInMS = -1.0f;
    }
}
