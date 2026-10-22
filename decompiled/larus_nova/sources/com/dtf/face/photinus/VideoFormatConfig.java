package com.dtf.face.photinus;

import androidx.exifinterface.media.ExifInterface;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum VideoFormatConfig extends Enum<VideoFormatConfig> {
    public static final VideoFormatConfig L = null;
    public static final VideoFormatConfig M = null;
    public static final VideoFormatConfig S = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoFormatConfig[] f273643a = null;
    private int bitRate;
    private int frameRate;

    static {
        VideoFormatConfig r100 = new VideoFormatConfig(ExifInterface.LATITUDE_SOUTH, 0, 50);
        S = r100;
        VideoFormatConfig r101 = new VideoFormatConfig("M", 1, 40);
        M = r101;
        VideoFormatConfig r102 = new VideoFormatConfig("L", 2, 30);
        L = r102;
        f273643a = new VideoFormatConfig[]{r100, r101, r102};
    }

    public static VideoFormatConfig[] values() {
        return (VideoFormatConfig[]) f273643a.clone();
    }

    public int getBitRate() {
        return this.bitRate;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public static VideoFormatConfig valueOf(String r100) {
        return (VideoFormatConfig) a.a(VideoFormatConfig.class, r100);
    }

    public VideoFormatConfig(String r100, int r101, int r102) {
        super(r100, r101);
        this.frameRate = r102;
        this.bitRate = 1000000;
    }
}
