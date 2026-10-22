package com.ss.android.lark.chameleonv2.lkapi.usercomponent;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import q1b.a;
import q1b.b;
import q1b.d;

/* JADX INFO: loaded from: classes35.dex */
public final class LKApiUserCompatModule_ProvideUserManagerFactory implements Factory<a> {
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

    public LKApiUserCompatModule_ProvideUserManagerFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static LKApiUserCompatModule_ProvideUserManagerFactory create(Provider<j> r100, Provider<v> r101) {
        return new LKApiUserCompatModule_ProvideUserManagerFactory(r100, r101);
    }

    public static a provideUserManager(j r100, v r101) {
        int r102 = b.f531316a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        d r103 = new d(r100, r101);
        h.a(r103);
        return (a) Preconditions.checkNotNullFromProvides(r103);
    }
}
