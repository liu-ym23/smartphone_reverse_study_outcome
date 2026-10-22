package com.bytedance.ee.lark.plugin_annotation.bean;

import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum LKOpenApiBizDomain extends Enum<LKOpenApiBizDomain> {
    public static final LKOpenApiBizDomain ALL = null;
    public static final LKOpenApiBizDomain CALENDAR = null;
    public static final LKOpenApiBizDomain CCM = null;
    public static final LKOpenApiBizDomain INTERNAL_WEB = null;
    public static final LKOpenApiBizDomain MAIL = null;
    public static final LKOpenApiBizDomain MESSENGER = null;
    public static final LKOpenApiBizDomain OPEN_PLATFORM = null;
    public static final LKOpenApiBizDomain PANO = null;
    public static final LKOpenApiBizDomain PASSPORT = null;
    public static final LKOpenApiBizDomain VC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LKOpenApiBizDomain[] f242838a = null;

    static {
        LKOpenApiBizDomain r100 = new LKOpenApiBizDomain(AccountType.ALL, 0);
        ALL = r100;
        LKOpenApiBizDomain r101 = new LKOpenApiBizDomain("OPEN_PLATFORM", 1);
        OPEN_PLATFORM = r101;
        LKOpenApiBizDomain r102 = new LKOpenApiBizDomain("MESSENGER", 2);
        MESSENGER = r102;
        LKOpenApiBizDomain r103 = new LKOpenApiBizDomain("CCM", 3);
        CCM = r103;
        LKOpenApiBizDomain r104 = new LKOpenApiBizDomain("VC", 4);
        VC = r104;
        LKOpenApiBizDomain r105 = new LKOpenApiBizDomain("MAIL", 5);
        MAIL = r105;
        LKOpenApiBizDomain r110 = new LKOpenApiBizDomain("CALENDAR", 6);
        CALENDAR = r110;
        LKOpenApiBizDomain r111 = new LKOpenApiBizDomain("PASSPORT", 7);
        PASSPORT = r111;
        LKOpenApiBizDomain r112 = new LKOpenApiBizDomain("PANO", 8);
        PANO = r112;
        LKOpenApiBizDomain r113 = new LKOpenApiBizDomain("INTERNAL_WEB", 9);
        INTERNAL_WEB = r113;
        f242838a = new LKOpenApiBizDomain[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static LKOpenApiBizDomain[] values() {
        return (LKOpenApiBizDomain[]) f242838a.clone();
    }

    public static LKOpenApiBizDomain valueOf(String r100) {
        return (LKOpenApiBizDomain) a.a(LKOpenApiBizDomain.class, r100);
    }

    public LKOpenApiBizDomain(String r100, int r101) {
        super(r100, r101);
    }
}
