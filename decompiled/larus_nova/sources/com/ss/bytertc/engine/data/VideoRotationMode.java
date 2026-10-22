package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoRotationMode extends Enum<VideoRotationMode> {
    private static final /* synthetic */ VideoRotationMode[] $VALUES = null;
    public static final VideoRotationMode FOLLOW_APP = null;
    public static final VideoRotationMode FOLLOW_GSENSOR = null;
    private int value;

    static {
        VideoRotationMode r100 = new VideoRotationMode("FOLLOW_APP", 0, 0);
        FOLLOW_APP = r100;
        VideoRotationMode r101 = new VideoRotationMode("FOLLOW_GSENSOR", 1, 1);
        FOLLOW_GSENSOR = r101;
        $VALUES = new VideoRotationMode[]{r100, r101};
    }

    public static VideoRotationMode[] values() {
        return (VideoRotationMode[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != FOLLOW_GSENSOR) goto L5;
        return "kVideoRotationModeFollowGSensor";
    L5:
        return "kVideoRotationModeFollowApp";
    }

    public int value() {
        return this.value;
    }

    public static VideoRotationMode fromId(int r100) {
        VideoRotationMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        VideoRotationMode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static VideoRotationMode valueOf(String r100) {
        return (VideoRotationMode) a.a(VideoRotationMode.class, r100);
    }

    private VideoRotationMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
