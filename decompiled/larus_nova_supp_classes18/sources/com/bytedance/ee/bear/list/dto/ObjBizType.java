package com.bytedance.ee.bear.list.dto;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum ObjBizType extends Enum<ObjBizType> {
    public static final ObjBizType SPACE = null;
    public static final ObjBizType WIKI = null;
    public static final /* synthetic */ ObjBizType[] a = null;
    private final int type;

    static {
        ObjBizType r0 = new ObjBizType("SPACE", 0, 1);
        SPACE = r0;
        ObjBizType r1 = new ObjBizType("WIKI", 1, 2);
        WIKI = r1;
        a = new ObjBizType[]{r0, r1};
    }

    public static ObjBizType[] values() {
        return (ObjBizType[]) a.clone();
    }

    public int getType() {
        return this.type;
    }

    public static ObjBizType valueOf(String r1) {
        return (ObjBizType) a.a(ObjBizType.class, r1);
    }

    public ObjBizType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
