package com.ss.android.lark.create.groupchat.impl.service;

import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class CreateGroupServiceModule_ProvideCreateGroupServiceFactory implements Factory<h> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public h get() {
        return provideCreateGroupService(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CreateGroupServiceModule_ProvideCreateGroupServiceFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static CreateGroupServiceModule_ProvideCreateGroupServiceFactory create(Provider<j> r100, Provider<v> r101) {
        return new CreateGroupServiceModule_ProvideCreateGroupServiceFactory(r100, r101);
    }

    public static h provideCreateGroupService(j r100, v r101) {
        int r102 = e.f420211a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        f r103 = new f(r100, r101);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (h) Preconditions.checkNotNullFromProvides(r103);
    }
}
