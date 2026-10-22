package com.ss.android.lark.security.protocol.emm.api;

import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final enum SecurityBizType extends Enum<SecurityBizType> {
    private static final /* synthetic */ SecurityBizType[] $VALUES = null;
    public static final SecurityBizType SCREEN_CAPTURE_PROTECT = null;

    static {
        SecurityBizType r100 = new SecurityBizType("SCREEN_CAPTURE_PROTECT", 0);
        SCREEN_CAPTURE_PROTECT = r100;
        $VALUES = new SecurityBizType[]{r100};
    }

    public static SecurityBizType[] values() {
        return (SecurityBizType[]) $VALUES.clone();
    }

    public static SecurityBizType valueOf(String r100) {
        return (SecurityBizType) a.a(SecurityBizType.class, r100);
    }

    private SecurityBizType(String r100, int r101) {
        super(r100, r101);
    }
}
