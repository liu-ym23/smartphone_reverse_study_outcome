package com.ss.android.lark.forwardv2.dto.template.config;

import com.obric.miniapp.alarm.AccountType;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum Condition$ShieldTypeCondition extends Enum<Condition$ShieldTypeCondition> implements Serializable {
    public static final Condition$ShieldTypeCondition ALL = null;
    public static final Condition$ShieldTypeCondition NORMAL = null;
    public static final Condition$ShieldTypeCondition SHIELD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Condition$ShieldTypeCondition[] f424876a = null;
    public static int offset;
    private final int value;

    static {
        Condition$ShieldTypeCondition r100 = new Condition$ShieldTypeCondition(AccountType.ALL, 0, 0);
        ALL = r100;
        Condition$ShieldTypeCondition r101 = new Condition$ShieldTypeCondition("SHIELD", 1, 1);
        SHIELD = r101;
        Condition$ShieldTypeCondition r102 = new Condition$ShieldTypeCondition(EffectConstants.NORMAL, 2, 2);
        NORMAL = r102;
        f424876a = new Condition$ShieldTypeCondition[]{r100, r101, r102};
        offset = 8;
    }

    public static Condition$ShieldTypeCondition[] values() {
        return (Condition$ShieldTypeCondition[]) f424876a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.value;
        if (r100 != 0) goto L5;
        return AccountType.ALL;
    L5:
        if (r100 != 1) goto L7;
        return "SHIELD";
    L7:
        if (r100 == 2) goto L10;
        return "null";
    L10:
        return EffectConstants.NORMAL;
    }

    public int getValue() {
        return this.value;
    }

    public static Condition$ShieldTypeCondition fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return NORMAL;
    L12:
        return SHIELD;
    L14:
        return ALL;
    }

    public static Condition$ShieldTypeCondition valueOf(String r100) {
        return (Condition$ShieldTypeCondition) a.a(Condition$ShieldTypeCondition.class, r100);
    }

    public Condition$ShieldTypeCondition(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
