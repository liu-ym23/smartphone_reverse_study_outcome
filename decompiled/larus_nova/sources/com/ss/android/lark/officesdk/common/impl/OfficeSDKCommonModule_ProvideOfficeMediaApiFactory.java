package com.ss.android.lark.officesdk.common.impl;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import itb.e;
import jtb.d;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKCommonModule_ProvideOfficeMediaApiFactory implements Factory<e> {
    private final jtb.e module;

    @Override // javax.inject.Provider
    public e get() {
        return provideOfficeMediaApi(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKCommonModule_ProvideOfficeMediaApiFactory(jtb.e r100) {
        this.module = r100;
    }

    public static OfficeSDKCommonModule_ProvideOfficeMediaApiFactory create(jtb.e r100) {
        return new OfficeSDKCommonModule_ProvideOfficeMediaApiFactory(r100);
    }

    public static e provideOfficeMediaApi(jtb.e r100) {
        r100.getClass();
        return (e) Preconditions.checkNotNullFromProvides(new d());
    }
}
