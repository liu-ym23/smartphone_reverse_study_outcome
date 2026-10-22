package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum SingleStreamTaskEvent extends Enum<SingleStreamTaskEvent> {
    private static final /* synthetic */ SingleStreamTaskEvent[] $VALUES = null;
    public static final SingleStreamTaskEvent BASE = null;
    public static final SingleStreamTaskEvent START_FAILED = null;
    public static final SingleStreamTaskEvent START_SUCCESS = null;
    public static final SingleStreamTaskEvent STOP_FAILED = null;
    public static final SingleStreamTaskEvent STOP_SUCCESS = null;
    public static final SingleStreamTaskEvent WARNING = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.live.SingleStreamTaskEvent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskEvent = null;

        static {
            int[] r100 = new int[SingleStreamTaskEvent.values().length];
            $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskEvent = r100;
            r100[SingleStreamTaskEvent.BASE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskEvent[SingleStreamTaskEvent.START_SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskEvent[SingleStreamTaskEvent.START_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskEvent[SingleStreamTaskEvent.STOP_SUCCESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskEvent[SingleStreamTaskEvent.STOP_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskEvent[SingleStreamTaskEvent.WARNING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        SingleStreamTaskEvent r100 = new SingleStreamTaskEvent("BASE", 0, 0);
        BASE = r100;
        SingleStreamTaskEvent r101 = new SingleStreamTaskEvent("START_SUCCESS", 1, 1);
        START_SUCCESS = r101;
        SingleStreamTaskEvent r102 = new SingleStreamTaskEvent("START_FAILED", 2, 2);
        START_FAILED = r102;
        SingleStreamTaskEvent r103 = new SingleStreamTaskEvent("STOP_SUCCESS", 3, 3);
        STOP_SUCCESS = r103;
        SingleStreamTaskEvent r104 = new SingleStreamTaskEvent("STOP_FAILED", 4, 4);
        STOP_FAILED = r104;
        SingleStreamTaskEvent r105 = new SingleStreamTaskEvent("WARNING", 5, 5);
        WARNING = r105;
        $VALUES = new SingleStreamTaskEvent[]{r100, r101, r102, r103, r104, r105};
    }

    public static SingleStreamTaskEvent[] values() {
        return (SingleStreamTaskEvent[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskEvent[ordinal()]) {
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
        return "WARNING";
    L6:
        return "STREAM_MIXING_STOP_FAILED";
    L7:
        return "STREAM_MIXING_STOP_SUCCESS";
    L8:
        return "START_FAILED";
    L9:
        return "START_SUCCESS";
    L10:
        return "BASE";
    }

    public int value() {
        return this.value;
    }

    public static SingleStreamTaskEvent fromId(int r100) {
        SingleStreamTaskEvent[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        SingleStreamTaskEvent r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static SingleStreamTaskEvent valueOf(String r100) {
        return (SingleStreamTaskEvent) a.a(SingleStreamTaskEvent.class, r100);
    }

    private SingleStreamTaskEvent(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
