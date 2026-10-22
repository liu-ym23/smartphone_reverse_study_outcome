package com.bytedance.android.livesdk.livecommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import el2.k;
import sg2.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLiveCommerceModel_ProvideLiveServiceFactory implements Factory<k> {
    private final i module;

    public k get() {
        return provideInstance(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m537get() {
        return get();
    }

    public ECLiveCommerceModel_ProvideLiveServiceFactory(i r1) {
        this.module = r1;
    }

    public static ECLiveCommerceModel_ProvideLiveServiceFactory create(i r1) {
        return new ECLiveCommerceModel_ProvideLiveServiceFactory(r1);
    }

    public static k provideInstance(i r0) {
        return proxyProvideLiveService(r0);
    }

    public static k proxyProvideLiveService(i r1) {
        r1.getClass();
        return (k) Preconditions.checkNotNull(i.d, "Cannot return null from a non-@Nullable @Provides method");
    }
}
