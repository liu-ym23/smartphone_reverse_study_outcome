package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum WTNSubscribeState extends Enum<WTNSubscribeState> {
    private static final /* synthetic */ WTNSubscribeState[] $VALUES = null;
    public static final WTNSubscribeState SUBSCRIBED = null;
    public static final WTNSubscribeState UNSUBSCRIBED = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.WTNSubscribeState$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeState = null;

        static {
            int[] r100 = new int[WTNSubscribeState.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeState = r100;
            r100[WTNSubscribeState.SUBSCRIBED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeState[WTNSubscribeState.UNSUBSCRIBED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        WTNSubscribeState r100 = new WTNSubscribeState("SUBSCRIBED", 0, 0);
        SUBSCRIBED = r100;
        WTNSubscribeState r101 = new WTNSubscribeState("UNSUBSCRIBED", 1, 1);
        UNSUBSCRIBED = r101;
        $VALUES = new WTNSubscribeState[]{r100, r101};
    }

    public static WTNSubscribeState[] values() {
        return (WTNSubscribeState[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeState[ordinal()];
        if (r100 != 1) goto L5;
        return "kWTNSubscribeStateSubscribed";
    L5:
        if (r100 == 2) goto L7;
        return "";
    L7:
        return "kWTNSubscribeStateUnsubscribed";
    }

    public int value() {
        return this.value;
    }

    public static WTNSubscribeState fromId(int r100) {
        WTNSubscribeState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        WTNSubscribeState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static WTNSubscribeState valueOf(String r100) {
        return (WTNSubscribeState) a.a(WTNSubscribeState.class, r100);
    }

    private WTNSubscribeState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
