package com.ss.android.lark.integrator.im.impl.search;

import bnb.b;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import tza.a;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeSDKSearchModule_ProvideOfficeSDKSearchRouterFactory implements Factory<a> {
    private final b module;

    @Override // javax.inject.Provider
    public a get() {
        return provideOfficeSDKSearchRouter(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKSearchModule_ProvideOfficeSDKSearchRouterFactory(b r100) {
        this.module = r100;
    }

    public static OfficeSDKSearchModule_ProvideOfficeSDKSearchRouterFactory create(b r100) {
        return new OfficeSDKSearchModule_ProvideOfficeSDKSearchRouterFactory(r100);
    }

    public static a provideOfficeSDKSearchRouter(b r100) {
        r100.getClass();
        Object r101 = (a) OfficeSDKManager.getHostGlobalService(a.class);
        if (r101 != null) goto L6;
        r101 = new bnb.a();
    L6:
        return (a) Preconditions.checkNotNullFromProvides(r101);
    }
}
