package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoDeviceFacing extends Enum<VideoDeviceFacing> {
    private static final /* synthetic */ VideoDeviceFacing[] $VALUES = null;
    public static final VideoDeviceFacing BACK = null;
    public static final VideoDeviceFacing FRONT = null;
    public static final VideoDeviceFacing UNKNOWN = null;
    private int value;

    static {
        VideoDeviceFacing r100 = new VideoDeviceFacing("FRONT", 0, 0);
        FRONT = r100;
        VideoDeviceFacing r101 = new VideoDeviceFacing("BACK", 1, 1);
        BACK = r101;
        VideoDeviceFacing r102 = new VideoDeviceFacing("UNKNOWN", 2, 2);
        UNKNOWN = r102;
        $VALUES = new VideoDeviceFacing[]{r100, r101, r102};
    }

    public static VideoDeviceFacing[] values() {
        return (VideoDeviceFacing[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static VideoDeviceFacing fromId(int r100) {
        VideoDeviceFacing[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        VideoDeviceFacing r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static VideoDeviceFacing valueOf(String r100) {
        return (VideoDeviceFacing) a.a(VideoDeviceFacing.class, r100);
    }

    private VideoDeviceFacing(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
