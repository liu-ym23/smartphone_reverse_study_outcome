package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class RecordingInfo {
    public String filePath;
    public int height;
    public VideoCodecType videoCodecType;
    public int width;

    public RecordingInfo(String r100, VideoCodecType r101, int r102, int r103) {
        this.filePath = r100;
        this.videoCodecType = r101;
        this.width = r102;
        this.height = r103;
    }

    public static RecordingInfo create(String r100, VideoCodecType r101, int r102, int r103) {
        return new RecordingInfo(r100, r101, r102, r103);
    }
}
