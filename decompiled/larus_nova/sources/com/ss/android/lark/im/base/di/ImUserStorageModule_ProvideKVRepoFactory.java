package com.ss.android.lark.im.base.di;

import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.storage.kv.storage.a;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ImUserStorageModule_ProvideKVRepoFactory implements Factory<KVRepo> {
    private final Provider<a> kvStorageProvider;
    private final gkb.a module;

    @Override // javax.inject.Provider
    public KVRepo get() {
        return provideKVRepo(this.module, this.kvStorageProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ImUserStorageModule_ProvideKVRepoFactory(gkb.a r100, Provider<a> r101) {
        this.module = r100;
        this.kvStorageProvider = r101;
    }

    public static ImUserStorageModule_ProvideKVRepoFactory create(gkb.a r100, Provider<a> r101) {
        return new ImUserStorageModule_ProvideKVRepoFactory(r100, r101);
    }

    public static KVRepo provideKVRepo(gkb.a r100, a r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "kvStorage");
        LarkKVStorage r102 = LarkKVStorage.f440926a;
        com.ss.android.lark.storage.a r103 = com.ss.android.lark.im.base.a.f425880b;
        r102.getClass();
        return (KVRepo) Preconditions.checkNotNullFromProvides(LarkKVStorage.l(r101, r103, null));
    }
}
