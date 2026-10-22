package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum LocalProxyError extends Enum<LocalProxyError> {
    private static final /* synthetic */ LocalProxyError[] $VALUES = null;
    public static final LocalProxyError HTTP_TUNNEL_FAILED = null;
    public static final LocalProxyError OK = null;
    public static final LocalProxyError SOCKS5_FORMAT_ERROR = null;
    public static final LocalProxyError SOCKS5_INVALID_VALUE = null;
    public static final LocalProxyError SOCKS5_TCP_CLOSED = null;
    public static final LocalProxyError SOCKS5_USER_PASS_NOT_GIVEN = null;
    public static final LocalProxyError SOCKS5_VERSION_ERROR = null;
    private int value;

    static {
        LocalProxyError r100 = new LocalProxyError("OK", 0, 0);
        OK = r100;
        LocalProxyError r101 = new LocalProxyError("SOCKS5_VERSION_ERROR", 1, 1);
        SOCKS5_VERSION_ERROR = r101;
        LocalProxyError r102 = new LocalProxyError("SOCKS5_FORMAT_ERROR", 2, 2);
        SOCKS5_FORMAT_ERROR = r102;
        LocalProxyError r103 = new LocalProxyError("SOCKS5_INVALID_VALUE", 3, 3);
        SOCKS5_INVALID_VALUE = r103;
        LocalProxyError r104 = new LocalProxyError("SOCKS5_USER_PASS_NOT_GIVEN", 4, 4);
        SOCKS5_USER_PASS_NOT_GIVEN = r104;
        LocalProxyError r105 = new LocalProxyError("SOCKS5_TCP_CLOSED", 5, 5);
        SOCKS5_TCP_CLOSED = r105;
        LocalProxyError r110 = new LocalProxyError("HTTP_TUNNEL_FAILED", 6, 6);
        HTTP_TUNNEL_FAILED = r110;
        $VALUES = new LocalProxyError[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static LocalProxyError[] values() {
        return (LocalProxyError[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static LocalProxyError fromId(int r100) {
        LocalProxyError[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        LocalProxyError r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static LocalProxyError valueOf(String r100) {
        return (LocalProxyError) a.a(LocalProxyError.class, r100);
    }

    private LocalProxyError(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
