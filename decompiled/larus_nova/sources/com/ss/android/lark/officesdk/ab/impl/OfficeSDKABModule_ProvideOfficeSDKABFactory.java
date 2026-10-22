package com.ss.android.lark.officesdk.ab.impl;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import etb.b;
import ftb.c;
import ftb.d;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKABModule_ProvideOfficeSDKABFactory implements Factory<b> {
    private final c module;

    @Override // javax.inject.Provider
    public b get() {
        return provideOfficeSDKAB(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKABModule_ProvideOfficeSDKABFactory(c r100) {
        this.module = r100;
    }

    public static OfficeSDKABModule_ProvideOfficeSDKABFactory create(c r100) {
        return new OfficeSDKABModule_ProvideOfficeSDKABFactory(r100);
    }

    public static b provideOfficeSDKAB(c r100) {
        r100.getClass();
        return (b) Preconditions.checkNotNullFromProvides(new d());
    }
}
