package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum SingleStreamTaskErrorCode extends Enum<SingleStreamTaskErrorCode> {
    private static final /* synthetic */ SingleStreamTaskErrorCode[] $VALUES = null;
    public static final SingleStreamTaskErrorCode BASE = null;
    public static final SingleStreamTaskErrorCode OK = null;
    public static final SingleStreamTaskErrorCode SIGNAL_REQUEST_TIMEOUT = null;
    public static final SingleStreamTaskErrorCode UNKNOWN_BY_SERVER = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.live.SingleStreamTaskErrorCode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskErrorCode = null;

        static {
            int[] r100 = new int[SingleStreamTaskErrorCode.values().length];
            $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskErrorCode = r100;
            r100[SingleStreamTaskErrorCode.OK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskErrorCode[SingleStreamTaskErrorCode.BASE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskErrorCode[SingleStreamTaskErrorCode.UNKNOWN_BY_SERVER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskErrorCode[SingleStreamTaskErrorCode.SIGNAL_REQUEST_TIMEOUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        SingleStreamTaskErrorCode r100 = new SingleStreamTaskErrorCode("OK", 0, 0);
        OK = r100;
        SingleStreamTaskErrorCode r101 = new SingleStreamTaskErrorCode("BASE", 1, 1090);
        BASE = r101;
        SingleStreamTaskErrorCode r102 = new SingleStreamTaskErrorCode("UNKNOWN_BY_SERVER", 2, 1091);
        UNKNOWN_BY_SERVER = r102;
        SingleStreamTaskErrorCode r103 = new SingleStreamTaskErrorCode("SIGNAL_REQUEST_TIMEOUT", 3, 1092);
        SIGNAL_REQUEST_TIMEOUT = r103;
        $VALUES = new SingleStreamTaskErrorCode[]{r100, r101, r102, r103};
    }

    public static SingleStreamTaskErrorCode[] values() {
        return (SingleStreamTaskErrorCode[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskErrorCode[ordinal()];
        if (r100 != 1) goto L5;
        return "OK";
    L5:
        if (r100 != 2) goto L7;
        return "BASE";
    L7:
        if (r100 != 3) goto L9;
        return "UNKNOWN_BY_SERVER";
    L9:
        if (r100 == 4) goto L11;
        return "";
    L11:
        return "SIGNAL_REQUEST_TIMEOUT";
    }

    public int value() {
        return this.value;
    }

    public static SingleStreamTaskErrorCode fromId(int r100) {
        SingleStreamTaskErrorCode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        SingleStreamTaskErrorCode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static SingleStreamTaskErrorCode valueOf(String r100) {
        return (SingleStreamTaskErrorCode) a.a(SingleStreamTaskErrorCode.class, r100);
    }

    private SingleStreamTaskErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
