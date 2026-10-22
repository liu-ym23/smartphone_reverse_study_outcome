package com.ss.android.lark.forwardv2.dto.template.config;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum Condition$PublicTypeCondition extends Enum<Condition$PublicTypeCondition> implements Serializable {
    public static final Condition$PublicTypeCondition ALL_STATUS = null;
    public static final Condition$PublicTypeCondition PRIVATE = null;
    public static final Condition$PublicTypeCondition PUBLIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Condition$PublicTypeCondition[] f424875a = null;
    public static int offset;
    private final int value;

    static {
        Condition$PublicTypeCondition r100 = new Condition$PublicTypeCondition("ALL_STATUS", 0, 0);
        ALL_STATUS = r100;
        Condition$PublicTypeCondition r101 = new Condition$PublicTypeCondition("PUBLIC", 1, 1);
        PUBLIC = r101;
        Condition$PublicTypeCondition r102 = new Condition$PublicTypeCondition("PRIVATE", 2, 2);
        PRIVATE = r102;
        f424875a = new Condition$PublicTypeCondition[]{r100, r101, r102};
        offset = 6;
    }

    public static Condition$PublicTypeCondition[] values() {
        return (Condition$PublicTypeCondition[]) f424875a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.value;
        if (r100 != 0) goto L5;
        return "ALL_STATUS";
    L5:
        if (r100 != 1) goto L7;
        return "PUBLIC";
    L7:
        if (r100 == 2) goto L10;
        return "null";
    L10:
        return "PRIVATE";
    }

    public int getValue() {
        return this.value;
    }

    public static Condition$PublicTypeCondition fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return PRIVATE;
    L12:
        return PUBLIC;
    L14:
        return ALL_STATUS;
    }

    public static Condition$PublicTypeCondition valueOf(String r100) {
        return (Condition$PublicTypeCondition) a.a(Condition$PublicTypeCondition.class, r100);
    }

    public Condition$PublicTypeCondition(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
