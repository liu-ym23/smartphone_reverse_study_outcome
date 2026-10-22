package com.ss.android.lark.passport;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class UserListFetcherModule_ProvideUserListFetcherTriggerFactory implements Factory<d> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public d get() {
        return provideUserListFetcherTrigger(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserListFetcherModule_ProvideUserListFetcherTriggerFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static UserListFetcherModule_ProvideUserListFetcherTriggerFactory create(Provider<j> r100, Provider<v> r101) {
        return new UserListFetcherModule_ProvideUserListFetcherTriggerFactory(r100, r101);
    }

    public static d provideUserListFetcherTrigger(j r100, v r101) {
        int r102 = c.f437716a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        UserListFetcherTriggerImpl r103 = new UserListFetcherTriggerImpl(r100, r101);
        h.a(r103);
        return (d) Preconditions.checkNotNullFromProvides(r103);
    }
}
