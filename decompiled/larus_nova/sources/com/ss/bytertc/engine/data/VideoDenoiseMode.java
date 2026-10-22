package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoDenoiseMode extends Enum<VideoDenoiseMode> {
    private static final /* synthetic */ VideoDenoiseMode[] $VALUES = null;
    public static final VideoDenoiseMode VIDEO_DENOISE_MODE_AUTO = null;
    public static final VideoDenoiseMode VIDEO_DENOISE_MODE_OFF = null;
    private int value;

    static {
        VideoDenoiseMode r100 = new VideoDenoiseMode("VIDEO_DENOISE_MODE_OFF", 0, 0);
        VIDEO_DENOISE_MODE_OFF = r100;
        VideoDenoiseMode r101 = new VideoDenoiseMode("VIDEO_DENOISE_MODE_AUTO", 1, 1);
        VIDEO_DENOISE_MODE_AUTO = r101;
        $VALUES = new VideoDenoiseMode[]{r100, r101};
    }

    public static VideoDenoiseMode[] values() {
        return (VideoDenoiseMode[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.value;
        if (r100 != 0) goto L5;
        return "kVideoDenoiseModeOff";
    L5:
        if (r100 == 1) goto L8;
        return "";
    L8:
        return "kVideoDenoiseModeAuto";
    }

    public int value() {
        return this.value;
    }

    public static VideoDenoiseMode fromId(int r100) {
        VideoDenoiseMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        VideoDenoiseMode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static VideoDenoiseMode valueOf(String r100) {
        return (VideoDenoiseMode) a.a(VideoDenoiseMode.class, r100);
    }

    private VideoDenoiseMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
