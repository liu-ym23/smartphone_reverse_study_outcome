package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum PlayerError extends Enum<PlayerError> {
    private static final /* synthetic */ PlayerError[] $VALUES = null;
    public static final PlayerError ERROR_CURRENTLY_PLAYING = null;
    public static final PlayerError FORMAT_NOT_SUPPORT = null;
    public static final PlayerError INVALID_AUDIO_TRACK_INDEX = null;
    public static final PlayerError INVALID_EFFECT_ID = null;
    public static final PlayerError INVALID_PATH = null;
    public static final PlayerError INVALID_PITCH = null;
    public static final PlayerError INVALID_PLAYBACK_SPEED = null;
    public static final PlayerError INVALID_POSITION = null;
    public static final PlayerError INVALID_STATE = null;
    public static final PlayerError INVALID_VOLUME = null;
    public static final PlayerError OK = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.PlayerError$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$PlayerError = null;

        static {
            int[] r100 = new int[PlayerError.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$PlayerError = r100;
            r100[PlayerError.OK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L28:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerError[PlayerError.FORMAT_NOT_SUPPORT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerError[PlayerError.INVALID_PATH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L46:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerError[PlayerError.INVALID_STATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerError[PlayerError.INVALID_POSITION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L36:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerError[PlayerError.INVALID_VOLUME.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L40:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerError[PlayerError.INVALID_PITCH.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerError[PlayerError.INVALID_AUDIO_TRACK_INDEX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L26:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerError[PlayerError.INVALID_PLAYBACK_SPEED.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L32:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerError[PlayerError.INVALID_EFFECT_ID.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L38:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerError[PlayerError.ERROR_CURRENTLY_PLAYING.ordinal()] = 11;     // Catch: NoSuchFieldError -> L25
            return;
        }
    }

    static {
        PlayerError r100 = new PlayerError("OK", 0, 0);
        OK = r100;
        PlayerError r101 = new PlayerError("FORMAT_NOT_SUPPORT", 1, 1);
        FORMAT_NOT_SUPPORT = r101;
        PlayerError r102 = new PlayerError("INVALID_PATH", 2, 2);
        INVALID_PATH = r102;
        PlayerError r103 = new PlayerError("INVALID_STATE", 3, 3);
        INVALID_STATE = r103;
        PlayerError r104 = new PlayerError("INVALID_POSITION", 4, 4);
        INVALID_POSITION = r104;
        PlayerError r105 = new PlayerError("INVALID_VOLUME", 5, 5);
        INVALID_VOLUME = r105;
        PlayerError r110 = new PlayerError("INVALID_PITCH", 6, 6);
        INVALID_PITCH = r110;
        PlayerError r111 = new PlayerError("INVALID_AUDIO_TRACK_INDEX", 7, 7);
        INVALID_AUDIO_TRACK_INDEX = r111;
        PlayerError r112 = new PlayerError("INVALID_PLAYBACK_SPEED", 8, 8);
        INVALID_PLAYBACK_SPEED = r112;
        PlayerError r113 = new PlayerError("INVALID_EFFECT_ID", 9, 9);
        INVALID_EFFECT_ID = r113;
        PlayerError r114 = new PlayerError("ERROR_CURRENTLY_PLAYING", 10, 10);
        ERROR_CURRENTLY_PLAYING = r114;
        $VALUES = new PlayerError[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
    }

    public static PlayerError[] values() {
        return (PlayerError[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$PlayerError[ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "ERROR_CURRENTLY_PLAYING";
    L6:
        return "INVALID_EFFECT_ID";
    L7:
        return "INVALID_PLAYBACK_SPEED";
    L8:
        return "INVALID_AUDIO_TRACK_INDEX";
    L9:
        return "INVALID_PITCH";
    L10:
        return "INVALID_VOLUME";
    L11:
        return "INVALID_POSITION";
    L12:
        return "INVALID_STATE";
    L13:
        return "INVALID_PATH";
    L14:
        return "FORMAT_NOT_SUPPORT";
    L15:
        return "OK";
    }

    public int value() {
        return this.value;
    }

    public static PlayerError fromId(int r100) {
        PlayerError[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        PlayerError r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static PlayerError valueOf(String r100) {
        return (PlayerError) a.a(PlayerError.class, r100);
    }

    private PlayerError(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
