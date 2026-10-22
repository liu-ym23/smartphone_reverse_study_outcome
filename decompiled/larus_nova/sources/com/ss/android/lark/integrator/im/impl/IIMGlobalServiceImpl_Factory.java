package com.ss.android.lark.integrator.im.impl;

import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class IIMGlobalServiceImpl_Factory implements Factory<IIMGlobalServiceImpl> {
    private final Provider<vmb.c> mixedFeedUserBundleProxyProvider;
    private final Provider<sza.c> officeUrlPreviewServiceProvider;
    private final Provider<j> userServiceProvider;

    @Override // javax.inject.Provider
    public IIMGlobalServiceImpl get() {
        IIMGlobalServiceImpl r100 = newInstance(this.userServiceProvider.get(), this.mixedFeedUserBundleProxyProvider.get());
        r100.f427951c = this.officeUrlPreviewServiceProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static IIMGlobalServiceImpl newInstance(j r100, vmb.c r101) {
        return new IIMGlobalServiceImpl(r100, r101);
    }

    public IIMGlobalServiceImpl_Factory(Provider<j> r100, Provider<vmb.c> r101, Provider<sza.c> r102) {
        this.userServiceProvider = r100;
        this.mixedFeedUserBundleProxyProvider = r101;
        this.officeUrlPreviewServiceProvider = r102;
    }

    public static IIMGlobalServiceImpl_Factory create(Provider<j> r100, Provider<vmb.c> r101, Provider<sza.c> r102) {
        return new IIMGlobalServiceImpl_Factory(r100, r101, r102);
    }
}
