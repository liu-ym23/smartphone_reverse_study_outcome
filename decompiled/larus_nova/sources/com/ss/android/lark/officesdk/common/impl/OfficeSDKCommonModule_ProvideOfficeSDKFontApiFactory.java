package com.ss.android.lark.officesdk.common.impl;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import itb.d;
import jtb.c;
import jtb.e;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKCommonModule_ProvideOfficeSDKFontApiFactory implements Factory<d> {
    private final e module;

    @Override // javax.inject.Provider
    public d get() {
        return provideOfficeSDKFontApi(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKCommonModule_ProvideOfficeSDKFontApiFactory(e r100) {
        this.module = r100;
    }

    public static OfficeSDKCommonModule_ProvideOfficeSDKFontApiFactory create(e r100) {
        return new OfficeSDKCommonModule_ProvideOfficeSDKFontApiFactory(r100);
    }

    public static d provideOfficeSDKFontApi(e r100) {
        r100.getClass();
        return (d) Preconditions.checkNotNullFromProvides(new c());
    }
}
