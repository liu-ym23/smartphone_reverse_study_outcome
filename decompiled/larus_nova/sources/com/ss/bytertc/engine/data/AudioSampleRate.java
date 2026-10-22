package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioSampleRate extends Enum<AudioSampleRate> {
    private static final /* synthetic */ AudioSampleRate[] $VALUES = null;
    public static final AudioSampleRate AUDIO_SAMPLE_RATE_11025 = null;
    public static final AudioSampleRate AUDIO_SAMPLE_RATE_16000 = null;
    public static final AudioSampleRate AUDIO_SAMPLE_RATE_22050 = null;
    public static final AudioSampleRate AUDIO_SAMPLE_RATE_24000 = null;
    public static final AudioSampleRate AUDIO_SAMPLE_RATE_32000 = null;
    public static final AudioSampleRate AUDIO_SAMPLE_RATE_44100 = null;
    public static final AudioSampleRate AUDIO_SAMPLE_RATE_48000 = null;
    public static final AudioSampleRate AUDIO_SAMPLE_RATE_8000 = null;
    public static final AudioSampleRate AUDIO_SAMPLE_RATE_AUTO = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AudioSampleRate$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate = null;

        static {
            int[] r100 = new int[AudioSampleRate.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate = r100;
            r100[AudioSampleRate.AUDIO_SAMPLE_RATE_AUTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[AudioSampleRate.AUDIO_SAMPLE_RATE_8000.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[AudioSampleRate.AUDIO_SAMPLE_RATE_11025.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[AudioSampleRate.AUDIO_SAMPLE_RATE_16000.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[AudioSampleRate.AUDIO_SAMPLE_RATE_22050.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[AudioSampleRate.AUDIO_SAMPLE_RATE_24000.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[AudioSampleRate.AUDIO_SAMPLE_RATE_32000.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[AudioSampleRate.AUDIO_SAMPLE_RATE_44100.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[AudioSampleRate.AUDIO_SAMPLE_RATE_48000.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    static {
        AudioSampleRate r100 = new AudioSampleRate("AUDIO_SAMPLE_RATE_AUTO", 0, -1);
        AUDIO_SAMPLE_RATE_AUTO = r100;
        AudioSampleRate r101 = new AudioSampleRate("AUDIO_SAMPLE_RATE_8000", 1, 8000);
        AUDIO_SAMPLE_RATE_8000 = r101;
        AudioSampleRate r102 = new AudioSampleRate("AUDIO_SAMPLE_RATE_11025", 2, 11025);
        AUDIO_SAMPLE_RATE_11025 = r102;
        AudioSampleRate r103 = new AudioSampleRate("AUDIO_SAMPLE_RATE_16000", 3, 16000);
        AUDIO_SAMPLE_RATE_16000 = r103;
        AudioSampleRate r104 = new AudioSampleRate("AUDIO_SAMPLE_RATE_22050", 4, 22050);
        AUDIO_SAMPLE_RATE_22050 = r104;
        AudioSampleRate r105 = new AudioSampleRate("AUDIO_SAMPLE_RATE_24000", 5, 24000);
        AUDIO_SAMPLE_RATE_24000 = r105;
        AudioSampleRate r110 = new AudioSampleRate("AUDIO_SAMPLE_RATE_32000", 6, 32000);
        AUDIO_SAMPLE_RATE_32000 = r110;
        AudioSampleRate r111 = new AudioSampleRate("AUDIO_SAMPLE_RATE_44100", 7, 44100);
        AUDIO_SAMPLE_RATE_44100 = r111;
        AudioSampleRate r112 = new AudioSampleRate("AUDIO_SAMPLE_RATE_48000", 8, 48000);
        AUDIO_SAMPLE_RATE_48000 = r112;
        $VALUES = new AudioSampleRate[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static AudioSampleRate[] values() {
        return (AudioSampleRate[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "kAudioSampleRate48000";
    L6:
        return "kAudioSampleRate44100";
    L7:
        return "kAudioSampleRate32000";
    L8:
        return "kAudioSampleRate24000";
    L9:
        return "kAudioSampleRate22050";
    L10:
        return "kAudioSampleRate16000";
    L11:
        return "kAudioSampleRate11025";
    L12:
        return "kAudioSampleRate8000";
    L13:
        return "kAudioSampleRateAuto";
    }

    public int value() {
        return this.value;
    }

    public static AudioSampleRate fromId(int r100) {
        AudioSampleRate[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioSampleRate r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioSampleRate valueOf(String r100) {
        return (AudioSampleRate) a.a(AudioSampleRate.class, r100);
    }

    private AudioSampleRate(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
