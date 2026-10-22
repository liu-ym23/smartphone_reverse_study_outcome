package com.bytedance.ug.sdk.yz.type;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum PushType extends Enum<PushType> {
    public static final PushType ALIYUN_PUSH = null;
    public static final PushType GCM_PUSH = null;
    public static final PushType GETUI_PUSH = null;
    public static final PushType HW_PUSH = null;
    public static final PushType IXINTUI_PUSH = null;
    public static final PushType MI_PUSH = null;
    public static final PushType MYSELF_PUSH = null;
    public static final PushType MZ_PUSH = null;
    public static final PushType OPPO_PUSH = null;
    public static final PushType UMENG_PUSH = null;
    public static final PushType VIVO_PUSH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PushType[] f272365a = null;
    public int value;

    static {
        PushType r100 = new PushType("MI_PUSH", 0, 1);
        MI_PUSH = r100;
        PushType r101 = new PushType("MYSELF_PUSH", 1, 2);
        MYSELF_PUSH = r101;
        PushType r102 = new PushType("IXINTUI_PUSH", 2, 3);
        IXINTUI_PUSH = r102;
        PushType r103 = new PushType("GETUI_PUSH", 3, 4);
        GETUI_PUSH = r103;
        PushType r104 = new PushType("GCM_PUSH", 4, 5);
        GCM_PUSH = r104;
        PushType r110 = new PushType("UMENG_PUSH", 5, 6);
        UMENG_PUSH = r110;
        PushType r111 = new PushType("HW_PUSH", 6, 7);
        HW_PUSH = r111;
        PushType r112 = new PushType("MZ_PUSH", 7, 8);
        MZ_PUSH = r112;
        PushType r113 = new PushType("ALIYUN_PUSH", 8, 9);
        ALIYUN_PUSH = r113;
        PushType r114 = new PushType("OPPO_PUSH", 9, 10);
        OPPO_PUSH = r114;
        PushType r115 = new PushType("VIVO_PUSH", 10, 11);
        VIVO_PUSH = r115;
        f272365a = new PushType[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115};
    }

    public static PushType[] values() {
        return (PushType[]) f272365a.clone();
    }

    public static PushType valueOf(String r100) {
        return (PushType) a.a(PushType.class, r100);
    }

    public PushType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
