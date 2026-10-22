package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public class VECameraFrameTime {
    public float avgCameraToEffectStart;
    public float avgEffectEndToDraw;
    public float avgEffectStartToEffectEnd;
    public float avgWait;
    public long frameCount;
    public float frameRenderCost;

    public String toString() {
        return "VECameraFrameTime{avgCameraToEffectStart=" + this.avgCameraToEffectStart + ", avgEffectStartToEffectEnd=" + this.avgEffectStartToEffectEnd + ", avgEffectEndToDraw=" + this.avgEffectEndToDraw + ", avgWait=" + this.avgWait + ", frameCount=" + this.frameCount + ", frameRenderCost=" + this.frameRenderCost + '}';
    }

    public VECameraFrameTime() {
        this.avgCameraToEffectStart = 0.0f;
        this.avgEffectStartToEffectEnd = 0.0f;
        this.avgEffectEndToDraw = 0.0f;
        this.avgWait = 0.0f;
        this.frameCount = 0;
        this.frameRenderCost = 0.0f;
    }
}
