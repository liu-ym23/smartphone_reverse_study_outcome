package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoDeviceType extends Enum<VideoDeviceType> {
    private static final /* synthetic */ VideoDeviceType[] $VALUES = null;
    public static final VideoDeviceType VIDEO_DEVICE_TYPE_CAPTURE_DEVICE = null;
    public static final VideoDeviceType VIDEO_DEVICE_TYPE_RENDER_DEVICE = null;
    public static final VideoDeviceType VIDEO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE = null;
    public static final VideoDeviceType VIDEO_DEVICE_TYPE_UNKNOWN = null;
    private final int value;

    static {
        VideoDeviceType r100 = new VideoDeviceType("VIDEO_DEVICE_TYPE_UNKNOWN", 0, -1);
        VIDEO_DEVICE_TYPE_UNKNOWN = r100;
        VideoDeviceType r101 = new VideoDeviceType("VIDEO_DEVICE_TYPE_RENDER_DEVICE", 1, 0);
        VIDEO_DEVICE_TYPE_RENDER_DEVICE = r101;
        VideoDeviceType r102 = new VideoDeviceType("VIDEO_DEVICE_TYPE_CAPTURE_DEVICE", 2, 1);
        VIDEO_DEVICE_TYPE_CAPTURE_DEVICE = r102;
        VideoDeviceType r103 = new VideoDeviceType("VIDEO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE", 3, 2);
        VIDEO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE = r103;
        $VALUES = new VideoDeviceType[]{r100, r101, r102, r103};
    }

    public static VideoDeviceType[] values() {
        return (VideoDeviceType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static VideoDeviceType fromId(int r100) {
        VideoDeviceType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        VideoDeviceType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return VIDEO_DEVICE_TYPE_UNKNOWN;
    }

    public static VideoDeviceType valueOf(String r100) {
        return (VideoDeviceType) a.a(VideoDeviceType.class, r100);
    }

    private VideoDeviceType(String r100, int r101) {
        super(r100, r101);
        this.value = 0;
    }

    private VideoDeviceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
