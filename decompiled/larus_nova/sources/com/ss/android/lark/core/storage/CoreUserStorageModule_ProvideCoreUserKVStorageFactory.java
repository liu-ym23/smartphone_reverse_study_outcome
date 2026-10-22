package com.ss.android.lark.core.storage;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class CoreUserStorageModule_ProvideCoreUserKVStorageFactory implements Factory<d> {
    private final Provider<com.ss.android.lark.storage.kv.storage.a> kvStorageProvider;
    private final e module;

    @Override // javax.inject.Provider
    public d get() {
        return provideCoreUserKVStorage(null, this.kvStorageProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CoreUserStorageModule_ProvideCoreUserKVStorageFactory(e r100, Provider<com.ss.android.lark.storage.kv.storage.a> r101) {
        this.kvStorageProvider = r101;
    }

    public static CoreUserStorageModule_ProvideCoreUserKVStorageFactory create(e r100, Provider<com.ss.android.lark.storage.kv.storage.a> r101) {
        return new CoreUserStorageModule_ProvideCoreUserKVStorageFactory(r100, r101);
    }

    public static d provideCoreUserKVStorage(e r100, com.ss.android.lark.storage.kv.storage.a r101) {
        throw null;
    }
}
