package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioProfileType extends Enum<AudioProfileType> {
    private static final /* synthetic */ AudioProfileType[] $VALUES = null;
    public static final AudioProfileType AUDIO_PROFILE_DEFAULT = null;
    public static final AudioProfileType AUDIO_PROFILE_FLUENT = null;
    public static final AudioProfileType AUDIO_PROFILE_HD = null;
    public static final AudioProfileType AUDIO_PROFILE_HD_MONO = null;
    public static final AudioProfileType AUDIO_PROFILE_STANDARD = null;
    public static final AudioProfileType AUDIO_PROFILE_STANDARD_STEREO = null;
    private final int value;

    static {
        AudioProfileType r100 = new AudioProfileType("AUDIO_PROFILE_DEFAULT", 0, 0);
        AUDIO_PROFILE_DEFAULT = r100;
        AudioProfileType r101 = new AudioProfileType("AUDIO_PROFILE_FLUENT", 1, 1);
        AUDIO_PROFILE_FLUENT = r101;
        AudioProfileType r102 = new AudioProfileType("AUDIO_PROFILE_STANDARD", 2, 2);
        AUDIO_PROFILE_STANDARD = r102;
        AudioProfileType r103 = new AudioProfileType("AUDIO_PROFILE_HD", 3, 3);
        AUDIO_PROFILE_HD = r103;
        AudioProfileType r104 = new AudioProfileType("AUDIO_PROFILE_STANDARD_STEREO", 4, 4);
        AUDIO_PROFILE_STANDARD_STEREO = r104;
        AudioProfileType r105 = new AudioProfileType("AUDIO_PROFILE_HD_MONO", 5, 5);
        AUDIO_PROFILE_HD_MONO = r105;
        $VALUES = new AudioProfileType[]{r100, r101, r102, r103, r104, r105};
    }

    public static AudioProfileType[] values() {
        return (AudioProfileType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static AudioProfileType fromId(int r100) {
        AudioProfileType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        AudioProfileType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return AUDIO_PROFILE_DEFAULT;
    }

    public static AudioProfileType valueOf(String r100) {
        return (AudioProfileType) a.a(AudioProfileType.class, r100);
    }

    private AudioProfileType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
