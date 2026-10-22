package com.ss.android.ttvecamera.actionsound;

import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final enum VEMediaActionSoundType extends Enum<VEMediaActionSoundType> {
    private static final /* synthetic */ VEMediaActionSoundType[] $VALUES = null;
    public static final VEMediaActionSoundType FOCUS_COMPLETE = null;
    public static final VEMediaActionSoundType SHUTTER_CLICK = null;
    public static final VEMediaActionSoundType START_VIDEO_RECORDING = null;
    public static final VEMediaActionSoundType STOP_VIDEO_RECORDING = null;

    private static /* synthetic */ VEMediaActionSoundType[] $values() {
        return new VEMediaActionSoundType[]{SHUTTER_CLICK, FOCUS_COMPLETE, START_VIDEO_RECORDING, STOP_VIDEO_RECORDING};
    }

    static {
        SHUTTER_CLICK = new VEMediaActionSoundType("SHUTTER_CLICK", 0);
        FOCUS_COMPLETE = new VEMediaActionSoundType("FOCUS_COMPLETE", 1);
        START_VIDEO_RECORDING = new VEMediaActionSoundType("START_VIDEO_RECORDING", 2);
        STOP_VIDEO_RECORDING = new VEMediaActionSoundType("STOP_VIDEO_RECORDING", 3);
        $VALUES = $values();
    }

    public static VEMediaActionSoundType[] values() {
        return (VEMediaActionSoundType[]) $VALUES.clone();
    }

    public static VEMediaActionSoundType valueOf(String r100) {
        return (VEMediaActionSoundType) a.a(VEMediaActionSoundType.class, r100);
    }

    private VEMediaActionSoundType(String r100, int r101) {
        super(r100, r101);
    }
}
