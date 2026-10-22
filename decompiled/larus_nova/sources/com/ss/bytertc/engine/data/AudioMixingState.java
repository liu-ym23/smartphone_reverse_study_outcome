package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioMixingState extends Enum<AudioMixingState> {
    private static final /* synthetic */ AudioMixingState[] $VALUES = null;
    public static final AudioMixingState AUDIO_MIXING_STATE_FAILED = null;
    public static final AudioMixingState AUDIO_MIXING_STATE_FINISHED = null;
    public static final AudioMixingState AUDIO_MIXING_STATE_PAUSED = null;
    public static final AudioMixingState AUDIO_MIXING_STATE_PCM_DISABLED = null;
    public static final AudioMixingState AUDIO_MIXING_STATE_PCM_ENABLED = null;
    public static final AudioMixingState AUDIO_MIXING_STATE_PLAYING = null;
    public static final AudioMixingState AUDIO_MIXING_STATE_PRELOADED = null;
    public static final AudioMixingState AUDIO_MIXING_STATE_STOPPED = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AudioMixingState$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState = null;

        static {
            int[] r100 = new int[AudioMixingState.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState = r100;
            r100[AudioMixingState.AUDIO_MIXING_STATE_PRELOADED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState[AudioMixingState.AUDIO_MIXING_STATE_PLAYING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState[AudioMixingState.AUDIO_MIXING_STATE_PAUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState[AudioMixingState.AUDIO_MIXING_STATE_STOPPED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState[AudioMixingState.AUDIO_MIXING_STATE_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState[AudioMixingState.AUDIO_MIXING_STATE_FINISHED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState[AudioMixingState.AUDIO_MIXING_STATE_PCM_ENABLED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState[AudioMixingState.AUDIO_MIXING_STATE_PCM_DISABLED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static {
        AudioMixingState r100 = new AudioMixingState("AUDIO_MIXING_STATE_PRELOADED", 0, 0);
        AUDIO_MIXING_STATE_PRELOADED = r100;
        AudioMixingState r101 = new AudioMixingState("AUDIO_MIXING_STATE_PLAYING", 1, 1);
        AUDIO_MIXING_STATE_PLAYING = r101;
        AudioMixingState r102 = new AudioMixingState("AUDIO_MIXING_STATE_PAUSED", 2, 2);
        AUDIO_MIXING_STATE_PAUSED = r102;
        AudioMixingState r103 = new AudioMixingState("AUDIO_MIXING_STATE_STOPPED", 3, 3);
        AUDIO_MIXING_STATE_STOPPED = r103;
        AudioMixingState r104 = new AudioMixingState("AUDIO_MIXING_STATE_FAILED", 4, 4);
        AUDIO_MIXING_STATE_FAILED = r104;
        AudioMixingState r105 = new AudioMixingState("AUDIO_MIXING_STATE_FINISHED", 5, 5);
        AUDIO_MIXING_STATE_FINISHED = r105;
        AudioMixingState r110 = new AudioMixingState("AUDIO_MIXING_STATE_PCM_ENABLED", 6, 6);
        AUDIO_MIXING_STATE_PCM_ENABLED = r110;
        AudioMixingState r111 = new AudioMixingState("AUDIO_MIXING_STATE_PCM_DISABLED", 7, 7);
        AUDIO_MIXING_STATE_PCM_DISABLED = r111;
        $VALUES = new AudioMixingState[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static AudioMixingState[] values() {
        return (AudioMixingState[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioMixingState[ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "AUDIO_MIXING_STATE_PCM_DISABLED";
    L6:
        return "AUDIO_MIXING_STATE_PCM_ENABLED";
    L7:
        return "AUDIO_MIXING_STATE_FINISHED";
    L8:
        return "AUDIO_MIXING_STATE_FAILED";
    L9:
        return "AUDIO_MIXING_STATE_STOPPED";
    L10:
        return "AUDIO_MIXING_STATE_PAUSED";
    L11:
        return "AUDIO_MIXING_STATE_PLAYING";
    L12:
        return "AUDIO_MIXING_STATE_PRELOADED";
    }

    public int value() {
        return this.value;
    }

    public static AudioMixingState fromId(int r100) {
        AudioMixingState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioMixingState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioMixingState valueOf(String r100) {
        return (AudioMixingState) a.a(AudioMixingState.class, r100);
    }

    private AudioMixingState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
