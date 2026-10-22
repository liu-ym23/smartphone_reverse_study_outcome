package com.ss.android.ugc.effectmanager;

import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum FetchModelType extends Enum<FetchModelType> {
    private static final /* synthetic */ FetchModelType[] $VALUES = null;
    public static final FetchModelType ORIGIN = null;
    public static final FetchModelType ZIP = null;
    private int value;

    static {
        FetchModelType r100 = new FetchModelType("ORIGIN", 0, 0);
        ORIGIN = r100;
        FetchModelType r101 = new FetchModelType("ZIP", 1, 1);
        ZIP = r101;
        $VALUES = new FetchModelType[]{r100, r101};
    }

    public static FetchModelType[] values() {
        return (FetchModelType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static FetchModelType fromValue(int r100) {
        FetchModelType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        FetchModelType r104 = r101[r103];
        if (r104.value == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return ORIGIN;
    }

    public static FetchModelType valueOf(String r100) {
        return (FetchModelType) a.a(FetchModelType.class, r100);
    }

    private FetchModelType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
