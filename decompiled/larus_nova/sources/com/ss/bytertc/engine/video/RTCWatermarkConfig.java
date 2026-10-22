package com.ss.bytertc.engine.video;

/* JADX INFO: loaded from: classes40.dex */
public class RTCWatermarkConfig {
    public ByteWatermark positionInLandscapeMode;
    public ByteWatermark positionInPortraitMode;
    public boolean visibleInPreview;

    public RTCWatermarkConfig() {
        this.visibleInPreview = true;
    }

    public RTCWatermarkConfig(boolean r100, ByteWatermark r101, ByteWatermark r102) {
        this.visibleInPreview = r100;
        this.positionInLandscapeMode = r101;
        this.positionInPortraitMode = r102;
    }
}
