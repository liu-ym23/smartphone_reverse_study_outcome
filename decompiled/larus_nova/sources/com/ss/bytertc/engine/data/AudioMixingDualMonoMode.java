package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioMixingDualMonoMode extends Enum<AudioMixingDualMonoMode> {
    private static final /* synthetic */ AudioMixingDualMonoMode[] $VALUES = null;
    public static final AudioMixingDualMonoMode AUDIO_MIXING_DUAL_MONO_MODE_AUTO = null;
    public static final AudioMixingDualMonoMode AUDIO_MIXING_DUAL_MONO_MODE_L = null;
    public static final AudioMixingDualMonoMode AUDIO_MIXING_DUAL_MONO_MODE_MIX = null;
    public static final AudioMixingDualMonoMode AUDIO_MIXING_DUAL_MONO_MODE_R = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AudioMixingDualMonoMode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioMixingDualMonoMode = null;

        static {
            int[] r100 = new int[AudioMixingDualMonoMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingDualMonoMode = r100;
            r100[AudioMixingDualMonoMode.AUDIO_MIXING_DUAL_MONO_MODE_AUTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingDualMonoMode[AudioMixingDualMonoMode.AUDIO_MIXING_DUAL_MONO_MODE_L.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingDualMonoMode[AudioMixingDualMonoMode.AUDIO_MIXING_DUAL_MONO_MODE_R.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingDualMonoMode[AudioMixingDualMonoMode.AUDIO_MIXING_DUAL_MONO_MODE_MIX.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        AudioMixingDualMonoMode r100 = new AudioMixingDualMonoMode("AUDIO_MIXING_DUAL_MONO_MODE_AUTO", 0, 0);
        AUDIO_MIXING_DUAL_MONO_MODE_AUTO = r100;
        AudioMixingDualMonoMode r101 = new AudioMixingDualMonoMode("AUDIO_MIXING_DUAL_MONO_MODE_L", 1, 1);
        AUDIO_MIXING_DUAL_MONO_MODE_L = r101;
        AudioMixingDualMonoMode r102 = new AudioMixingDualMonoMode("AUDIO_MIXING_DUAL_MONO_MODE_R", 2, 2);
        AUDIO_MIXING_DUAL_MONO_MODE_R = r102;
        AudioMixingDualMonoMode r103 = new AudioMixingDualMonoMode("AUDIO_MIXING_DUAL_MONO_MODE_MIX", 3, 3);
        AUDIO_MIXING_DUAL_MONO_MODE_MIX = r103;
        $VALUES = new AudioMixingDualMonoMode[]{r100, r101, r102, r103};
    }

    public static AudioMixingDualMonoMode[] values() {
        return (AudioMixingDualMonoMode[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioMixingDualMonoMode[ordinal()];
        if (r100 != 1) goto L5;
        return "AUDIO_MIXING_DUAL_MONO_MODE_AUTO";
    L5:
        if (r100 != 2) goto L7;
        return "AUDIO_MIXING_DUAL_MONO_MODE_L";
    L7:
        if (r100 != 3) goto L9;
        return "AUDIO_MIXING_DUAL_MONO_MODE_R";
    L9:
        if (r100 == 4) goto L11;
        return "";
    L11:
        return "AUDIO_MIXING_DUAL_MONO_MODE_MIX";
    }

    public int value() {
        return this.value;
    }

    public static AudioMixingDualMonoMode fromId(int r100) {
        AudioMixingDualMonoMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioMixingDualMonoMode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioMixingDualMonoMode valueOf(String r100) {
        return (AudioMixingDualMonoMode) a.a(AudioMixingDualMonoMode.class, r100);
    }

    private AudioMixingDualMonoMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
