package com.bytedance.ee.bear.appsetting;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class o implements jdb.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jdb.g f206265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f206266b;

    @Override // jdb.g
    public final void addFeatureGatingUpdateListener(String r100, jdb.c r101, String r102) {
        this.f206265a.addFeatureGatingUpdateListener(EmergencyFixConfig.SETTING_FG, r101, "_normal_fg");
    }

    @Override // jdb.g
    public final boolean isCurrentEnable(String r100) {
        Boolean r101 = this.f206266b.a(r100);
        if (r101 == null) goto L6;
        return r101.booleanValue();
    L6:
        return this.f206265a.isCurrentEnable(r100);
    }

    @Override // jdb.g
    public final boolean isEnable(String r100) {
        Boolean r101 = this.f206266b.a(r100);
        if (r101 == null) goto L6;
        return r101.booleanValue();
    L6:
        return this.f206265a.isEnable(r100);
    }

    public o(jdb.g r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "userFG");
        Intrinsics.checkNotNullParameter(r101, "emergencySettingFG");
        this.f206265a = r100;
        this.f206266b = r101;
    }
}
