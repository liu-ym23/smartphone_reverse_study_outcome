package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.b;
import p83.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AnchorModuleFallback_ProvideECAnchorV3StoreServiceFactory implements Factory<e> {
    private final b module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public e m842get() {
        return provideInstance(null);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m842get();
    }

    public AnchorModuleFallback_ProvideECAnchorV3StoreServiceFactory(b r1) {
    }

    public static AnchorModuleFallback_ProvideECAnchorV3StoreServiceFactory create(b r1) {
        return new AnchorModuleFallback_ProvideECAnchorV3StoreServiceFactory(r1);
    }

    public static e provideInstance(b r0) {
        return proxyProvideECAnchorV3StoreService(r0);
    }

    public static e proxyProvideECAnchorV3StoreService(b r0) {
        throw null;
    }
}
