package com.bytedance.bmf;

import r27.a;

/* JADX INFO: loaded from: classes43.dex */
final enum OpaqueDataKey extends Enum<OpaqueDataKey> {
    private static final /* synthetic */ OpaqueDataKey[] $VALUES = null;
    public static final OpaqueDataKey kJsonParam = null;
    private int value;

    static {
        OpaqueDataKey r100 = new OpaqueDataKey("kJsonParam", 0, 2);
        kJsonParam = r100;
        $VALUES = new OpaqueDataKey[]{r100};
    }

    public static OpaqueDataKey[] values() {
        return (OpaqueDataKey[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static OpaqueDataKey valueOf(String r100) {
        return (OpaqueDataKey) a.a(OpaqueDataKey.class, r100);
    }

    private OpaqueDataKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
