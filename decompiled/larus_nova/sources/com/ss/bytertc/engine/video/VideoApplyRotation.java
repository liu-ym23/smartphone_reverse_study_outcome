package com.ss.bytertc.engine.video;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoApplyRotation extends Enum<VideoApplyRotation> {
    private static final /* synthetic */ VideoApplyRotation[] $VALUES = null;
    public static final VideoApplyRotation DEFAULT = null;
    public static final VideoApplyRotation DEGREE_0 = null;
    private int value;

    static {
        VideoApplyRotation r100 = new VideoApplyRotation("DEFAULT", 0, -1);
        DEFAULT = r100;
        VideoApplyRotation r101 = new VideoApplyRotation("DEGREE_0", 1, 0);
        DEGREE_0 = r101;
        $VALUES = new VideoApplyRotation[]{r100, r101};
    }

    public static VideoApplyRotation[] values() {
        return (VideoApplyRotation[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static VideoApplyRotation convertFromInt(int r100) {
        if (r100 == (-1)) goto L10;
        if (r100 != 0) goto L8;
        return DEGREE_0;
    L8:
        throw new IllegalArgumentException("VideoApplyRotation enum value invalidate: " + r100);
    L10:
        return DEFAULT;
    }

    public static VideoApplyRotation valueOf(String r100) {
        return (VideoApplyRotation) a.a(VideoApplyRotation.class, r100);
    }

    private VideoApplyRotation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
