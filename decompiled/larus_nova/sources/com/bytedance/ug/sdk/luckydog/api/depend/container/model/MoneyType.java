package com.bytedance.ug.sdk.luckydog.api.depend.container.model;

import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum MoneyType extends Enum<MoneyType> {
    public static final MoneyType ALL = null;
    public static final MoneyType GOLD = null;
    public static final MoneyType RMB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MoneyType[] f271569a = null;

    static {
        MoneyType r100 = new MoneyType(AccountType.ALL, 0);
        ALL = r100;
        MoneyType r101 = new MoneyType("RMB", 1);
        RMB = r101;
        MoneyType r102 = new MoneyType("GOLD", 2);
        GOLD = r102;
        f271569a = new MoneyType[]{r100, r101, r102};
    }

    public static MoneyType[] values() {
        return (MoneyType[]) f271569a.clone();
    }

    public static MoneyType valueOf(String r100) {
        return (MoneyType) a.a(MoneyType.class, r100);
    }

    public MoneyType(String r100, int r101) {
        super(r100, r101);
    }
}
