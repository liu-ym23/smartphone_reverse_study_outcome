package com.ss.bytertc.engine.video;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoDecoderConfig extends Enum<VideoDecoderConfig> {
    private static final /* synthetic */ VideoDecoderConfig[] $VALUES = null;
    public static final VideoDecoderConfig VIDEO_DECODER_CONFIG_BOTH = null;
    public static final VideoDecoderConfig VIDEO_DECODER_CONFIG_ENCODE = null;
    public static final VideoDecoderConfig VIDEO_DECODER_CONFIG_RAW = null;
    private int value;

    static {
        VideoDecoderConfig r100 = new VideoDecoderConfig("VIDEO_DECODER_CONFIG_RAW", 0, 0);
        VIDEO_DECODER_CONFIG_RAW = r100;
        VideoDecoderConfig r101 = new VideoDecoderConfig("VIDEO_DECODER_CONFIG_ENCODE", 1, 1);
        VIDEO_DECODER_CONFIG_ENCODE = r101;
        VideoDecoderConfig r102 = new VideoDecoderConfig("VIDEO_DECODER_CONFIG_BOTH", 2, 2);
        VIDEO_DECODER_CONFIG_BOTH = r102;
        $VALUES = new VideoDecoderConfig[]{r100, r101, r102};
    }

    public static VideoDecoderConfig[] values() {
        return (VideoDecoderConfig[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static VideoDecoderConfig fromId(int r100) {
        VideoDecoderConfig[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        VideoDecoderConfig r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static VideoDecoderConfig valueOf(String r100) {
        return (VideoDecoderConfig) a.a(VideoDecoderConfig.class, r100);
    }

    private VideoDecoderConfig(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
