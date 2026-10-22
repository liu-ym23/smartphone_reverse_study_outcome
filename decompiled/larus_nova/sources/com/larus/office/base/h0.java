package com.larus.office.base;

import com.larus.abtest.api.IAbTest;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class h0 implements etb.c {
    public h0() {
    }

    @Override // etb.c
    public final <T> T getConfig(String r100, Class<T> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "valueClass");
        FLogger.f375446a.i("OfficeSdkInitor", "OfficeSDKLibra getConfig, key: " + r100 + ", valueClass: " + r101.getName() + ", withExposure: " + r102);
        return (T) IAbTest.f286085a.getExperimentValue(r100, r101, null, r102);
    }
}
