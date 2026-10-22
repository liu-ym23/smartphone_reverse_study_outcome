package com.ss.android.lark.forwardv2.dto.template.config;

import com.obric.miniapp.alarm.AccountType;
import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum Condition$UserTypeCondition extends Enum<Condition$UserTypeCondition> implements Serializable {
    public static final Condition$UserTypeCondition ALL_USER = null;
    public static final Condition$UserTypeCondition OTHERS = null;
    public static final Condition$UserTypeCondition SELF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Condition$UserTypeCondition[] f424879a = null;
    public static int offset;
    private final int value;

    static {
        Condition$UserTypeCondition r100 = new Condition$UserTypeCondition("ALL_USER", 0, 0);
        ALL_USER = r100;
        Condition$UserTypeCondition r101 = new Condition$UserTypeCondition("SELF", 1, 1);
        SELF = r101;
        Condition$UserTypeCondition r102 = new Condition$UserTypeCondition(AccountType.OTHERS, 2, 2);
        OTHERS = r102;
        f424879a = new Condition$UserTypeCondition[]{r100, r101, r102};
        offset = 2;
    }

    public static Condition$UserTypeCondition[] values() {
        return (Condition$UserTypeCondition[]) f424879a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.value;
        if (r100 != 0) goto L5;
        return "ALL_USER";
    L5:
        if (r100 != 1) goto L7;
        return "SELF";
    L7:
        if (r100 == 2) goto L10;
        return "null";
    L10:
        return AccountType.OTHERS;
    }

    public int getValue() {
        return this.value;
    }

    public static Condition$UserTypeCondition fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return OTHERS;
    L12:
        return SELF;
    L14:
        return ALL_USER;
    }

    public static Condition$UserTypeCondition valueOf(String r100) {
        return (Condition$UserTypeCondition) a.a(Condition$UserTypeCondition.class, r100);
    }

    public Condition$UserTypeCondition(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
