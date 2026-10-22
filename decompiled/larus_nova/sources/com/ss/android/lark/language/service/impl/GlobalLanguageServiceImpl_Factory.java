package com.ss.android.lark.language.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class GlobalLanguageServiceImpl_Factory implements Factory<GlobalLanguageServiceImpl> {
    private final Provider<com.ss.android.lark.core.storage.b> globalCoreStorageProvider;

    @Override // javax.inject.Provider
    public GlobalLanguageServiceImpl get() {
        return newInstance(this.globalCoreStorageProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GlobalLanguageServiceImpl_Factory(Provider<com.ss.android.lark.core.storage.b> r100) {
        this.globalCoreStorageProvider = r100;
    }

    public static GlobalLanguageServiceImpl_Factory create(Provider<com.ss.android.lark.core.storage.b> r100) {
        return new GlobalLanguageServiceImpl_Factory(r100);
    }

    public static GlobalLanguageServiceImpl newInstance(com.ss.android.lark.core.storage.b r100) {
        return new GlobalLanguageServiceImpl(r100);
    }
}
