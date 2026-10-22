package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import g33.e;
import gd3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AnchorModuleFallback_ProvideBridgeProviderInnerServiceFactory implements Factory<e> {
    private final b module;

    public e get() {
        return provideInstance(null);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m841get() {
        return get();
    }

    public AnchorModuleFallback_ProvideBridgeProviderInnerServiceFactory(b r1) {
    }

    public static AnchorModuleFallback_ProvideBridgeProviderInnerServiceFactory create(b r1) {
        return new AnchorModuleFallback_ProvideBridgeProviderInnerServiceFactory(r1);
    }

    public static e provideInstance(b r0) {
        return proxyProvideBridgeProviderInnerService(r0);
    }

    public static e proxyProvideBridgeProviderInnerService(b r0) {
        throw null;
    }
}
