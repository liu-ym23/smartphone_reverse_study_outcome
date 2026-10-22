package com.bytedance.ee.bear.bitable.card.model.enums;

import cu5.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum ECardType extends Enum<ECardType> {
    public static final ECardType BITABLE = null;
    public static final ECardType JIRA = null;
    public static final ECardType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECardType[] f207086a = null;

    static {
        ECardType r100 = new ECardType("BITABLE", 0);
        BITABLE = r100;
        ECardType r101 = new ECardType("JIRA", 1);
        JIRA = r101;
        ECardType r102 = new ECardType("UNKNOWN", 2);
        UNKNOWN = r102;
        f207086a = new ECardType[]{r100, r101, r102};
    }

    public static ECardType[] values() {
        return (ECardType[]) f207086a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return a.a(name().toLowerCase());
    }

    public static ECardType valueOf(String r100) {
        return (ECardType) r27.a.a(ECardType.class, r100);
    }

    public ECardType(String r100, int r101) {
        super(r100, r101);
    }
}
