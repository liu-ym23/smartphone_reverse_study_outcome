package com.bytedance.bdinstall.dtrait.constant;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum DTraitRiskType extends Enum<DTraitRiskType> {
    public static final DTraitRiskType HIGH = null;
    public static final DTraitRiskType LOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DTraitRiskType[] f199633a = null;
    private final String value;

    static {
        DTraitRiskType r100 = new DTraitRiskType("HIGH", 0, "HIGH");
        HIGH = r100;
        DTraitRiskType r101 = new DTraitRiskType("LOW", 1, "LOW");
        LOW = r101;
        f199633a = new DTraitRiskType[]{r100, r101};
    }

    public static DTraitRiskType[] values() {
        return (DTraitRiskType[]) f199633a.clone();
    }

    public String getValue() {
        return this.value;
    }

    public static DTraitRiskType valueOf(String r100) {
        return (DTraitRiskType) a.a(DTraitRiskType.class, r100);
    }

    public DTraitRiskType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
