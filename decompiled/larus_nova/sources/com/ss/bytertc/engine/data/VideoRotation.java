package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoRotation extends Enum<VideoRotation> {
    private static final /* synthetic */ VideoRotation[] $VALUES = null;
    public static final VideoRotation VIDEO_ROTATION_0 = null;
    public static final VideoRotation VIDEO_ROTATION_180 = null;
    public static final VideoRotation VIDEO_ROTATION_270 = null;
    public static final VideoRotation VIDEO_ROTATION_90 = null;
    private int value;

    static {
        VideoRotation r100 = new VideoRotation("VIDEO_ROTATION_0", 0, 0);
        VIDEO_ROTATION_0 = r100;
        VideoRotation r101 = new VideoRotation("VIDEO_ROTATION_90", 1, 90);
        VIDEO_ROTATION_90 = r101;
        VideoRotation r102 = new VideoRotation("VIDEO_ROTATION_180", 2, 180);
        VIDEO_ROTATION_180 = r102;
        VideoRotation r103 = new VideoRotation("VIDEO_ROTATION_270", 3, 270);
        VIDEO_ROTATION_270 = r103;
        $VALUES = new VideoRotation[]{r100, r101, r102, r103};
    }

    public static VideoRotation[] values() {
        return (VideoRotation[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static VideoRotation fromId(int r100) {
        VideoRotation[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        VideoRotation r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static VideoRotation valueOf(String r100) {
        return (VideoRotation) a.a(VideoRotation.class, r100);
    }

    private VideoRotation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
