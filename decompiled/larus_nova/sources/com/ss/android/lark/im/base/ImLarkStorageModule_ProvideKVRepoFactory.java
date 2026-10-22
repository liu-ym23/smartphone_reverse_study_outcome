package com.ss.android.lark.im.base;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class ImLarkStorageModule_ProvideKVRepoFactory implements Factory<KVRepo> {
    private final Provider<com.ss.android.lark.storage.kv.storage.a> kvStorageProvider;
    private final e module;

    @Override // javax.inject.Provider
    public KVRepo get() {
        return provideKVRepo(null, this.kvStorageProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ImLarkStorageModule_ProvideKVRepoFactory(e r100, Provider<com.ss.android.lark.storage.kv.storage.a> r101) {
        this.kvStorageProvider = r101;
    }

    public static ImLarkStorageModule_ProvideKVRepoFactory create(e r100, Provider<com.ss.android.lark.storage.kv.storage.a> r101) {
        return new ImLarkStorageModule_ProvideKVRepoFactory(r100, r101);
    }

    public static KVRepo provideKVRepo(e r100, com.ss.android.lark.storage.kv.storage.a r101) {
        throw null;
    }
}
