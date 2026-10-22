package com.ss.android.lark.officesdk.common.impl;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import itb.c;
import jtb.b;
import jtb.e;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKCommonModule_ProvideOfficeExposureApiFactory implements Factory<c> {
    private final e module;

    @Override // javax.inject.Provider
    public c get() {
        return provideOfficeExposureApi(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKCommonModule_ProvideOfficeExposureApiFactory(e r100) {
        this.module = r100;
    }

    public static OfficeSDKCommonModule_ProvideOfficeExposureApiFactory create(e r100) {
        return new OfficeSDKCommonModule_ProvideOfficeExposureApiFactory(r100);
    }

    public static c provideOfficeExposureApi(e r100) {
        r100.getClass();
        return (c) Preconditions.checkNotNullFromProvides(new b());
    }
}
