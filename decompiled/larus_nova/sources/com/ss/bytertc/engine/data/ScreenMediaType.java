package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum ScreenMediaType extends Enum<ScreenMediaType> {
    private static final /* synthetic */ ScreenMediaType[] $VALUES = null;
    public static final ScreenMediaType SCREEN_MEDIA_TYPE_AUDIO_ONLY = null;
    public static final ScreenMediaType SCREEN_MEDIA_TYPE_VIDEO_AND_AUDIO = null;
    public static final ScreenMediaType SCREEN_MEDIA_TYPE_VIDEO_ONLY = null;
    private int value;

    static {
        ScreenMediaType r100 = new ScreenMediaType("SCREEN_MEDIA_TYPE_VIDEO_ONLY", 0, 0);
        SCREEN_MEDIA_TYPE_VIDEO_ONLY = r100;
        ScreenMediaType r101 = new ScreenMediaType("SCREEN_MEDIA_TYPE_AUDIO_ONLY", 1, 1);
        SCREEN_MEDIA_TYPE_AUDIO_ONLY = r101;
        ScreenMediaType r102 = new ScreenMediaType("SCREEN_MEDIA_TYPE_VIDEO_AND_AUDIO", 2, 2);
        SCREEN_MEDIA_TYPE_VIDEO_AND_AUDIO = r102;
        $VALUES = new ScreenMediaType[]{r100, r101, r102};
    }

    public static ScreenMediaType[] values() {
        return (ScreenMediaType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static ScreenMediaType fromId(int r100) {
        ScreenMediaType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ScreenMediaType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static ScreenMediaType valueOf(String r100) {
        return (ScreenMediaType) a.a(ScreenMediaType.class, r100);
    }

    private ScreenMediaType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
