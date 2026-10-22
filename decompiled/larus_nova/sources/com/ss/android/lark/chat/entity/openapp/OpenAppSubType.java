package com.ss.android.lark.chat.entity.openapp;

import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final enum OpenAppSubType extends Enum<OpenAppSubType> {
    public static final OpenAppSubType BOT_CHAT = null;
    public static final OpenAppSubType MINI_APP = null;
    public static final OpenAppSubType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenAppSubType[] f415346a = null;
    int value;

    static {
        OpenAppSubType r100 = new OpenAppSubType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        OpenAppSubType r101 = new OpenAppSubType("MINI_APP", 1, 1);
        MINI_APP = r101;
        OpenAppSubType r102 = new OpenAppSubType("BOT_CHAT", 2, 2);
        BOT_CHAT = r102;
        f415346a = new OpenAppSubType[]{r100, r101, r102};
    }

    public static OpenAppSubType[] values() {
        return (OpenAppSubType[]) f415346a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static OpenAppSubType forNumber(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return UNKNOWN;
    L9:
        return BOT_CHAT;
    L11:
        return MINI_APP;
    }

    public static OpenAppSubType valueOf(String r100) {
        return (OpenAppSubType) a.a(OpenAppSubType.class, r100);
    }

    public static OpenAppSubType valueOf(int r100) {
        return forNumber(r100);
    }

    public OpenAppSubType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
