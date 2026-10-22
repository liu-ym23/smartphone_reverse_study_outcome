package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoSourceType extends Enum<VideoSourceType> {
    private static final /* synthetic */ VideoSourceType[] $VALUES = null;
    public static final VideoSourceType VIDEO_SOURCE_TYPE_ENCODED_WITHOUT_SIMULCAST = null;
    public static final VideoSourceType VIDEO_SOURCE_TYPE_ENCODED_WITH_SIMULCAST = null;
    public static final VideoSourceType VIDEO_SOURCE_TYPE_EXTERNAL = null;
    public static final VideoSourceType VIDEO_SOURCE_TYPE_INTERNAL = null;
    private int value;

    static {
        VideoSourceType r100 = new VideoSourceType("VIDEO_SOURCE_TYPE_EXTERNAL", 0, 0);
        VIDEO_SOURCE_TYPE_EXTERNAL = r100;
        VideoSourceType r101 = new VideoSourceType("VIDEO_SOURCE_TYPE_INTERNAL", 1, 1);
        VIDEO_SOURCE_TYPE_INTERNAL = r101;
        VideoSourceType r102 = new VideoSourceType("VIDEO_SOURCE_TYPE_ENCODED_WITH_SIMULCAST", 2, 2);
        VIDEO_SOURCE_TYPE_ENCODED_WITH_SIMULCAST = r102;
        VideoSourceType r103 = new VideoSourceType("VIDEO_SOURCE_TYPE_ENCODED_WITHOUT_SIMULCAST", 3, 3);
        VIDEO_SOURCE_TYPE_ENCODED_WITHOUT_SIMULCAST = r103;
        $VALUES = new VideoSourceType[]{r100, r101, r102, r103};
    }

    public static VideoSourceType[] values() {
        return (VideoSourceType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static VideoSourceType fromId(int r100) {
        VideoSourceType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        VideoSourceType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static VideoSourceType valueOf(String r100) {
        return (VideoSourceType) a.a(VideoSourceType.class, r100);
    }

    private VideoSourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
