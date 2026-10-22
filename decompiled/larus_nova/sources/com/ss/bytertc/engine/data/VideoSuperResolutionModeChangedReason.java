package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoSuperResolutionModeChangedReason extends Enum<VideoSuperResolutionModeChangedReason> {
    private static final /* synthetic */ VideoSuperResolutionModeChangedReason[] $VALUES = null;
    public static final VideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_OFF = null;
    public static final VideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_ON = null;
    public static final VideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DEVICE_NOT_SUPPORT = null;
    public static final VideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DYNAMIC_CLOSE = null;
    public static final VideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_NO_COMPONENT = null;
    public static final VideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_DISABLED = null;
    public static final VideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_ENABLED = null;
    public static final VideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OVER_USE = null;
    public static final VideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_RESOLUTION_EXCEED = null;
    public static final VideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_STREAM_NOT_EXIST = null;
    private int value;

    static {
        VideoSuperResolutionModeChangedReason r100 = new VideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_OFF", 0, 0);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_OFF = r100;
        VideoSuperResolutionModeChangedReason r101 = new VideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_ON", 1, 1);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_ON = r101;
        VideoSuperResolutionModeChangedReason r102 = new VideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_RESOLUTION_EXCEED", 2, 2);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_RESOLUTION_EXCEED = r102;
        VideoSuperResolutionModeChangedReason r103 = new VideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OVER_USE", 3, 3);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OVER_USE = r103;
        VideoSuperResolutionModeChangedReason r104 = new VideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DEVICE_NOT_SUPPORT", 4, 4);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DEVICE_NOT_SUPPORT = r104;
        VideoSuperResolutionModeChangedReason r105 = new VideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DYNAMIC_CLOSE", 5, 5);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DYNAMIC_CLOSE = r105;
        VideoSuperResolutionModeChangedReason r110 = new VideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_DISABLED", 6, 6);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_DISABLED = r110;
        VideoSuperResolutionModeChangedReason r111 = new VideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_ENABLED", 7, 7);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_ENABLED = r111;
        VideoSuperResolutionModeChangedReason r112 = new VideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_NO_COMPONENT", 8, 8);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_NO_COMPONENT = r112;
        VideoSuperResolutionModeChangedReason r113 = new VideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_STREAM_NOT_EXIST", 9, 9);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_STREAM_NOT_EXIST = r113;
        $VALUES = new VideoSuperResolutionModeChangedReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static VideoSuperResolutionModeChangedReason[] values() {
        return (VideoSuperResolutionModeChangedReason[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.value;
        if (r100 != 0) goto L5;
        return "kVideoSuperResolutionModeChangedReasonAPIOff";
    L5:
        if (r100 != 1) goto L7;
        return "kVideoSuperResolutionModeChangedReasonAPIOn";
    L7:
        if (r100 != 2) goto L9;
        return "kVideoSuperResolutionModeChangedReasonResolutionExceed";
    L9:
        if (r100 != 3) goto L11;
        return "kVideoSuperResolutionModeChangedReasonOverUse";
    L11:
        if (r100 != 4) goto L13;
        return "kVideoSuperResolutionModeChangedReasonDeviceNotSupport";
    L13:
        if (r100 != 5) goto L15;
        return "kVideoSuperResolutionModeChangedReasonDynamicClose";
    L15:
        if (r100 != 100) goto L17;
        return "kVideoSuperResolutionModeChangedReasonNoComponent";
    L17:
        if (r100 != 101) goto L19;
        return "kVideoSuperResolutionModeChangedReasonStreamNotExist";
    L19:
        if (r100 == 200) goto L22;
        return "";
    L22:
        return "kVideoSuperResolutionModeChangedReasonOther";
    }

    public int value() {
        return this.value;
    }

    public static VideoSuperResolutionModeChangedReason fromId(int r100) {
        VideoSuperResolutionModeChangedReason[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        VideoSuperResolutionModeChangedReason r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static VideoSuperResolutionModeChangedReason valueOf(String r100) {
        return (VideoSuperResolutionModeChangedReason) a.a(VideoSuperResolutionModeChangedReason.class, r100);
    }

    private VideoSuperResolutionModeChangedReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
