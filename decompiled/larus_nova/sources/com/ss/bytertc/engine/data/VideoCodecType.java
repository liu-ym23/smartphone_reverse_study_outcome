package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoCodecType extends Enum<VideoCodecType> {
    private static final /* synthetic */ VideoCodecType[] $VALUES = null;
    public static final VideoCodecType VIDEO_CODEC_TYPE_BYTEVC1 = null;
    public static final VideoCodecType VIDEO_CODEC_TYPE_H264 = null;
    public static final VideoCodecType VIDEO_CODEC_TYPE_MJPEG = null;
    public static final VideoCodecType VIDEO_CODEC_TYPE_UNKNOWN = null;
    int value;

    static {
        VideoCodecType r100 = new VideoCodecType("VIDEO_CODEC_TYPE_UNKNOWN", 0, 0);
        VIDEO_CODEC_TYPE_UNKNOWN = r100;
        VideoCodecType r101 = new VideoCodecType("VIDEO_CODEC_TYPE_H264", 1, 1);
        VIDEO_CODEC_TYPE_H264 = r101;
        VideoCodecType r102 = new VideoCodecType("VIDEO_CODEC_TYPE_BYTEVC1", 2, 2);
        VIDEO_CODEC_TYPE_BYTEVC1 = r102;
        VideoCodecType r103 = new VideoCodecType("VIDEO_CODEC_TYPE_MJPEG", 3, 3);
        VIDEO_CODEC_TYPE_MJPEG = r103;
        $VALUES = new VideoCodecType[]{r100, r101, r102, r103};
    }

    public static VideoCodecType[] values() {
        return (VideoCodecType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static VideoCodecType fromId(int r100) {
        VideoCodecType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        VideoCodecType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static VideoCodecType valueOf(String r100) {
        return (VideoCodecType) a.a(VideoCodecType.class, r100);
    }

    private VideoCodecType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
