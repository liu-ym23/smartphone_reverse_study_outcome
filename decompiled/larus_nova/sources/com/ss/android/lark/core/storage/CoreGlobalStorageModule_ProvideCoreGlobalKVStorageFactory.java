package com.ss.android.lark.core.storage;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class CoreGlobalStorageModule_ProvideCoreGlobalKVStorageFactory implements Factory<b> {
    private final Provider<com.ss.android.lark.storage.kv.storage.a> globalKvStorageProvider;
    private final c module;

    @Override // javax.inject.Provider
    public b get() {
        return provideCoreGlobalKVStorage(this.module, this.globalKvStorageProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CoreGlobalStorageModule_ProvideCoreGlobalKVStorageFactory(c r100, Provider<com.ss.android.lark.storage.kv.storage.a> r101) {
        this.module = r100;
        this.globalKvStorageProvider = r101;
    }

    public static CoreGlobalStorageModule_ProvideCoreGlobalKVStorageFactory create(c r100, Provider<com.ss.android.lark.storage.kv.storage.a> r101) {
        return new CoreGlobalStorageModule_ProvideCoreGlobalKVStorageFactory(r100, r101);
    }

    public static b provideCoreGlobalKVStorage(c r100, com.ss.android.lark.storage.kv.storage.a r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "globalKvStorage");
        return (b) Preconditions.checkNotNullFromProvides(new b(r101));
    }
}
