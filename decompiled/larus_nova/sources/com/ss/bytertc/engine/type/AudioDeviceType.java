package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioDeviceType extends Enum<AudioDeviceType> {
    private static final /* synthetic */ AudioDeviceType[] $VALUES = null;
    public static final AudioDeviceType AUDIO_DEVICE_TYPE_CAPTURE_DEVICE = null;
    public static final AudioDeviceType AUDIO_DEVICE_TYPE_RENDER_DEVICE = null;
    public static final AudioDeviceType AUDIO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE = null;
    public static final AudioDeviceType AUDIO_DEVICE_TYPE_UNKNOWN = null;
    private final int value;

    static {
        AudioDeviceType r100 = new AudioDeviceType("AUDIO_DEVICE_TYPE_UNKNOWN", 0, -1);
        AUDIO_DEVICE_TYPE_UNKNOWN = r100;
        AudioDeviceType r101 = new AudioDeviceType("AUDIO_DEVICE_TYPE_RENDER_DEVICE", 1, 0);
        AUDIO_DEVICE_TYPE_RENDER_DEVICE = r101;
        AudioDeviceType r102 = new AudioDeviceType("AUDIO_DEVICE_TYPE_CAPTURE_DEVICE", 2, 1);
        AUDIO_DEVICE_TYPE_CAPTURE_DEVICE = r102;
        AudioDeviceType r103 = new AudioDeviceType("AUDIO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE", 3, 2);
        AUDIO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE = r103;
        $VALUES = new AudioDeviceType[]{r100, r101, r102, r103};
    }

    public static AudioDeviceType[] values() {
        return (AudioDeviceType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static AudioDeviceType fromId(int r100) {
        AudioDeviceType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        AudioDeviceType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return AUDIO_DEVICE_TYPE_UNKNOWN;
    }

    public static AudioDeviceType valueOf(String r100) {
        return (AudioDeviceType) a.a(AudioDeviceType.class, r100);
    }

    private AudioDeviceType(String r100, int r101) {
        super(r100, r101);
        this.value = 0;
    }

    private AudioDeviceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
