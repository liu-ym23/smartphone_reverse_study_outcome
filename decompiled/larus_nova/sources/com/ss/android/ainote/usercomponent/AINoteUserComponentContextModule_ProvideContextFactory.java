package com.ss.android.ainote.usercomponent;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import yra.c;
import yra.d;
import yra.e;

/* JADX INFO: loaded from: classes34.dex */
public final class AINoteUserComponentContextModule_ProvideContextFactory implements Factory<e> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public e get() {
        return provideContext(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AINoteUserComponentContextModule_ProvideContextFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static AINoteUserComponentContextModule_ProvideContextFactory create(Provider<j> r100, Provider<v> r101) {
        return new AINoteUserComponentContextModule_ProvideContextFactory(r100, r101);
    }

    public static e provideContext(j r100, v r101) {
        int r102 = c.f568940a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        d r103 = new d(r100, r101);
        h.a(r103);
        return (e) Preconditions.checkNotNullFromProvides(r103);
    }
}
