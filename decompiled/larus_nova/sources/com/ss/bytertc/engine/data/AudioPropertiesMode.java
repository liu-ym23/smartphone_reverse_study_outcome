package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioPropertiesMode extends Enum<AudioPropertiesMode> {
    private static final /* synthetic */ AudioPropertiesMode[] $VALUES = null;
    public static final AudioPropertiesMode AUDIO_PROPERTIES_MODE_AUDIOMIXING = null;
    public static final AudioPropertiesMode AUDIO_PROPERTIES_MODE_MICROPHONE = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AudioPropertiesMode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioPropertiesMode = null;

        static {
            int[] r100 = new int[AudioPropertiesMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioPropertiesMode = r100;
            r100[AudioPropertiesMode.AUDIO_PROPERTIES_MODE_MICROPHONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$engine$data$AudioPropertiesMode[AudioPropertiesMode.AUDIO_PROPERTIES_MODE_AUDIOMIXING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        AudioPropertiesMode r100 = new AudioPropertiesMode("AUDIO_PROPERTIES_MODE_MICROPHONE", 0, 0);
        AUDIO_PROPERTIES_MODE_MICROPHONE = r100;
        AudioPropertiesMode r101 = new AudioPropertiesMode("AUDIO_PROPERTIES_MODE_AUDIOMIXING", 1, 1);
        AUDIO_PROPERTIES_MODE_AUDIOMIXING = r101;
        $VALUES = new AudioPropertiesMode[]{r100, r101};
    }

    public static AudioPropertiesMode[] values() {
        return (AudioPropertiesMode[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioPropertiesMode[ordinal()];
        if (r100 != 1) goto L5;
        return "AUDIO_PROPERTIES_MODE_MICROPHONE";
    L5:
        if (r100 != 2) goto L10;
        return "AUDIO_PROPERTIES_MODE_AUDIOMIXING";
    L10:
        return "AUDIO_PROPERTIES_MODE_MICROPHONE";
    }

    public int value() {
        return this.value;
    }

    public static AudioPropertiesMode fromId(int r100) {
        AudioPropertiesMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioPropertiesMode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioPropertiesMode valueOf(String r100) {
        return (AudioPropertiesMode) a.a(AudioPropertiesMode.class, r100);
    }

    private AudioPropertiesMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
