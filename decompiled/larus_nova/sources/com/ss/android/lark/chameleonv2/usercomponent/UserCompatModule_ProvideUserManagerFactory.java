package com.ss.android.lark.chameleonv2.usercomponent;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import v1b.a;
import v1b.c;
import v1b.d;

/* JADX INFO: loaded from: classes35.dex */
public final class UserCompatModule_ProvideUserManagerFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideUserManager(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserCompatModule_ProvideUserManagerFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static UserCompatModule_ProvideUserManagerFactory create(Provider<j> r100, Provider<v> r101) {
        return new UserCompatModule_ProvideUserManagerFactory(r100, r101);
    }

    public static a provideUserManager(j r100, v r101) {
        int r102 = d.f552659a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        c r103 = new c(r100, r101);
        h.a(r103);
        return (a) Preconditions.checkNotNullFromProvides(r103);
    }
}
