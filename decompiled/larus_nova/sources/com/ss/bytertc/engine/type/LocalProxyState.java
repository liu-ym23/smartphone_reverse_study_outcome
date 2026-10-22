package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum LocalProxyState extends Enum<LocalProxyState> {
    private static final /* synthetic */ LocalProxyState[] $VALUES = null;
    public static final LocalProxyState CONNECTED = null;
    public static final LocalProxyState ERROR = null;
    public static final LocalProxyState INITED = null;
    private int value;

    static {
        LocalProxyState r100 = new LocalProxyState("INITED", 0, 0);
        INITED = r100;
        LocalProxyState r101 = new LocalProxyState("CONNECTED", 1, 1);
        CONNECTED = r101;
        LocalProxyState r102 = new LocalProxyState("ERROR", 2, 2);
        ERROR = r102;
        $VALUES = new LocalProxyState[]{r100, r101, r102};
    }

    public static LocalProxyState[] values() {
        return (LocalProxyState[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static LocalProxyState fromId(int r100) {
        LocalProxyState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        LocalProxyState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static LocalProxyState valueOf(String r100) {
        return (LocalProxyState) a.a(LocalProxyState.class, r100);
    }

    private LocalProxyState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
