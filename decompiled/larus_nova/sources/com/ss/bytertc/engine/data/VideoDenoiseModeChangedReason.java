package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VideoDenoiseModeChangedReason extends Enum<VideoDenoiseModeChangedReason> {
    private static final /* synthetic */ VideoDenoiseModeChangedReason[] $VALUES = null;
    public static final VideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_API_OFF = null;
    public static final VideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_API_ON = null;
    public static final VideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_CONFIG_DISABLED = null;
    public static final VideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_CONFIG_ENABLED = null;
    public static final VideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_DYNAMIC_CLOSE = null;
    public static final VideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_DYNAMIC_OPEN = null;
    public static final VideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_INTERNAL_EXCEPTION = null;
    public static final VideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_NULL = null;
    public static final VideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_RESOLUTION = null;
    private int value;

    static {
        VideoDenoiseModeChangedReason r100 = new VideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_NULL", 0, -1);
        VIDEO_DENOISE_MODE_CHANGED_REASON_NULL = r100;
        VideoDenoiseModeChangedReason r101 = new VideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_API_OFF", 1, 0);
        VIDEO_DENOISE_MODE_CHANGED_REASON_API_OFF = r101;
        VideoDenoiseModeChangedReason r102 = new VideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_API_ON", 2, 1);
        VIDEO_DENOISE_MODE_CHANGED_REASON_API_ON = r102;
        VideoDenoiseModeChangedReason r103 = new VideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_CONFIG_DISABLED", 3, 2);
        VIDEO_DENOISE_MODE_CHANGED_REASON_CONFIG_DISABLED = r103;
        VideoDenoiseModeChangedReason r104 = new VideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_CONFIG_ENABLED", 4, 3);
        VIDEO_DENOISE_MODE_CHANGED_REASON_CONFIG_ENABLED = r104;
        VideoDenoiseModeChangedReason r105 = new VideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_INTERNAL_EXCEPTION", 5, 4);
        VIDEO_DENOISE_MODE_CHANGED_REASON_INTERNAL_EXCEPTION = r105;
        VideoDenoiseModeChangedReason r110 = new VideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_DYNAMIC_CLOSE", 6, 5);
        VIDEO_DENOISE_MODE_CHANGED_REASON_DYNAMIC_CLOSE = r110;
        VideoDenoiseModeChangedReason r111 = new VideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_DYNAMIC_OPEN", 7, 6);
        VIDEO_DENOISE_MODE_CHANGED_REASON_DYNAMIC_OPEN = r111;
        VideoDenoiseModeChangedReason r112 = new VideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_RESOLUTION", 8, 7);
        VIDEO_DENOISE_MODE_CHANGED_REASON_RESOLUTION = r112;
        $VALUES = new VideoDenoiseModeChangedReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static VideoDenoiseModeChangedReason[] values() {
        return (VideoDenoiseModeChangedReason[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(this.value) {
            case -1: goto L22;
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
        return "kVideoDenoiseModeChangedReasonResolution";
    L8:
        return "kVideoDenoiseModeChangedReasonDynamicOpen";
    L10:
        return "kVideoDenoiseModeChangedReasonDynamicClose";
    L12:
        return "kVideoDenoiseModeChangedReasonInternalException";
    L14:
        return "kVideoDenoiseModeChangedReasonConfigEnabled";
    L16:
        return "kVideoDenoiseModeChangedReasonConfigDisabled";
    L18:
        return "kVideoDenoiseModeChangedReasonApiOn";
    L20:
        return "kVideoDenoiseModeChangedReasonApiOff";
    L22:
        return "kVideoDenoiseModeChangedReasonNull";
    }

    public int value() {
        return this.value;
    }

    public static VideoDenoiseModeChangedReason fromId(int r100) {
        VideoDenoiseModeChangedReason[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        VideoDenoiseModeChangedReason r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static VideoDenoiseModeChangedReason valueOf(String r100) {
        return (VideoDenoiseModeChangedReason) a.a(VideoDenoiseModeChangedReason.class, r100);
    }

    private VideoDenoiseModeChangedReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
