package com.bytedance.ee.bear.list.dto;

import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final enum ObjBizType extends Enum<ObjBizType> {
    public static final ObjBizType SPACE = null;
    public static final ObjBizType WIKI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObjBizType[] f227915a = null;
    private final int type;

    static {
        ObjBizType r100 = new ObjBizType("SPACE", 0, 1);
        SPACE = r100;
        ObjBizType r101 = new ObjBizType("WIKI", 1, 2);
        WIKI = r101;
        f227915a = new ObjBizType[]{r100, r101};
    }

    public static ObjBizType[] values() {
        return (ObjBizType[]) f227915a.clone();
    }

    public int getType() {
        return this.type;
    }

    public static ObjBizType valueOf(String r100) {
        return (ObjBizType) a.a(ObjBizType.class, r100);
    }

    public ObjBizType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
