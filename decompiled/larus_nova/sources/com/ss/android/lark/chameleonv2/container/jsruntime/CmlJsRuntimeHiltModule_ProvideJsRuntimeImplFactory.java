package com.ss.android.lark.chameleonv2.container.jsruntime;

import com.ss.android.lark.chameleon.AbsChameleonJsRuntime;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import e0c.k;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import m0b.b;
import m0b.c;

/* JADX INFO: loaded from: classes35.dex */
public final class CmlJsRuntimeHiltModule_ProvideJsRuntimeImplFactory implements Factory<AbsChameleonJsRuntime> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public AbsChameleonJsRuntime get() {
        return provideJsRuntimeImpl(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CmlJsRuntimeHiltModule_ProvideJsRuntimeImplFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static CmlJsRuntimeHiltModule_ProvideJsRuntimeImplFactory create(Provider<j> r100, Provider<v> r101) {
        return new CmlJsRuntimeHiltModule_ProvideJsRuntimeImplFactory(r100, r101);
    }

    public static AbsChameleonJsRuntime provideJsRuntimeImpl(j r100, v r101) {
        int r102 = b.f511546a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        UserSession r103 = r100.b();
        if (r103 != null) goto L5;
        r103 = ContainerConstsKt.a();
    L5:
        c r104 = new c(r100, r101, new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r103), AbsChameleonJsRuntime.class), AbsChameleonJsRuntime.class));
        h.a(r104);
        return (AbsChameleonJsRuntime) Preconditions.checkNotNullFromProvides(r104);
    }
}
