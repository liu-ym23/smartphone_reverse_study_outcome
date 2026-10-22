package com.ss.android.lark.search.dto;

import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final enum OpenAppState extends Enum<OpenAppState> {
    public static final OpenAppState APP_DELETED = null;
    public static final OpenAppState APP_NEED_PAY_USE = null;
    public static final OpenAppState DEVELOPER_FORBIDDEN = null;
    public static final OpenAppState OFFLINE = null;
    public static final OpenAppState PLATFORM_FORBIDDEN = null;
    public static final OpenAppState TENANT_FORBIDDEN = null;
    public static final OpenAppState USABLE = null;
    public static final OpenAppState USER_INVISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenAppState[] f440123a = null;
    private int value;

    static {
        OpenAppState r100 = new OpenAppState("USABLE", 0, 0);
        USABLE = r100;
        OpenAppState r101 = new OpenAppState("TENANT_FORBIDDEN", 1, 2);
        TENANT_FORBIDDEN = r101;
        OpenAppState r102 = new OpenAppState("PLATFORM_FORBIDDEN", 2, 3);
        PLATFORM_FORBIDDEN = r102;
        OpenAppState r103 = new OpenAppState("DEVELOPER_FORBIDDEN", 3, 4);
        DEVELOPER_FORBIDDEN = r103;
        OpenAppState r104 = new OpenAppState("OFFLINE", 4, 5);
        OFFLINE = r104;
        OpenAppState r110 = new OpenAppState("USER_INVISIBLE", 5, 6);
        USER_INVISIBLE = r110;
        OpenAppState r111 = new OpenAppState("APP_NEED_PAY_USE", 6, 7);
        APP_NEED_PAY_USE = r111;
        OpenAppState r112 = new OpenAppState("APP_DELETED", 7, 8);
        APP_DELETED = r112;
        f440123a = new OpenAppState[]{r100, r101, r102, r103, r104, r110, r111, r112};
    }

    public static OpenAppState[] values() {
        return (OpenAppState[]) f440123a.clone();
    }

    public final int getNumber() {
        return this.value;
    }

    public static OpenAppState forNumber(int r100) {
        if (r100 == 0) goto L30;
        if (r100 == 2) goto L28;
        if (r100 == 3) goto L26;
        if (r100 == 4) goto L24;
        if (r100 == 5) goto L22;
        if (r100 == 7) goto L20;
        if (r100 == 8) goto L18;
        return USER_INVISIBLE;
    L18:
        return APP_DELETED;
    L20:
        return APP_NEED_PAY_USE;
    L22:
        return OFFLINE;
    L24:
        return DEVELOPER_FORBIDDEN;
    L26:
        return PLATFORM_FORBIDDEN;
    L28:
        return TENANT_FORBIDDEN;
    L30:
        return USABLE;
    }

    public static OpenAppState valueOf(String r100) {
        return (OpenAppState) a.a(OpenAppState.class, r100);
    }

    public OpenAppState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
