package com.bytedance.ee.bear.account.container;

import com.bytedance.ee.bear.account.container.dwarf.UserAccountInfoServiceProxy;
import com.bytedance.ee.bear.contract.a0;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ym4.a;

/* JADX INFO: loaded from: classes15.dex */
public final class AccountCompatModule_ProvideDwarfGlobalAccountServiceFactory implements Factory<a0> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public a0 get() {
        return provideDwarfGlobalAccountService(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AccountCompatModule_ProvideDwarfGlobalAccountServiceFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static AccountCompatModule_ProvideDwarfGlobalAccountServiceFactory create(Provider<j> r100, Provider<v> r101) {
        return new AccountCompatModule_ProvideDwarfGlobalAccountServiceFactory(r100, r101);
    }

    public static a0 provideDwarfGlobalAccountService(j r100, v r101) {
        int r102 = a.f568379a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        UserAccountInfoServiceProxy r103 = new UserAccountInfoServiceProxy(r100, r101);
        h.a(r103);
        return (a0) Preconditions.checkNotNullFromProvides(r103);
    }
}
