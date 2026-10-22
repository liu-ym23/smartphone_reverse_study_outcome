package com.ss.bytertc.ktv.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum PlayState extends Enum<PlayState> {
    private static final /* synthetic */ PlayState[] $VALUES = null;
    public static final PlayState FAILED = null;
    public static final PlayState FINISHED = null;
    public static final PlayState PAUSED = null;
    public static final PlayState PLAYING = null;
    public static final PlayState STOPPED = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.ktv.data.PlayState$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$PlayState = null;

        static {
            int[] r100 = new int[PlayState.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$PlayState = r100;
            r100[PlayState.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$bytertc$ktv$data$PlayState[PlayState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$bytertc$ktv$data$PlayState[PlayState.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$ss$bytertc$ktv$data$PlayState[PlayState.FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$ss$bytertc$ktv$data$PlayState[PlayState.FINISHED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        PlayState r100 = new PlayState("PLAYING", 0, 1);
        PLAYING = r100;
        PlayState r101 = new PlayState("PAUSED", 1, 2);
        PAUSED = r101;
        PlayState r102 = new PlayState("STOPPED", 2, 3);
        STOPPED = r102;
        PlayState r103 = new PlayState("FAILED", 3, 4);
        FAILED = r103;
        PlayState r104 = new PlayState("FINISHED", 4, 5);
        FINISHED = r104;
        $VALUES = new PlayState[]{r100, r101, r102, r103, r104};
    }

    public static PlayState[] values() {
        return (PlayState[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$PlayState[ordinal()];
        if (r100 != 1) goto L5;
        return "PLAY_STATE_PLAYING";
    L5:
        if (r100 != 2) goto L7;
        return "PLAY_STATE_PAUSED";
    L7:
        if (r100 != 3) goto L9;
        return "PLAY_STATE_STOPPED";
    L9:
        if (r100 != 4) goto L11;
        return "PLAY_STATE_FAILED";
    L11:
        if (r100 == 5) goto L13;
        return "";
    L13:
        return "PLAY_STATE_FINISHED";
    }

    public int value() {
        return this.value;
    }

    public static PlayState fromId(int r100) {
        PlayState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        PlayState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static PlayState valueOf(String r100) {
        return (PlayState) a.a(PlayState.class, r100);
    }

    private PlayState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
