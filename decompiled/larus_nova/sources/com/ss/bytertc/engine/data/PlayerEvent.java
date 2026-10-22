package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum PlayerEvent extends Enum<PlayerEvent> {
    private static final /* synthetic */ PlayerEvent[] $VALUES = null;
    public static final PlayerEvent SEEK_BEGIN = null;
    public static final PlayerEvent SEEK_COMPLETED = null;
    public static final PlayerEvent SEEK_FAILED = null;
    public static final PlayerEvent SELECT_AUDIO_TRACK_BEGIN = null;
    public static final PlayerEvent SELECT_AUDIO_TRACK_COMPLETED = null;
    public static final PlayerEvent SELECT_AUDIO_TRACK_FAILED = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.PlayerEvent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$PlayerEvent = null;

        static {
            int[] r100 = new int[PlayerEvent.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$PlayerEvent = r100;
            r100[PlayerEvent.SELECT_AUDIO_TRACK_BEGIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerEvent[PlayerEvent.SELECT_AUDIO_TRACK_COMPLETED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerEvent[PlayerEvent.SELECT_AUDIO_TRACK_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerEvent[PlayerEvent.SEEK_BEGIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerEvent[PlayerEvent.SEEK_COMPLETED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerEvent[PlayerEvent.SEEK_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        PlayerEvent r100 = new PlayerEvent("SELECT_AUDIO_TRACK_BEGIN", 0, 0);
        SELECT_AUDIO_TRACK_BEGIN = r100;
        PlayerEvent r101 = new PlayerEvent("SELECT_AUDIO_TRACK_COMPLETED", 1, 1);
        SELECT_AUDIO_TRACK_COMPLETED = r101;
        PlayerEvent r102 = new PlayerEvent("SELECT_AUDIO_TRACK_FAILED", 2, 2);
        SELECT_AUDIO_TRACK_FAILED = r102;
        PlayerEvent r103 = new PlayerEvent("SEEK_BEGIN", 3, 3);
        SEEK_BEGIN = r103;
        PlayerEvent r104 = new PlayerEvent("SEEK_COMPLETED", 4, 4);
        SEEK_COMPLETED = r104;
        PlayerEvent r105 = new PlayerEvent("SEEK_FAILED", 5, 5);
        SEEK_FAILED = r105;
        $VALUES = new PlayerEvent[]{r100, r101, r102, r103, r104, r105};
    }

    public static PlayerEvent[] values() {
        return (PlayerEvent[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$PlayerEvent[ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "SEEK_FAILED";
    L6:
        return "SEEK_COMPLETED";
    L7:
        return "SEEK_BEGIN";
    L8:
        return "SELECT_AUDIO_TRACK_FAILED";
    L9:
        return "SELECT_AUDIO_TRACK_COMPLETED";
    L10:
        return "SELECT_AUDIO_TRACK_BEGIN";
    }

    public int value() {
        return this.value;
    }

    public static PlayerEvent fromId(int r100) {
        PlayerEvent[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        PlayerEvent r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static PlayerEvent valueOf(String r100) {
        return (PlayerEvent) a.a(PlayerEvent.class, r100);
    }

    private PlayerEvent(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
