package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: classes8.dex */
public final enum VideoRotation extends Enum<VideoRotation> {
    private static final /* synthetic */ VideoRotation[] $VALUES = null;
    public static final VideoRotation VIDEO_ROTATION_0 = null;
    public static final VideoRotation VIDEO_ROTATION_180 = null;
    public static final VideoRotation VIDEO_ROTATION_270 = null;
    public static final VideoRotation VIDEO_ROTATION_90 = null;
    private int value;

    private static /* synthetic */ VideoRotation[] $values() {
        return new VideoRotation[]{VIDEO_ROTATION_0, VIDEO_ROTATION_90, VIDEO_ROTATION_180, VIDEO_ROTATION_270};
    }

    static {
        VIDEO_ROTATION_0 = new VideoRotation("VIDEO_ROTATION_0", 0, 0);
        VIDEO_ROTATION_90 = new VideoRotation("VIDEO_ROTATION_90", 1, 90);
        VIDEO_ROTATION_180 = new VideoRotation("VIDEO_ROTATION_180", 2, 180);
        VIDEO_ROTATION_270 = new VideoRotation("VIDEO_ROTATION_270", 3, 270);
        $VALUES = $values();
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
        return (VideoRotation) r27.a.a(VideoRotation.class, r100);
    }

    private VideoRotation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
