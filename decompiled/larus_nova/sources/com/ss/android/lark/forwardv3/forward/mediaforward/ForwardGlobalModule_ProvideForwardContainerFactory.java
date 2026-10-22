package com.ss.android.lark.forwardv3.forward.mediaforward;

import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ForwardGlobalModule_ProvideForwardContainerFactory implements Factory<f> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public f get() {
        return provideForwardContainer(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ForwardGlobalModule_ProvideForwardContainerFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static ForwardGlobalModule_ProvideForwardContainerFactory create(Provider<j> r100, Provider<v> r101) {
        return new ForwardGlobalModule_ProvideForwardContainerFactory(r100, r101);
    }

    public static f provideForwardContainer(j r100, v r101) {
        int r102 = e.f425374a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        d r103 = new d(r100, r101);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (f) Preconditions.checkNotNullFromProvides(r103);
    }
}
