package com.ss.android.lark.security.protocol.emm.api;

import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final enum SecurityActionType extends Enum<SecurityActionType> {
    private static final /* synthetic */ SecurityActionType[] $VALUES = null;
    public static final SecurityActionType EXEMPT = null;
    public static final SecurityActionType RESUME = null;

    static {
        SecurityActionType r100 = new SecurityActionType("EXEMPT", 0);
        EXEMPT = r100;
        SecurityActionType r101 = new SecurityActionType("RESUME", 1);
        RESUME = r101;
        $VALUES = new SecurityActionType[]{r100, r101};
    }

    public static SecurityActionType[] values() {
        return (SecurityActionType[]) $VALUES.clone();
    }

    public static SecurityActionType valueOf(String r100) {
        return (SecurityActionType) a.a(SecurityActionType.class, r100);
    }

    private SecurityActionType(String r100, int r101) {
        super(r100, r101);
    }
}
