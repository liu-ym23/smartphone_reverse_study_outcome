package com.ss.android.lark.rustinfrabridge.store.service.impl.userscope;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import j3c.b;
import javax.inject.Provider;
import k3c.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class UserStoreServiceModuleProvider_ProvideUserStoreModuleFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideUserStoreModule(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserStoreServiceModuleProvider_ProvideUserStoreModuleFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static UserStoreServiceModuleProvider_ProvideUserStoreModuleFactory create(Provider<j> r100, Provider<v> r101) {
        return new UserStoreServiceModuleProvider_ProvideUserStoreModuleFactory(r100, r101);
    }

    public static a provideUserStoreModule(j r100, v r101) {
        int r102 = j3c.a.f497156a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        b r103 = new b(r100, r101);
        h.a(r103);
        return (a) Preconditions.checkNotNullFromProvides(r103);
    }
}
