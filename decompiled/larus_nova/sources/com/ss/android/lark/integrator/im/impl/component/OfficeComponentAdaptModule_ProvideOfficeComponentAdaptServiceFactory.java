package com.ss.android.lark.integrator.im.impl.component;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import eza.a;
import tmb.b;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeComponentAdaptModule_ProvideOfficeComponentAdaptServiceFactory implements Factory<a> {
    private final b module;

    @Override // javax.inject.Provider
    public a get() {
        return provideOfficeComponentAdaptService(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeComponentAdaptModule_ProvideOfficeComponentAdaptServiceFactory(b r100) {
        this.module = r100;
    }

    public static OfficeComponentAdaptModule_ProvideOfficeComponentAdaptServiceFactory create(b r100) {
        return new OfficeComponentAdaptModule_ProvideOfficeComponentAdaptServiceFactory(r100);
    }

    public static a provideOfficeComponentAdaptService(b r100) {
        r100.getClass();
        Object r101 = (a) OfficeSDKManager.getHostGlobalService(a.class);
        if (r101 != null) goto L6;
        r101 = new tmb.a(r100);
    L6:
        return (a) Preconditions.checkNotNullFromProvides(r101);
    }
}
