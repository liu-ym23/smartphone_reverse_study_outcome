package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum LocalProxyType extends Enum<LocalProxyType> {
    private static final /* synthetic */ LocalProxyType[] $VALUES = null;
    public static final LocalProxyType HTTP_TUNNEL = null;
    public static final LocalProxyType SOCKS5 = null;
    private int value;

    static {
        LocalProxyType r100 = new LocalProxyType("SOCKS5", 0, 1);
        SOCKS5 = r100;
        LocalProxyType r101 = new LocalProxyType("HTTP_TUNNEL", 1, 2);
        HTTP_TUNNEL = r101;
        $VALUES = new LocalProxyType[]{r100, r101};
    }

    public static LocalProxyType[] values() {
        return (LocalProxyType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static LocalProxyType fromId(int r100) {
        LocalProxyType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        LocalProxyType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static LocalProxyType valueOf(String r100) {
        return (LocalProxyType) a.a(LocalProxyType.class, r100);
    }

    private LocalProxyType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
