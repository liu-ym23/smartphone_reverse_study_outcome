package com.facebook.imagepipeline.transcoder;

/* JADX INFO: loaded from: classes23.dex */
public class ImageTranscodeResult {
    private final int mTranscodeStatus;

    public String toString() {
        return String.format(null, "Status: %d", new Object[]{Integer.valueOf(this.mTranscodeStatus)});
    }

    public int getTranscodeStatus() {
        return this.mTranscodeStatus;
    }

    public ImageTranscodeResult(int r100) {
        this.mTranscodeStatus = r100;
    }
}
