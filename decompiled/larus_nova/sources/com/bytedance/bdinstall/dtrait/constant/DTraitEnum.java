package com.bytedance.bdinstall.dtrait.constant;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum DTraitEnum extends Enum<DTraitEnum> {
    public static final DTraitEnum COLLECT = null;
    public static final DTraitEnum FACTOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DTraitEnum[] f199632a = null;

    static {
        DTraitEnum r100 = new DTraitEnum("COLLECT", 0);
        COLLECT = r100;
        DTraitEnum r101 = new DTraitEnum("FACTOR", 1);
        FACTOR = r101;
        f199632a = new DTraitEnum[]{r100, r101};
    }

    public static DTraitEnum[] values() {
        return (DTraitEnum[]) f199632a.clone();
    }

    public static DTraitEnum valueOf(String r100) {
        return (DTraitEnum) a.a(DTraitEnum.class, r100);
    }

    public DTraitEnum(String r100, int r101) {
        super(r100, r101);
    }
}
