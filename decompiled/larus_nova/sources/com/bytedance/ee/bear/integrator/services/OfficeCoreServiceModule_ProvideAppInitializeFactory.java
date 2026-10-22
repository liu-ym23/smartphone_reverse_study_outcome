package com.bytedance.ee.bear.integrator.services;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import hb5.a;
import hb5.b;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficeCoreServiceModule_ProvideAppInitializeFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final sb5.a module;
    private final Provider<j> passportServiceProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideAppInitialize(this.module, this.passportServiceProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeCoreServiceModule_ProvideAppInitializeFactory(sb5.a r100, Provider<j> r101, Provider<v> r102) {
        this.module = r100;
        this.passportServiceProvider = r101;
        this.accessorProvider = r102;
    }

    public static OfficeCoreServiceModule_ProvideAppInitializeFactory create(sb5.a r100, Provider<j> r101, Provider<v> r102) {
        return new OfficeCoreServiceModule_ProvideAppInitializeFactory(r100, r101, r102);
    }

    public static a provideAppInitialize(sb5.a r100, j r101, v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passportService");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        b r103 = new b(r101, r102);
        h.a(r103);
        return (a) Preconditions.checkNotNullFromProvides(r103);
    }
}
