package com.bytedance.awemeopen.bizmodels.ad;

import r27.a;

/* JADX INFO: loaded from: classes44.dex */
public final enum AdType extends Enum<AdType> {
    public static final AdType FIT_CONTAINER_CSJ_DRAW = null;
    public static final AdType NO_AD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AdType[] f198167a = null;

    static {
        AdType r100 = new AdType("FIT_CONTAINER_CSJ_DRAW", 0);
        FIT_CONTAINER_CSJ_DRAW = r100;
        AdType r101 = new AdType("NO_AD", 1);
        NO_AD = r101;
        f198167a = new AdType[]{r100, r101};
    }

    public static AdType[] values() {
        return (AdType[]) f198167a.clone();
    }

    public static AdType valueOf(String r100) {
        return (AdType) a.a(AdType.class, r100);
    }

    public AdType(String r100, int r101) {
        super(r100, r101);
    }
}
