package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoPictureType extends Enum<VideoPictureType> {
    private static final /* synthetic */ VideoPictureType[] $VALUES = null;
    public static final VideoPictureType VIDEO_PICTURE_TYPE_B = null;
    public static final VideoPictureType VIDEO_PICTURE_TYPE_I = null;
    public static final VideoPictureType VIDEO_PICTURE_TYPE_P = null;
    public static final VideoPictureType VIDEO_PICTURE_TYPE_UNKNOWN = null;
    int value;

    static {
        VideoPictureType r100 = new VideoPictureType("VIDEO_PICTURE_TYPE_UNKNOWN", 0, 0);
        VIDEO_PICTURE_TYPE_UNKNOWN = r100;
        VideoPictureType r101 = new VideoPictureType("VIDEO_PICTURE_TYPE_I", 1, 1);
        VIDEO_PICTURE_TYPE_I = r101;
        VideoPictureType r102 = new VideoPictureType("VIDEO_PICTURE_TYPE_P", 2, 2);
        VIDEO_PICTURE_TYPE_P = r102;
        VideoPictureType r103 = new VideoPictureType("VIDEO_PICTURE_TYPE_B", 3, 3);
        VIDEO_PICTURE_TYPE_B = r103;
        $VALUES = new VideoPictureType[]{r100, r101, r102, r103};
    }

    public static VideoPictureType[] values() {
        return (VideoPictureType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static VideoPictureType fromId(int r100) {
        VideoPictureType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        VideoPictureType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static VideoPictureType valueOf(String r100) {
        return (VideoPictureType) a.a(VideoPictureType.class, r100);
    }

    private VideoPictureType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
