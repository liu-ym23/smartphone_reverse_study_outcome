package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class StorePrivateDescriptionHandlerFactoryMockModule_ProvideStorePrivateDescriptionHandlerFactoryFactory implements Factory<a2b.k> {
    private final s module;

    @Override // javax.inject.Provider
    public a2b.k get() {
        return provideStorePrivateDescriptionHandlerFactory(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public StorePrivateDescriptionHandlerFactoryMockModule_ProvideStorePrivateDescriptionHandlerFactoryFactory(s r100) {
        this.module = r100;
    }

    public static StorePrivateDescriptionHandlerFactoryMockModule_ProvideStorePrivateDescriptionHandlerFactoryFactory create(s r100) {
        return new StorePrivateDescriptionHandlerFactoryMockModule_ProvideStorePrivateDescriptionHandlerFactoryFactory(r100);
    }

    public static a2b.k provideStorePrivateDescriptionHandlerFactory(s r100) {
        r100.getClass();
        return (a2b.k) Preconditions.checkNotNullFromProvides(new r());
    }
}
