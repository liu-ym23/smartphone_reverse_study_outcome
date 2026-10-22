package com.larus.account.base.model;

import r27.a;

/* JADX INFO: loaded from: classes24.dex */
public final enum PhoneOneKeyPlatform extends Enum<PhoneOneKeyPlatform> {
    public static final PhoneOneKeyPlatform MOBILE = null;
    public static final PhoneOneKeyPlatform TELECOM = null;
    public static final PhoneOneKeyPlatform UNICOM = null;
    public static final PhoneOneKeyPlatform UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PhoneOneKeyPlatform[] f286207a = null;

    static {
        PhoneOneKeyPlatform r100 = new PhoneOneKeyPlatform("MOBILE", 0);
        MOBILE = r100;
        PhoneOneKeyPlatform r101 = new PhoneOneKeyPlatform("TELECOM", 1);
        TELECOM = r101;
        PhoneOneKeyPlatform r102 = new PhoneOneKeyPlatform("UNICOM", 2);
        UNICOM = r102;
        PhoneOneKeyPlatform r103 = new PhoneOneKeyPlatform("UNKNOWN", 3);
        UNKNOWN = r103;
        f286207a = new PhoneOneKeyPlatform[]{r100, r101, r102, r103};
    }

    public static PhoneOneKeyPlatform[] values() {
        return (PhoneOneKeyPlatform[]) f286207a.clone();
    }

    public static PhoneOneKeyPlatform valueOf(String r100) {
        return (PhoneOneKeyPlatform) a.a(PhoneOneKeyPlatform.class, r100);
    }

    public PhoneOneKeyPlatform(String r100, int r101) {
        super(r100, r101);
    }
}
