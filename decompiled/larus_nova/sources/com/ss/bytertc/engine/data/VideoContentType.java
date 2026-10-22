package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoContentType extends Enum<VideoContentType> {
    private static final /* synthetic */ VideoContentType[] $VALUES = null;
    public static final VideoContentType BLACK_FRAME = null;
    public static final VideoContentType NORMAL_FRAME = null;
    private int value;

    static {
        VideoContentType r100 = new VideoContentType("NORMAL_FRAME", 0, 0);
        NORMAL_FRAME = r100;
        VideoContentType r101 = new VideoContentType("BLACK_FRAME", 1, 1);
        BLACK_FRAME = r101;
        $VALUES = new VideoContentType[]{r100, r101};
    }

    public static VideoContentType[] values() {
        return (VideoContentType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != NORMAL_FRAME) goto L5;
        return "kVideoContentTypeNormalFrame";
    L5:
        return "kVideoContentTypeBlackFrame";
    }

    public int value() {
        return this.value;
    }

    public static VideoContentType fromId(int r100) {
        VideoContentType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        VideoContentType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static VideoContentType valueOf(String r100) {
        return (VideoContentType) a.a(VideoContentType.class, r100);
    }

    private VideoContentType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
