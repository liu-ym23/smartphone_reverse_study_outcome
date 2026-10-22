package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MixedStreamTaskEvent extends Enum<MixedStreamTaskEvent> {
    private static final /* synthetic */ MixedStreamTaskEvent[] $VALUES = null;
    public static final MixedStreamTaskEvent BASE = null;
    public static final MixedStreamTaskEvent START_FAILED = null;
    public static final MixedStreamTaskEvent START_SUCCESS = null;
    public static final MixedStreamTaskEvent STOP_FAILED = null;
    public static final MixedStreamTaskEvent STOP_SUCCESS = null;
    public static final MixedStreamTaskEvent UPDATE_FAILED = null;
    public static final MixedStreamTaskEvent UPDATE_SUCCESS = null;
    public static final MixedStreamTaskEvent WARNING = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.live.MixedStreamTaskEvent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskEvent = null;

        static {
            int[] r100 = new int[MixedStreamTaskEvent.values().length];
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskEvent = r100;
            r100[MixedStreamTaskEvent.BASE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskEvent[MixedStreamTaskEvent.START_SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskEvent[MixedStreamTaskEvent.START_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskEvent[MixedStreamTaskEvent.UPDATE_SUCCESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskEvent[MixedStreamTaskEvent.UPDATE_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskEvent[MixedStreamTaskEvent.STOP_SUCCESS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskEvent[MixedStreamTaskEvent.STOP_FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskEvent[MixedStreamTaskEvent.WARNING.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static {
        MixedStreamTaskEvent r100 = new MixedStreamTaskEvent("BASE", 0, 0);
        BASE = r100;
        MixedStreamTaskEvent r101 = new MixedStreamTaskEvent("START_SUCCESS", 1, 1);
        START_SUCCESS = r101;
        MixedStreamTaskEvent r102 = new MixedStreamTaskEvent("START_FAILED", 2, 2);
        START_FAILED = r102;
        MixedStreamTaskEvent r103 = new MixedStreamTaskEvent("UPDATE_SUCCESS", 3, 3);
        UPDATE_SUCCESS = r103;
        MixedStreamTaskEvent r104 = new MixedStreamTaskEvent("UPDATE_FAILED", 4, 4);
        UPDATE_FAILED = r104;
        MixedStreamTaskEvent r105 = new MixedStreamTaskEvent("STOP_SUCCESS", 5, 5);
        STOP_SUCCESS = r105;
        MixedStreamTaskEvent r110 = new MixedStreamTaskEvent("STOP_FAILED", 6, 6);
        STOP_FAILED = r110;
        MixedStreamTaskEvent r111 = new MixedStreamTaskEvent("WARNING", 7, 7);
        WARNING = r111;
        $VALUES = new MixedStreamTaskEvent[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static MixedStreamTaskEvent[] values() {
        return (MixedStreamTaskEvent[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$live$MixedStreamTaskEvent[ordinal()]) {
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
        return "WARNING";
    L6:
        return "STREAM_MIXING_STOP_FAILED";
    L7:
        return "STREAM_MIXING_STOP_SUCCESS";
    L8:
        return "UPDATE_FAILED";
    L9:
        return "UPDATE_SUCCESS";
    L10:
        return "START_FAILED";
    L11:
        return "START_SUCCESS";
    L12:
        return "BASE";
    }

    public int value() {
        return this.value;
    }

    public static MixedStreamTaskEvent fromId(int r100) {
        MixedStreamTaskEvent[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        MixedStreamTaskEvent r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static MixedStreamTaskEvent valueOf(String r100) {
        return (MixedStreamTaskEvent) a.a(MixedStreamTaskEvent.class, r100);
    }

    private MixedStreamTaskEvent(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
