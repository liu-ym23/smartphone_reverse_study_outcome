package com.ss.bytertc.engine.video;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoSinkMirrorType extends Enum<VideoSinkMirrorType> {
    private static final /* synthetic */ VideoSinkMirrorType[] $VALUES = null;
    public static final VideoSinkMirrorType OFF = null;
    public static final VideoSinkMirrorType ON = null;
    private int value;

    static {
        VideoSinkMirrorType r100 = new VideoSinkMirrorType("ON", 0, 1);
        ON = r100;
        VideoSinkMirrorType r101 = new VideoSinkMirrorType("OFF", 1, 2);
        OFF = r101;
        $VALUES = new VideoSinkMirrorType[]{r100, r101};
    }

    public static VideoSinkMirrorType[] values() {
        return (VideoSinkMirrorType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static VideoSinkMirrorType convertFromInt(int r100) {
        if (r100 == 1) goto L11;
        if (r100 != 2) goto L9;
        return OFF;
    L9:
        throw new IllegalArgumentException("VideoSinkMirrorType enum value invalidate: " + r100);
    L11:
        return ON;
    }

    public static VideoSinkMirrorType valueOf(String r100) {
        return (VideoSinkMirrorType) a.a(VideoSinkMirrorType.class, r100);
    }

    private VideoSinkMirrorType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
