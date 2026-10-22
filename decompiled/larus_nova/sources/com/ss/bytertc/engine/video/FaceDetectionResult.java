package com.ss.bytertc.engine.video;

import java.util.Arrays;

/* JADX INFO: loaded from: classes40.dex */
public class FaceDetectionResult {
    public int detectResult;
    public Rectangle[] faces;
    public long frameTimestampUs;
    public int imageHeight;
    public int imageWidth;

    public FaceDetectionResult() {
    }

    public String toString() {
        return "FaceDetectionResult{detectResult=" + this.detectResult + ", imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ", faces=" + Arrays.toString(this.faces) + ", frameTimestampUs=" + this.frameTimestampUs + '}';
    }
}
