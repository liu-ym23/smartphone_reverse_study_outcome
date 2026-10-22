package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoSuperResolutionMode extends Enum<VideoSuperResolutionMode> {
    private static final /* synthetic */ VideoSuperResolutionMode[] $VALUES = null;
    public static final VideoSuperResolutionMode OFF = null;
    public static final VideoSuperResolutionMode SCALE_11X = null;
    public static final VideoSuperResolutionMode SCALE_12X = null;
    public static final VideoSuperResolutionMode SCALE_13X = null;
    public static final VideoSuperResolutionMode SCALE_14X = null;
    public static final VideoSuperResolutionMode SCALE_15X = null;
    public static final VideoSuperResolutionMode SCALE_20X = null;
    public static final VideoSuperResolutionMode SCALE_AUTO = null;
    private int value;

    static {
        VideoSuperResolutionMode r100 = new VideoSuperResolutionMode("OFF", 0, 0);
        OFF = r100;
        VideoSuperResolutionMode r101 = new VideoSuperResolutionMode("SCALE_AUTO", 1, 1);
        SCALE_AUTO = r101;
        VideoSuperResolutionMode r102 = new VideoSuperResolutionMode("SCALE_15X", 2, 2);
        SCALE_15X = r102;
        VideoSuperResolutionMode r103 = new VideoSuperResolutionMode("SCALE_20X", 3, 3);
        SCALE_20X = r103;
        VideoSuperResolutionMode r104 = new VideoSuperResolutionMode("SCALE_11X", 4, 4);
        SCALE_11X = r104;
        VideoSuperResolutionMode r105 = new VideoSuperResolutionMode("SCALE_12X", 5, 5);
        SCALE_12X = r105;
        VideoSuperResolutionMode r110 = new VideoSuperResolutionMode("SCALE_13X", 6, 6);
        SCALE_13X = r110;
        VideoSuperResolutionMode r111 = new VideoSuperResolutionMode("SCALE_14X", 7, 7);
        SCALE_14X = r111;
        $VALUES = new VideoSuperResolutionMode[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static VideoSuperResolutionMode[] values() {
        return (VideoSuperResolutionMode[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(this.value) {
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        return "";
    L6:
        return "kVideoSuperResolutionModeScale14X";
    L8:
        return "kVideoSuperResolutionModeScale13X";
    L10:
        return "kVideoSuperResolutionModeScale12X";
    L12:
        return "kVideoSuperResolutionModeScale11X";
    L14:
        return "kVideoSuperResolutionModeScale20X";
    L16:
        return "kVideoSuperResolutionModeScale15X";
    L18:
        return "kVideoSuperResolutionModeScaleAuto";
    L20:
        return "kVideoSuperResolutionModeOff";
    }

    public int value() {
        return this.value;
    }

    public static VideoSuperResolutionMode fromId(int r100) {
        VideoSuperResolutionMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        VideoSuperResolutionMode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static VideoSuperResolutionMode valueOf(String r100) {
        return (VideoSuperResolutionMode) a.a(VideoSuperResolutionMode.class, r100);
    }

    private VideoSuperResolutionMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
