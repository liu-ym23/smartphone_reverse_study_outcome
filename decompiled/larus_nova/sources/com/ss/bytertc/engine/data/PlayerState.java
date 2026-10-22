package com.ss.bytertc.engine.data;

import com.ss.android.cert.manager.constants.EventConstant;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum PlayerState extends Enum<PlayerState> {
    private static final /* synthetic */ PlayerState[] $VALUES = null;
    public static final PlayerState FAILED = null;
    public static final PlayerState FINISHED = null;
    public static final PlayerState IDLE = null;
    public static final PlayerState LOOP_FINISHED = null;
    public static final PlayerState OPENED = null;
    public static final PlayerState PAUSED = null;
    public static final PlayerState PLAYING = null;
    public static final PlayerState PRELOADED = null;
    public static final PlayerState STOPPED = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.PlayerState$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$PlayerState = null;

        static {
            int[] r100 = new int[PlayerState.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$PlayerState = r100;
            r100[PlayerState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerState[PlayerState.PRELOADED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerState[PlayerState.OPENED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerState[PlayerState.PLAYING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerState[PlayerState.PAUSED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerState[PlayerState.STOPPED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerState[PlayerState.FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerState[PlayerState.FINISHED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            $SwitchMap$com$ss$bytertc$engine$data$PlayerState[PlayerState.LOOP_FINISHED.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    static {
        PlayerState r100 = new PlayerState("IDLE", 0, 0);
        IDLE = r100;
        PlayerState r101 = new PlayerState("PRELOADED", 1, 1);
        PRELOADED = r101;
        PlayerState r102 = new PlayerState(EventConstant.Event.EVENT_NFC_OPENED, 2, 2);
        OPENED = r102;
        PlayerState r103 = new PlayerState("PLAYING", 3, 3);
        PLAYING = r103;
        PlayerState r104 = new PlayerState("PAUSED", 4, 4);
        PAUSED = r104;
        PlayerState r105 = new PlayerState("STOPPED", 5, 5);
        STOPPED = r105;
        PlayerState r110 = new PlayerState("FAILED", 6, 6);
        FAILED = r110;
        PlayerState r111 = new PlayerState("FINISHED", 7, 7);
        FINISHED = r111;
        PlayerState r112 = new PlayerState("LOOP_FINISHED", 8, 8);
        LOOP_FINISHED = r112;
        $VALUES = new PlayerState[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static PlayerState[] values() {
        return (PlayerState[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$PlayerState[ordinal()]) {
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
        return "LOOP_FINISHED";
    L6:
        return "FINISHED";
    L7:
        return "FAILED";
    L8:
        return "STOPPED";
    L9:
        return "PAUSED";
    L10:
        return "PLAYING";
    L11:
        return EventConstant.Event.EVENT_NFC_OPENED;
    L12:
        return "PRELOADED";
    L13:
        return "IDLE";
    }

    public int value() {
        return this.value;
    }

    public static PlayerState fromId(int r100) {
        PlayerState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        PlayerState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static PlayerState valueOf(String r100) {
        return (PlayerState) a.a(PlayerState.class, r100);
    }

    private PlayerState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
