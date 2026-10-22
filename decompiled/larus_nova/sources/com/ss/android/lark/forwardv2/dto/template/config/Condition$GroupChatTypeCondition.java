package com.ss.android.lark.forwardv2.dto.template.config;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum Condition$GroupChatTypeCondition extends Enum<Condition$GroupChatTypeCondition> implements Serializable {
    public static final Condition$GroupChatTypeCondition ALL_CHAT = null;
    public static final Condition$GroupChatTypeCondition DEFAULT_CHAT = null;
    public static final Condition$GroupChatTypeCondition THREAD_CHAT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Condition$GroupChatTypeCondition[] f424874a = null;
    public static int offset;
    private final int value;

    static {
        Condition$GroupChatTypeCondition r100 = new Condition$GroupChatTypeCondition("ALL_CHAT", 0, 0);
        ALL_CHAT = r100;
        Condition$GroupChatTypeCondition r101 = new Condition$GroupChatTypeCondition("DEFAULT_CHAT", 1, 1);
        DEFAULT_CHAT = r101;
        Condition$GroupChatTypeCondition r102 = new Condition$GroupChatTypeCondition("THREAD_CHAT", 2, 2);
        THREAD_CHAT = r102;
        f424874a = new Condition$GroupChatTypeCondition[]{r100, r101, r102};
        offset = 4;
    }

    public static Condition$GroupChatTypeCondition[] values() {
        return (Condition$GroupChatTypeCondition[]) f424874a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.value;
        if (r100 != 0) goto L5;
        return "ALL_CHAT";
    L5:
        if (r100 != 1) goto L7;
        return "DEFAULT_CHAT";
    L7:
        if (r100 == 2) goto L10;
        return "null";
    L10:
        return "THREAD_CHAT";
    }

    public int getValue() {
        return this.value;
    }

    public static Condition$GroupChatTypeCondition fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return THREAD_CHAT;
    L12:
        return DEFAULT_CHAT;
    L14:
        return ALL_CHAT;
    }

    public static Condition$GroupChatTypeCondition valueOf(String r100) {
        return (Condition$GroupChatTypeCondition) a.a(Condition$GroupChatTypeCondition.class, r100);
    }

    public Condition$GroupChatTypeCondition(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
