package com.ss.android.lark.message.service.dto;

import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum CardActionMethodType extends Enum<CardActionMethodType> {
    public static final CardActionMethodType GET = null;
    public static final CardActionMethodType LARK_COMMAND = null;
    public static final CardActionMethodType OPEN_URL = null;
    public static final CardActionMethodType POST = null;
    public static final CardActionMethodType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardActionMethodType[] f432231a = null;
    private int value;

    static {
        CardActionMethodType r100 = new CardActionMethodType("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        CardActionMethodType r101 = new CardActionMethodType("GET", 1, 1);
        GET = r101;
        CardActionMethodType r102 = new CardActionMethodType("POST", 2, 2);
        POST = r102;
        CardActionMethodType r103 = new CardActionMethodType("LARK_COMMAND", 3, 3);
        LARK_COMMAND = r103;
        CardActionMethodType r104 = new CardActionMethodType("OPEN_URL", 4, 4);
        OPEN_URL = r104;
        f432231a = new CardActionMethodType[]{r100, r101, r102, r103, r104};
    }

    public static CardActionMethodType[] values() {
        return (CardActionMethodType[]) f432231a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static CardActionMethodType forNumber(int r100) {
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L13;
        return UNKNOWN;
    L13:
        return OPEN_URL;
    L15:
        return LARK_COMMAND;
    L17:
        return POST;
    L19:
        return GET;
    }

    public static CardActionMethodType valueOf(String r100) {
        return (CardActionMethodType) a.a(CardActionMethodType.class, r100);
    }

    public static CardActionMethodType valueOf(int r100) {
        return forNumber(r100);
    }

    public CardActionMethodType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
