package com.hihonor.cloudservice.core.entity;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum IntentType extends Enum<IntentType> {
    public static final IntentType BIND_EMAIL = null;
    public static final IntentType BIND_MOBILE_PHONE = null;
    public static final IntentType REAL_NAME_VERIFY = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ IntentType[] f276485c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f276486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FeatureType f276487b;

    static {
        IntentType r100 = new IntentType("REAL_NAME_VERIFY", 0, "RealNameVerifyIntent", FeatureType.REAL_NAME_VERIFY);
        REAL_NAME_VERIFY = r100;
        IntentType r101 = new IntentType("BIND_MOBILE_PHONE", 1, "BindMobilePhoneIntent", FeatureType.BIND_MOBILE_PHONE);
        BIND_MOBILE_PHONE = r101;
        IntentType r102 = new IntentType("BIND_EMAIL", 2, "BindEmailIntent", FeatureType.BIND_EMAIL);
        BIND_EMAIL = r102;
        f276485c = new IntentType[]{r100, r101, r102};
    }

    public static IntentType[] values() {
        return (IntentType[]) f276485c.clone();
    }

    public FeatureType getFeatureType() {
        return this.f276487b;
    }

    public String getType() {
        return this.f276486a;
    }

    public static IntentType valueOf(String r100) {
        return (IntentType) a.a(IntentType.class, r100);
    }

    public IntentType(String r100, int r101, String r102, FeatureType r103) {
        super(r100, r101);
        this.f276486a = r102;
        this.f276487b = r103;
    }
}
