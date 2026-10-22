package com.ss.android.lark.officesdk.common.impl;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import itb.a;
import jtb.e;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKCommonModule_ProvideOfficeSDKBrandApiFactory implements Factory<a> {
    private final e module;

    @Override // javax.inject.Provider
    public a get() {
        return provideOfficeSDKBrandApi(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKCommonModule_ProvideOfficeSDKBrandApiFactory(e r100) {
        this.module = r100;
    }

    public static OfficeSDKCommonModule_ProvideOfficeSDKBrandApiFactory create(e r100) {
        return new OfficeSDKCommonModule_ProvideOfficeSDKBrandApiFactory(r100);
    }

    public static a provideOfficeSDKBrandApi(e r100) {
        r100.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new jtb.a());
    }
}
