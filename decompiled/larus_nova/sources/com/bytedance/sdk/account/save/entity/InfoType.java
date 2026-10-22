package com.bytedance.sdk.account.save.entity;

import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum InfoType extends Enum<InfoType> {
    public static final InfoType INFO_TYPE_1 = null;
    public static final InfoType INFO_TYPE_2 = null;
    public static final InfoType INFO_TYPE_3 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InfoType[] f269315a = null;
    private int type;

    static {
        InfoType r100 = new InfoType("INFO_TYPE_1", 0, 1);
        INFO_TYPE_1 = r100;
        InfoType r101 = new InfoType("INFO_TYPE_2", 1, 2);
        INFO_TYPE_2 = r101;
        InfoType r102 = new InfoType("INFO_TYPE_3", 2, 4);
        INFO_TYPE_3 = r102;
        f269315a = new InfoType[]{r100, r101, r102};
    }

    public static InfoType[] values() {
        return (InfoType[]) f269315a.clone();
    }

    public int getValue() {
        return this.type;
    }

    public static int getValue(List<InfoType> r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        InfoType r102 = INFO_TYPE_1;
        if (r100.contains(r102) == false) goto L8;
        r101 = 0 + r102.type;
    L8:
        InfoType r103 = INFO_TYPE_2;
        if (r100.contains(r103) == false) goto L11;
        r101 = r101 + r103.type;
    L11:
        InfoType r104 = INFO_TYPE_3;
        if (r100.contains(r104) == true) goto L14;
        return r101;
    L14:
        return r101 + r104.type;
    }

    public static InfoType valueOf(String r100) {
        return (InfoType) a.a(InfoType.class, r100);
    }

    public InfoType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
