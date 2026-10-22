package com.ss.android.lark.forwardv2.dto.template.config;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum Condition$TenantCondition extends Enum<Condition$TenantCondition> implements Serializable {
    public static final Condition$TenantCondition ALL_TENANT = null;
    public static final Condition$TenantCondition CROSS_TENANT = null;
    public static final Condition$TenantCondition NOT_CROSS_TENANT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Condition$TenantCondition[] f424877a = null;
    public static int offset;
    private final int value;

    static {
        Condition$TenantCondition r100 = new Condition$TenantCondition("ALL_TENANT", 0, 0);
        ALL_TENANT = r100;
        Condition$TenantCondition r101 = new Condition$TenantCondition("NOT_CROSS_TENANT", 1, 1);
        NOT_CROSS_TENANT = r101;
        Condition$TenantCondition r102 = new Condition$TenantCondition("CROSS_TENANT", 2, 2);
        CROSS_TENANT = r102;
        f424877a = new Condition$TenantCondition[]{r100, r101, r102};
        offset = 0;
    }

    public static Condition$TenantCondition[] values() {
        return (Condition$TenantCondition[]) f424877a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.value;
        if (r100 != 0) goto L5;
        return "ALL_TENANT";
    L5:
        if (r100 != 1) goto L7;
        return "NOT_CROSS_TENANT";
    L7:
        if (r100 == 2) goto L10;
        return "null";
    L10:
        return "CROSS_TENANT";
    }

    public int getValue() {
        return this.value;
    }

    public static Condition$TenantCondition fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return CROSS_TENANT;
    L12:
        return NOT_CROSS_TENANT;
    L14:
        return ALL_TENANT;
    }

    public static Condition$TenantCondition valueOf(String r100) {
        return (Condition$TenantCondition) a.a(Condition$TenantCondition.class, r100);
    }

    public Condition$TenantCondition(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
