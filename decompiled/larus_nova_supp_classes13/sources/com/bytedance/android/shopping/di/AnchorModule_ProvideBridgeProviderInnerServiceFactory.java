package com.bytedance.android.shopping.di;

import com.bytedance.android.shopping.hybrid.EShoppingBridgeProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import g33.e;
import gd3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AnchorModule_ProvideBridgeProviderInnerServiceFactory implements Factory<e> {
    private final a module;

    public e get() {
        return provideInstance(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m845get() {
        return get();
    }

    public AnchorModule_ProvideBridgeProviderInnerServiceFactory(a r1) {
        this.module = r1;
    }

    public static AnchorModule_ProvideBridgeProviderInnerServiceFactory create(a r1) {
        return new AnchorModule_ProvideBridgeProviderInnerServiceFactory(r1);
    }

    public static e provideInstance(a r0) {
        return proxyProvideBridgeProviderInnerService(r0);
    }

    public static e proxyProvideBridgeProviderInnerService(a r1) {
        r1.getClass();
        return (e) Preconditions.checkNotNull(EShoppingBridgeProvider.a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
