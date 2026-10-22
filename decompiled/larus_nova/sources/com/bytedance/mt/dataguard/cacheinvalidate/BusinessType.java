package com.bytedance.mt.dataguard.cacheinvalidate;

import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final enum BusinessType extends Enum<BusinessType> {
    public static final BusinessType FEED_VIDEO = null;
    public static final BusinessType IM_NOTICE = null;
    public static final BusinessType LIVE_BANNER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BusinessType[] f265655a = null;

    static {
        BusinessType r100 = new BusinessType("FEED_VIDEO", 0);
        FEED_VIDEO = r100;
        BusinessType r101 = new BusinessType("IM_NOTICE", 1);
        IM_NOTICE = r101;
        BusinessType r102 = new BusinessType("LIVE_BANNER", 2);
        LIVE_BANNER = r102;
        f265655a = new BusinessType[]{r100, r101, r102};
    }

    public static BusinessType[] values() {
        return (BusinessType[]) f265655a.clone();
    }

    public static BusinessType valueOf(String r100) {
        return (BusinessType) a.a(BusinessType.class, r100);
    }

    public BusinessType(String r100, int r101) {
        super(r100, r101);
    }
}
