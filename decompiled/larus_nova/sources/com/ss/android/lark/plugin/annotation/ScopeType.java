package com.ss.android.lark.plugin.annotation;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ScopeType extends Enum<ScopeType> {
    public static final ScopeType GLOBAL = null;
    public static final ScopeType USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScopeType[] f438798a = null;

    static {
        ScopeType r100 = new ScopeType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 0);
        USER = r100;
        ScopeType r101 = new ScopeType("GLOBAL", 1);
        GLOBAL = r101;
        f438798a = new ScopeType[]{r100, r101};
    }

    public static ScopeType[] values() {
        return (ScopeType[]) f438798a.clone();
    }

    public static ScopeType valueOf(String r100) {
        return (ScopeType) a.a(ScopeType.class, r100);
    }

    public ScopeType(String r100, int r101) {
        super(r100, r101);
    }
}
