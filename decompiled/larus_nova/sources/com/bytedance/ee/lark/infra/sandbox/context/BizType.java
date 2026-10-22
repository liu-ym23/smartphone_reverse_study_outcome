package com.bytedance.ee.lark.infra.sandbox.context;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum BizType extends Enum<BizType> {
    public static final BizType BlockitApp = null;
    public static final BizType CardAPP = null;
    public static final BizType GadgetAPP = null;
    public static final BizType NativeApp = null;
    public static final BizType UNKNOWN = null;
    public static final BizType WebAPP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BizType[] f242811a = null;

    static {
        BizType r100 = new BizType("GadgetAPP", 0);
        GadgetAPP = r100;
        BizType r101 = new BizType("WebAPP", 1);
        WebAPP = r101;
        BizType r102 = new BizType("CardAPP", 2);
        CardAPP = r102;
        BizType r103 = new BizType("NativeApp", 3);
        NativeApp = r103;
        BizType r104 = new BizType("BlockitApp", 4);
        BlockitApp = r104;
        BizType r105 = new BizType("UNKNOWN", 5);
        UNKNOWN = r105;
        f242811a = new BizType[]{r100, r101, r102, r103, r104, r105};
    }

    public static BizType[] values() {
        return (BizType[]) f242811a.clone();
    }

    public static BizType valueOf(String r100) {
        return (BizType) a.a(BizType.class, r100);
    }

    public BizType(String r100, int r101) {
        super(r100, r101);
    }
}
