package com.ss.android.lark.rustinfrabridge.netstate;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.rustinfrabridge.netstate.impl.UserNetStateServiceProxy;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import g3c.a;
import g3c.b;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class NetStateServiceModule_ProvideNetStateServiceFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideNetStateService(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public NetStateServiceModule_ProvideNetStateServiceFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static NetStateServiceModule_ProvideNetStateServiceFactory create(Provider<j> r100, Provider<v> r101) {
        return new NetStateServiceModule_ProvideNetStateServiceFactory(r100, r101);
    }

    public static a provideNetStateService(j r100, v r101) {
        int r102 = b.f479938a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        UserNetStateServiceProxy r103 = new UserNetStateServiceProxy(r100, r101);
        h.a(r103);
        return (a) Preconditions.checkNotNullFromProvides(r103);
    }
}
