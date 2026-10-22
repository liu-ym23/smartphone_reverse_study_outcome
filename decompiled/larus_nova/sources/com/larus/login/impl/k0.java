package com.larus.login.impl;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f357801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f357802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f357803c;

    public k0(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "countryName");
        Intrinsics.checkNotNullParameter(r101, CommonConstant.KEY_COUNTRY_CODE);
        Intrinsics.checkNotNullParameter(r102, "phoneCode");
        this.f357801a = r100;
        this.f357802b = r101;
        this.f357803c = r102;
    }
}
