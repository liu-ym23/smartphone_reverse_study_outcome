package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioMixingError extends Enum<AudioMixingError> {
    private static final /* synthetic */ AudioMixingError[] $VALUES = null;
    public static final AudioMixingError AUDIO_MIXING_ERROR_ID_NOT_FOUND = null;
    public static final AudioMixingError AUDIO_MIXING_ERROR_ID_TYPE_INVALID_PITCH = null;
    public static final AudioMixingError AUDIO_MIXING_ERROR_ID_TYPE_NOT_MATCH = null;
    public static final AudioMixingError AUDIO_MIXING_ERROR_INVALID_AUDIO_TRACK = null;
    public static final AudioMixingError AUDIO_MIXING_ERROR_INVALID_PLAYBACK_SPEED = null;
    public static final AudioMixingError AUDIO_MIXING_ERROR_INVALID_VOLUME = null;
    public static final AudioMixingError AUDIO_MIXING_ERROR_IS_STARTING = null;
    public static final AudioMixingError AUDIO_MIXING_ERROR_LOAD_CONFLICT = null;
    public static final AudioMixingError AUDIO_MIXING_ERROR_OK = null;
    public static final AudioMixingError AUDIO_MIXING_ERROR_PRELOAD_FAILED = null;
    public static final AudioMixingError AUDIO_MIXING_ERROR_SET_POSITION_FAILED = null;
    public static final AudioMixingError AUDIO_MIXING_ERROR_START_FAILED = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AudioMixingError$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioMixingError = null;

        static {
            int[] r100 = new int[AudioMixingError.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingError = r100;
            r100[AudioMixingError.AUDIO_MIXING_ERROR_OK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingError[AudioMixingError.AUDIO_MIXING_ERROR_PRELOAD_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingError[AudioMixingError.AUDIO_MIXING_ERROR_START_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingError[AudioMixingError.AUDIO_MIXING_ERROR_ID_NOT_FOUND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingError[AudioMixingError.AUDIO_MIXING_ERROR_SET_POSITION_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingError[AudioMixingError.AUDIO_MIXING_ERROR_INVALID_VOLUME.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingError[AudioMixingError.AUDIO_MIXING_ERROR_LOAD_CONFLICT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingError[AudioMixingError.AUDIO_MIXING_ERROR_ID_TYPE_NOT_MATCH.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingError[AudioMixingError.AUDIO_MIXING_ERROR_ID_TYPE_INVALID_PITCH.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingError[AudioMixingError.AUDIO_MIXING_ERROR_INVALID_AUDIO_TRACK.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingError[AudioMixingError.AUDIO_MIXING_ERROR_IS_STARTING.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingError[AudioMixingError.AUDIO_MIXING_ERROR_INVALID_PLAYBACK_SPEED.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    static {
        AudioMixingError r100 = new AudioMixingError("AUDIO_MIXING_ERROR_OK", 0, 0);
        AUDIO_MIXING_ERROR_OK = r100;
        AudioMixingError r101 = new AudioMixingError("AUDIO_MIXING_ERROR_PRELOAD_FAILED", 1, 1);
        AUDIO_MIXING_ERROR_PRELOAD_FAILED = r101;
        AudioMixingError r102 = new AudioMixingError("AUDIO_MIXING_ERROR_START_FAILED", 2, 2);
        AUDIO_MIXING_ERROR_START_FAILED = r102;
        AudioMixingError r103 = new AudioMixingError("AUDIO_MIXING_ERROR_ID_NOT_FOUND", 3, 3);
        AUDIO_MIXING_ERROR_ID_NOT_FOUND = r103;
        AudioMixingError r104 = new AudioMixingError("AUDIO_MIXING_ERROR_SET_POSITION_FAILED", 4, 4);
        AUDIO_MIXING_ERROR_SET_POSITION_FAILED = r104;
        AudioMixingError r105 = new AudioMixingError("AUDIO_MIXING_ERROR_INVALID_VOLUME", 5, 5);
        AUDIO_MIXING_ERROR_INVALID_VOLUME = r105;
        AudioMixingError r110 = new AudioMixingError("AUDIO_MIXING_ERROR_LOAD_CONFLICT", 6, 6);
        AUDIO_MIXING_ERROR_LOAD_CONFLICT = r110;
        AudioMixingError r111 = new AudioMixingError("AUDIO_MIXING_ERROR_ID_TYPE_NOT_MATCH", 7, 7);
        AUDIO_MIXING_ERROR_ID_TYPE_NOT_MATCH = r111;
        AudioMixingError r112 = new AudioMixingError("AUDIO_MIXING_ERROR_ID_TYPE_INVALID_PITCH", 8, 8);
        AUDIO_MIXING_ERROR_ID_TYPE_INVALID_PITCH = r112;
        AudioMixingError r113 = new AudioMixingError("AUDIO_MIXING_ERROR_INVALID_AUDIO_TRACK", 9, 9);
        AUDIO_MIXING_ERROR_INVALID_AUDIO_TRACK = r113;
        AudioMixingError r114 = new AudioMixingError("AUDIO_MIXING_ERROR_IS_STARTING", 10, 10);
        AUDIO_MIXING_ERROR_IS_STARTING = r114;
        AudioMixingError r115 = new AudioMixingError("AUDIO_MIXING_ERROR_INVALID_PLAYBACK_SPEED", 11, 11);
        AUDIO_MIXING_ERROR_INVALID_PLAYBACK_SPEED = r115;
        $VALUES = new AudioMixingError[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
    }

    public static AudioMixingError[] values() {
        return (AudioMixingError[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioMixingError[ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L6;
            case 12: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "AUDIO_MIXING_ERROR_INVALID_PLAYBACK_SPEED";
    L6:
        return "AUDIO_MIXING_ERROR_IS_STARTING";
    L7:
        return "AUDIO_MIXING_ERROR_INVALID_AUDIO_TRACK";
    L8:
        return "AUDIO_MIXING_ERROR_ID_TYPE_INVALID_PITCH";
    L9:
        return "AUDIO_MIXING_ERROR_ID_TYPE_NOT_MATCH";
    L10:
        return "AUDIO_MIXING_ERROR_LOAD_CONFLICT";
    L11:
        return "AUDIO_MIXING_ERROR_INVALID_VOLUME";
    L12:
        return "AUDIO_MIXING_ERROR_SET_POSITION_FAILED";
    L13:
        return "AUDIO_MIXING_ERROR_ID_NOT_FOUND";
    L14:
        return "AUDIO_MIXING_ERROR_START_FAILED";
    L15:
        return "AUDIO_MIXING_ERROR_PRELOAD_FAILED";
    L16:
        return "AUDIO_MIXING_ERROR_OK";
    }

    public int value() {
        return this.value;
    }

    public static AudioMixingError fromId(int r100) {
        AudioMixingError[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioMixingError r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioMixingError valueOf(String r100) {
        return (AudioMixingError) a.a(AudioMixingError.class, r100);
    }

    private AudioMixingError(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
