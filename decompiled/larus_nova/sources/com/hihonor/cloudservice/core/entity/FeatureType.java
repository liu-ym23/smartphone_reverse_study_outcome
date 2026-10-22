package com.hihonor.cloudservice.core.entity;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum FeatureType extends Enum<FeatureType> {
    public static final FeatureType BIND_EMAIL = null;
    public static final FeatureType BIND_MOBILE_PHONE = null;
    public static final FeatureType COLLABORATIVE_LOGIN = null;
    public static final FeatureType COLLABORATIVE_LOGIN_LOW_LOGIN_LEVEL = null;
    public static final FeatureType QRCODE_LOGIN = null;
    public static final FeatureType REAL_NAME_VERIFY = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ FeatureType[] f276483b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f276484a;

    static {
        FeatureType r100 = new FeatureType("REAL_NAME_VERIFY", 0, "AR000FVSC4");
        REAL_NAME_VERIFY = r100;
        FeatureType r101 = new FeatureType("BIND_MOBILE_PHONE", 1, "AR000FVSC4");
        BIND_MOBILE_PHONE = r101;
        FeatureType r102 = new FeatureType("BIND_EMAIL", 2, "AR000FVSC4");
        BIND_EMAIL = r102;
        FeatureType r103 = new FeatureType("QRCODE_LOGIN", 3, "AR000G6CR7");
        QRCODE_LOGIN = r103;
        FeatureType r104 = new FeatureType("COLLABORATIVE_LOGIN", 4, "AR000FVSPM");
        COLLABORATIVE_LOGIN = r104;
        FeatureType r105 = new FeatureType("COLLABORATIVE_LOGIN_LOW_LOGIN_LEVEL", 5, "AR000FVSPM_LOW_LOGIN_LEVEL");
        COLLABORATIVE_LOGIN_LOW_LOGIN_LEVEL = r105;
        f276483b = new FeatureType[]{r100, r101, r102, r103, r104, r105};
    }

    public static FeatureType[] values() {
        return (FeatureType[]) f276483b.clone();
    }

    public String getType() {
        return this.f276484a;
    }

    public static FeatureType valueOf(String r100) {
        return (FeatureType) a.a(FeatureType.class, r100);
    }

    public FeatureType(String r100, int r101, String r102) {
        super(r100, r101);
        this.f276484a = r102;
    }
}
