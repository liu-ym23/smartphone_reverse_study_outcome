package com.bytedance.ee.bear.bitable.core.usercomponent;

import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableGlobalModule_ProvideBitableAppFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideBitableApp(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public BitableGlobalModule_ProvideBitableAppFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static BitableGlobalModule_ProvideBitableAppFactory create(Provider<j> r100, Provider<v> r101) {
        return new BitableGlobalModule_ProvideBitableAppFactory(r100, r101);
    }

    public static a provideBitableApp(j r100, v r101) {
        int r102 = e.f210604a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        e.a r103 = new e.a(r100, r101);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (a) Preconditions.checkNotNullFromProvides(r103);
    }
}
