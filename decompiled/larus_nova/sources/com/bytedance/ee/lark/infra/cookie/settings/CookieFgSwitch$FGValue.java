package com.bytedance.ee.lark.infra.cookie.settings;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
final enum CookieFgSwitch$FGValue extends Enum<CookieFgSwitch$FGValue> {
    public static final CookieFgSwitch$FGValue CLOSE = null;
    public static final CookieFgSwitch$FGValue DEFAULT = null;
    public static final CookieFgSwitch$FGValue OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CookieFgSwitch$FGValue[] f242791a = null;

    static {
        CookieFgSwitch$FGValue r100 = new CookieFgSwitch$FGValue("DEFAULT", 0);
        DEFAULT = r100;
        CookieFgSwitch$FGValue r101 = new CookieFgSwitch$FGValue("OPEN", 1);
        OPEN = r101;
        CookieFgSwitch$FGValue r102 = new CookieFgSwitch$FGValue("CLOSE", 2);
        CLOSE = r102;
        f242791a = new CookieFgSwitch$FGValue[]{r100, r101, r102};
    }

    public static CookieFgSwitch$FGValue[] values() {
        return (CookieFgSwitch$FGValue[]) f242791a.clone();
    }

    public static CookieFgSwitch$FGValue valueOf(String r100) {
        return (CookieFgSwitch$FGValue) a.a(CookieFgSwitch$FGValue.class, r100);
    }

    public CookieFgSwitch$FGValue(String r100, int r101) {
        super(r100, r101);
    }
}
