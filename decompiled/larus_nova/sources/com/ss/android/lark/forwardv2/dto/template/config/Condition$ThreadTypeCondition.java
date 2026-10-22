package com.ss.android.lark.forwardv2.dto.template.config;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum Condition$ThreadTypeCondition extends Enum<Condition$ThreadTypeCondition> implements Serializable {
    public static final Condition$ThreadTypeCondition ALL_THREAD = null;
    public static final Condition$ThreadTypeCondition CHAT_THREAD = null;
    public static final Condition$ThreadTypeCondition MSG_THREAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Condition$ThreadTypeCondition[] f424878a = null;
    public static int offset;
    private final int value;

    static {
        Condition$ThreadTypeCondition r100 = new Condition$ThreadTypeCondition("ALL_THREAD", 0, 0);
        ALL_THREAD = r100;
        Condition$ThreadTypeCondition r101 = new Condition$ThreadTypeCondition("CHAT_THREAD", 1, 1);
        CHAT_THREAD = r101;
        Condition$ThreadTypeCondition r102 = new Condition$ThreadTypeCondition("MSG_THREAD", 2, 2);
        MSG_THREAD = r102;
        f424878a = new Condition$ThreadTypeCondition[]{r100, r101, r102};
        offset = 10;
    }

    public static Condition$ThreadTypeCondition[] values() {
        return (Condition$ThreadTypeCondition[]) f424878a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.value;
        if (r100 != 0) goto L5;
        return "ALL_THREAD";
    L5:
        if (r100 != 1) goto L7;
        return "CHAT_THREAD";
    L7:
        if (r100 == 2) goto L10;
        return "null";
    L10:
        return "MSG_THREAD";
    }

    public int getValue() {
        return this.value;
    }

    public static Condition$ThreadTypeCondition fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return MSG_THREAD;
    L12:
        return CHAT_THREAD;
    L14:
        return ALL_THREAD;
    }

    public static Condition$ThreadTypeCondition valueOf(String r100) {
        return (Condition$ThreadTypeCondition) a.a(Condition$ThreadTypeCondition.class, r100);
    }

    public Condition$ThreadTypeCondition(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
