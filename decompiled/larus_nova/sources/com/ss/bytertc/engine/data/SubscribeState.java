package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum SubscribeState extends Enum<SubscribeState> {
    private static final /* synthetic */ SubscribeState[] $VALUES = null;
    public static final SubscribeState SUBSCRIBED = null;
    public static final SubscribeState UNSUBSCRIBED = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.SubscribeState$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$SubscribeState = null;

        static {
            int[] r100 = new int[SubscribeState.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$SubscribeState = r100;
            r100[SubscribeState.SUBSCRIBED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$engine$data$SubscribeState[SubscribeState.UNSUBSCRIBED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        SubscribeState r100 = new SubscribeState("SUBSCRIBED", 0, 0);
        SUBSCRIBED = r100;
        SubscribeState r101 = new SubscribeState("UNSUBSCRIBED", 1, 1);
        UNSUBSCRIBED = r101;
        $VALUES = new SubscribeState[]{r100, r101};
    }

    public static SubscribeState[] values() {
        return (SubscribeState[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$SubscribeState[ordinal()];
        if (r100 != 1) goto L5;
        return "kSubscribeStateSubscribed";
    L5:
        if (r100 == 2) goto L7;
        return "";
    L7:
        return "kSubscribeStateUnsubscribed";
    }

    public int value() {
        return this.value;
    }

    public static SubscribeState fromId(int r100) {
        SubscribeState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        SubscribeState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static SubscribeState valueOf(String r100) {
        return (SubscribeState) a.a(SubscribeState.class, r100);
    }

    private SubscribeState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
