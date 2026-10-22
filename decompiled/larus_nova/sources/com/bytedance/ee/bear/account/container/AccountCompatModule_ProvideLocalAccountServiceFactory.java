package com.bytedance.ee.bear.account.container;

import com.bytedance.ee.bear.account.container.impl.UserLocalAccountServiceProxy;
import com.bytedance.ee.bear.contract.h0;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ym4.a;

/* JADX INFO: loaded from: classes15.dex */
public final class AccountCompatModule_ProvideLocalAccountServiceFactory implements Factory<h0> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public h0 get() {
        return provideLocalAccountService(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AccountCompatModule_ProvideLocalAccountServiceFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static AccountCompatModule_ProvideLocalAccountServiceFactory create(Provider<j> r100, Provider<v> r101) {
        return new AccountCompatModule_ProvideLocalAccountServiceFactory(r100, r101);
    }

    public static h0 provideLocalAccountService(j r100, v r101) {
        int r102 = a.f568379a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        UserLocalAccountServiceProxy r103 = new UserLocalAccountServiceProxy(r100, r101);
        h.a(r103);
        return (h0) Preconditions.checkNotNullFromProvides(r103);
    }
}
