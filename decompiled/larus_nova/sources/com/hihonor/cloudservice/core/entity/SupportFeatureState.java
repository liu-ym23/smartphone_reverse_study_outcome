package com.hihonor.cloudservice.core.entity;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum SupportFeatureState extends Enum<SupportFeatureState> {
    public static final SupportFeatureState HNID_IS_NO_INSTALL = null;
    public static final SupportFeatureState HNID_IS_SUPPORT = null;
    public static final SupportFeatureState HNID_VERSION_LOW_OR_NO_START = null;
    public static final SupportFeatureState HNID_VERSION_NOT_SUPPORT = null;
    public static final SupportFeatureState PARAMETER_ERROR = null;
    public static final SupportFeatureState QUERY_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SupportFeatureState[] f276488a = null;

    static {
        SupportFeatureState r100 = new SupportFeatureState("PARAMETER_ERROR", 0);
        PARAMETER_ERROR = r100;
        SupportFeatureState r101 = new SupportFeatureState("HNID_IS_NO_INSTALL", 1);
        HNID_IS_NO_INSTALL = r101;
        SupportFeatureState r102 = new SupportFeatureState("HNID_VERSION_NOT_SUPPORT", 2);
        HNID_VERSION_NOT_SUPPORT = r102;
        SupportFeatureState r103 = new SupportFeatureState("HNID_VERSION_LOW_OR_NO_START", 3);
        HNID_VERSION_LOW_OR_NO_START = r103;
        SupportFeatureState r104 = new SupportFeatureState("QUERY_ERROR", 4);
        QUERY_ERROR = r104;
        SupportFeatureState r105 = new SupportFeatureState("HNID_IS_SUPPORT", 5);
        HNID_IS_SUPPORT = r105;
        f276488a = new SupportFeatureState[]{r100, r101, r102, r103, r104, r105};
    }

    public static SupportFeatureState[] values() {
        return (SupportFeatureState[]) f276488a.clone();
    }

    public static SupportFeatureState valueOf(String r100) {
        return (SupportFeatureState) a.a(SupportFeatureState.class, r100);
    }

    public SupportFeatureState(String r100, int r101) {
        super(r100, r101);
    }
}
