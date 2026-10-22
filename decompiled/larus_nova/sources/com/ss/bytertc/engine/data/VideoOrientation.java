package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoOrientation extends Enum<VideoOrientation> {
    private static final /* synthetic */ VideoOrientation[] $VALUES = null;
    public static final VideoOrientation ADAPTIVE = null;
    public static final VideoOrientation LANDSCAPE = null;
    public static final VideoOrientation PORTRAIT = null;
    private int value;

    static {
        VideoOrientation r100 = new VideoOrientation("ADAPTIVE", 0, 0);
        ADAPTIVE = r100;
        VideoOrientation r101 = new VideoOrientation("PORTRAIT", 1, 1);
        PORTRAIT = r101;
        VideoOrientation r102 = new VideoOrientation("LANDSCAPE", 2, 2);
        LANDSCAPE = r102;
        $VALUES = new VideoOrientation[]{r100, r101, r102};
    }

    public static VideoOrientation[] values() {
        return (VideoOrientation[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.value;
        if (r100 != 0) goto L5;
        return "kVideoOrientationAdaptive";
    L5:
        if (r100 != 1) goto L7;
        return "kVideoOrientationPortrait";
    L7:
        if (r100 == 2) goto L10;
        return "";
    L10:
        return "kVideoOrientationLandscape";
    }

    public int value() {
        return this.value;
    }

    public static VideoOrientation fromId(int r100) {
        VideoOrientation[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        VideoOrientation r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static VideoOrientation valueOf(String r100) {
        return (VideoOrientation) a.a(VideoOrientation.class, r100);
    }

    private VideoOrientation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
