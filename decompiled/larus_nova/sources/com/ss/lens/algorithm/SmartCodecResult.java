package com.ss.lens.algorithm;

/* JADX INFO: loaded from: classes40.dex */
public class SmartCodecResult {
    public float averageComplexity;
    public float bitrate;
    public byte[] data;
    public float maxComplexity;
    public float minComplexity;
    public boolean needIFrame;
    public int stride;
    public int textureId;
    public boolean validFrameData;
    public int version;

    public SmartCodecResult() {
        this.validFrameData = false;
        this.data = null;
        this.stride = -1;
        this.textureId = -1;
    }
}
